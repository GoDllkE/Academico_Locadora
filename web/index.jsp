<%-- 
    Document   : index
    Created on : 09/03/2016, 10:14:37
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
        <title>Locadoras N4</title>

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
                    
        <%
            if(session.getAttribute("errorMessage") != null) {
                out.println("<div class=\"alert alert alert-danger alert-dismissible formularios-center\" data-dismiss=\"alert\" role=\"danger\">");
                out.println("<button type=\"button\" class=\"close\" data-dismiss=\"info\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>");
                out.println("<span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>");
                out.println("<strong>Error:</strong> " + request.getAttribute("errorMessage") + "</div>");
            }
            else if(session.getAttribute("sucessMessage") != null) {
                out.println("<div class=\"alert alert alert-success alert-dismissible formularios-center\" data-dismiss=\"alert\" role=\"danger\">");
                out.println("<button type=\"button\" class=\"close\" data-dismiss=\"info\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>");
                out.println("<span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>");
                out.println("<strong>Sucess:</strong> " + request.getAttribute("sucessMessage") + "</div>");
            }
        %>      
                    
        <!-- Jumbotron -->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="src/img/Banner1.jpg" width="1366" alt="Cloud">
              <div class="carousel-caption">
                Something to say here
              </div>
            </div>
            <div class="item">
                <img src="src/img/Banner2.jpg" width="1366" alt="Cloud">
              <div class="carousel-caption">
                Something to say here
              </div>
            </div>
            <div class="item">
                <img src="src/img/Banner3.jpg" width="1366" alt="Cloud">
              <div class="carousel-caption">
                Something to say here
              </div>
            </div>
            Something to say here
          </div>

          <!-- Controls -->
          <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <br><br><hr><br>

        <div class="align-center">
            <h1>Services<br><small>The best way to upgrade your company</small></h1>
        </div>
        <br><br>
        <div class="row thumbnails-align thumbnails-grid">
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img src="src/img/cloud.jpg" alt="Cloud Computing">
                    <div class="caption">
                        <h3>Cloud Computing Services</h3>
                        <p>Want to get the best service of cloud computing?<br>Contact us and you'll discover what's the meaning of be the best of cloud computing</p>
                        <p><center>
                            <a href="contato.jsp" class="btn btn-primary thumbnails-btn" role="button">Contato</a> 
                            <a href="#" class="btn btn-default thumbnails-btn" role="button">Ler mais</a>
                        </center></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img src="src/img/cloud.jpg" alt="Cloud Computing">
                    <div class="caption">
                        <h3>Cloud Computing Services</h3>
                        <p>Want to get the best service of cloud computing?<br>Contact us and you'll discover what's the meaning of be the best of cloud computing</p>
                        <p><center>
                            <a href="contato.jsp" class="btn btn-primary thumbnails-btn" role="button">Contato</a> 
                            <a href="#" class="btn btn-default thumbnails-btn" role="button">Ler mais</a>
                        </center></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img src="src/img/cloud.jpg" alt="Cloud Computing">
                    <div class="caption">
                        <h3>Cloud Computing Services</h3>
                        <p>Want to get the best service of cloud computing?<br>Contact us and you'll discover what's the meaning of be the best of cloud computing</p>
                        <p><center>
                            <a href="contato.jsp" class="btn btn-primary thumbnails-btn" role="button">Contato</a> 
                            <a href="#" class="btn btn-default thumbnails-btn" role="button">Ler mais</a>
                        </center></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row thumbnails-align thumbnails-grid">
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img src="src/img/cloud.jpg" alt="Cloud Computing">
                    <div class="caption">
                        <h3>Cloud Computing Services</h3>
                        <p>Want to get the best service of cloud computing?<br>Contact us and you'll discover what's the meaning of be the best of cloud computing</p>
                        <p><center>
                            <a href="contato.jsp" class="btn btn-primary thumbnails-btn" role="button">Contato</a> 
                            <a href="#" class="btn btn-default thumbnails-btn" role="button">Ler mais</a>
                        </center></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img src="src/img/cloud.jpg" alt="Cloud Computing">
                    <div class="caption">
                        <h3>Cloud Computing Services</h3>
                        <p>Want to get the best service of cloud computing?<br>Contact us and you'll discover what's the meaning of be the best of cloud computing</p>
                        <p><center>
                            <a href="contato.jsp" class="btn btn-primary thumbnails-btn" role="button">Contato</a> 
                            <a href="#" class="btn btn-default thumbnails-btn" role="button">Ler mais</a>
                        </center></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <img src="src/img/cloud.jpg" alt="Cloud Computing">
                    <div class="caption">
                        <h3>Cloud Computing Services</h3>
                        <p>Want to get the best service of cloud computing?<br>Contact us and you'll discover what's the meaning of be the best of cloud computing</p>
                        <p><center>
                            <a href="contato.jsp" class="btn btn-primary thumbnails-btn" role="button">Contato</a>
                            <a href="#" class="btn btn-default thumbnails-btn" role="button">Ler mais</a>
                        </center></p>
                    </div>
                </div>
            </div>
        </div>
        <br><br><hr>
        <br>
    </body>
</html>


