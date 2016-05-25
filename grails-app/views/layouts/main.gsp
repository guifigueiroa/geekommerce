<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${createLink(uri: '/')}">GEEK.KOMMERCE</a>
        </div>
        <div class="navbar-collapse collapse navbar-right">
          <ul class="nav navbar-nav">
            <geek:li><a href="${createLink(uri: '/')}"><g:message code="menu.home" /></a></geek:li>
            <geek:li><a href="${createLink(controller: 'mysteryBox', action: 'index')}"><g:message code="menu.mysteryBoxes" /></a></geek:li>
            <geek:li><a href="#"><g:message code="menu.buy" /></a></geek:li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><g:message code="menu.account" /><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#"><g:message code="menu.myProducts" /></a></li>
                <li><a href="#"><g:message code="menu.logout" /></a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <g:layoutBody/>

    <div id="footerwrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <h4>Sobre</h4>
                    <div class="hline-w"></div>
                    <p>Site focado na cultura nerd que tem como objetivo listar as Mystery Boxes disponíveis no Brasil, para podermos compará-las e compartilhar itens à venda.</p>
                </div>
                <div class="col-lg-4">
                    <h4>Social Links</h4>
                    <div class="hline-w"></div>
                    <p>
                    </p>
                </div>
                <div class="col-lg-4">
                    <h4>Ajude-nos</h4>
                    <div class="hline-w"></div>
                    <p>Vocẽ pode nos ajudar postando novidades sobre as mystery boxes, como novos produtos, spoilers e erros em nosso site.</p>
                    <p>Mande um email para: geekommerce@gmail.com</p>
                </div>

            </div><!--/row -->
        </div><!--/container -->
     </div><!--/footerwrap -->

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
