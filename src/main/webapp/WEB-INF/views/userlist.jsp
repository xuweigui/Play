<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language= "java" contentType="text/html;charset=UTF-8"%>

<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

    <table id="dg" title="DataGrid" style="width:700px;height:250px" data-options="
                singleSelect:true,
                data:data
            ">
        <thead>
            <tr>
                <th data-options="field:'itemid',width:80">Item ID</th>
                <th data-options="field:'productid',width:100">Product</th>
                <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
                <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
                <th data-options="field:'attr1',width:250">Attribute</th>
                <th data-options="field:'status',width:60,align:'center'">Status</th>
            </tr>
        </thead>
    </table>




<script  type="text/javascript">

    function createDetailLink(empNo) {
       return "<a id='emp_" + empNo + "' link='#'>Detail</a>";
    }
    function addEvent(empNo) {
        $("#emp_" + empNo).click(function(){
            alert("dddd");
         });
    }
</script>

    <div class="ui-widget">
        <table class="ui-widget ui-widget-content">
           <thead>
               <tr class="ui-widget-header ">
                   <th>First Name</th><th>Last Name</th><th>Gender</th><th>Job Title</th><th>Hire Date</th><th>Action</th>
               </tr>
           </thead>
           <tbody id="item-table-body">
           <c:if test="${fn:length(employees) > 0}">
               <c:forEach items="${employees}" var="employee">
               <tr>
                    <td class="tdValue"> <c:out value="${employee.firstName}"/></td>
                    <td class="tdValue"> <c:out value="${employee.lastName}"/></td>
                    <td class="tdValue"> <c:out value="${employee.gender}"/></td>
                    <td class="tdValue"> <c:out value="${employee.currentTitle.title}"/></td>
                    <td class="tdValue"><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.hireDate}" /></td>
                    <td>
                        <script type="text/javascript">
                            document.write(createDetailLink('<c:out value="${employee.empNo}"/>'));
                            addEvent('<c:out value="${employee.empNo}"/>');
                        </script>
                    </td>
               </tr>
           </c:forEach>
           </c:if>
           </tbody>
       </table>
   </div>





