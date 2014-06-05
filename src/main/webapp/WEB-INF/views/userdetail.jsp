<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language= "java" contentType="text/html;charset=UTF-8"%>
<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/common.js"></script>
<body>
    <div class="ui-widget" id="user-detail-div">
    <table class="ui-widget ui-widget-content">
       <tbody id="item-table-body">
           <tr>
                <td class="tdLabel"><label class="label">First Name:</label></td>
                <td class="tdValue"> <c:out value="${employee.firstName}"/></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Last Name:</label></td>
                <td class="tdValue"> <c:out value="${employee.lastName}"/></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Gender:</label></td>
                <td class="tdValue"> <c:out value="${employee.gender}"/></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Current Department:</label></td>
                <td class="tdValue"> <c:out value="${employee.currentDepartment.deptName}"/></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Current Job Title:</label></td>
                <td class="tdValue"> <c:out value="${employee.currentTitle.title}"/></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Hire Date:</label></td>
                <td class="tdValue"><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.hireDate}" /></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Years With Company:</label></td>
                <td class="tdValue"><c:out value="${employee.yearsWithCompany}" /></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Birth Date:</label></td>
                <td class="tdValue"><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.birthDate}" /></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Age:</label></td>
                <td class="tdValue"><c:out value="${employee.age}"/></td>
           </tr>
           <tr>
                <td class="tdLabel"><label class="label">Current Salary:</label></td>
                <td class="tdValue"><fmt:formatNumber type="currency" currencySymbol="$" value="${employee.currentSalary.salary}" /></td>
           </tr>
       </tbody>
       </table>
   </div>

</body>


