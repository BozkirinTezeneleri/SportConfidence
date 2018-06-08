<template>
  <div id="app">

    <div id="wrapper">
			<div id="overlay-1">
				<section v-if="isLogin" id= "navigation">
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
                      <li><a>Welcome,
                        <i class="fa fa-user fa-fw"></i>{{session.role}}, {{session.name}} {{session.surname}}
                      </a></li>
		      						<li><a href="#about_us">About Us</a></li>
                      <li><a href="#sport_clubs">Sport Clubs</a></li>
		        					<li v-if="session.role==='ADMIN' || session.role==='DOCTOR'"><a href="#add_player">Add New Player</a></li>
                      <li><a href="#user_list">User List</a></li>
		        					<li v-if="session.role==='ADMIN'"><a href="#add_user">User Register</a></li>
		        					<li><a href="#contact_us">Contact Us</a></li>

                      <li><a href="" @click="Logout"> Logout, {{session.username}} </a></li>

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
		<section v-if="isLogin" id="about_us">

        <about-us></about-us>

		</section>	<!-- about us -->

		<!-- Sport Clubs -->
	  <section v-if="isLogin" id="sport_clubs">

          <sport-clubs :headerInfo=user :session=session></sport-clubs>

	    </section>	<!-- sport-clubs -->
    <br v-if="isLogin"><br v-if="isLogin">

    <!-- Add New Player -->
    <section v-if="isLogin && (session.role==='ADMIN' || session.role==='DOCTOR')" id="add_player">

        <player-add :headerInfo=user :session=session></player-add>

    </section>  <!-- add new player -->

    <!-- User List -->
    <section v-if="isLogin" id="user_list">

    	 <user-list  :headerInfo=user :session=session></user-list>

    </section>	<!-- user-list -->

    <!-- Add User -->
    <section v-if="isLogin && session.role==='ADMIN'" id="add_user">

        <user-add :headerInfo=user :session=session></user-add>

    </section>	<!-- add-user -->

		<!-- contact -->
	  <section v-if="isLogin" id= "contact_us">

        <contact-us :headerInfo=user></contact-us>

	  </section>	<!-- contacts -->

    <!--deneme-->
    <!--<p>{{sessionCounter}}</p>-->

    <!--deneme-->

    <!-- Login -->
	  <section v-if="!isLogin" id= "login">

      <div v-if="sessionInfo" class="alert alert-danger animated zoomInDown">
          <center><strong>Warning!</strong> {{sessionInfo}}</center>
      </div>

      <div class= "container">
          <div class="row text-center" id= "heading">
            <div class= "bg-image">
              <div class= "col-lg-6 col-lg-offset-3 share-text wow animated zoomInDown" id= "heading-text">
                <h3 class= "text-center">LOGIN</h3>
                        <p>Enter your information, for entry your account.</p>
                        <hr class= "full">
                        <br/>
              </div>
            </div>
          </div>
          <div class= "row text-center main_content">
            <div class= "col-md-6 col-md-offset-3 text-center">
              <form v-on:submit.prevent="Login" id="login" method="post" action="#">
                <div class= "form">
                  <div class="input-group margin-bottom-sm">
                      <span class="input-group-addon">
                        <i class="fa fa-user fa-fw"></i>
                      </span>
                    <input class="form-control" name="username" type="text" v-model.trim="user.username" placeholder="Enter your username" required>
                  </div>
                  <div class="input-group margin-bottom-sm">
                      <span class="input-group-addon">
                        <i class="fa fa-lock fa-fw"></i>
                      </span>
                    <input class="form-control" name="password" type="password" v-model.trim="user.password" placeholder="Enter your password" required>
                  </div>

                </div>

                <input class="btn btn-primary send" type="submit" value="LOGIN">
              </form>
            </div>
          </div>

        </div>

	  </section>	<!-- login -->

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

  data(){
    return{
      isLogin:false,//yenilemede : false olmamalı

      user:{
        username:null,//yenilemede : null olmamalı
        password:null,//yenilemede : null olmamalı
      },
      session:null,//yenilemede : null olmamalı
      sessionInfo:null,//yenilemede : null olmamalı
      headerInfo:null,//yenilemede : null olmamalı

      sessionCounter:0,

    }

  },


  methods:{

    Login(){

      setInterval(()=>{
        this.sessionCounter+=1;

        if(this.sessionCounter==7200){
          this.Logout();
        }
      },1000);

      var url = `http://localhost:8080/login/`+ this.user.username + `/` + this.user.password;

      this.$http.get(url).then(function (resp) {
        //console.log(resp);
        if (resp.status == 200) {

          this.session = resp.data;

          if(this.session){
            this.isLogin=true;
            console.log("SESSION ACTIVE");
            this.sessionInfo=null

            // console.log(this.headerInfo);
          }else{
            console.log("SESSION NULL");
            this.isLogin=false
            this.sessionInfo="Wrong Username or Password...Try Again..."
            this.headerInfo=null

            this.user.username=null
            this.user.password=null
          }
          // console.log(JSON.stringify(this.session));
        }
      });

    },

    Logout(){

      this.isLogin=false
      this.session = null
      this.headerInfo=null
      this.sessionCounter=0

      this.user.username=null
      this.user.password=null
    }
  },

}
</script>
