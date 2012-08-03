package com.worthsoln.taglib;

import org.apache.struts.taglib.html.LinkTag;

import javax.servlet.jsp.JspException;

/**
 *  Extend the Struts link tag to apply tenancy contexts to links
 */
public class PatientViewLinkTag extends LinkTag {

    @Override
    protected String calculateURL() throws JspException {
        return super.calculateURL();
    }
}
