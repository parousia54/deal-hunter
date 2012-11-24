
<!doctype html>
<html>
<head>
    <meta name="layout" content="admin">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div class="page-header">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
</div>

<g:if test="${flash.message}">
    <div class="alert" role="status">${flash.message}</div>
</g:if>

<div class="row">
    <div class="span3">
        <g:link class="btn" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link>
    </div>

    <div class="span9">
        <div class="property-list user">
            
            <p class="clearfix">
                <span class="property-label"><g:message code="user.businessAddress.label" default="Business Address"/></span>
                
                <span class="property-value" aria-labelledby="businessAddress-label"><g:fieldValue bean="${userInstance}" field="businessAddress"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="user.businessPhone.label" default="Business Phone"/></span>
                
                <span class="property-value" aria-labelledby="businessPhone-label"><g:fieldValue bean="${userInstance}" field="businessPhone"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="user.isVerified.label" default="Is Verified"/></span>
                
                <span class="property-value" aria-labelledby="isVerified-label"><g:formatBoolean boolean="${userInstance?.isVerified}"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="user.password.label" default="Password"/></span>
                
                <span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="user.username.label" default="Username"/></span>
                
                <span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>
                
            </p>
            
        </div>
        <g:form>
            <fieldset class="buttons">
                <g:hiddenField name="id" value="${userInstance?.id}"/>
                <g:link class="btn" action="edit" id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit »"/></g:link>
                <g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </fieldset>
        </g:form>
    </div>
</div>
</div>
</body>
</html>
