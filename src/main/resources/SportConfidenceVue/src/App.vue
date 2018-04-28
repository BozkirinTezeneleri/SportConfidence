<template>
  <div id="app">

    <div id="wrapper">
			<div id="overlay-1">
				<section id= "navigation">
					<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	  					<div class="container-fluid">
	    					<div class="navbar-header">
	      						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					        		<span class="ion-navicon"></span>
					      		</button>
					      		<a class="navbar-brand" href="">Sport Confidence</a>
					    	</div>
	    					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      					<ul class="nav navbar-nav navbar-right">
		      						<li><a href="#about">About Us</a></li>
		      						<li><router-link href="#our_service" to="/users">User List</router-link></li>
		        					<li><router-link href="#team" to="/user_add">Add New User</router-link></li>
                      <li><a href="#portfolio">Sport Clubs</a></li>
                      <li><router-link href="#price_table" to="/players">Player List</router-link></li>
		        					<li><router-link href="#blog" to="/player_add">Add New Player</router-link></li>
		        					<li><a href="#contact">Contact Us</a></li>
							    </ul>
	    					</div>	<!-- collapse navbar-collapse -->
	  					</div>	<!-- container-fluid -->
					</nav>	<!-- navbar -->
				</section>	<!-- #navigation -->
				<section id="starting">
					<div class="text-center starting-text">
						<h1 class="rene">Sport Confidence</h1>
						<h2>Welcome to our Information World</h2>
					</div>
				</section>
				<div id="bottom" class="bottom text-center">
			        <a href="#about"><i class="ion-ios7-arrow-down"></i></a>
			  </div>
			</div><!-- overlay-1 -->
		</div>	<!-- wrapper -->

    <!-- About Us -->
		<section id="about">
			<div class="container">
				<div class="row text-center" id="heading">
					<div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
						<h3>About Us</h3>
	                	<p>We are here, Nothing to fear</p>
	                	<hr class="full">
	                	<br/>
					</div>
				</div>	<!-- row -->
				<div class="row about-us-text">
					<div class="col-md-8 col-md-offset-2">
						<p class="text-center">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
					</div>
				</div>	<!-- row -->
				<div class="row main_content">
					<div class="col-md-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block" src="src/assets/img/3-col-icons-web.png">
						</figure>
						<h5 class="text-center">Spring Boot Development</h5>
						<div class="row">
							<div class="col-xs-12 text-center" style="border-right: 1px solid #f4f4f4">
                                <div style="display: inline; width: 60px; height: 60px;">
                                    <input type="text" class="knob" data-readonly="true" value="90" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: Arial; text-align: center; /* color: rgb(57, 204, 204); */ padding: 0px; -webkit-appearance: none; background: none;">
                                </div>
                            </div>	<!-- col-xs-12 -->
						</div>	<!-- row -->
					</div>	<!-- col-md-4 -->

					<div class="col-md-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block" src="src/assets/img/3-col-icons-android.png">
						</figure>
						<h5 class="text-center">VueJs Development</h5>
						<div class="row">
							<div class="col-xs-12 text-center" style="border-right: 1px solid #f4f4f4">
	                            <div style="display: inline; width: 60px; height: 60px;">
	                            	<input type="text" class="knob" data-readonly="true" value="80" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: Arial; text-align: center; /* color: rgb(57, 204, 204); */ padding: 0px; -webkit-appearance: none; background: none;">
	                            </div>
	                        </div>	<!-- col-xs-12 -->
						</div>	<!-- row -->
					</div>	<!-- col-md-4 -->

					<div class="col-md-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block" src="src/assets/img/3-col-icons-iphone.png">
						</figure>
						<h5 class="text-center">Ethereum&Solidity Development</h5>
						<div class="row">
							<div class="col-xs-12 text-center" style="border-right: 1px solid #f4f4f4">
	                            <div style="display: inline; width: 60px; height: 60px;">
	                                <input type="text" class="knob" data-readonly="true" value="75" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: Arial; text-align: center; /* color: rgb(57, 204, 204); */ padding: 0px; -webkit-appearance: none; background: none;">
	                        	</div>
	                    	</div>	<!-- col-xs-12 -->
						</div>	<!-- row -->
					</div>	<!-- col-md-4 -->
				</div><!-- row main_content -->
			</div>	<!-- container -->
		</section>	<!-- about us -->

		<!-- User List -->
		<section id="our_service">
			<div class="container">
				<div class="row text-center" id= "heading">
	        		<div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id= "heading-text">
	        			<h3>User List</h3>
	                	<p>Users</p>
	                	<hr class= "full">
	                	<br/>
	        		</div>
		        </div>
            <div class="row main_content">

              <user-list></user-list>

            </div> <!-- row main_content -->
			</div>	<!-- container -->
		</section>	<!-- our_service -->

		<!-- Add User -->
	    <section id="team">
	    	<div class="container">
          <div class="team-members">
		    		<div class="row text-center" id="heading">
		    			<div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
		        			<h3>Add User</h3>
		                	<p>Add New User Information</p>
		                	<hr class="full">
		                	<br/>
		        		</div>
		    		</div>

            <user-add></user-add>


			    </div>	<!-- team-members -->
			   </div>	<!-- container -->
	    </section>	<!-- team -->

		<!-- Sport Clubs -->
	    <section id="portfolio">
	    	<div class="container">
	    		<div class="row text-center" id="heading">
	    			<div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
	        			<h3>Sport Clubs</h3>
	                	<p>Select a Sport Club</p>
	                	<hr class= "full">
	                	<br/>
	        		</div>
	    		</div>
	    		<div class= "row text-center main_content">
            <div class= "col-md-6 col-md-offset-3 text-center">
              <h2>Sport Club Informations</h2>

              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon">
                    <i class="fa fa-tags fa-fw"></i>
                  </span>
                <select class="form-control" id="country" >
                  <option>Turkey</option>
                </select>
              </div>
              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon">
                    <i class="fa fa-tags fa-fw"></i>
                  </span>
                <select class="form-control" id="league">
                  <option>Turkish Super League</option>
                </select>
              </div>
              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon">
                    <i class="fa fa-tags fa-fw"></i>
                  </span>
                <select class="form-control" id="sportClub">
                  <option>Fenerbahce</option>
                </select>
              </div>
            </div>

	    		</div>	<!-- main_content -->
          <hr>
	    	</div>	<!-- container -->
	    </section>	<!-- portfolio -->
      <br><br>

		<!-- Players -->
	    <section id="price_table">
	    	<div class="container">
	    		<div class="row text-center" id="heading">
	    			<div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
	        			<h3>Players</h3>
	                	<p>Player List</p>
	                	<hr class="full">
	                	<br/>
	        		</div>
	    		</div>	<!-- row -->
	    		<div class="row main_content">

              <player-list></player-list>

	    		</div>	<!-- row main_content -->

	    	</div>	<!-- container -->
	    </section>

      <!-- players -->

      <!-- Add New Player -->
        <section id="blog">
          <div class="container">
            <div class="team-members">
              <div class="row text-center" id="heading">

                  <div class= "col-md-6 col-md-offset-3 wow animated zoomInDown" id= "heading-text">
                      <h3>Add New Player</h3>
                          <p>Enter New Player Information</p>
                          <hr class= "full">
                          <br/>
                  </div>

              </div>


              <player-add></player-add>

            </div>	<!-- team-members -->
          </div>	<!-- container -->
        </section>
    <!-- add new player -->

		<!-- contact -->
	    <section id= "contact">
	    	<div class= "container">
				<div class="row text-center" id= "heading">
					<div class= "bg-image">
						<div class= "col-lg-6 col-lg-offset-3 share-text wow animated zoomInDown" id= "heading-text">
							<h3 class= "text-center">CONTACT US</h3>
		                	<p>If you want to connect with us, Please you write to us.</p>
		                	<hr class= "full">
		                	<br/>
						</div>
					</div>
				</div>
				<div class= "row text-center main_content">
					<div class= "col-md-6 col-md-offset-3 text-center">
						<form method="post" action="#">
							<div class= "form">
								<div class="input-group margin-bottom-sm">
	  								<span class="input-group-addon">
	  									<i class="fa fa-user fa-fw"></i>
	  								</span>
								 	<input class="form-control" type="text" placeholder="Name" required>
								</div>
								<div class="input-group margin-bottom-sm">
	  								<span class="input-group-addon">
	  									<i class="fa fa-envelope-o fa-fw"></i>
	  								</span>
								 	<input class="form-control" type="text" placeholder="Email address" required>
								</div>
								<div class="input-group margin-bottom-sm">
	  								<span class="input-group-addon">
	  									<i class="fa fa-tags fa-fw"></i>
	  								</span>
								 	<input class="form-control" type="text" placeholder="Subject">
								</div>
							</div>
							<div class="input-group margin-bottom-sm">
									<span class="input-group-addon">
										<i class="fa fa-comment-o fa-fw"></i>
									</span>
								<textarea class="form-control" rows="6" type= "text" placeholder="Your Message" required></textarea>
							</div>
							<input class="btn btn-primary send" type="submit" value="Send Message">
						</form>
					</div>
				</div>

			</div>
	    </section>	<!-- contacts -->

		<!-- footer -->
		<section id= "footer" class= "main-footer">
			<div class= "row">
				<div class= "logo text-center">
					<h1>Sport Confidence</h1>
				</div>
			</div>
			<div class= "row">
				<div class= "copyright text-center">
					<p> © 2018 Tech. Designed and Developed by Bozkırın Tezeneleri</p>
				</div>
			</div>
		</section><!-- footer -->

  </div>
</template>

<script>
export default {
  name: 'app',

}
</script>

<style>

</style>
