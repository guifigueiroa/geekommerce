<div class="container">
    <div class="row">
        <div class="col-md-6">
            <g:form action="${edition ? 'update' : 'save'}" method="${edition ? 'PUT' : 'POST'}">
                <div class="form-group">
                    <g:hiddenField name="id" value="${edition?.id}" />
                    <div class="form-group">
                        <label for="email"><g:message code="user.email" />:</label>
                        <g:textField class="form-control" name="email" value="${user?.email}" />
                    </div>

                    <div class="form-group">
                        <label for="password"><g:message code="user.password" />:</label>
                        <g:passwordField class="form-control" name="password" />
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword"><g:message code="user.confirmPassword" />:</label>
                        <g:passwordField class="form-control" name="confirmPassword" />
                    </div>
                </div>
                <input type="submit" class="btn btn-default" value="${message(code: (user ? 'default.button.update.label' : 'default.button.create.label'))}"/>
            </g:form>
        </div>
    </div>
</div>
