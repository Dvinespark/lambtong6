<%@include file="/parts/header.jsp"%>
<div class="container p-5" style="height: 50%;background-color:#6bd8ff">
	<div class="row align-items-center justify-content-center">


		<div class="col-md-10 mt-lg-5 text-center">
			<div class="single-text owl-carousel">
				<div class="slide">
					<h1 class="text-uppercase" data-aos="fade-up">agent dashboard</h1>
					<p class="mb-5 desc" data-aos="fade-up" data-aos-delay="100"></p>
					<div data-aos="fade-up" data-aos-delay="100"></div>
				</div>


			</div>
		</div>

	</div>
</div>

<div class="container">

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Profile information</h5>
    <p class="card-text">Username: abc123</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Name: firstname lastname</li>
    <li class="list-group-item">Employee ID: agent_id</li>
    <li class="list-group-item">A third item</li>
  </ul>
</div>

</div>

<div class="container">
<div class="card">
  <h5 class="card-header">Actions</h5>
  <div class="card-body">
    <h5 class="card-title">Open Bank Account</h5>
    <p class="card-text">Open a New Account for newly registered Customers</p>
    <a href="Customer_account" class="btn btn-primary">Open Account</a>
  </div>
    <div class="card-body">
    <h5 class="card-title">Register Customer</h5>
    <p class="card-text">Create Account profile for new customer</p>
    <a href="Customer_Registration" class="btn btn-primary">Register</a>
  </div>
</div>
</div>
<%@include file="/parts/footer.jsp"%>