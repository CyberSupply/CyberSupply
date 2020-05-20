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
<header>

	<c:if test="${a.logado}">
    <nav class="navbar navbar-inverse" id="navbar-principal">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" title="Seja Cyber!"><img id="logo" src="img/Logo_Cyber.png"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu_lista" aria-controls="menu_lista" aria-expanded="false" aria-label="Menu">
                    <span class="sr-only">Menu</span>
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="pos-f-t" id="menu_lista">
                <ul id="menu_lista" class="nav nav-pills">
                    <li class="link_menu">
                    <a class="nav-link" href="Home.do?">home</a>
                    </li>
                    <li class="link_menu">
                    <a class="nav-link" href="index.jsp#sobre" id="btnsobre">quem somos</a>
                    </li>
                    <li class="link_menu">
	                    <form action="ChamaProjetos.do" method="get">
		                    <button class="nav-link btnnavegue" type="submit">projetos</button>
	                    </form>              
                    </li>
                    <li class="link_menu">
	                    <form action="ChamaGeral.do" method="get">
		                    <button class="nav-link btnnavegue" type="submit">usuários</button>
	                    </form>              
                    </li>
                    
                     <!--Gatilho-->
                     <li class="link_login">
                     <a id="loginbtn" class="btn" type="button" href="Login.do?email%2Fcnpj=${a.email}&senha=${a.senha}" style="color:white;">${a.nome}</a>
                     </li>
                </ul>
            </div>
        </div>
    </nav>
	</c:if>
	<c:if test="${!a.logado}">
    <nav class="navbar navbar-inverse" id="navbar-principal">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" title="Seja Cyber!"><img id="logo" src="img/Logo_Cyber.png"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu_lista" aria-controls="menu_lista" aria-expanded="false" aria-label="Menu">
                    <span class="sr-only">Menu</span>
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="pos-f-t" id="menu_lista">
                <ul id="menu_lista" class="nav nav-pills">
                    <li class="link_menu">
                    <a class="nav-link" href="index.jsp">home</a>
                    </li>
                    <li class="link_menu">
                    <a class="nav-link" href="index.jsp#sobre" id="btnsobre">quem somos</a>
                    </li>
                    <li class="link_menu">
	                    <form action="ChamaProjetos.do" method="get">
		                    <button class="nav-link btnnavegue" type="submit">projetos</button>
	                    </form>              
                    </li>
                    <li class="link_menu">
	                    <form action="ChamaGeral.do" method="get">
		                    <button class="nav-link btnnavegue" type="submit">usuários</button>
	                    </form>              
                    </li>
					
                     <!--Gatilho-->
                     <li class="link_login">
                     <a id="loginbtn" class="btn" type="button" href="Login.jsp" style="color:white;">Login</a>
                     </li>
                </ul>
            </div>
        </div>
    </nav>
	</c:if>
</header>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</body>
</html>