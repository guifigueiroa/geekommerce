<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="home.title" /></title>

    <!--asset:link rel="icon" href="favicon.ico" type="image/x-ico" /-->
</head>
<body>
    <div id="blue">
        <h1>Bem-vindo ao Geek.kommerce</h1>
    </div>
    <div class="container">
            <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
    </div>

</body>
</html>
