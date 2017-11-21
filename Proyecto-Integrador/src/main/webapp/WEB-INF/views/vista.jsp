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
		      
       <div class="col-lg-4 col-md-5">
			<div class="card mb-3" style="height: 800px;">
					<div class="card-block">
						<div class="list-inline text-center">
							<br>
							<a><h4 class="card-title">Filtros</h4></a>
							<br>
							<a><h4 class="card-title" style="font-weight: normal; ">Distritos</h4></a>
							<br>
												<select class="form-control border-input" name='distrito'>
														<option value="Santa Anita">Santa Anita</option>
														<option value="Ate">Ate</option>
														<option value="Cercado de Lima">Cercado de Lima</option>
														<option value="Barranco">Barranco</option>
														<option value="Comas">Comas</option>
														<option value="Chorrillos">Chorrillos</option>
														<option value="El Agustino">El Agustino</option>
														<option value="La Molina">La Molina</option>
														<option value="La Victoria">La Victoria</option>
														<option value="Miraflores">Miraflores</option>
														<option value="Lince">Lince</option>
														<option value="Rimac">Rimac</option>
														<option value="San Borja">San Borja</option>
														<option value="San Luis">San Luis</option>
														<option value="San Isidro">San Isidro</option>
												</select>
							<br>
							<a><h4 class="card-title" style="font-weight: normal;  ">Precio</h4></a>
							<input type="text" class="form-control" placeholder="S/. Desde" >
							<br>
							<input type="text" class="form-control" placeholder="S/. Hasta" >
							<br>
							<button class="btn btn-secondary">APLICAR</button>
							<br>
							<br>
							<a><h4 class="card-title" style="font-weight: normal; ">Dormitorios</h4></a>
							<input type="number" class="form-control"  >
							<br>
							<button class="btn btn-secondary">BUSCAR</button>
							
						</div>
					</div>  
            </div>
		</div>
		<div class="col-lg-8 col-md-5">
				
				<c:forEach var="centro" items="${lista2}">
				
				<div class="container">
				<div class="card mb-3" style="height: 150%;">
					<div class="row">
						
						<div class="col-lg-5 col-md-5">
							<div class="list-inline text-center">
								<img class="card-img-top" style="height: 235px;" src="<%=Utils.URL_BASE%>/images/inmuebles/${centro.imagen}" alt="Card image cap">
							</div>	
 						</div>
 						
 						<div class="col-lg-7 col-md-5">
 							<div class="card-block">
 									<br>
									<a href="vista2/${centro.id}"><h4 class="card-title">${centro.distrito}</h4></a>
										<p ><small class="text-muted" style="font-weight: normal; font-size: 60%;">${centro.direccion} <br>${centro.descripcion}</small></p>
									
									<br>
								
							</div> 
 						</div>
 						</div>
					</div>
				</div>
 				
 					
			</c:forEach>
				
				
			
	
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
