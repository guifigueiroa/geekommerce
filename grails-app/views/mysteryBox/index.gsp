
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'mysteryBox.label', default: 'Mystery Box')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.list.label" args="[entityName]" /></h3>
        </div>

        <geek:messages />

        <div class="container">

            <div class="row">
                <g:each var="box" in="${mysteryBoxList}">
                    <div class="col-sm-10">
                        <g:render template="box" collection="${box}" var="box"/>
                    </div>
                </g:each>
            </div>

            <div class="row">
                <g:link class="create" action="create">
                    <button type="button" class="btn btn-primary">
                        <g:message code="default.new.label" args="[entityName]" />
                    </button>
                </g:link>
            </div>
        </div>

    </body>
</html>
