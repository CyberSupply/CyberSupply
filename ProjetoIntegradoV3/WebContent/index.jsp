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
        <div class="container">
            <h1 id="boasvindas" class="display-1">Bem vindo, Dev!</h1>
            <h2 id="slogan">à plataforma que irá te promover.</h2>
        </div>
    </div>
    <div id="middle">
        <div class="info-card-component colored">

        </div>
        <div class="container">
            <h2 style="color: white;">confira os projetos em cada linguagem:</h2>
        </div>
        <div id = "cards" class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card">
                        <img src="img/langs/python.png" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">Python</h5>
                            <p class="card-text">Projetos de nossos usuários usando a linguaguem Python.</p>
                            <a href="#" class="btn btn-outline-primary">Quero saber!</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <img src="img/langs/cpp.png" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">C++</h5>
                            <p class="card-text">Projetos de nossos usuários usando a linguaguem C++.</p>
                            <a href="#" class="btn btn-outline-primary">Quero saber!</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <img src="img/langs/java.png" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">Java</h5>
                            <p class="card-text">Projetos de nossos usuários usando a linguaguem Java.</p>
                            <a href="#" class="btn btn-outline-primary">Quero saber!</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <img src="img/langs/web.png" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">Desenvolvimento Web</h5>
                            <p class="card-text">Projetos de nossos usuários usando as ferramentas para desenvolvimento Web.</p>
                            <a href="#" class="btn btn-outline-primary">Quero saber!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="jumbotron" style="text-align: center;" id="sobre">
            <h1 class="display-4">quem somos?</h1>
            <p class="lead">Os caras...</p>
            <hr class="my-4">
            <p class="font-small">clique no botão abaixo para se cadastrar:</p>
            <p class="lead">
            <a id="signupbtn"class="btn btn-lg" type="button" href=Login.jsp>Faça parte!</a>
            </p>
        </div>
</div>

<!--importação do Footer-->
<c:import url="Footer.jsp"/>

</body>
</html>