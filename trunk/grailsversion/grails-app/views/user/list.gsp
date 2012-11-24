
<%@ page import="dealhunter.User" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="admin">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="page-header">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
</div>

<g:if test="${flash.message}">
    <div class="alert" role="status">${flash.message}</div>
</g:if>

<div class="row">
    <div class="span3">
        <g:link class="btn" action="create"><g:message code="default.create.label" args="[entityName]"/></g:link>
    </div>

    <div id="list-user" class="span9 content scaffold-list" role="main">
        <table class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                
                <g:sortableColumn property="businessAddress" title="${message(code: 'user.businessAddress.label', default: 'Business Address')}"/>
                
                <g:sortableColumn property="businessPhone" title="${message(code: 'user.businessPhone.label', default: 'Business Phone')}"/>
                
                <g:sortableColumn property="isVerified" title="${message(code: 'user.isVerified.label', default: 'Is Verified')}"/>
                
                <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}"/>
                
                <g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}"/>
                
            </tr>
            </thead>
            <tbody>
            <g:each in="${userInstanceList}" status="i" var="userInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    
                    <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "businessAddress")}</g:link></td>
                    
                    <td>${fieldValue(bean: userInstance, field: "businessPhone")}</td>
                    
                    <td><g:formatBoolean boolean="${userInstance.isVerified}"/></td>
                    
                    <td>${fieldValue(bean: userInstance, field: "password")}</td>
                    
                    <td>${fieldValue(bean: userInstance, field: "username")}</td>
                    
                </tr>
            </g:each>
            </tbody>
        </table>

        <div id="pagination">
            <g:paginate total="${userInstanceTotal}"/>
        </div>
    </div>
</div>
</body>
</html>
