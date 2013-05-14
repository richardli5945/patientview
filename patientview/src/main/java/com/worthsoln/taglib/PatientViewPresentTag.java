package com.worthsoln.taglib;

import com.worthsoln.patientview.model.Unit;
import com.worthsoln.patientview.unit.UnitUtils;
import com.worthsoln.utils.LegacySpringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.logic.PresentTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Override to evaluate user the patient view user and role rather than the tomcat/request/container
 */
public class PatientViewPresentTag extends PresentTag {

    private String specialty;
    private String feature;

    @Override
    protected boolean condition(boolean desired) throws JspException {

        // Evaluate the presence of the specified value
        boolean present = false;
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        if (cookie != null) {
            present = this.isCookiePresent(request);
        } else if (header != null) {
            String value = request.getHeader(header);
            present = (value != null);
        } else if (name != null) {
            present = this.isBeanPresent();
        } else if (parameter != null) {
            String value = request.getParameter(parameter);
            present = (value != null);
        } else if (role != null) {
            StringTokenizer st = new StringTokenizer(role, ROLE_DELIMITER, false);
            while (!present && st.hasMoreTokens()) {
                present = LegacySpringUtils.getSecurityUserManager().isRolePresent(st.nextToken());
            }
        } else if (user != null) {
            String username = LegacySpringUtils.getSecurityUserManager().getLoggedInUsername();
            present = (username != null) && user.equals(username);
        } else if (specialty != null) {
            present = LegacySpringUtils.getSecurityUserManager().isSpecialtyPresent(specialty);
        } else if (feature != null) {
            present = LegacySpringUtils.getSecurityUserManager().isRolePresent("superadmin");

            if (!present) {
                List<Unit> usersUnits = LegacySpringUtils.getUnitManager().getLoggedInUsersUnits();
                List<Unit> featureUnits = LegacySpringUtils.getFeatureManager().getUnitsForFeature(feature);

                FeatureLoop:
                for (Unit featureUnit : featureUnits) {
                    if (featureUnit.getUnitcode().equals(UnitUtils.PATIENT_ENTERS_UNITCODE)) {
                        present = true;
                        break;
                    } else {
                        for (Unit userUnit : usersUnits) {
                            if (userUnit.equals(featureUnit)) {
                                present = true;
                                break FeatureLoop;
                            }
                        }
                    }
                }
            }
        } else {
            JspException e = new JspException
                    (messages.getMessage("logic.selector"));
            TagUtils.getInstance().saveException(pageContext, e);
            throw e;
        }

        return (present == desired);
    }

    @Override
    public void release() {
        super.release();

        specialty = null;
        feature = null;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
