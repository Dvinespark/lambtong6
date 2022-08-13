<%@include file="/parts/header.jsp"%>
<%@ page import="java.util.* , com.lambton.models.*"%>

<title>Insert title here</title>
<!--
	private int id; //no need
	private int customer_id;
	private AccountTypes accountTypes;
	private Bank bank;
	private Date created_date;
	private float balance;
 -->



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

					<div class="form-group">
						<input type="text" class="form-control" id="customer_id"
							name="customer_id" placeholder="Customer ID">

					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="firstname"
							name="firstname" placeholder="First Name">

					</div>
					<!-- 
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    Dropdown button
  </button>
  <ul class='dropdown-menu'>
    <li><a class="dropdown-item" href="#">Action</a></li>
    <li><a class="dropdown-item" href="#">Another action</a></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
  </ul>
  
  accounts.get(i).getAccountTypes()
</div>
 -->
					<div class="form-group">

    <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    Account Types
  </button>
<%--   <select class='dropdown-menu'>
  <% for (int i=0; i<accounts.size(); i++){ %>
	
   <option class="dropdown-item"><% accounts.get(i).getAccountTypes();%></option>

<%} %> --%>
 

  </select>
    

					</div>
					
					
					<div class="form-group">
						<input type="email" class="form-control" id="e-mail" name="e-mail"
							placeholder="E-mail">

					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password">

					</div>
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="/parts/footer.jsp"%>