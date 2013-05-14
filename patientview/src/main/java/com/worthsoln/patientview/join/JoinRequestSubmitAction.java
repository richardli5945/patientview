package com.worthsoln.patientview.join;

import com.worthsoln.ibd.action.BaseAction;
import com.worthsoln.patientview.EmailUtils;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.model.JoinRequest;
import com.worthsoln.patientview.model.Unit;
import com.worthsoln.patientview.user.UserUtils;
import com.worthsoln.utils.LegacySpringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class JoinRequestSubmitAction extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        /**
         * validate form
         */
        DynaActionForm dynaForm = (DynaActionForm) form;

        if (!validate(dynaForm, request)) {
            /**
             * set bean values for success screen
             */
            List<Unit> units = LegacySpringUtils.getUnitManager().getAllDisregardingSpeciality(false);
            request.setAttribute("units", units);

            return mapping.findForward(INPUT);
        }

        /**
         * get data from form
         */
        String firstName = BeanUtils.getProperty(form, "firstName");
        String lastName = BeanUtils.getProperty(form, "lastName");
        Date dateOfBirth = convertFormDateString("dateOfBirth", dynaForm);
        String nhsNo = BeanUtils.getProperty(form, "nhsNo");
        String unitcode = BeanUtils.getProperty(form, "unitcode");
        String email = BeanUtils.getProperty(form, "email");

        /**
         * save the join request
         */
        JoinRequest joinRequest = new JoinRequest(firstName, lastName, dateOfBirth, nhsNo, unitcode, email);
        LegacySpringUtils.getJoinRequestManager().save(joinRequest);

        /**
         * send a mail to rpv admin
         */
        sendJoinRequestEmailToRPVAdmin(request, unitcode, joinRequest);

        return LogonUtils.logonChecks(mapping, request);
    }

    private static void sendJoinRequestEmailToRPVAdmin(HttpServletRequest request, String unitcode,
                                                       JoinRequest joinRequest) {
        /**
         * from
         */
        String fromAddress = request.getSession().getServletContext().getInitParameter("noreply.email");

        /**
         * to
         */
        String toAddress = "";

        Unit unit = LegacySpringUtils.getUnitManager().get(unitcode);

        if (null == unit || null == unit.getRenaladminemail() || "".equals(unit.getRenaladminemail())) {
            toAddress = request.getSession().getServletContext().getInitParameter("support.email");
        } else {
            toAddress = unit.getRenaladminemail();
        }

        /**
         * subject
         */
        String subject = "[PatientView] New join request from patient";

        /**
         * body
         */
        String message = "Hello,\n" +
                "\n" +
                "A patient has made a request on the website to join PatientView at your unit. Their details are below.\n" +
                "\n" +
                "First name: " + joinRequest.getFirstName() + "\n" +
                "Last name: " + joinRequest.getLastName() + "\n" +
                "NHS No: " + joinRequest.getNhsNo() + "\n" +
                "Unit code: " + joinRequest.getUnitcode() + "\n" +
                "Date of birth: " + joinRequest.getDateOfBirthFormatted() + "\n" +
                "Email address: " + joinRequest.getEmail() + "\n" +
                "\n" +
                "Please verify these details and follow up this request with the patient using your usual process to consent and add patients to PatientView." +
                "\n";

        /**
         * send the mail
         */
        EmailUtils.sendEmail(request.getSession().getServletContext(), fromAddress, toAddress, subject, message);
    }

    private boolean validate(DynaActionForm form, HttpServletRequest request) {
        ActionMessages actionErrors = new ActionMessages();

        // Comment out the ones that do not require validation
        if (form.get("firstName") == null || ((String) form.get("firstName")).length() == 0) {
            actionErrors.add("firstName", new ActionMessage("firstName.required"));
        }

        if (form.get("lastName") == null || ((String) form.get("lastName")).length() == 0) {
            actionErrors.add("lastName", new ActionMessage("lastName.required"));
        }

        if (form.get("dateOfBirth") == null || ((String) form.get("dateOfBirth")).length() == 0) {
            actionErrors.add("dateOfBirth", new ActionMessage("dateOfBirth.required"));
        }

        if (StringUtils.isNotEmpty((String) form.get("nhsNo"))) {
            try {
                if (!UserUtils.nhsNumberChecksumValid((String) form.get("nhsNo"))) {
                    actionErrors.add("nhsNo", new ActionMessage("nhsno.checksum"));
                }
            } catch (NumberFormatException e) {
                actionErrors.add("nhsNo", new ActionMessage("nhsno.checksum"));
            }
        }

        if (form.get("unitcode") == null || ((String) form.get("unitcode")).length() == 0 ||
                ((String) form.get("unitcode")).equals("-1")) {
            actionErrors.add("unitcode", new ActionMessage("unitcode.required"));
        }

        if (form.get("email") == null || ((String) form.get("email")).length() == 0) {
            actionErrors.add("email", new ActionMessage("email.required"));
        } else if (((String) form.get("email")).indexOf("@") < 0 || ((String) form.get("email")).indexOf(".") < 0) {
            actionErrors.add("email", new ActionMessage("email.valid"));
        }

        if (form.get("antiSpamAnswer") == null || !((String) form.get("antiSpamAnswer")).equals(
                request.getSession().getAttribute("ANTI_SPAM_ANSWER"))) {
            actionErrors.add("antiSpamAnswer", new ActionMessage("antispam.wrong.answer"));
        }

        if (actionErrors.size() > 0) {
            saveErrors(request, actionErrors);
            return false;
        }

        return true;
    }

}
