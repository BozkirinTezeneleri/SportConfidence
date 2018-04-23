<template>

  <div>
    <h2>NEW USER INFORMATION</h2>
    <hr>
    <form v-if="!submitData" v-on:submit.prevent="addUser" id="UserAdd" method="post">
      <div>
        <label for="name">Name :</label>
        <input type="text" id="name" v-model="newUser.name">
      </div>

      <div>
        <label for="surname">Surname :</label>
        <input type="text" id="surname" v-model="newUser.surname">
      </div>

      <div>
        <label for="email">Email :</label>
        <input type="email" id="email" v-model="newUser.email" placeholder="example@example.com">
      </div>

      <div>
        <label for="password">Password :</label>
        <input type="password" id="password" v-model="newUser.password" placeholder="Please enter min 6 chracter..." minlength="6">
      </div>

      <div>
        <label for="phone">Phone Number :</label>
        <input type="text" id="phone" v-model="newUser.phone" placeholder="Please, enter 10 character..." minlength="10" maxlength="10">
      </div>

      <div>
        <label for="role">Role :</label>
        <select class="" id="role" v-model="newUser.role">
          <option>ADMIN</option>
          <option>DOCTOR</option>
          <option>MANAGER</option>
        </select>
      </div>

      <hr>
      <p v-if="submitData">{{submitData}}</p>
      <hr>

      <button type="submit">SAVE</button>
      <hr>

    </form>
    <div v-if="submitInfo">
      <center>
        <b><p>{{submitInfo}}</p></b>
        <button @click="goBack">Go Back to User List</button>
      </center>
    </div>
  </div>
</template>

<script>

export default {
  name: 'UserAdd',

  data(){
    return{
      newUser:{
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

    goBack(){

        this.$router.push({ name : 'userList' })//syfa yonlendirme

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

            this.newUser.name=null
            this.newUser.surname=null
            this.newUser.email=null
            this.newUser.password=null
            this.newUser.phone=null
            this.newUser.role=null
            this.submitInfo='...Succesful Record Operation for New User...'
          }

      })
        .catch((err)=>console.error(err))

      //////// END-FETCH-POST/////////////////////

      ///////////////////// START- VueRouter-POST //////////

      /*this.$http.post(url, this.submitData).then(function(resp) {

          console.log(resp.status);
          //console.log(resp.data);

         if (resp.status == 201) {

         console.log("INFO : " + url + "- SUCCESSFUL POST Operation for USER...")

         }
       },function(resp){
          console.log("INFO : HATAAAAAAAAAAAAAAAAA");

       });*/
       //////////////////// END-VueRouter-POST/////////////
    }
  }
}
</script>
