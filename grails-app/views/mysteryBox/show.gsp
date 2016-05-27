
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
                <div class="col-md-8">

                    <div class="media">
                        <g:each var="edition" in="${mysteryBox.editions}">
                            <div class="media-left media-middle">
                                <geek:image obj="${edition}" class="media-object" width="64px" />
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading"><%= edition.theme %></h4>
                                <ul class="list-group">
                                    <g:each var="item" in="${edition.items}">
                                        <li class="list-group-item"><%= item.name %></li>
                                    </g:each>
                                    <li class="list-group-item">
                                        <g:form action="save" controller="mysteryBoxItem" class="form-inline">
                                            <div class="form-group">
                                                <input type="text" class="form-control" placeholder="Novo item">
                                            </div>
                                            <button type="submit" class="btn btn-default">Adicionar</button>
                                        </g:form>
                                    </li>
                                </ul>
                            </div>
                        </g:each>
                    </div>

                </div>
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
