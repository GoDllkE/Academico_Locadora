<%-- 
    Document   : cliente
    Created on : 30/03/2016, 10:07:07
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
        <!-- The above 3 meta tags *must* come first in the head; 
        any other head content must come *after* these tags -->
        <title>Cadastro de Cliente</title>

        <!-- Bootstrap (Local) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        
        <script src="js/bootstrap-combobox.js"></script>
        <link href="css/bootstrap-combobox.css" rel="stylesheet">

        <!-- Our CSS -->
        <link rel="stylesheet" type="text/css" href="src/css/cadastro_style.css">
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
            <li class="disabled">Cadastro</li>
            <li class="disabled">Cliente</li>
        </ol><hr>
        
        <!-- Formulario para cadastro -->
        <div class="page-header formularios-center">
            <h1>Cadastro de cliente<small> para facilitar as coisas!</small></h1>
        </div
        
        <!-- Painel de login -->
        <div class="panel panel-default formularios-painel formulario-middle formulario-backround">
            <div class="panel-body">
                <form name="Cadastro_Cliente" method="post" action="Cadastrar_Cliente">
                    <div class="alert alert alert-info alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="info" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <strong>Observação:</strong> Entre os dados corretamente!
                    </div>
                    <!-- Nome -->
                    <label for="basic-url">Nome</label>
                    <span class="label label-primary">Necessario</span>
                    <div class="input-group formulario-middle">
                        <span class="input-group-addon" id="basic-addon1">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        </span>
                        <input name="Nome" type="text" class="form-control" placeholder="Ex: joão Ninguem" aria-describedby="basic-addon1">
                    </div>
                    <br>

                    <!-- Idade -->
                    <label for="basic-url">Idade</label>
                    <span class="label label-primary">Necessario</span>
                    <div class="input-group">
                        <input name="Idade" type="text" class="form-control" aria-label="Idade" placeholder="Ex: 15">
                        <span class="input-group-addon">Anos</span>
                    </div>
                    <br>

                    <!-- Genero -->
                    <label for="basic-url">Genero</label>
                    <span class="label label-primary">Necessary</span>
                    <div class="form-group">
                        <select Name="Genero" class="combobox form-control" placeholder="Selecione uma opção">
                          <option selected="selected"></option>
                          <option value="Masculino">Masculino</option>
                          <option value="Feminino">Feminino</option>
                          <option value="Indefinido">Indefinido</option>
                          <option value="Outros">Outros</option>
                        </select>
                    </div>
                    <script type="text/javascript">
                        $(document).ready(function(){
                        $('.combobox').combobox();
                        });
                    </script>

                    <!-- CPF -->
                    <label for="basic-url">CPF</label>
                    <span class="label label-primary">Necessario</span>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">
                            <span class="glyphicon glyphicon-grain" aria-hidden="true"></span>
                        </span>
                        <input name="CPF" type="text" class="form-control" placeholder="Ex: 123.456.789-10" aria-describedby="basic-addon1">
                    </div>
                    <br>

                    <!-- RG -->
                    <label for="basic-url">RG</label>
                    <span class="label label-primary">Necessario</span>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                        </span>
                        <input name="RG" type="text" class="form-control" placeholder="Ex: 01.123.456-7" aria-describedby="basic-addon1">
                    </div>
                    <br>

                    <!-- Telefone -->
                    <label for="basic-url">Telefone</label>
                    <span class="label label-primary">Necessario</span>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">
                            <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
                        </span>
                        <input name="Telefone" type="text" class="form-control" placeholder="Ex: (11)1234-5678" aria-describedby="basic-addon1">
                    </div>
                    <br>

                    <!-- Endereço -->
                    <label for="basic-url">Endereço</label>
                    <span class="label label-primary">Necessary</span>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">
                            <span class="glyphicon glyphicon-tree-deciduous" aria-hidden="true"></span>
                        </span>
                        <input name="Endereco" type="text" class="form-control" placeholder="Ex: Rua dos bobos, 0" aria-describedby="basic-addon1">
                    </div><br>
                    <center>
                        <button type="submit" name="post" value="login" class="btn btn-primary formulario-btn "><b>Cadastrar</b></button>
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
