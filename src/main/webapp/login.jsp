<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language= "java" contentType="text/html;charset=UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
        <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/common.js"></script>
        <title>Iress Test</title>
    </head>
    <body>
        <div id="login-div">
            <c:if test="${errorMsg!=null}">
                <label class="error"> <c:out value="${errorMsg}" /> </label>
            </c:if>
            <form id="login-form" method="post" action="<c:out value='${pageContext.request.contextPath}'/>/login">
                <table>
                <tr>
                    <td class="tdLabel"><label for="login-form_username" class="label">Username:</label></td>
                    <td>
                        <input id="login-form_username" name="username" type="text" value='<c:out value="${username}" />'/>
                    </td>
                </tr>

                <tr>
                    <td class="tdLabel"><label for="login-form_password" class="label">Password:</label></td>
                    <td>
                        <input id="login-form_password" name="password" type="password"/>
                    </td>
                </tr>
                </table>
            </form>
        </div>
    </body>


<script type="text/javascript">

    $().ready(function(){

        $( "#login-div" ).dialog({
            autoOpen: false,
            width: 400,
            modal: true,
            autoOpen: true,
            resizable: false,
            closeOnEscape: false,
            title: 'Welcome!',
            buttons: {
                "login": function() {
                   $("#login-form").submit();

                }
            },
            close: function() {
            }
        });

       //set validate rules for the form
        $("#login-form").validate({
            rules: {
               "username": {
                    required: true
                },
                "password": {
                    required: true
                }
            }
        });

        $("#login-div button").focus();
        $("span[class*='ui-icon-closethick']").css("display", "none");

        //$("#login-div").dialog("open");
    });

</script>




<html>