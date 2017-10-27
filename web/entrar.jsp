<%-- 
    Document   : login
    Created on : 09/03/2016, 08:40:27
    Author     : Gustavo Toledo
--%>

<%@page import="VO.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <!-- The above 3 meta tags *must* come first in the head; 
         any other head content must come *after* these tags -->
        <title>Login - Locadoras N4</title>

        <!-- Bootstrap (Local) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Our CSS -->
        <link rel="stylesheet" type="text/css" href="src/css/style.css">
    </head>
    <body>
        <!--Start -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        Locadoras N4
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="about.jsp">A empresa<span class="sr-only">(current)</span></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastro<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="cliente.jsp">Cliente</a></li>
                                <li><a href="filme.jsp">Filme</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="genero.jsp">Genero</a></li>
                                <li><a href="diretor.jsp">Diretor</a></li>
                                <li><a href="produtora.jsp">Produtora</a></li>
                                <li><a href="classificacao.jsp">Classificação</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="outros.jsp">Outros...</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gerenciar<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="gerenciar/cliente.jsp">Cliente</a></li>
                                <li><a href="gerenciar/filme.jsp">Filme</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="gerenciar/genero.jsp">Genero</a></li>
                                <li><a href="gerenciar/diretor.jsp">Diretor</a></li>
                                <li><a href="gerenciar/produtora.jsp">Produtora</a></li>
                                <li><a href="gerenciar/classificacao.jsp">Classificação</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="outros.jsp">Outros...</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Serviços<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="servico/reserva.jsp">Reserva</a></li>
                                <li><a href="servico/emprestimo.jsp">Emprestimo</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="outros.jsp">Outros...</a></li>
                            </ul>
                        </li>
                        <li><a href="contato.jsp">Contato</a></li>
                    </ul>
                    <ul class="navbar-right">
                        <%
                            if(session.getAttribute("user") != null) {
                                Login log = (Login)session.getAttribute("user");
                                out.write("<font class=\"navbar-text\"> Logged as <a href=\"#\" class=\"navbar-link\">" + log.getUser() + "</a></font>");
                            }
                            else {
                                out.println("<div class=\"btn-group nav navbar-right\" role=\"group\">");
                                out.println("<a href=\"signin.jsp\" class=\"btn btn-primary navbar-btn btn-md\" role=\"button\">Cadastar</a>");
                                out.println("<a href=\"entrar.jsp\" class=\"btn btn-primary navbar-btn btn-md\" role=\"button\">Entrar</a>");
                                out.println("</div>");
                            }
                        %>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Breadcrumbs (Rastro de navegação) -->
        <ol class="breadcrumb">
            <span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
            <li><a href="index.jsp">Home</a></li>
            <li class="disabled">Login</li>
        </ol>

        <!-- Painel de login -->
        <div class="panel panel-default formularios-painel formulario-middle formulario-backround">
            <div class="panel-body">                    
                <%
                    if(request.getAttribute("errorMessage") != null) {
                        out.println("<div class=\"alert alert alert-danger alert-dismissible formularios-center\" data-dismiss=\"alert\" role=\"danger\">");
                        out.println("<button type=\"button\" class=\"close\" data-dismiss=\"info\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>");
                        out.println("<span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>");
                        out.println("<strong>Information:</strong> " + request.getAttribute("errorMessage") + "</div>");
                    }
                %>
                <form name="Login_Sistema" method="post" action="Login_Sistema">
                    <!-- Formulario para cadastro -->
                    <br>
                    <div class="input-group input-group-lg formularios-center">
                        <span class="input-group-addon" id="sizing-addon1">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        </span>
                        <input type="text" name="Nome" class="form-control" placeholder="Ex: João" aria-describedby="sizing-addon1">
                    </div>
                    <br>
                    <div class="input-group input-group-lg formularios-center">
                        <span class="input-group-addon" id="sizing-addon1">
                            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
                        </span>
                        <input type="text" name="Senha" class="form-control" placeholder="Ex: 123456" aria-describedby="sizing-addon1">
                    </div>
                    <div class="formularios-center">
                        <div class="formularios-left">
                            <a class="disabled" href="#" target="_self">Forgot password?</a>
                        </div>
                        <div class="checkbox checkbox-inline" >
                            <input type="checkbox" checked=true aria-label="lembrar-me"> Remember-me <br>
                            <input type="checkbox" aria-label="checkbox" aria-label="visibilidade"> Login como invisivel
                        </div>
                    </div><br>
                    <center>
                        <button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary formulario-btn" autocomplete="off">Login</button>
                    </center>
                </form>
            </div>
            <!-- End of Login-Formulary-panel-content -->
        </div>	
        <!-- End of Login-Formulary-panel -->
        <br>
        <br>
    </body>
</html>
