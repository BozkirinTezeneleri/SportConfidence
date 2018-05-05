<template>

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

            <div class="col-md-3 col-sm-5 text-center" v-for="user in users">
              <div class="row wow animated zoomIn" data-wow-delay="0.1s">
                <div class="col-md-8 col-md-offset-2">
                  <img class="img-circle img-responsive center-block" src="src/assets/img/Syed-Rezwanul-Haque.jpg" alt="Syed Rezwanul Haque Rubel">
                </div>
              </div>
              <h4 class="wow animated fadeInUp" data-wow-delay= "0.2s" style="color: rgb(32, 178, 170);">

                  {{user.userId}}- {{user.name}} {{user.surname}}

              </h4>
              <p class= "member-title wow animated fadeIn" data-wow-delay= "0.3s">{{user.role}}</p>
              <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Email : </b>{{user.email}}</p>
              <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Phone : </b>{{user.phone}}</p>
              <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
                <div class= "team-member-contact">
                    <button class="btn btn-primary" @click="getUserProfile(user.userId)">Show Profile</button>
                    <button class="btn btn-danger" @click="delUser(user.userId)">Delete</button>
                </div>

              </div>

              <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
                  <strong>User Deleted!</strong> {{deleteInfo}}
              </div>

            </div>

        </div> <!-- row main_content -->

        <user-profile v-if="selectedUserId" :selectedUser=selectedUser></user-profile>

  </div>	<!-- container -->

</template>

<script>

export default {
  name: 'UserList',

  data(){
    return{
      users:{},
      deleteInfo:null,

      selectedUser:{},
      selectedUserId:null,

    }
  },
  methods:{

    getUserProfile(userId){
      this.selectedUserId=userId;

      console.log("RUNNING INFORMATION : FetchData is running for selected User...");

      fetch(`http://localhost:8080/users/`+userId)//istek
      .then((res) => {return res.json()})//response json a cevrildi
      .then((user) => { this.selectedUser=user;})
    },

    getUser(){

      console.log("RUNNING INFORMATION : GetUser is running for All Users...");

      var url = 'http://localhost:8080/users';
      this.$http.get(url).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added UserList...");

          this.users = resp.data;
        }
      });
    },

    delUser(id){

      var url = 'http://localhost:8080/users/'+ id;
      console.log("RUNNING INFORMATION : DeleteUser is Running for " + url);

      this.$http.delete(url).then(function (res) {

        console.log("INFO : " + url + ' - ID: ' + id + ' =>DELETED USER...');

        this.deleteInfo="DELETE";
      })

    }
  },

  created(){
    console.log("RUNNING INFORMATION : UserList is running...");

    //this.getUser();

    setInterval(() => {
        this.getUser();
        //console.log("aaa")
    },3000);

  },

}
</script>
