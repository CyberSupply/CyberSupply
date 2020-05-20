//Animação que scrolla de leve até o lugar do conteúdo selecionado
$('#btnsobre').click(function(e){
    e.preventDefault();
    var id = $('#sobre').attr('#sobre');
        targetOffset= $('#sobre').offset().top;
$('html, body').animate({
    scrollTop: targetOffset
}, 500);
});

//Detalhes de inicio de página
//$('body').css('display', 'none');
//$('body').fadeIn(600);

$('#boasvindas').css('display', 'none');
$('#boasvindas').fadeIn(3000);

$('#slogan').css('display', 'none');
$('#slogan').fadeIn(4000);

//Barra de pesquisa do navegue.html
$(document).ready(function(){
    $("#pesquisa").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("#projetosCard *").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });

  //foto de perfil
  $(document).ready(function() {

    
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.avatar').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    

    $(".file-upload").on('change', function(){
        readURL(this);
    });
});


//mask para receber cnpj e fone no signup Empresa
$(document).ready(function(){	
    $("#cnpjSignup").mask("99.999.999/9999-99");
});

$(document).ready(function(){	
    $("#foneSignup").mask("(00) 9 9999-9999");
});