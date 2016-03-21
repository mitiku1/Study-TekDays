<%--
  Created by IntelliJ IDEA.
  User: apposit-pc
  Date: 3/21/16
  Time: 11:59 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TekDays-Signup</title>
    <meta name="layout" content="main"/>
</head>

<body>
    <g:if test="${tekUserInstance}">
        <div class="message" style="color:red">
            <g:renderErrors bean="${tekUserInstance}"  />


        </div>

    </g:if>
    <g:form action="register">
        <table>
            <tr class="prog">
                <td class="label">
                    Full Name
                </td>
                <td class="value">
                    <g:textField name="fullName" value="${tekUserInstance?.fullName}"/>
                </td>
            </tr>

            <tr class="prog">
                <td class="label">
                    Username
                </td>
                <td class="value">
                    <g:textField name="userName" value="${tekUserInstance?.userName}"/>
                </td>
            </tr>

            <tr class="prog">
                <td class="label">
                    password
                </td>
                <td class="value">
                    <g:passwordField name="password" value="${tekUserInstance?.password}"/>
                </td>
            </tr>

            <tr class="prog">
                <td class="label">
                    Email
                </td>
                <td class="value">
                    <g:textField name="email" value="${tekUserInstance?.email}"/>
                </td>
            </tr>

            <tr class="prog">
                <td class="label">
                    Website
                </td>
                <td class="value">
                    <g:textField name="website" value="${tekUserInstance?.website}"/>
                </td>
            </tr>
            <tr class="prog">
                <td class="label">
                    Bio
                </td>
                <td class="value">
                    <g:textArea name="bio" value="${tekUserInstance?.bio}"/>
                </td>
            </tr>
            <tr class="prog">
                <td class="label">

                </td>

                <td class="value">
                    <g:submitButton name="registerButton" value="register"/>
                </td>
            </tr>
        </table>
    </g:form>
</body>
</html>