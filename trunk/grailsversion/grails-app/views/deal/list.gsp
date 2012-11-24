<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'deal.label', default: 'Deal')}"/>
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

    <div id="list-deal" class="span9 content scaffold-list" role="main">
        <table class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                
                <g:sortableColumn property="dealTitle" title="${message(code: 'deal.dealTitle.label', default: 'Deal Title')}"/>
                
                <g:sortableColumn property="dealDescription" title="${message(code: 'deal.dealDescription.label', default: 'Deal Description')}"/>
                
                <g:sortableColumn property="dealStartDate" title="${message(code: 'deal.dealStartDate.label', default: 'Deal Start Date')}"/>
                
                <g:sortableColumn property="dealEndDate" title="${message(code: 'deal.dealEndDate.label', default: 'Deal End Date')}"/>
                
                <g:sortableColumn property="dealScore" title="${message(code: 'deal.dealScore.label', default: 'Deal Score')}"/>
                
            </tr>
            </thead>
            <tbody>
            <g:each in="${dealInstanceList}" status="i" var="dealInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    
                    <td><g:link action="show" id="${dealInstance.id}">${fieldValue(bean: dealInstance, field: "dealTitle")}</g:link></td>
                    
                    <td>${fieldValue(bean: dealInstance, field: "dealDescription")}</td>
                    
                    <td><mat:formatDate date="${dealInstance.dealStartDate}"/></td>
                    
                    <td><mat:formatDate date="${dealInstance.dealEndDate}"/></td>
                    
                    <td>${fieldValue(bean: dealInstance, field: "dealScore")}</td>
                    
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
