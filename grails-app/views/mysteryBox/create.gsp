<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'mysteryBox.label', default: 'MysteryBox')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.create.label" args="[entityName]" /></h3>
        </div>

        <geek:messages />

        <div class="container">
            <div class="row">
            <div class="col-md-6">
                <g:form action="save" enctype="multipart/form-data">
                    <div class="form-group">
                        <div class="form-group">
                            <label for="name"><g:message code="mysteryBox.name" />:</label>
                            <g:textField class="form-control input-lg" name="name"/>
                        </div>

                        <div class="form-group">
                            <label for="url"><g:message code="mysteryBox.url" />:</label>
                            <div class="input-group">
                            <div class="input-group-addon">http://</div>
                                <g:textField class="form-control" name="url"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="defaultProducts"><g:message code="mysteryBox.defaultProducts" />:</label>
                            <g:textArea class="form-control" name="defaultProducts"/>
                        </div>

                        <div class="form-group">
                            <label for="minPrice"><g:message code="mysteryBox.minPrice" />:</label>
                            <div class="input-group">
                                <div class="input-group-addon">R$</div>
                                <g:textField class="form-control" name="minPrice"/>
                            </div>
                        </div>

                        <div class="checkbox">
                            <label>
                                <g:checkBox name="freight" value="${true}" class="checkbox" /><g:message code="mysteryBox.freight" />
                            </label>
                        </div>

                        <div class="form-group">
                            <label for="image"><g:message code="mysteryBox.image" />:</label><br/>
                            <input type="file" name="image"/>
                        </div>
                    </div>

                    <input type="submit" class="btn btn-default" value="${message(code: 'default.button.create.label')}"/>
                </g:form>
            </div>
            </div>
        </div>
    </body>
</html>
