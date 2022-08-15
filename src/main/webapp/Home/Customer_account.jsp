<%@include file="/parts/header.jsp"%>
<%@ page import="java.util.* , com.lambton.models.*"%>

<title>Insert title here</title>
<!--

	
for account create page we need 

	private int customer_name; dropdown
	private AccountTypes accountTypes; dropdown savings, chequing
	private Bank bank; dropdown banks
	private float balance;
 -->

<%--   <select >
  <% for (int i=0; i<accounts.size(); i++){ %>
	
   <option value=<% accounts.get(i).getAccountTypes();%>><% accounts.get(i).getAccountTypes();%></option>

<%} %> --%>

<div id="LoginForm">
<%-- 	<%
    List<account> accounts = (List<account>)session.getAttribute("customer_accounts");
%> --%>
	<div class="container pt-5" style="height: 730px;">

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>New Customer Registration</h2>
					<p></p>
				</div>
				<form method="post" action="login">

					<!-- account dropdown -->
					<div class="form-group">

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Choose Name:</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">

    <option value="1">Name 1</option>
    <option value="2">Name 1</option>
    <option value="3">TName 1</option>
  </select>
</div>
						
    

					</div>
					
							<div class="form-group">

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Choose Bank:</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">

    <option value="1">TD</option>
    <option value="2">CIBC</option>
    <option value="3">RBC</option>
  </select>
</div>
				
					
						<div class="form-group">

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Choose A/c Type:</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">

    <option value="1">Checking</option>
    <option value="2">Saving</option>
    
  </select>
</div>

			
					
					
					<div class="form-group">
						<input type="number" class="form-control" id="e-mail" name="e-mail"
							placeholder="Balance" step="0.01" min="0" max="10">

					</div>

					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="/parts/footer.jsp"%>