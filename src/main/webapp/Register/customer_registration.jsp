<%@include file="/parts/header.jsp"%>


<title>Customer Registration</title>


<div id="LoginForm">
	<div class="container pt-5" style="height: 730px;">

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>New Customer Registration</h2>
					<p></p>
				</div>
				<form method="post" action="login">

					<div class="form-group">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="username">

					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="firstname"
							name="firstname" placeholder="First Name">

					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="lastname"
							name="lastname" placeholder="Last Name">

					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="e-mail" name="e-mail"
							placeholder="E-mail">

					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password1"
							name="password1" placeholder="Password">

					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password2"
							name="password2" placeholder="Confirm Password">

					</div>

					<div class="form-group">
						<input type="text" class="form-control" id="address"
							name="address" placeholder="Address">

					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="age" name="age"
							placeholder="Age">

					</div>
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="/parts/footer.jsp"%>