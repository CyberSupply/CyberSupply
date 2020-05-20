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
    <div class="container jumbotron" style="background-color: rgb(58, 58, 58);">
        
        <div class="row">
                <div class="col-sm" style="color:white;">
                    <img src="${a.imagem}" class="avatar img-circle rounded img-thumbnail" alt="avatar">
                        <div style="margin-top: 30px;" class="row">
                        
                        </div>
                    
                    <div class="row">
                    	<form action="CarregaProjetosNoPerfil.do" method="post">
                			<button type="submit" class="btn btn-warning">Ver Projetos</button>
                			<a class="btn btn-success" href="CriarProjeto.do?">+ Novo projeto</a>
                    	</form>
                    </div>
                </div>
                <div class="col-sm" style="color:white; font-size: 23px;">
                    <h2 class="display-4" style="color: white; margin-bottom: 22px;">${a.nome}</h2>
                    
                    
                    
                    <hr style="background-color: white;">
                    <p><strong>Interesse: </strong> Web Designer / UI. </p>
                    <p><strong>Bio: </strong> Descrição ou bio. </p>
                    <p><strong>Skills: </strong>
                        <span class="badge badge-warning">html5</span> 
                        <span class="badge badge-warning">css3</span>
                        <span class="badge badge-warning">jquery</span>
                        <span class="badge badge-warning">javascript</span>
                    </p>                   
                </div>
               
        </div>

        <c:if test="${not empty projeto}">
        <div class="row" style="margin-top:20px">
        	<table class="table table-dark">
	    		<thead>
	    			<tr>
	    				<th scope="col">Nome</th>
	    				<th scope="col">Linguagem</th>
	    				<th scope="col">Preço</th>
	    				<th scope="col">Ações</th>
	    			</tr>
	    		</thead>
	    		<tbody>
	    		<c:forEach var="projeto" items="${projeto}"> 
	    			<tr>
	    				<th>${projeto.nome}</th>
	    				<th>${projeto.linguagem}</th>
	    				<th>${projeto.preco}</th>
	    				<th class ="actions">
		    				<form action="VerProjeto.do" method="post">
		        				<input type="hidden" name="id" value="${projeto.id}">
			        			<button type="submit" class="btn btn-success btn-sm" name="acao" value="Visualizar">Visualizar</button>
		                        <button type="submit" class="btn btn-warning btn-sm" name="acao" value="Alterar">Editar</button>
		                        <button type="submit" class="btn btn-danger btn-sm" name="acao" value="Excluir">Excluir</button>
		                    </form>
	    				</th>
	    			</tr>
	    		</c:forEach>
	    		</tbody>
	    	</table>
	    	
    	</div>
    	</c:if>
    	<form action="LogOut.do" method="get">
	    		<button type="submit" class="btn btn-outline-danger btn-lg float-right" style="margin: 1px; ">Log Out</button>
			</form> 
    	<form action="AlterarTransicao.do" method="get">
			            <button type="submit" class="btn btn-outline-warning btn-lg" style="float: right; margin: 1px;">Editar perfil</button>
			        </form>
    </div>
</div>

    <footer class="page-footer font-small blue" style="bottom:0;width:100%;">
        <div class="footer-copyright text-center py-3">© 2020 Copyright: <a style="color: rgb(196, 196, 196);">CyberSupply CO.</a>
        </div>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </footer>

</body>
</html>