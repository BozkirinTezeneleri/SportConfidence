<template>

  <div>
    <h2>EDIT USER INFORMATION</h2>

    <hr>
    <form v-if="!editData" v-on:submit.prevent="updateUser" id="EditUser" method="post">
      <div>
        <label for="name">Name :</label>
        <input type="text" id="name" v-model="editUser.name">
      </div>

      <div>
        <label for="surname">Surname :</label>
        <input type="text" id="surname" v-model="editUser.surname">
      </div>

      <div>
        <label for="email">Email :</label>
        <input type="email" id="email" v-model="editUser.email" placeholder="example@example.com">
      </div>

      <div>
        <label for="password">Password :</label>
        <input type="password" id="password" v-model="editUser.password" placeholder="Please enter min 6 chracter..." minlength="6">
      </div>

      <div>
        <label for="phone">Phone Number :</label>
        <input type="text" id="phone" v-model="editUser.phone" placeholder="Please, enter 10 character..." minlength="10" maxlength="10">
      </div>

      <div>
        <label for="role">Role :</label>
        <select class="" id="role" v-model="editUser.role">
          <option>ADMIN</option>
          <option>DOCTOR</option>
          <option>MANAGER</option>
        </select>
      </div>

      <hr>
      <p v-if="editData">{{editData}}</p>
      <hr>

      <button type="submit">UPDATE</button>
      <button @click="goBack">Go Back to User List</button>
      <hr>

    </form>
    <div v-if="editInfo">
      <center>
        <b><p>{{editInfo}}</p></b>
        <button @click="goBack">Go Back to User List</button>
      </center>
    </div>

  </div>
</template>

<script>

export default {
  name: 'EditUser',

  data(){
    return{
      editUser:{
        name:null,
        surname:null,
        email:null,
        password:null,
        phone:null,
        role:null

      },
      editData: null,
      editInfo:null
    }
  },

  created(){
    this.getUser();
  },

  methods:{

    getUser(){
      //console.log("RUNNING INFORMATION : GetUser is running for All Users...");

      var url = `http://localhost:8080/users/${this.$route.params.userId}`;
      this.$http.get(url).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added UserList...");

          this.editUser = resp.data;
        }
      });
    },

    goBack(){

        this.$router.push({ name : 'userList' })//syfa yonlendirme

    },
    updateUser:function(){
      this.editData = JSON.stringify(this.editUser);
      console.log("RUNNING INFORMATION : UpdateUser is running...");

      var url=`http://localhost:8080/users/${this.$route.params.userId}`;

      ///////////////////// START- VueResource-PUT //////////

      this.$http.put(url, this.editData).then(function(resp) {

          //console.log(resp.status);
          //console.log(resp.data);

         if (resp.status == 202) {

            console.log("INFO : " + url + "- SUCCESSFUL PUT(UPDATE) Operation for USER...")
            this.editUser.name=null
            this.editUser.surname=null
            this.editUser.email=null
            this.editUser.password=null
            this.editUser.phone=null
            this.editUser.role=null
            this.editInfo='...Succesful Update Operation for This User...'
         }
       },function(error){
          console.error(error);

       });
       //////////////////// END-VueResource-PUT/////////////
    }
  }
}
</script>
