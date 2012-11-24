<% import grails.persistence.Event %>
<%=packageName%>
<!doctype html>
<html>
<head>
    <meta name="layout" content="admin">
    <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="page-header">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
</div>

<g:if test="\${flash.message}">
    <div class="alert" role="status">\${flash.message}</div>
</g:if>

<div class="row">
    <div class="span3">
        <g:link class="btn" action="create"><g:message code="default.create.label" args="[entityName]"/></g:link>
    </div>

    <div id="list-${domainClass.propertyName}" class="span9 content scaffold-list" role="main">
        <table class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                <% excludedProps = Event.allEvents.toList() << 'id' << 'version'
                allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
                props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && it.type != null && !Collection.isAssignableFrom(it.type) }
                Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                props.eachWithIndex { p, i ->
                    if (i < 6) {
                        if (p.isAssociation()) { %>
                <th><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}"/></th>
                <% } else { %>
                <g:sortableColumn property="${p.name}" title="\${message(code: '${domainClass.propertyName}.${p.name}.label', default: '${p.naturalName}')}"/>
                <% }
                }
                } %>
            </tr>
            </thead>
            <tbody>
            <g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
                <tr class="\${(i % 2) == 0 ? 'even' : 'odd'}">
                    <% props.eachWithIndex { p, i ->
                        if (i == 0) { %>
                    <td><g:link action="show" id="\${${propertyName}.id}">\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</g:link></td>
                    <% } else if (i < 6) {
                        if (p.type == Boolean || p.type == boolean) { %>
                    <td><g:formatBoolean boolean="\${${propertyName}.${p.name}}"/></td>
                    <% } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
                    <td><mat:formatDate date="\${${propertyName}.${p.name}}"/></td>
                    <% } else { %>
                    <td>\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</td>
                    <% }
                    }
                    } %>
                </tr>
            </g:each>
            </tbody>
        </table>

        <div id="pagination">
            <g:paginate total="\${${propertyName}Total}"/>
        </div>
    </div>
</div>
</body>
</html>
