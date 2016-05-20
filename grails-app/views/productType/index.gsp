
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'productType.label', default: 'ProductType')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.list.label" args="[entityName]" /></h3>
        </div>
        <ul>
        <g:each var="type" in="${productTypeList}">
            <li><%= type.name %></li>
        </g:each>
        </ul>
        </div>
    </body>
</html>
