
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
                <g:each var="edition" in="${mysteryBox.editions}">
                <div class="col-md-8">
                    <div class="media">
                        <div class="media-left media-middle">
                            <geek:image obj="${edition}" class="media-object" width="64px" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><%= edition.theme %>
                                <small>
                                    <g:link action="edit" controller="mysteryBoxEdition" id="${edition.id}">
                                        <g:message code="default.button.edit.label" />
                                    </g:link>
                                </small>
                            </h4>
                            <g:render template="../mysteryBoxEdition/edition" var="edition" bean="${edition}" />
                        </div>
                    </div>
                </div>
                </g:each>
            </div>

            <div class="row">
                <g:link controller="MysteryBoxEdition" action="create" params="${['box.id': mysteryBox.id]}">
                    <button type="button" class="btn btn-primary">
                        <g:message code="default.new.label" args="${[message(code:'mysteryBoxEdition.label')]}" />
                    </button>
                </g:link>
            </div>
        </div>

    </body>
</html>
