<template>

  <div class="container">
    <div class="team-members">
      <div class="row text-center" id="heading">
        <div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
            <h3>Add User</h3>
                <p>Enter New User Information</p>
                <hr class="full">
                <br/>
          </div>
      </div>

      <div class="row main_content">

        <div v-if="submitInfo" class="alert alert-success animated zoomInDown">
            <strong>Succesful Record!</strong> {{submitInfo}}
        </div>

        <div class= "row text-center main_content">
          <h3>NEW USER INFORMATION</h3>
          <hr>
          <div class= "col-md-6 col-md-offset-3 text-center">

            <form v-on:submit.prevent="addUser" id="UserAdd" method="post" action="#">
              <div class= "form">
                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <b>@</b>
                    </span>
                  <input class="form-control" type="text" id="username" v-model.trim="newUser.username" placeholder="Username" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="name" v-model.trim="newUser.name" placeholder="Name" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="surname" v-model.trim="newUser.surname" placeholder="Surname" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-envelope-o fa-fw"></i>
                    </span>
                  <input class="form-control" type="email" id="email" v-model.trim="newUser.email" placeholder="example@example.com" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-lock fa-fw"></i>
                    </span>
                  <input class="form-control" type="password" id="password" v-model="newUser.password" placeholder="Please enter min 6 chracter..." minlength="6" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-phone fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="phone" v-model="newUser.phone" placeholder="Please, enter 11 character..." minlength="11" maxlength="11" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Role
                    </span>
                  <select class="form-control" id="role" v-model="newUser.role" required>
                    <option>ADMIN</option>
                    <option>DOCTOR</option>
                    <option>MANAGER</option>
                  </select>
                </div>
              </div>

              <button class="btn btn-primary send" type="submit">ADD NEW USER</button>
            </form>

          </div>
        </div>
        <hr>

      </div> <!-- row main_content -->

    </div>	<!-- team-members -->
   </div>	<!-- container -->

</template>

<script>

export default {
  name: 'UserAdd',

  data(){
    return{
      newUser:{
        username:null,
        name:null,
        surname:null,
        email:null,
        password:null,
        phone:null,
        role:null

      },
      submitData: null,
      submitInfo:null
    }
  },

  methods:{

    created(){
      console.log("RUNNING INFORMATION : UserAdd is running...")

    },

    addUser(){

      this.submitData = JSON.stringify(this.newUser);
      console.log("RUNNING INFORMATION : AddUser running...");

      var url='http://localhost:8080/users';

      ////////// START- FETCH-POST //////////////
      fetch(url, {
        method: 'POST',
        headers: {
          "Content-type": "application/json"
        },

        body:this.submitData

      }).then((res) =>{
          console.log(res)

          if(res.status==201){
            console.log("INFO : " + url + "- SUCCESSFUL POST Operation for USER...")

            this.newUser.username=null
            this.newUser.name=null
            this.newUser.surname=null
            this.newUser.email=null
            this.newUser.password=null
            this.newUser.phone=null
            this.newUser.role=null
            this.submitInfo='...Succesful Record Operation for New User...'

            //alert(this.submitInfo);

          }

      })
        .catch((err)=>console.error(err))

      //////// END-FETCH-POST/////////////////////

    }
  }
}
</script>
