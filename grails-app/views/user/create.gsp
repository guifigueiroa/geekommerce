<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.create.label" args="[entityName]" /></h3>
        </div>

        <geek:messages />

        <g:render template="userForm" />
    </body>
</html>
