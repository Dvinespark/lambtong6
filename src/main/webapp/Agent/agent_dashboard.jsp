<%@include file="/parts/header.jsp"%>
<%
Agent agent = (Agent) request.getAttribute("agent");
%>
<div class="container mt-5">
	<div class="row">
		<div class="col-12 text-center p-5 mt-5">
			<div class="single-text owl-carousel">
				<div class="slide">
					<h1 class="text-uppercase" data-aos="fade-up">Agent Dashboard</h1>
					<p class="mb-5 desc" data-aos="fade-up" data-aos-delay="100"></p>
					<div data-aos="fade-up" data-aos-delay="100"></div>
				</div>
			</div>
		</div>

	</div>
</div>

<div class="alert-success text-center m-2">
	<% if (session_obj.message.length() > 0){%>
		<h4><%= session_obj.message %></h4>
								
	<%}%>
</div>

<div class="container">

	<div class="card">
		<div class="card-body">
			<h5 class="card-title">Profile information</h5>
			<p class="card-text">
				<b>Username: </b><%=agent.getUsername().toUpperCase()%></p>
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item"><b>Name: </b> <%=agent.getFirstname() + " " + agent.getLastname()%></li>
			<li class="list-group-item"><b>Agent ID: </b> <%=agent.getId()%></li>
		</ul>
	</div>

</div>
<hr>
<div class="container">
	<div class="card mb-5">
		<h5 class="card-header">Actions</h5>
		<div class="row">
			<div class="col-6">
					<div class="card-body">
			<h5 class="card-title">Register Customer</h5>
			<p class="card-text">Create Account profile for new customer</p>
			<a href="<%= request.getContextPath() + "/register" %>" class="btn btn-primary">Register Customer</a>
		</div>
			</div>
			<div class="col-6">
					<div class="card-body">
			<h5 class="card-title">Open Bank Account</h5>
			<p class="card-text"> Open a New Account for newly registered
				Customers</p>
			<a href="<%= request.getContextPath() + "/account" %>" class="btn btn-primary">Create Account</a>
		</div>
			</div>
		</div>


	</div>
</div>
<%@include file="/parts/footer.jsp"%>