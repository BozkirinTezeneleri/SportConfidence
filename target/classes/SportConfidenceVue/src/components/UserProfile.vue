<template>

  <div>
    <button @click="goBack">Go Back to User List</button>
    <button @click="editUser">Edit User Information</button>
    <h2><b>{{userData.userId}} -</b> {{userData.name}} {{userData.surname}}</h2>
    <ul>

      <li><b>Username :</b> {{userData.username}}</li>
      <li><b>Role :</b> {{userData.role}}</li>
      <li><b>Phone Number :</b> {{userData.phone}}</li>

      <li><b>Email :</b> {{userData.email}}</li>


    </ul>

    <br>
    <router-link :to="prevUserLink">Previous User</router-link>
    <router-link :to="nextUserLink">Next User</router-link>

  </div>

</template>

<script>

export default {
  name: 'UserProfile',

  data(){
    return{
      userData:{}//Object temsil eder
    }
  },
  methods : {
    fetchData(){
      console.log("RUNNING INFORMATION : FetchData is running for User...");

      fetch(`http://localhost:8080/users/${this.$route.params.userId}`)//istek
      .then((res) => {return res.json()})//response json a cevrildi
      .then((user) => { this.userData=user;})
    },
    goBack(){

        this.$router.push({ name : 'userList' })//syfa yonlendirme

    },
    editUser(){

        this.$router.push({ name : 'editUser' })//syfa yonlendirme

    }
  },
  watch:{//olmazsa route degisir ama data degismez...
    '$route' : 'fetchData' // route dinle...fetchData metodu yeniden calistir.
  },
  computed :{

    nextUserLink(){
      console.log("RUNNING INFORMATION : NextUserLink is running...");

      return `/users/${parseInt(this.$route.params.userId,10)+1}`;
    },
    prevUserLink(){
      console.log("RUNNING INFORMATION : PrevUserLink is running...");

      return `/users/${parseInt(this.$route.params.userId,10)-1}`;
    }
  },

  created(){
    console.log("RUNNING INFORMATION : UserProfile is Running...")
    this.fetchData();
  }

}
</script>
