<%@include file="/parts/header.jsp"%>
<%@ page import="java.util.* , com.lambton.models.*"%>

<div id="RecoverForm">
	<div class="container pt-5" style="height: 600px;">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Recover Account</h2>
				<% if ((session_obj.message.length() > 0) && session_obj.page_title.equals("recover")){%>
					<div class="alert-success mt-5 text-center"> <p><%= session_obj.message %></p></div>			
				<%}%>
				</div>
				<form method="post" action="accountRecover">
					<div class="form-group">
						<div class="form-group">
							<input type="number" class="form-control" id="sin" name="sin_no"
								placeholder="SIN Number">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group">
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="E-mail">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Recover Account</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/parts/footer.jsp"%>