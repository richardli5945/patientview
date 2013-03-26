<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html:xhtml/>

<div class="page-header">
    <h1>Join Patient View</h1>
</div>

<html:form action="/joinSubmit" styleClass="form-horizontal">
    
    <html:errors/>

    <div class="control-group">
        <label class="control-label">First name</label>

        <div class="controls"><html:text property="firstName"/></div>
    </div>

    <div class="control-group">
        <label class="control-label">Last name</label>

        <div class="controls"><html:text property="lastName"/></div>
    </div>

    <div class="control-group">
        <label class="control-label">Date of birth</label>

        <div class="input-append date datePicker controls" data-date="<bean:write name="joinForm" property="dateOfBirth"/>">
            <input name="dateOfBirth" class="span2" size="16" type="text" value="<bean:write name="joinForm" property="dateOfBirth"/>" readonly>
            <span class="add-on"><i class="icon-th"></i></span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">Unit code</label>

        <div class="controls">
            <html:select property="unitcode">
                <html:options collection="units" property="unitcode" labelProperty="name"/>
            </html:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">Email address</label>

        <div class="controls"><html:text property="email"/></div>
    </div>

    <div class="control-group">
        <div class="controls"><html:submit value="Join" styleClass="btn"/></div>
    </div>

</html:form>
