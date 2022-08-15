<%@include file="/parts/header.jsp"%>

<!-- Radio button for transfer, withdraw, deposit, pay bill

From
Accounttype dropdown
Balance

To account id,
Account type
Account name -->

<div id="LoginForm">
<%-- 	<%
    List<account> accounts = (List<account>)session.getAttribute("customer_accounts");
%> --%>
	<div class="container pt-5" style="height: 730px;">

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Transaction Form</h2>
					<p></p>
				</div>
				<form method="post" action="login">
<div class="form-group">
<label for="transaction_types" class="float-left">From:</label>
</div>
					<div class="form-group">
						<input type="text" class="form-control" id="customer_id"
							name="customer_id" placeholder="Customer ID">

					</div>
	

				

					<div class="form-group">
					  <label for="transaction_types">Choose Transaction Type:</label>
						<div class="d-flex flex-row">
	<div class="form-check  col-sm-3">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="transfer" checked>
  <label class="form-check-label" for="exampleRadios1">
    Transfer
  </label>
</div>

<div class="form-check col-sm-3">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="withdraw" checked>
  <label class="form-check-label" for="exampleRadios1">
    Withdraw
  </label>
</div>

<div class="form-check col-sm-3">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
  <label class="form-check-label" for="exampleRadios1">
    Deposit
  </label>
</div>

<div class="form-check col-sm-3">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
  <label class="form-check-label" for="exampleRadios1">
    Bill Payment
  </label>
</div>
								
	
					</div>
					
					</div>
					
									<form method="post" action="login">
<div class="form-group">
<label for="transaction_types" class="float-left">To:</label>
</div>

					
					<div class="form-group">
						<input type="text" class="form-control" id="e-mail" name="accid"
							placeholder="Account ID">

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
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="e-mail" name="name"
							placeholder="Account Name">
							
							
<!-- 							<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Choose Name:</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">

    <option value="1">Name 1</option>
    <option value="2">Name 1</option>
    <option value="3">TName 1</option>
  </select>
</div> -->

					</div>

					<button type="submit" class="btn btn-primary">Pay</button>

				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/parts/footer.jsp"%>