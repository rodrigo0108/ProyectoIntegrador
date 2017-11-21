<%@page import="com.ramos.utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>StudAlquiler</title>

     <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/clean-blog.min.css" />" rel="stylesheet">

  </head>

  <body style="background:#FCF8F7">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" style="color: black" href="">StudAlquiler</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
       
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" style="color: black" href="<%=request.getContextPath()%>">Inicio</a>
            </li>

          </ul>
        </div>
      </div>
    </nav>

     <!-- Page Header -->
    <header class="masthead">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
          
          </div>
        </div>
      </div>
    </header>
				
	<br>
	<br>
	<br>
    <!-- Main Content -->
				
    <div class="container">
      <div class="row">
		      
       <div class="col-lg-8 col-md-5">
			<div class="card mb-3" style="height: 500px;">
					<div class="card-block">
					
							<span class="caption" style="font-size: 150%;">&nbsp;&nbsp;Departamento en estreno</span>
							<span class="caption text-muted">&nbsp;&nbsp; <i class="fa fa-map-marker"></i>&nbsp;${inmueble.direccion}</span>
						
							
							<img src="<%=Utils.URL_BASE%>/images/inmuebles/${inmueble.imagen}" style="width: 100%; height: 100%;"></img>
					
					</div>  
            </div>
		</div>
		<div class="col-lg-4 col-md-5">
			
				<div class="col-lg-12 col-md-5">
				<div class="list-inline text-center">
					<div class="card mb-3" style="height: 80px;">
					<h3 style="font-weight: normal; font-size: 85%; color:#B9B7B6">Precio</h3>
					<small class="text-muted"><h1 style=" font-weight: normal; color:black;  font-size: 180%;">${inmueble.precio}</h1> </small>
				</div>
					</div>
				</div>
				<div class="col-lg-12 col-md-5">
					<div class="card mb-3" style="height: 250px;">
					<br>
					<h3 style="font-weight: normal; font-size: 90%;">&nbsp;&nbsp;Datos importantes</h3>
					<br>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-home"></i>&nbsp;&nbsp;Tipo de alquiler: ${inmueble.tipo}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-area-chart"></i>&nbsp;&nbsp;Área total: ${inmueble.area_total}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-bath"></i>&nbsp;&nbsp;Número de baños: ${inmueble.num_banios}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-bed"></i>&nbsp;&nbsp;Número de dormitorios: ${inmueble.num_dormitorios}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-money"></i>&nbsp;&nbsp;Precio: ${inmueble.precio}</h3>
					</div>
				</div>
				<div class="col-lg-12 col-md-5">
					<div class="card mb-3" style="height: 270px;">
					<br>
					<h3 style="font-weight: normal; font-size: 90%;">&nbsp;&nbsp;Descripción</h3>
					<br>
					<div class="list-inline text-center">
					<h3 style="font-weight: normal; font-size: 70%;">"${inmueble.descripcion}"</h3>
					</div>
					</div>
				</div>
		</div>
		<div class="col-lg-12 col-md-5">
					<div class="card mb-3" style="height: 250px;">
					<br>
					<h3 style="font-weight: normal; font-size: 90%;">&nbsp;&nbsp;Datos del anunciante</h3>
					<br>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-user-circle-o"></i>&nbsp;&nbsp;Nombres: ${usuario.nombres}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-user-circle"></i>&nbsp;&nbsp;Apellidos: ${usuario.apellidos}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-google" ></i>&nbsp;&nbsp;Correo: ${usuario.correo}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-phone" ></i>&nbsp;&nbsp;Teléfono: ${usuario.telefono}</h3>
					<h3 style="font-weight: normal; font-size: 70%;">&nbsp;&nbsp;<i class="fa fa-picture-o"></i>&nbsp;&nbsp;Imagen: ${usuario.imagen}</h3>
					</div>
				</div>
      </div>
    </div>
	<br>

    <hr>
	<!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; StudAlquiler 2017</p>
          </div>
        </div>
      </div>
    </footer>
    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>

    <!-- Custom scripts for this template -->
    <script src="<c:url value="/resources/js/clean-blog.min.js" />"></script>

  </body>

</html>
