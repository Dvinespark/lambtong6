<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.lambton.controllers.SessionHandler" %>
<%@ page import= "java.util.*, com.lambton.models.*" %>
    
<% SessionHandler session_obj = (SessionHandler)session.getAttribute("lambton_session"); %>
<!DOCTYPE html>
<html>
  <head>
    <title>G6Bank</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">    
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="static/css/style.css">
  </head>
 <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  

  <div id="overlayer"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div>


<div class="site-mobile-menu site-navbar-target">
	<div class="site-mobile-menu-header">
		<div class="site-mobile-menu-close mt-3">
			<span class="icon-close2 js-menu-toggle"></span>
		</div>
	</div>
	<div class="site-mobile-menu-body"></div>
</div>
<header class="site-navbar js-sticky-header site-navbar-target"
	role="banner">

	<div class="container">
		<div class="row align-items-center">

			<div class="col-6 col-xl-2">
				<h1 class="mb-0 site-logo">
					<a href="/lambtong6" class="h2 mb-0">G6 Bank<span
						class="text-primary">.</span>
					</a>
				</h1>
			</div>

			<div class="col-12 col-md-10 d-none d-xl-block">
				<nav class="site-navigation position-relative text-right"
					role="navigation">

					<ul
						class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
						<li><a href="/lambtong6/#home-section" class="nav-link">Home</a></li>
						<li><a href="/lambtong6/#about-section" class="nav-link">About Us</a></li>
						<li><a href="/lambtong6/#contact-section" class="nav-link">Contact</a></li>
						<% if (session_obj.login_flag == true){
							if (session_obj.login_type.equals("admin")){%>
								<li><a href="<%=request.getContextPath() + "/agent" %>" class="nav-link">Welcome <%= session_obj.firstname %></a></li>
							<%}else {%>
								<li><a href="<%=request.getContextPath() + "/customer" %>" class="nav-link">Welcome <%= session_obj.firstname %></a></li>
							<%} %>
							<li><a href="<%=request.getContextPath() + "/login?logout=true" %>" class="nav-link">Log out</a></li>
						<%}else {%>
							<li><a href="login" class="nav-link">Sign in</a></li>
						<%}%>
						
						


					</ul>
				</nav>
			</div>


			<div class="col-6 d-inline-block d-xl-none ml-md-0 py-3"
				style="position: relative; top: 3px;">
				<a href="#" class="site-menu-toggle js-menu-toggle float-right"><span
					class="icon-menu h3"></span></a>
			</div>

		</div>
	</div>

</header>