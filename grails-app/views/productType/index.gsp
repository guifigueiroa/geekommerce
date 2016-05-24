
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

        <geek:messages />

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <table class="table table-striped">
                        <thead><td><b><g:message code="productType.name" /></b></td></thead>
                        <g:each var="type" in="${productTypeList}">
                            <tr><td><%= type.name %></td></tr>
                        </g:each>
                    </table>
                </div>
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
