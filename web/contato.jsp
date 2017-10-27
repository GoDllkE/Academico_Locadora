<%-- 
    Document   : contato
    Created on : 30/03/2016, 10:07:52
    Author     : 28226142
--%>

<%@page import="VO.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Web Page</title>

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
            <li>Contacto</li>
        </ol>
    </body>
</html>