<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'productType.label', default: 'ProductType')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.create.label" args="[entityName]" /></h3>
        </div>

        <geek:messages />

        <div class="container">
            <div class="row">
            <div class="col-md-5">
                <g:form action="save">
                    <div class="form-group">
                        <label for="name"><g:message code="productType.name" />:</label>
                        <g:textField class="form-control" name="name"/>
                    </div>
                    <input type="submit" class="btn btn-default" value="${message(code: 'default.button.create.label')}"/>
                </g:form>
            </div>
            </div>
        </div>
    </body>
</html>
