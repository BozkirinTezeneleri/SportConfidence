<template>

  <div class="container">
    <div class="team-members">
      <div class="row text-center" id="heading">

          <div class= "col-md-6 col-md-offset-3 wow animated zoomInDown" id= "heading-text">
              <h3>Edit User</h3>
                  <p>Enter New Information For This User</p>
                  <hr class= "full">
                  <br/>
          </div>

      </div>

      <div class="row main_content">

        <div class= "row text-center main_content">

          <div class= "col-md-6 col-md-offset-3 text-center">

            <form v-on:submit.prevent="updateUser(editUserInfo.userId)" id="EditUser" method="post" action="#">
              <div class= "form">

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <b>@</b>
                    </span>
                  <input class="form-control" type="text" id="username" v-model.trim="editUserInfo.username" placeholder="Username" required>
                </div>
                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="name" v-model.trim="editUserInfo.name" placeholder="Name" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="surname" v-model.trim="editUserInfo.surname" placeholder="Surname" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-envelope-o fa-fw"></i>
                    </span>
                  <input class="form-control" id="email" type="email" v-model.trim="editUserInfo.email" placeholder="example@example.com" required>
                </div>
                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-lock fa-fw"></i>
                    </span>
                  <input class="form-control" id="password" type="password" v-model.trim="editUser.password" placeholder="Please enter min 6 chracter..." minlength="6" required>
                </div>
                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-phone fa-fw"></i>
                    </span>
                  <input class="form-control" id="phone" type="phone" v-model.trim="editUserInfo.phone" placeholder="Please, enter 11 character..." minlength="11" maxlength="11" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Role
                    </span>
                  <select class="form-control" id="role" v-model="editUserInfo.role" required>
                    <option>ADMIN</option>
                    <option>DOCTOR</option>
                    <option>MANAGER</option>
                  </select>
                </div>
                <hr>

                <button class="btn btn-primary send" type="submit">UPDATE INFORMATIONS</button>
              </div>

            </form>

          </div>
        </div>


      </div>

    </div>	<!-- team-members -->
    <br>
    <div v-if="editInfo" class="alert alert-info animated zoomInDown">
        <strong>Succesful Update!</strong> {{editInfo}}
    </div>


  </div>	<!-- container -->


</template>

<script>

export default {
  name: 'EditUser',

  props:{

    editUserInfo: { type: Object, required:true },
    headerInfo:null,
    session:null

  },

  data(){
    return{
      editUser:{
        username: null,
        name: null,
        surname: null,
        role:null,
        email:null,
        password:null,
        phone:null,
      },

      editData: null,
      editInfo:null,

      headerInfoAuth:this.headerInfo,

    }
  },

  created(){

    console.log("INFO : EditUser Running...");
  },

  methods:{

    updateUser(userId){

      this.editUser.username=this.editUserInfo.username;
      this.editUser.name=this.editUserInfo.name;
      this.editUser.surname=this.editUserInfo.surname;
      this.editUser.role=this.editUserInfo.role;
      this.editUser.email=this.editUserInfo.email;
      this.editUser.password=this.editUserInfo.password;
      this.editUser.phone=this.editUserInfo.phone;


      this.editData = JSON.stringify(this.editUser);

      //console.log(this.editData);

      console.log("RUNNING INFORMATION : UpdateUser is running...");

      var url = `http://localhost:8080/users/`+userId;

      //////////// START-VueResource-PUT ////////////////////
       this.$http.put(url, this.editData,{

         headers:{

           'Content-Type': 'application/json',
           'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
         }
       }

       ).then(function(resp) {

          //console.log(resp.status);
          //console.log(resp.data);

         if (resp.status == 202) {

            console.log("INFO : " +url + "- SUCCESSFUL PUT(UPDATE) Operation for This PLAYER...");

            this.editUser.username=null;
            this.editUser.name=null;
            this.editUser.surname=null;
            this.editUser.role=null;
            this.editUser.email=null;
            this.editUser.password=null;
            this.editUser.phone=null;

             this.editInfo='...Succesful Update Operation for This User...'

         }
       },function(error){
          console.error(error);
       })
         .catch((err)=>console.error(err))
      //////////// END-VueResource-PUT ////////////////////
    },

  },

}
</script>
