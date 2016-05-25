<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'mysteryBoxEdition.label', default: 'MysteryBoxEdition')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="blue">
            <h3><g:message code="default.create.label" args="[entityName]" /></h3>
        </div>

        <geek:messages />

        <div class="container">
            <div class="row">
                <g:render template="box" contextPath="../mysteryBox" collections="${mysteryBoxEdition?.box}" var="box" />
            </div>
            <div class="row">
                <div class="col-md-6">
                    <g:form action="save" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="theme"><g:message code="mysteryBoxEdition.theme" />:</label>
                                <g:textField class="form-control input-lg" name="theme"/>
                            </div>

                            <div class="form-group">
                                <label for="date"><g:message code="mysteryBoxEdition.date" />:</label>
                                <g:datePicker name="date" value="${new Date()}"
                                    noSelection="['':'-Choose-']" precision="month"
                                    years="${2010..2020}" />
                            </div>

                            <div class="form-group">
                                <label for="image"><g:message code="mysteryBoxEdition.image" />:</label><br/>
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
