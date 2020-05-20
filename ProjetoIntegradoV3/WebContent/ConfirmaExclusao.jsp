<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="img/favicon.png" sizes="32x32" type="image/png">
    <title>Cyber Supply</title>
</head>
<body>
<!--importação do menu-->
<c:import url="menu.jsp"/>

<div id="main">
    <div class="container login-container">
        <div class="row">
            <div class="col-md login-form">
                <h1 class="display-1">Tem certeza que deseja excluir?</h1><h4 style="color:white;">Confirme seu email para prosseguir.</h4>
                <form action="CRUDExcluir.do" method="get">
                	<div class="form-group">
	                    <input class="form-control" type="text" name="email" placeholder="Email/CNPJ">
	                </div>
	                
	                <div class="form-group">
	                    <input class="form-control" type="password" name="senha" placeholder="Confirme sua senha">
	                </div>
	                
	                <div class="form-group">
	                    <input class="form-control" type="password" name="senha2" placeholder="Digite-a novamente">
	                </div>
	                
	                <!--<button type="submit" class="btn btn-outline-warning btn-lg" style="float: right; margin-right:12px" name="acao" value="cancelar">Cancelar</button>-->
  					<button type="submit" class="btn btn-outline-warning btn-lg" style="float: left;" name="acao" value="cancelar">Cancelar</button>
					<button class="btn btn-danger btn-lg" type="submit" style="float:right;" name="acao" value="excluir">Excluir</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!--importação do Footer-->
    <footer class="page-footer font-small blue" style="bottom:0;width:100%;position:absolute;">
        <div class="footer-copyright text-center py-3">© 2020 Copyright: <a style="color: rgb(196, 196, 196);">CyberSupply CO.</a>
        </div>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </footer>

</body>
</html>