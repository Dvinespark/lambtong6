
<%@include file="/parts/header.jsp"%>

<div id="LoginForm">
	<div class="container pt-5" style="height: 610px;">

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Login Portal</h2>
					<p>Login with your username and password.</p>
				</div>
				<form method="post" action="login">

					<div class="form-group">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="Enter username">

					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password">

					</div>
					<div clss="form-group">
						<div class="row p-2">
							<div class="col-3 float-right">
								<input class="form-check-input" type="radio" name="login_type"
									id="login_type1" value="admin"> <label
									class="form-check-label" for="login_type1"> Admin </label>
							</div>
							<div class="col-1">
								<input class="form-check-input" type="radio" name="login_type"
									id="login_type2" checked value="customer"> <label
									class="form-check-label" for="login_type2"> Customer </label>
							</div>
							<div class="col-4"></div>
							<%
							if (session_obj.login_flag == false) {
							%>
							<div class="col-4">
								<a id="_create_account" href="<%= request.getContextPath() + "/register" %>">Create Account</a>
							</div>

							<%
							}
							%>

						</div>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/parts/footer.jsp"%>