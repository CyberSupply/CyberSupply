<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
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
	<div class="container login-form">
		<div class="row">
			<div class="col-md">
				<h1 class="display-1">${projeto.nome}</h1>
				<div id="label" class="text-right display-1">Preço: <strong>R$: ${projeto.preco}0</strong></div>
				<hr style="background-color:#8a8a8a;">
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h1 class="display-4" style="color: white;">Descrição</h1>
				<p class="h5" style="color: white;">${projeto.descricao}</div>
			<div class="col-md-6">
				<div class="row col-md justify-content-end">
					<a class="btn btn-outline-warning" href="${projeto.link}">Clique para acessar o projeto</a>
				</div>
				<hr style="background-color:#8a8a8a;">
				<div class="container">
					<div class="row justify-content-center">
						<img class="projetoImg rounded-circle border border-white" src="${b.imagem}">
					</div>
					<div class="row justify-content-center">
						<h1 class="display-1" style="font-size:24px; margin-top:12px">${b.nome}</h1>
					</div>
					<div class="row justify-content-center">
						<h1 class="display-1" style="font-size:15px;">${projeto.email}</h1>
					</div>
					<div class="row justify-content-center">
						<a class="btn btn-outline-info" style="margin-top:10px" href="Login.do?email%2Fcnpj=${b.email}&senha=${b.senha}">Ver perfil</a>
					</div>
					
				</div>
				<hr style="background-color:#8a8a8a;"/>
				<div class="row col-md">
					<div class="col">
					<h1 id="label" class="display-1">Linguagem: <strong>${projeto.linguagem}</strong></h1>
					</div>
					<div class="col">
					<button class="btn btn-success btn-block" type="submit">Investir no projeto</button>
					<br>
					<div id="paypal-button-container"></div>
					<script src="https://www.paypal.com/sdk/js?client-id=sb&currency=BRL" data-sdk-integration-source="button-factory"></script>
					<script>
 						 paypal.Buttons({
   						   style: {
     					     shape: 'pill',
        				     color: 'gold',
          					 layout: 'vertical',
          					 label: 'paypal',
          
      					   },
      					   createOrder: function(data, actions) {
          				     return actions.order.create({
              			       purchase_units: [{
                  			     amount: {
                          	       value: ${projeto.preco}
                  			     }
              			       }]
          			   	     });
      				       },
      					   onApprove: function(data, actions) {
          				     return actions.order.capture().then(function(details) {
              				   alert('Transaction completed by ' + details.payer.name.given_name + '!');
          				     });
      					   }
  					     }).render('#paypal-button-container');
					</script>
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