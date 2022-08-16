
<%@include file="/parts/header.jsp"%>
<%@ page import="java.util.*, com.lambton.models.*"%>

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
			<li class="list-group-item">Name: <%=customer.getFirstname() + " " + customer.getLastname()%></li>
			<li class="list-group-item">Address: <%=customer.getAddress()%></li>
			<li class="list-group-item">Contact No: <%=customer.getPhone_no()%></li>
			<li class="list-group-item">SIN No: <%=customer.getSin_no()%></li>
			<li class="list-group-item">Registered Date: <%=customer.getCreated_date().toString()%></li>
		</ul>
	</div>
</div>

<div class="container p-5">
	<h2 class="card-title">Your Accounts:</h2>
		<div class="row p-2">
			<%
			for (int i = 0; i < accounts.size(); i++) {
			%>
			<div class="col-6" style="min-width:250px;">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><%= accounts.get(i).getBank().getName() %> Bank - Account Type <%= accounts.get(i).getAccountTypes().getAccount_types_code() %></h5>
						<p class="card-text">A/c no : <%= accounts.get(i).getId() %></p>
						<p class="card-text">A/c created date : <%= accounts.get(i).getCreated_date().toString() %></p>
						<p class="card-text">Current Balance : $<%= accounts.get(i).getBalance() %></p>
						<a href="<%= request.getContextPath() + "/view_account?account_id=" + accounts.get(i).getId() %>" class="btn btn-primary">Go to account</a>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>


</div>

<%@include file="/parts/footer.jsp"%>