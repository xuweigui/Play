<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language= "java" contentType="text/html;charset=UTF-8"%>
<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/common.js"></script>


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
    <form id="employee-filter-form" action="<c:out value='${pageContext.request.contextPath}'/>/user/json">
        <input type="hidden" name="deptNo" value='<c:out value="${deptNo}" />'/>
        <input type="hidden" name="currentPage" id="filter-currentPage" value="1"/>
    </form>
    <div class="ui-widget">
        <table class="ui-widget ui-widget-content">
           <thead>
               <tr class="ui-widget-header ">
                   <th>First Name</th><th>Last Name</th><th>Gender</th><th>Job Title</th><th>Hire Date</th><th>Action</th>
               </tr>
           </thead>
           <tbody id="item-table-body">
           </tbody>
       </table>
   </div>
   <div class="page">
    <a href="javascript:pageClick('first')"><span>&lt;&lt;</span></a>&nbsp;&nbsp;&nbsp;
    <a href="javascript:pageClick('prev')"><span>&lt;</span></a>&nbsp;&nbsp;&nbsp;
    <a href="javascript:pageClick('next')"><span>&gt;</span></a>&nbsp;&nbsp;&nbsp;
    <a href="javascript:pageClick('last')"><span>&gt;&gt;</span></a>
    <span id="numberIndicator"></span>
</div>

<input type="hidden" name="totalPage" id="filter-totalPage" value="1"/>



<script  type="text/javascript">

    function processUserListJson(data) {
        //remove all data
        console.log("received data");
        $("#item-table-body tr").remove();
        var employees = data.employees;
        for (i=0; i<employees.length; i++) {
            console.log("get " + employees[i]);
            $("#item-table-body").append($(createUserRow(employees[i])));
        }

        updateNumberIndicator(data.filter);
    }

    function updateNumberIndicator(filter) {
        var begin = (filter.currentPage - 1) * filter.countPerPage + 1;
        var end = filter.currentPage * filter.countPerPage;
        if (end > filter.total) end = filter.total;
        $("#numberIndicator").text("Showing " + begin + " to " + end + " of " + filter.total);
        $("#filter-currentPage").val(filter.currentPage);
        $("#filter-totalPage").val(parseInt((filter.total + 1) / filter.countPerPage + 1));
    }

    function createUserRow(emp) {
        return " <tr>" +
            "     <td class=\"tdValue\">" + emp.firstName + "</td>" +
            "     <td class=\"tdValue\">" + emp.lastName + "</td>" +
            "     <td class=\"tdValue\">" + emp.gender + "</td>" +
            "     <td class=\"tdValue\">" + emp.title + "</td>" +
            "     <td class=\"tdValue\">" + emp.hireDate + "</td>" +
            "     <td class=\"tdValue\">" + "</td>" +
            "  </tr>";
    }

    function pageClick(page) {
        console.log('page: ' + page + ' clicked');
        var currentPage = $("#filter-currentPage").val();
        var totalPage = $("#filter-totalPage").val();
        var newPage = currentPage;
        console.log("current page " + currentPage);
        if (page == "first") {
            newPage = 1;
        } else if (page == "prev") {
            newPage = (currentPage) == 1 ? 1 : (currentPage - 1);
        } else if (page == "next") {
            newPage = (currentPage == totalPage) ? totalPage : (parseInt(currentPage) + 1);
        } else if (page == "last") {
            newPage = totalPage;
        }

        console.log("new page " + newPage);
        if (newPage != currentPage) {
            $("#filter-currentPage").val(newPage);
            $('#employee-filter-form').submit();
            console.log("request new page");
        }

    }


    $().ready(function(){
        $('#employee-filter-form').ajaxForm({
            // dataType identifies the expected content type of the server response
            dataType:  'json',

            // success identifies the function to invoke when the server response
            // has been received
            success:   processUserListJson
        });

        $('#employee-filter-form').submit();
        console.log("form submit");
    });



</script>




