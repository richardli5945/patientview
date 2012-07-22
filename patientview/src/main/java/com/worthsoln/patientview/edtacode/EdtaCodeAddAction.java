package com.worthsoln.patientview.edtacode;

import com.opensymphony.xwork2.ActionSupport;
import com.worthsoln.HibernateUtil;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class EdtaCodeAddAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private EdtaCode edtaCode;

    @Override
    public String execute() throws Exception {


        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        session.save(edtaCode);

        tx.commit();
        HibernateUtil.closeSession();


        return SUCCESS;
    }

    public EdtaCode getEdtaCode() {
        return edtaCode;
    }

    public void setEdtaCode(EdtaCode edtaCode) {
        this.edtaCode = edtaCode;
    }

/*
    public String getEdtaCode() {
        return edtaCode;
    }

    public void setEdtaCode(String edtaCode) {
        eCode.setEdtaCode(edtaCode);
    }
*/
}
