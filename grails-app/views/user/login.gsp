<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="login.title" /></title>
</head>
<body>
    <geek:messages />

    <div id="content">
        <div class="container">
            <g:form action="doLogin" method="post" class="form-signin">
                <h3 class="form-signin-heading">Entre no Geek kommerce  </h3>

                <label for="email" class="sr-only">Email:</label>
                <input id="email" type="text" name="email" value="${user?.email}"
                    class="form-control" placeholder="${g.message(code: 'user.email')}" required autofocus />

                <label for="password" class="sr-only">Password:</label>
                <input id="password" type="password" name="password" value="${user?.password}"
                    class="form-control" placeholder="${g.message(code: 'user.password')}" required />

                <input type="submit" value="${g.message(code: 'login.title')}" class="btn btn-lg btn-primary btn-block"></input>

                <p>
                    <g:message code="login.newToGeekommerce" />

                    <g:link action="create">
                        <g:message code="login.createAnAccount" />
                    </g:link>
                </p>
            </g:form>
        </div>
    </div>
</body>
</html>
