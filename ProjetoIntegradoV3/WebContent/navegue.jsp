<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="shortcut icon" href="img/favicon.png" sizes="32x32" type="image/png">
    <title>Cyber Supply</title>
</head>
<body>
<!--importação do menu-->
<c:import url="menu.jsp"/>

<div id="main" class="content">
    <div class="container">
        <div>
            <h1 class="display-1">Conheça os projetos</h1>
            <div style="margin-bottom: 20px; margin-top: 20px;">
                <form>
                    <input style="color: white; background-color: black;" class="form-control mr-sm-2" type="search" placeholder="Filtre os projetos..." aria-label="Pesquisa" id="pesquisa">
                </form>
            </div>
        </div>
            <hr style="background-color: white;">
        <div class="list-group">
	        <c:forEach var="b" items="${lista}">
	        
	        	<a href="#" class="list-group-item list-group-item-action rounded" id="usuarioNavegue">
					<div class="row">
		        		<div class="col-md-9" style="margin-left:14px;">
		        			<div class="row">
		        				<h1 class="display-4" id="projetoTitulo">${b.nome}</h1>
		        			</div>
		        			<div class="row">
		        				<p id="projetoUsuario"><strong>Linguagem do Projeto</strong>${b.linguagem}</p>
		        			</div>
		        			<div class="row">
		        				<p id="projetoUsuario"><strong>Email: </strong>${b.email}</p>
		        			</div>
		        			<div class="row">
		        				<p id="projetoUsuario"><Strong>Preço: </Strong>${b.preco}</p>
		        			</div>
		        		</div>
		        		<div class="col-md-2">
		        			<form action="VerProjeto.do" method="post">
		        				<input type=hidden value="${b.id}" name="id">
		        				<button type="submit" name="acao" value="verDoNavegue" class="btn btn-warning">Visualizar projeto</button>
		        			</form>
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