<%@include file="/parts/header.jsp"%>



<div id="LoginForm">
	<div class="container pt-5" style="height: 730px;">
		<% if (session_obj.message.length() > 0 && session_obj.page_title.equals("register")){%>
			<div class="alert-success mt-5 text-center"> <p><%= session_obj.message %></p></div>			
		<%}%>
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>New Customer Registration</h2>
					<p></p>
				</div>
				<form method="post" action="register">

					<div class="form-group">
						<input type="text" class="form-control" id="firstname"
							name="firstname" placeholder="First Name">

					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="lastname"
							name="lastname" placeholder="Last Name">

					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="e-mail" name="email"
							placeholder="E-mail">

					</div>
					
					<div class="form-group">
						<input type="text" class="form-control" id="address"
							name="address" placeholder="Address">

					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="age" name="age"
							placeholder="Age">

					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="phone_no"
							name="phone_no" placeholder="Phone no.">

					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="sin_no" name="sin_no"
							placeholder="SIN No">

					</div>
					<button type="submit" class="btn btn-primary">Register Account</button>

				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="/parts/footer.jsp"%>