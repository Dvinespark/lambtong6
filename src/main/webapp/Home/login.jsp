<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<html>

<head>
    <link href="styles.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" style = "background-image:url(images/hero_2.jpg)">

  

  <div id="overlayer" style="padding-bottom:0px;"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div>


  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   
    
    <header class="site-navbar js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2">
            <h1 class="mb-0 site-logo"><a href="index.jsp" class="h2 mb-0">G6 Bank<span class="text-primary">.</span> </a></h1>
          </div>

          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation" >

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block" >
                <li><a href="index.jsp#home-section" class="nav-link" ><span style="color:black">Home</span></a></li>
                <li><a href="index.jsp#about-section" class="nav-link"><span style="color:Black">About Us</span></a>         
                </li>                
                <li><a href="index.jsp#contact-section" class="nav-link"><span style="color:black">Contact</span></a></li>
                <li><a href="login.jsp" class="nav-link"><span style="color:black">Sign in</span></a></li> 
				
                
              </ul>
            </nav>
          </div>


          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle float-right"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
	 
      
    </header><br><br><br><br>
	
	<div id="LoginForm"  >
    <div class="container">
        
        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h2>Admin Login</h2>
                    <p>Enter your email and password</p>
                </div>
                <form id="Login">

                    <div class="form-group">


                        <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">

                    </div>

                    <div class="form-group">

                        <input type="password" class="form-control" id="inputPassword" placeholder="Password">

                    </div>
                    <div class="forgot">
                        <a href="reset.jsp">Forgot password?</a>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>

                </form>
            </div>
        </div>
		</div>
		</div>
		
		
		
	<div>
		 
	    
    <footer class="site-footer" > 

        <div class="row pt-1 mt-1 text-center">
          <div class="col-md-12">
            <div >
              <p class="copyright"><small>
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved with group 6
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></small></p>
        
            </div>
          </div>
          
        </div>
    
    </footer>
  </div>
  </div>
   
	
	
  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>
  <script src="js/isotope.pkgd.min.js"></script>
  <script src="js/main.js"></script>

</body>

</html>