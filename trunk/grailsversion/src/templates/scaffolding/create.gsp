<%=packageName%>
<!doctype html>
<html>
<head>
    <meta name="layout" content="admin">
    <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div class="page-header">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
</div>

<g:if test="\${flash.message}">
    <div class="alert" role="status">\${flash.message}</div>
</g:if>

<div class="row">
    <div class="span3">
        <g:link class="btn" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link>
    </div>

    <div id="create-${domainClass.propertyName}" class="span9 scaffold-create" role="main">
        <g:hasErrors bean="\${${propertyName}}">
            <ul class="errors" role="alert">
                <g:eachError bean="\${${propertyName}}" var="error">
                    <li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
        <g:form action="save" <%=multiPart ? ' enctype="multipart/form-data"' : '' %>>
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save btn btn-primary" value="\${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>
