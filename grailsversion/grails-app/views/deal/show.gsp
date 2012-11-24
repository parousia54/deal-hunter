<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'deal.label', default: 'Deal')}"/>
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
        <div class="property-list deal">
            
            <img src="${createLink(controller: 'image', params:[path: deal.dealImageURL])}"/>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="deal.dealTitle.label" default="Deal Title"/></span>
                
                <span class="property-value" aria-labelledby="dealTitle-label"><g:fieldValue bean="${deal}" field="dealTitle"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="deal.dealDescription.label" default="Deal Description"/></span>
                
                <span class="property-value" aria-labelledby="dealDescription-label"><g:fieldValue bean="${deal}" field="dealDescription"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="deal.dealStartDate.label" default="Deal Start Date"/></span>
                
                <span class="property-value" aria-labelledby="dealStartDate-label"><mat:formatDate date="${deal?.dealStartDate}"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="deal.dealEndDate.label" default="Deal End Date"/></span>
                
                <span class="property-value" aria-labelledby="dealEndDate-label"><mat:formatDate date="${deal?.dealEndDate}"/></span>
                
            </p>
            
            <p class="clearfix">
                <span class="property-label"><g:message code="deal.dealScore.label" default="Deal Score"/></span>
                
                <span class="property-value" aria-labelledby="dealScore-label"><g:fieldValue bean="${deal}" field="dealScore"/></span>
                
            </p>
            
        </div>
        <g:form>
            <fieldset class="buttons">
                <g:hiddenField name="id" value="${deal?.id}"/>
                <g:link class="btn" action="edit" id="${deal?.id}"><g:message code="default.button.edit.label" default="Edit »"/></g:link>
                <g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </fieldset>
        </g:form>
    </div>
</div>
</div>
</body>
</html>
