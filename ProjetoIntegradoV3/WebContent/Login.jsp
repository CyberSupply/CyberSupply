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
    <div class="container" id="login-container">
        <div class="row">
            <div class="col-md-6" id="login-form">
                <h1 class="display-1">Login</h1><h4 style="color:white;">Isso se você já for um dos nossos.</h4>
                <form action="Login.do" method="get">
                	<div class="form-group">
	                    <input class="form-control" type="text" name="email/cnpj" placeholder="Email/CNPJ" required>
	                </div>
	                    <br>
	                <div class="form-group">
	                    <input class="form-control" type="password" name="senha" placeholder="Senha" required>
	                </div>
				<button class="btn" type="submit" id="loginbtn">Login</button>
                </form>
            </div>
            <div class="col-md-6" id="signup-form">
                <ul class="nav nav-tabs nav-justified" id="tabSignUp" role="tablist">
                   <li class="nav-item">
                       <a class="nav-link active" id="ususario-tab" data-toggle="tab" href="#sUsuario" role="tab" aria-controls="home" aria-selected="true">Usuário</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" id="empresa-tab" data-toggle="tab" href="#sEmpresa" role="tab" aria-controls="profile" aria-selected="false">Empresa</a>
                   </li>
                </ul>
            
                <h1 class="display-1" style="color:#212529;">SignUp</h1>
                <h4 style="color:#212529;">Isso se você ainda não for um dos nossos.</h4>
                <div class="tab-content" id="tabcontent">
                	<div class="tab-pane fade show active" id="sUsuario" role="tabpanel" aria-labelledby="usuario-tab">
		                <form action="RegistrarCliente.do" method="get">
		                	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="email" name="email" placeholder="Email" required>
			                </div>
			                    <br>
			                <div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="text" name="nome" placeholder="Nome" required>
			                </div>
			                    <br>
			               	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="password" name="senha" placeholder="Senha" required>
			                </div>
			                    <br>
			               	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="password" name="senha2" placeholder="Repita a senha" required>
			                </div>
		
		                    <button class="btn" type="submit" id="signupbtn">SignUp</button>
		                </form>
		             </div>
		             <div class="tab-pane fade show" id="sEmpresa" role="tabpanel" aria-labelledby="empresa-tab">
		                <form action="RegistrarEmpresa.do" method="get">
		                	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="text" name="nomeEmpresa" placeholder="Nome da sua empresa" required>
			                </div>
			                    <br>
			                <div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="text" name="cnpjEmpresa" placeholder="CNPJ" required>
			                </div>
			                    <br>
			               	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="text" name="foneEmpresa" placeholder="Fone" required>
			                </div>
			                    <br>
			               	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="email" name="emailEmpresa" placeholder="Email da sua empresa" required>
			                </div>
			                <br>
			               	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="password" name="senhaEmpresa" placeholder="Senha" required>
			                </div>
			                <br>
			               	<div class="form-group">
			                    <input style="background-color:#212529; color:white;" class="form-control" type="password" name="senha2Empresa" placeholder="Repita sua senha" required>
			                </div>
			                		
		                    <button class="btn" type="submit" id="signupbtn">SignUp</button>
		                </form>
		             </div>
	            </div>
            </div>
        </div>
    </div>
</div>

<!--importação do Footer-->
<c:import url="Footer.jsp"/>

</body>
</html>