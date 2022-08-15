
<%@include file="/parts/header.jsp"%>
<%@ page import= "java.util.*, com.lambton.models.*" %>

<%
Customer customer = (Customer) request.getAttribute("customer");
%>
<%
List<Account> accounts = (List<Account>) request.getAttribute("accounts");
%>
<div class="container p-5" style="height: 50%">
	<div class="row align-items-center justify-content-center">


		<div class="col-md-10 mt-lg-5 text-center">
			<div class="single-text owl-carousel">
				<div class="slide">
					<h1 class="text-uppercase" data-aos="fade-up">
						Hello there,
						<%=customer.getUsername()%>
						:)
					</h1>
					<p class="mb-5 desc" data-aos="fade-up" data-aos-delay="100">Customer
						Dashboard</p>
					<div data-aos="fade-up" data-aos-delay="100"></div>
				</div>


			</div>
		</div>

	</div>
</div>
<div class="container p-5">
	<h2 class="card-title">Customer information:</h2>
	<div class="card">
		<ul class="list-group list-group-flush">
			<li class="list-group-item">Name: <%= customer.getFirstname() + " " + customer.getLastname() %></li>
			<li class="list-group-item">Address: <%=customer.getAddress()%>
				C2D
			</li>
			<li class="list-group-item">Registered Date: <%=customer.getCreated_date().toString()%></li>
		</ul>
	</div>
</div>

<div class="container p-5">
	<h2 class="card-title">Your Accounts:</h2>
	<div class="d-flex flex-row">
	<%for (int i=0; i< accounts.size(); i++){
		
	} %>
		<div class="card w-50">
			<div class="card-body">
				<h5 class="card-title">Chequing</h5>
				<p class="card-text">A/c no : XX34 Bal: $$$$</p>
				<a href="#" class="btn btn-primary">View Statement</a>
			</div>
		</div>

		<div class="card w-50">
			<div class="card-body">
				<h5 class="card-title">Savings</h5>
				<p class="card-text">A/c no : XX34 Bal: $$$$</p>
				<a href="#" class="btn btn-primary">View Statement</a>
			</div>
		</div>

	</div>

	<div class="d-flex flex-row">
		<div class="card w-50">
			<div class="card-body">
				<h5 class="card-title">VISA Credit</h5>
				<p class="card-text">A/c no : XX34 Bal: $$$$</p>
				<a href="#" class="btn btn-primary">View Statement</a>
			</div>
		</div>

	</div>
</div>

<%@include file="/parts/footer.jsp"%>