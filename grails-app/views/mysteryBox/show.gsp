
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
                <div class="col-sm-12">
                    <geek:image obj="${mysteryBox}" />
                </div>
            </div>

            <div class="row">
                <g:link controller="MysteryBoxEdition" action="create" params="${['box.id': mysteryBox.id]}">
                    <button type="button" class="btn btn-primary">
                        <g:message code="default.new.label" args="${message(code:'mysteryBoxEdition.label')}" />
                    </button>
                </g:link>
            </div>
        </div>

    </body>
</html>
