<%@include file="/parts/header.jsp"%>
<%@ page import="java.util.*, com.lambton.models.*"%>
<%
List<Bank> banks = (List<Bank>)request.getAttribute("banks");
List<AccountTypes> accountTypes = (List<AccountTypes>)request.getAttribute("accountTypes");
List<Customer> customers = (List<Customer>)request.getAttribute("customers");
%>
<div class="container pt-5" style="height: 730px;">

	<div class="login-form">
		<div class="main-div">
			<div class="panel">
				<h2>Account Setup</h2>
						<% if ((session_obj.message.length() > 0) && session_obj.page_title.equals("account")){%>
			<div class="alert-success mt-5 text-center"> <p><%= session_obj.message %></p></div>			
		<%}%>
			</div>
			<form method="post" action="account">
				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="customer_id">Customer</label>
						</div>
						<select class="custom-select" id="customer_id" name="customer_id">
							<option value="0">Choose Customer</option>
							<% if (customers.size() > 0){  for (int i=0; i< customers.size(); i++){ %>

							<option value="<%= customers.get(i).getId()%>"><%= "Id: " + customers.get(i).getId() + "-" + customers.get(i).getUsername()%></option>
							<%}}%>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="bank_id">Choose Bank</label>
						</div>
						<select class="custom-select" id="bank_id" name="bank_id">

							<option value="0">Choose Bank</option>
							<% if (banks.size() > 0) { for (int i=0; i< banks.size(); i++){ %>

							<option value="<%= banks.get(i).getId()%>"><%= banks.get(i).getName()%></option>
							<%}}%>

						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="account_type"> A/c
								Type:</label>
						</div>
						<select class="custom-select" id="account_type" name="account_type">

							<option value="0">Choose Account Type</option>
							<% if (accountTypes.size() > 0){  for (int i=0; i< accountTypes.size(); i++){ %>

							<option value="<%= accountTypes.get(i).getAccount_types_code()%>"><%= accountTypes.get(i).getAccount_types_code()%></option>
							<%}}%>

						</select>
					</div>
				</div>
				<div class="form-group">
					<input type="number" class="form-control" id="balance"
						name="balance"
						placeholder="Enter initial amount to be deposited 0.0" step="0.01"
						min="0">

				</div>
				<button type="submit" class="btn btn-primary">Create an
					account</button>
			</form>
		</div>
	</div>
</div>


<%@include file="/parts/footer.jsp"%>