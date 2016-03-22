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
    <g:javascript library="jquery"/>
    <script type="text/javascript">

        function validateUserName(uname){
            $.ajax({
                type: "post",
                dataType: "html",
                url: "${g.createLink(action:'validateUserName')}",
                data:{userName:uname} ,
                success: function (response, status, xml) {
                    $("#userNameValidate").text(response);
                }
            });
        }
    </script>
</head>

<body>
    <g:form action="register">
        <table>
            <tr class="prog">
                <td class="label">
                    Full Name
                </td>
                <td class="value">
                    <input type="text" id="fullName" name="fullName" value="${tekUserInstance.fullName}"
                        <g:hasErrors bean="${tekUserInstance}" field="fullName">
                            style="border-color:red"
                        </g:hasErrors>
                    />
                </td>
                <g:hasErrors bean ="${tekUserInstance}" field="fullName">
                    <td class="error" style="color: red">
                        <g:renderErrors bean="${tekUserInstance}" field="fullName" />
                    </td>
                </g:hasErrors>
            </tr>

            <tr class="prog">
                <td class="label">
                    Username
                </td>
                <td class="value">
                    <input type="text" id="userName" name="userName" value="${tekUserInstance.userName}" onblur="validateUserName(this.value)"
                        <g:hasErrors bean="${tekUserInstance}" field="userName">
                            style="border-color:red"
                            </g:hasErrors>
                        />

                    <span id="userNameValidate" style="color:red"></span>

                </td>
                <g:hasErrors bean ="${tekUserInstance}" field="userName">
                    <td class="error" style="color: red">
                        <g:renderErrors bean="${tekUserInstance}" field="userName" />
                    </td>
                </g:hasErrors>
            </tr>

            <tr class="prog">
                <td class="label">
                    password
                </td>
                <td class="value">
                    <input type="password" id="password" name="password" value="${tekUserInstance.password}"
                        <g:hasErrors bean="${tekUserInstance}" field="password">
                            style="border-color:red"
                        </g:hasErrors>
                    />
                </td>
                <g:hasErrors bean ="${tekUserInstance}" field="password">
                    <td class="error" style="color: red">
                        <g:renderErrors bean="${tekUserInstance}" field="password" />
                    </td>
                </g:hasErrors>
            </tr>

            <tr class="prog">
                <td class="label">
                    Email
                </td>
                <td class="value">
                    <input type="text" id="email" name="email" value="${tekUserInstance.email}"
                        <g:hasErrors bean="${tekUserInstance}" field="email">
                            style="border-color:red"
                        </g:hasErrors>
                    />
                </td>
                <g:hasErrors bean ="${tekUserInstance}" field="email">
                    <td class="error" style="color: red">
                        <g:renderErrors bean="${tekUserInstance}" field="email" />
                    </td>
                </g:hasErrors>
            </tr>

            <tr class="prog">
                <td class="label">
                    Website
                </td>
                <td class="value">
                    <input type="text" id="website" name="website" value="${tekUserInstance.website}"
                        <g:hasErrors bean="${tekUserInstance}" field="website">
                            style="border-color:red"
                        </g:hasErrors>
                    />
                </td>
                <g:hasErrors bean ="${tekUserInstance}" field="website">
                    <td class="error" style="color: red">
                        <g:renderErrors bean="${tekUserInstance}" field="website" />
                    </td>
                </g:hasErrors>
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