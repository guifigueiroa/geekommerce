<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'mysteryBoxEdition.label', default: 'MysteryBoxEdition')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.edit.label" args="[entityName]" /></h3>
        </div>

        <geek:messages />

        <g:render template="editionForm" var="edition" bean="${this.mysteryBoxEdition}" />
    </body>
</html>
