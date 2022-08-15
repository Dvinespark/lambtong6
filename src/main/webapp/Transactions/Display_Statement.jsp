<!-- 	private int id;
	private Account account;
	private float amount;
	private Date created_at;
	private TransactionType transactionType;
	
		private String transaction_code;
	private String description;
	 -->

<%@include file="/parts/header.jsp"%>
<%@page import="java.util.*, com.lambton.models.*"%>
<h1>Statement</h1>
<%-- 	<%
    List<Transactions> trs = (List<Transactions>)session.getAttribute("customer_accounts"); //arraylist of records
%> --%>
<div class="container p-5" style="height: 1%;margin-top:-1%">
	<div class="row align-items-center justify-content-center">


		<div class="col-md-10 mt-lg-5 text-center" >
			<div class="single-text owl-carousel">
				<div class="slide" >
					<h1 class="text-uppercase" data-aos="fade-up" >Account Statement</h1>

					<div data-aos="fade-up" data-aos-delay="100"></div>
				</div>


			</div>
		</div>

	</div>
</div>

<div class="container">
<table class="table">
  <thead class="table-dark">
        <tr>
      <th scope="col">ID</th>
      <th scope="col">account</th>
      <th scope="col">created_at</th>
      <th scope="col">transactionType</th>
      <th scope="col">transaction_code</th> <!-- from TransactionType.java -->
      <th scope="col">description</th> <!-- from TransactionType.java -->
    </tr>
  </thead>
  <tbody>
<%--   <% for (int i=0; i<Transactions.size(); i++){ %> --%>
       <tr>
      <th scope="row">1</th>
      <td>Otto</td>
      <td>@mdo</td>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
<%--     <% } %> --%>
  </tbody>
</table>
</div>

<%@include file="/parts/footer.jsp"%>