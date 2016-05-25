
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
                        <div class="thumbnail">
                            <div class="row">
                                <div class="col-sm-8 crop">
                                    <geek:image mysteryBox="${box}" />
                                </div>
                                <div class="col-sm-4 caption">
                                    <h3><%= box.name %></h3>
                                    <p>
                                        <a href="http://${box.url}">
                                            http://<%= box.url %>
                                        </a>
                                    </p>
                                    <p>
                                        <b><g:message code="mysteryBox.minPrice" />: </b>
                                        R$ <g:formatNumber number="${box.minPrice}" minFractionDigits="2" />
                                        <g:if test="${box.freight}">
                                            + frete
                                        </g:if>
                                    </p>
                                    <p>
                                        <b><g:message code="mysteryBox.defaultProducts" />: </b>
                                        <%= box.defaultProducts %>
                                    </p>
                                    <p>
                                        <a href="${createLink(action: 'show', id: box.id)}" class="btn btn-default" role="button">
                                            <g:message code="mysteryBox.moreDetails" />
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </div>
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
