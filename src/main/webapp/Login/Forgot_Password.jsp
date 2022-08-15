<%@include file="/parts/header.jsp"%>
<%@ page import="java.util.* , com.lambton.models.*"%>

<div id="LoginForm">
<%-- 	<%
    List<account> accounts = (List<account>)session.getAttribute("customer_accounts");
%> --%>
	<div class="container pt-5" style="height: 730px;">

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Forgot Password</h2>
					<p></p>
				</div>
				<form method="post" action="login">

			
					<div class="form-group">

					<div class="form-group">
						<input type="text" class="form-control" id="full_name"
							name="full_name" placeholder="Full Name">

					</div>
						</div>
    					
					
							<div class="form-group">

				<div class="form-group">

					<div class="form-group">
						<input type="email" class="form-control" id="email"
							name="email" placeholder="E-mail">

					</div>
					</div>
					
					
				
					</div>
				
				
					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/parts/footer.jsp"%>