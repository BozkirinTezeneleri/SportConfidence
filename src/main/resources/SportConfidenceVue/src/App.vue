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
		      						<li><router-link href="#about_us" to="/about_us">About Us</router-link></li>
		      						<li><router-link href="#user_list" to="/users">User List</router-link></li>
		        					<li><router-link href="#add_user" to="/add_user">Add New User</router-link></li>
                      <li><router-link href="#sport_clubs" to="/sport_clubs">Sport Clubs</router-link></li>
                      <li><router-link href="#player_list" to="/players">Non-Club Player List</router-link></li>
		        					<li><router-link href="#add_player" to="/add_player">Add New Player</router-link></li>
		        					<li><router-link href="#contact_us" to="/contact_us">Contact Us</router-link></li>
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
		<section id="about_us">

        <about-us></about-us>

		</section>	<!-- about us -->

		<!-- User List -->
		<section id="user_list">
			<user-list></user-list>
		</section>	<!-- our_service -->

		<!-- Add User -->
	  <section id="add_user">

        <user-add></user-add>

	  </section>	<!-- team -->

		<!-- Sport Clubs -->
	  <section id="sport_clubs">

          <sport-clubs></sport-clubs>

	    </section>	<!-- sport-clubs -->
    <br><br>

		<!-- Players -->
	  <section id="player_list">

        <player-list></player-list>

	  </section><!-- players -->



    <!-- Add New Player -->
    <section id="add_player">

            <player-add></player-add>

        </section>  <!-- add new player -->


		<!-- contact -->
	  <section id= "contact_us">

        <contact-us></contact-us>

	  </section>	<!-- contacts -->

    <br>
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
