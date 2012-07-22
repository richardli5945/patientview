<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html:xhtml/>

<p class="header">Link Editing</p>

<html:errors />

<s:form action="edtaCodeAdd">

<%--
  <html:hidden property="linkType" name="codeType" />
--%>

    <s:hidden name="edtaCode.linkType" value="%{#session.codeType}"/>

<table cellpadding="3" >
    <tr>
      <td><img src="images/space.gif" height="10" /> </td>
    </tr>
    <tr>
      <td><b>Code</b></td>
      <td><s:textfield name="edtaCode.edtaCode" /></td>
    </tr>

    <tr>
      <td><b>Description</b></td>
      <td><s:textfield name="edtaCode.description" /></td>
    </tr>
    <tr>
      <td><img src="images/space.gif" height="10" /> </td>
    </tr>
    <tr>
      <td></td>
      <td align="center"><b>Link (e.g. http:// etc.)</b></td>
      <td align="center"><b>Text Description</b></td>
    </tr>
    <tr>
      <td><b>Medical Link 1</b></td>
      <td><s:textfield name="edtaCode.medicalLink01" /></td>
      <td><s:textfield name="edtaCode.medicalLinkText01" /></td>
    </tr>
    <tr>
      <td><b>Medical Link 2</b></td>
      <td><s:textfield name="edtaCode.medicalLink02" /></td>
      <td><s:textfield name="edtaCode.medicalLinkText02" /></td>
    </tr>
    <tr>
      <td><b>Medical Link 3</b></td>
      <td><s:textfield name="edtaCode.medicalLink03" /></td>
      <td><s:textfield name="edtaCode.medicalLinkText03" /></td>
    </tr>
    <tr>
      <td><b>Medical Link 4</b></td>
      <td><s:textfield name="edtaCode.medicalLink04" /></td>
      <td><s:textfield name="edtaCode.medicalLinkText04" /></td>
    </tr>
    <tr>
      <td><b>Medical Link 5</b></td>
      <td><s:textfield name="edtaCode.medicalLink05" /></td>
      <td><s:textfield name="edtaCode.medicalLinkText05" /></td>
    </tr>
    <tr>
      <td><b>Medical Link 6</b></td>
      <td><s:textfield name="edtaCode.medicalLink06" /></td>
      <td><s:textfield name="edtaCode.medicalLinkText06" /></td>
    </tr>
    <tr>
      <td><b>Patient Link 1</b></td>
      <td><s:textfield name="edtaCode.patientLink01" /></td>
      <td><s:textfield name="edtaCode.patientLinkText01" /></td>
    </tr>
    <tr>
      <td><b>Patient Link 2</b></td>
      <td><s:textfield name="edtaCode.patientLink02" /></td>
      <td><s:textfield name="edtaCode.patientLinkText02" /></td>
    </tr>
    <tr>
      <td><b>Patient Link 3</b></td>
      <td><s:textfield name="edtaCode.patientLink03" /></td>
      <td><s:textfield name="edtaCode.patientLinkText03" /></td>
    </tr>
    <tr>
      <td><b>Patient Link 4</b></td>
      <td><s:textfield name="edtaCode.patientLink04" /></td>
      <td><s:textfield name="edtaCode.patientLinkText04" /></td>
    </tr>
    <tr>
      <td><b>Patient Link 5</b></td>
      <td><s:textfield name="edtaCode.patientLink05" /></td>
      <td><s:textfield name="edtaCode.patientLinkText05" /></td>
    </tr>
    <tr>
      <td><b>Patient Link 6</b></td>
      <td><s:textfield name="edtaCode.patientLink06" /></td>
      <td><s:textfield name="edtaCode.patientLinkText06" /></td>
    </tr>

     <tr>
       <td><s:submit /></td>
     </tr>
 </table>

</s:form>
