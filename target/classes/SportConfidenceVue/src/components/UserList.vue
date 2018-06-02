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
                  <img class="img-circle img-responsive center-block" src="src/assets/img/user.png" alt="Syed Rezwanul Haque Rubel">
                </div>
              </div>
              <h4 class="wow animated fadeInUp" data-wow-delay= "0.2s" style="color: rgb(32, 178, 170);">

                  {{user.userId}}- {{user.name}} {{user.surname}}

              </h4>
              <p class= "member-title wow animated fadeIn" data-wow-delay= "0.3s">{{user.role}}</p>
              <p v-if="session.role==='ADMIN'" class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Email : </b>{{user.email}}</p>
              <p v-if="session.role==='ADMIN'" class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Phone : </b>{{user.phone}}</p>
              <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
                <div class= "team-member-contact">
                    <button class="btn btn-primary" @click="getUserProfile(user.userId)">Show Profile</button>
                    <button v-if="session.role==='ADMIN'" class="btn btn-danger" @click="delUser(user.userId)">Delete</button>
                </div>

              </div>

              <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
                  <strong>User Deleted!</strong> {{deleteInfo}}
              </div>

            </div>

        </div> <!-- row main_content -->

        <user-profile v-if="selectedUserId" :selectedUser=selectedUser :headerInfo=headerInfo :session=session></user-profile>


  </div>	<!-- container -->

</template>

<script>

export default {
  name: 'UserList',

  props:{

    headerInfo: null,
    session:null

  },

  data(){
    return{
      users:{},
      deleteInfo:null,

      selectedUser:{},
      selectedUserId:null,

      headerInfoAuth:this.headerInfo,

    }
  },
  methods:{

    getUserProfile(userId){
      this.selectedUserId=userId;

      console.log("RUNNING INFORMATION : FetchData is running for selected User...");

      var url=`http://localhost:8080/users/`+userId;
      this.$http.get(url,
      {
        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }
      }

      ).then(function (resp) {
        this.selectedUser=resp.data;
      });


    },

    getUser(){

      console.log("RUNNING INFORMATION : GetUser is running for All Users...");

      var url = 'http://localhost:8080/users';

      this.$http.get(url,
      {
        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }
      }

      ).then(function (resp) {
        //console.log(resp);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added UserList...");

          this.users = resp.data;
        }
      });

    },

    delUser(id){

      var url = 'http://localhost:8080/users/'+ id;
      console.log("RUNNING INFORMATION : DeleteUser is Running for " + url);

      this.$http.delete(url,
      {
        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }
      }

      ).then(function (resp) {
        console.log("INFO : " + url + ' - ID: ' + id + ' =>DELETED USER...');

        this.deleteInfo="DELETE";
        setTimeout(() => {
            this.deleteInfo=null
            //console.log("aaa")
        },2000);
      });

    }
  },

  created(){
    console.log("RUNNING INFORMATION : UserList is running...");

    setInterval(() => {
        this.getUser();
        //console.log("aaa")
    },3000);

  },

}
</script>
