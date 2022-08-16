<%@include file="/parts/header.jsp"%>

<%
List<Transactions> transactions = (List<Transactions>) request.getAttribute("transactions");
Account account = (Account) request.getAttribute("account");
List<TransactionType> transactionTypes = (List<TransactionType>) request.getAttribute("transactionTypes");
List<Bank> banks = (List<Bank>) request.getAttribute("banks");
%>



<div id="viewAccountForm">

	<div class="pt-5">

		<div class="login-form">
			<div class="main-div">
			<div class="row">
	<p class="font-weight-bold">
		Account ID -
		<%=account.getId()%>
		|
		<%=account.getAccountTypes().getAccount_types_code()%>
		Account
	</p>
</div>
				<div class="panel">
					<h2>Transaction Form</h2>
					<p></p>
				</div>
				<form method="post" action="view_account">
					<div class="form-group">
					<input hidden name="from_account" value="<%=account.getId()%>">
						<label for="from_account" class="float-left">From:</label> <input
							type="number" class="form-control"readonly
							placeholder="Account ID - <%=account.getId()%>">
					</div>
			
					<div class="form-group">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<label class="input-group-text" for="transaction_code">Transaction Type</label>
							</div>
							<select class="custom-select" id="transaction_code" name="transaction_code">
								<option value="0">Select transaction type</option>
								<%for (int i = 0; i < transactionTypes.size(); i++) { %>
									<option value="<%=transactionTypes.get(i).getTransaction_code() %>"><%=transactionTypes.get(i).getTransaction_code() %></option>
								<%}%>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="to_account" class="float-left">To:</label> <input
							type="number" class="form-control" id="to_account" name="to_account"
							placeholder="Account ID">
					</div>
					
					<div class="form-group">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<label class="input-group-text" for="inputGroupSelect01">Bank</label>
							</div>
							<select class="custom-select" id="bank_id" name="bank_id">
								<option value="0">Select bank</option>
								<%for (int i = 0; i < banks.size(); i++) { %>
									<option value="<%=banks.get(i).getId() %>"><%=banks.get(i).getName() %></option>
								<%}%>
							</select>
						</div>
					</div>

					<div class="form-group">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Account Holder Full Name">
					</div>
					
					<div class="form-group">
						<input type="number" min=0 class="form-control" id="amount" name="amount"
							placeholder="Amount">
					</div>
					
					<button type="submit" class="btn btn-primary">Transfer</button>
				</form>
			</div>
		</div>
	</div>
</div>

<hr>
<div class="container">
	<div class="row align-items-center justify-content-center"col-12 text-center">
			<div class="single-text owl-carousel">
				<div class="slide">
					<p class="text-uppercase text-center" data-aos="fade-up">Last 10 Statements</p>
					<div data-aos="fade-up" data-aos-delay="100"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container mb-5">
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th scope="col">Transaction ID</th>
				<th scope="col">From Account</th>
				<th scope="col">To Account</th>
				<th scope="col">Transaction Type</th>
				<th scope="col">Amount</th>
				<th scope="col">Created At</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (transactions.size() > 0) {
				for (int i = 0; i < transactions.size(); i++) {
			%>
			<tr>
				<th scope="row"><%=transactions.get(i).getId()%></th>
				<th><%=transactions.get(i).getFromAccount().getId()%></th>
				<th><%=transactions.get(i).getToAccount().getId()%></th>
				<th><%=transactions.get(i).getTransactionType().getTransaction_code()%></th>
				<th><%=transactions.get(i).getAmount()%></th>
				<th><%=transactions.get(i).getCreated_at().toString()%></th>

			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</div>

<%@include file="/parts/footer.jsp"%>