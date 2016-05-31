<div class="container">
    <div class="row">
        <div class="col-md-6">
            <g:form action="${edition ? 'update' : 'save'}" method="${edition ? 'PUT' : 'POST'}" enctype="multipart/form-data">
                <div class="form-group">
                    <g:hiddenField name="id" value="${edition?.id}" />
                    <div class="form-group">
                        <label for="theme"><g:message code="mysteryBoxEdition.theme" />:</label>
                        <g:textField class="form-control input-lg" name="theme" value="${edition?.theme}" />
                    </div>

                    <div class="form-group date-picker">
                        <label for="date"><g:message code="mysteryBoxEdition.date" />:</label>
                        <g:datePicker class="form-control" name="date" value="${edition ? edition.date : new Date()}"
                            precision="month"
                            years="${2010..2020}" />
                    </div>

                    <div class="form-group">
                        <label for="box"><g:message code="mysteryBox.label" />:</label>
                        <g:select name="box"
                          from="${gui.commerce.MysteryBox.list()}"
                          value="${edition ? edition.box.id : params.box?.id}"
                          optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="image"><g:message code="mysteryBoxEdition.image" />:</label><br/>
                        <input type="file" name="image"/>
                    </div>
                </div>
                <input type="submit" class="btn btn-default" value="${message(code: (edition ? 'default.button.update.label' : 'default.button.create.label'))}"/>
            </g:form>
        </div>

        <div class="col-md-6">
            <g:if test="${controllerName == 'mysteryBoxEdition' && edition}">
            <label><g:message code="mysteryBoxEdition.items" /></label>
            <g:render template="edition" var="edition" bean="${edition}" />
            </g:if>
        </div>
    </div>
</div>
