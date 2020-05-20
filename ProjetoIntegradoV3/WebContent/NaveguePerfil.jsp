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
<!--importacao do menu-->
<c:import url="menu.jsp"/>

<div id="main" class="content">
    <div class="container">
        <div>
            <h1 class="display-1">Conheça mais usuários</h1>
            <div style="margin-bottom: 20px; margin-top: 20px;">
                <form>
                    <input style="color: white; background-color: black;" class="form-control mr-sm-2" type="search" placeholder="Filtre os projetos..." aria-label="Pesquisa" id="pesquisa">
                </form>
            </div>
        </div>
            <hr style="background-color: white;">
        <div class="list-group">
	        <c:forEach var="a" items="${lista}">
	        	<a href="#" class="list-group-item list-group-item-action rounded" id="usuarioNavegue">
					<div class="row">
		        		<div class="col-sm-auto">
		        			<img class="projetoImg rounded-circle" src="${a.imagem}">
		        		</div>
		        		<div class="col-md-9">
		        			<div class="row">
		        				<h1 class="display-4" id="projetoTitulo">${a.nome}</h1>
		        			</div>
		        			<div class="row">
		        				<p id="projetoUsuario">Quantidade de projetos: <strong>90</strong></p>
		        			</div>
		        		</div>
		        		<div class="col-md-1">
		        			<button class="btn btn-warning">Visualizar perfil</button>
		        		</div>
		        	</div>
	  			</a>
	  		</c:forEach>
        </div>
    </div>
</div>

<!--importação do Footer-->
<c:import url="Footer.jsp"/>

</body>
</html>