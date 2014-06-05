<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language= "java" contentType="text/html;charset=UTF-8"%>
<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/common.js"></script>
<body>

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
<div id="mask"><span>loading...<span></div>
<div id="filter-div">
    <h3>Specify condition to filter:</h3>
    <div>
    <form id="employee-filter-form" action="<c:out value='${pageContext.request.contextPath}'/>/user/json">
        <input type="hidden" name="deptNo" value='<c:out value="${deptNo}" />'/>
        <input type="hidden" name="currentPage" id="filter-currentPage" value="1"/>

        <table>
            <tr>
                <td class="tdLabel"><label for="employee-filter_firstName" class="label">First Name:</label></td>
                <td>
                    <input id="employee-filter_firstName" name="firstName" type="text" value=''/>
                </td>
            </tr>

            <tr>
                <td class="tdLabel"><label for="employee-filter_lastName" class="label">Last Name:</label></td>
                <td>
                    <input id="employee-filter_lastName" name="lastName" type="text" value=''/>
                </td>
            </tr>

            <tr>
                <td class="tdLabel"><label for="employee-filter_title" class="label">Job Title:</label></td>
                <td>
                    <input id="employee-filter_title" name="title" type="text" value=''/>
                </td>
            </tr>

            <tr>
                <td class="tdLabel"><label for="gender" class="label">Gender:</label></td>
                <td>
                    <input type="radio" name="gender" value='' checked="true">All</input>
                    <input type="radio" name="gender" value='M'>Male</input>
                    <input type="radio" name="gender" value='F'>Female</input>
                </td>
            </tr>
            <tr>
                <td class="tdLabel"><label class="label">Hire Date From:</label></td>
                <td>
                    <input type="text" id="employee-filter_hireDateFrom" name="hireDateFrom"/>
                </td>
            </tr>
            <tr>
                <td class="tdLabel"><label class="label">Hire Date To:</label></td>
                <td>
                    <input type="text" id="employee-filter_hireDateTo" name="hireDateTo"/>
                </td>
            </tr>
        </table>

           <div class=" ui-helper-clearfix">
            <div class="">
                <button id="filter-button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false">
                    <span class="ui-button-text">Filter</span>
                </button>
            </div>
           </div>
    </form>
    </div>
</div>

    <div class="ui-widget" id="grid-div">
        <table class="ui-widget ui-widget-content">
           <thead>
               <tr class="ui-widget-header ">
                   <th>First Name</th><th>Last Name</th><th>Gender</th><th>Job Title</th><th>Hire Date</th><th>Action</th>
               </tr>
           </thead>
           <tbody id="item-table-body">
           </tbody>
       </table>
       <div class="page">
            <button onclick="pageClick('first')" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false">
                <span class="ui-button-text">&lt;&lt;</span>
            </button>
            <button onclick="pageClick('prev')" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false">
                <span class="ui-button-text">&lt;</span>
            </button>
            <button onclick="pageClick('next')" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false">
                <span class="ui-button-text">&gt;</span>
            </button>
            <button onclick="pageClick('last')" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false">
                <span class="ui-button-text">&gt;&gt;</span>
            </button>
        <span id="numberIndicator"></span>
      </div>
   </div>

<input type="hidden" name="totalPage" id="filter-totalPage" value="1"/>


<div id="userDetailDialog"></div>

<script  type="text/javascript">

    function processUserListJson(data) {
        //unmask
        $("#mask").css("display", "none");
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
        if (begin > end) begin = end;
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
            "     <td class=\"tdValue\"><button onclick=\"viewDetail(this, '"+ emp.empNo +"');return false;\" type='button class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' role='button' aria-disabled='false'><span>Detail</span></button></td>" +
            "  </tr>";
    }

    contextPath = "<c:out value='${pageContext.request.contextPath}'/>";

    function viewDetail(event, empNo) {
        //window.open(contextPath + "/user/" + empNo);
        //$("#userDetailDialog").load(contextPath + "/user/" + empNo);
        //event.stopPropagation();
        //$("#userDetailDialog").dialog("open");
        window.showModalDialog(contextPath + "/user/" + empNo,"User Detail",
        "dialogWidth:355px;dialogHeight:300px;center=yes;status=no;location=no");
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
            beforeSubmit: function(){$("#mask").css("display", "block")},
            // success identifies the function to invoke when the server response
            // has been received
            success:   processUserListJson
        });

        $('#employee-filter-form').submit();
        console.log("form submit");

        $("#filter-button").click(function(){$('#employee-filter-form').submit();});

        $("#employee-filter_hireDateFrom").datepicker();
        $("#employee-filter_hireDateFrom").datepicker('option','dateFormat','dd/mm/yy');
        $("#employee-filter_hireDateTo").datepicker();
        $("#employee-filter_hireDateTo").datepicker('option','dateFormat','dd/mm/yy');

        //this is a dialog for showing user detail
        $("#userDetailDialog").dialog({  //create dialog, but keep it closed
           autoOpen: false,
           height: 300,
           width: 350,
           modal: true
        });


    });

</script>
</body>



