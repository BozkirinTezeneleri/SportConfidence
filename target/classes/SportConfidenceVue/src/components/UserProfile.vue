<template>

  <div class="container">
    <div class="row text-center" id="heading">
      <div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
          <h3>User</h3>
              <p>Selected User Information</p>
              <hr class="full">
              <br/>
        </div>
    </div>	<!-- row -->
    <div class="row main_content">
        <div class="row" id="heading">

          <!--PROFILE-->

          <div class="col-md-4 col-sm-5 text-center" style="margin-left:180px;">
            <div class="row wow animated zoomIn" data-wow-delay="0.1s">
              <div class="col-md-8 col-md-offset-2">
                <img class="img-circle img-responsive center-block" src="src/assets/img/Syed-Rezwanul-Haque.jpg" alt="Syed Rezwanul Haque Rubel">
              </div>
            </div>
            <h4 class="wow animated fadeInUp" data-wow-delay= "0.2s" style="color: rgb(32, 178, 170);">

                {{selectedUser.userId}} - {{selectedUser.name}} {{selectedUser.surname}}

            </h4>
            <p class= "member-title wow animated fadeIn" data-wow-delay= "0.3s">{{selectedUser.role}}</p>


            <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
                <strong>User Deleted!</strong> {{deleteInfo}}
            </div>

          </div>

          <!--PROFILE-->

          <!--PROFILE INFORMATION-->
          <div class="col-md-5 col-sm-5" style="margin-top:50px;">
            <div class="col-md-8 col-sm-5">
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Username : </b>{{selectedUser.username}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>E-mail : </b>{{selectedUser.email}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Phone Number : </b>{{selectedUser.phone}}</p>

                <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
                    <strong>User Deleted!</strong> {{deleteInfo}}
                </div>

            </div>
          </div>
          <div class="col-md-5 col-sm-5" style="margin-top:40px;">
            <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
              <div class= "team-member-contact">
                  <button class="btn btn-info" @click="editUserProfile(selectedUser.userId)">EDIT INFORMATION</button>
              </div>
            </div>
          </div>

          <!--PROFILE INFORMATION-->



        </div>
    </div>	<!-- row main_content -->

    <!-- Edit Users -->
	  <section id="user_list">

        <edit-user v-if="editUserId" :editUserInfo=editUser></edit-user>

	  </section><!-- edit-users -->

    <hr>

  </div>	<!-- container -->

</template>

<script>

export default {
  name: 'UserProfile',

  props:{

    selectedUser: { type: Object, required:true }

  },

  data(){
    return{
      editUser:{},
      editUserId:null,
    }
  },
  methods:{

    editUserProfile(UserId){
      this.editUserId=UserId;

      console.log("RUNNING INFORMATION : FetchData is running for selected User...");

      fetch(`http://localhost:8080/users/`+UserId)//istek
      .then((res) => {return res.json()})//response json a cevrildi
      .then((user) => { this.editUser=user;})
    },

   },

}
</script>
