<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime-1.0" prefix="dt" %>
<%@ page import="org.patientview.utils.LegacySpringUtils" %>

<%--
  ~ PatientView
  ~
  ~ Copyright (c) Worth Solutions Limited 2004-2013
  ~
  ~ This file is part of PatientView.
  ~
  ~ PatientView is free software: you can redistribute it and/or modify it under the terms of the
  ~ GNU General Public License as published by the Free Software Foundation, either version 3 of the License,
  ~ or (at your option) any later version.
  ~ PatientView is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
  ~ the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
  ~ GNU General Public License for more details.
  ~ You should have received a copy of the GNU General Public License along with PatientView in a file
  ~ titled COPYING. If not, see <http://www.gnu.org/licenses/>.
  ~
  ~ @package PatientView
  ~ @link http://www.patientview.org
  ~ @author PatientView <info@patientview.org>
  ~ @copyright Copyright (c) 2004-2013, Worth Solutions Limited
  ~ @license http://www.gnu.org/licenses/gpl-3.0.html The GNU General Public License V3.0
  --%>

<html:xhtml/>
<div class="span9">
<div class="page-header">
    <h1>Users for Unit <logic:notEmpty name="unit"><bean:write name="unit" property="name"/></logic:notEmpty></h1>
</div>

<% String context=LegacySpringUtils.getSecurityUserManager().getLoggedInSpecialty().getContext();%>

<logic:notEmpty name="unitUsers">
    <div class="span10" style="margin-left: 10px;margin-bottom:5px;">
        <div class="row" style="float: right;">
            <logic:equal value="false" name="patients" property="firstPage">
                <a href="./unitUsers?page=prev">Prev</a>&nbsp;
            </logic:equal>
            &nbsp;
            <logic:equal value="false" name="patients" property="lastPage">
                <a href="./unitUsers?page=next">Next</a>
            </logic:equal>
        </div>
    </div>

  <table cellpadding="3" border="0" class="table table-striped table-bordered table-condensed">
      <tr>
        <th class="tableheader" onclick="sort('name')">Name</th>
        <th class="tableheader" onclick="sort('username')">Username</th>
        <th class="tableheader" onclick="sort('displayRole')">Role</th>
        <th class="tableheader" onclick="sort('email')">Email</th>
        <th class="tableheader" onclick="sort('emailverfied')">Email Verified</th>
        <th class="tableheader" onclick="sort('lastlogonFormatted')">Last Login</th>
        <th class="tableheader" onclick="sort('accountlocked')">Password Locked</th>
        <th class="tableheader" onclick="sort('isrecipient')">Message Recipient</th>
        <th class="tableheader" onclick="sort('isclinician')">Clinician</th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
    <logic:iterate id="unitUser" name="unitUsers" property="pageList">
      <tr>
        <td class="tablecell"><bean:write name="unitUser" property="name"/></td>
        <td class="tablecell"><bean:write name="unitUser" property="username"/></td>
        <td class="tablecell"><bean:write name="unitUser" property="displayRole"/></td>
        <td class="tablecell"><bean:write name="unitUser" property="email"/></td>
        <td class="tablecell">
            <logic:equal value="false" name="unitUser" property="emailverfied">
                <big><font color="red">&#10008;</font></big>
            </logic:equal>
            <logic:equal value="true" name="unitUser" property="emailverfied">
                <big><font color="green">&#10004;</font></big>
            </logic:equal>
        </td>
        <td class="tablecell"><bean:write name="unitUser" property="lastlogonFormatted"/></td>
          <td class="tablecell">
              <logic:equal value="true" name="unitUser" property="accountlocked">
                  <font color="red">locked</font>
              </logic:equal>
              <logic:equal value="false" name="unitUser" property="accountlocked">
                  <big><font color="green">&#10004;</font></big>
              </logic:equal>
          </td>

          <td class="tablecell">
              <logic:equal name="unitUser" property="isrecipient" value="false">No</logic:equal>
              <logic:equal name="unitUser" property="isrecipient" value="true">Yes</logic:equal>
          </td>
          <td class="tablecell">
              <logic:equal name="unitUser" property="isclinician" value="false">No</logic:equal>
              <logic:equal name="unitUser" property="isclinician" value="true">Yes</logic:equal>
          </td>

          <logic:present role="superadmin,unitadmin">
            <td>
              <html:form action="/control/unitUserEditInput">
                <html:hidden name="unitUser" property="username" />
                <logic:notEmpty name="unit">
                    <html:hidden name="unit" property="unitcode" />
                </logic:notEmpty>
                <html:submit value="Edit" styleClass="btn" />
              </html:form>
            </td>
        </logic:present>

        <logic:present role="superadmin,unitadmin">
            <td>
              <html:form action="/control/activityByUser">
                <html:hidden name="unitUser" property="username" />
                <html:submit value="Activity" styleClass="btn" />
              </html:form>
            </td>
        </logic:present>

        <logic:present role="superadmin,unitadmin">
             <td>
                 <bean:define id="username" name="unitUser" property="username" />
                 <bean:define id="email" name="unitUser" property="email" />
                 <bean:define id="emailverfied" name="unitUser" property="emailverfied"/>
                 <input type="button" value="Send Verification Email" class="btn formbutton" ${emailverfied?"disabled":""} onclick="sendVerification('${username}','${email}', '/${context}/web/control/emailverification.do', this)">
             </td>
        </logic:present>

      </tr>
    </logic:iterate>
   </table>
 </logic:notEmpty>
</div>
<script src="/js/emailverification.js" type="text/javascript"></script>

<script type="text/javascript">
    function sort(property){
        window.location.href="./unitUsers?page=sort&property="+property;
    }
</script>
