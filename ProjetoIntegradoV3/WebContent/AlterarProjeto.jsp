<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/projeto.css">
    <link rel="shortcut icon" href="img/favicon.png" sizes="32x32" type="image/png">
    <title>Cyber Supply</title>
</head>
<body>
<!--importação do menu-->
<c:import url="menu.jsp"/>

<div id="main">
	<h1 class="display-1">Alterar projeto ${projeto.nome}</h1>
	<div class="container">
		<form method="post" action="AlterarProjeto.do">
			<div class="row">
				<div class="col-md">
					<label class="display-1" id="label">Nome do projeto</label>
					<input class="form-control" placeholder="Insira o nome do projeto" name="nome" value="${projeto.nome}">
					<label class="display-1" id="label">Linguagem utilizada</label>
					<input class="form-control" placeholder="Insira a linguagem do projeto" name="linguagem" value="${projeto.linguagem}">
				</div>
				<div class="col-md">
					<label class="display-1" id="label">Preço do projeto</label>
					<input class="form-control" placeholder=" R$ 0,00" name="preco" value="${projeto.preco}">
				</div>
			</div>
			<div class="row">
				<div class="col">
				<label class="display-1" id="label">Link do projeto (Github)</label>
				<input class="form-control" placeholder="Insira o link do projeto" name="link" value="${projeto.link}">
				
				<label class="display-1" id="label">Descrição / Objetivo</label>
				<textarea class="form-control" name="descricao">${projeto.descricao}</textarea>
				</div>
			</div>
			<hr style="background-color:#8a8a8a;"/>
			<div class="text-center">
				<button class="btn btn-success btn-md" type="submit" name="acao" value="Altera">Adicionar</button>
				<a class="btn btn-outline-danger btn-md" href="Perfil.jsp">Cancelar</a>
			</div>
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