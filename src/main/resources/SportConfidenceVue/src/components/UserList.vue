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

          <template v-for="user in users">
            <user-item :user=user></user-item>
          </template>

        </div> <!-- row main_content -->
        
  </div>	<!-- container -->

</template>

<script>

import UserItem from './UserItem.vue'

export default {
  name: 'UserList',

  data(){
    return{
      users:{}
    }
  },
  methods:{

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
    }
  },

  /*computed() {
    return{
      users: 'getUser'
    }
  },*/

  created(){
    console.log("RUNNING INFORMATION : UserList is running...");

    //this.getUser();

    setInterval(() => {
        this.getUser();
        //console.log("aaa")
    },3000);

  },

  components:{ UserItem }

}
</script>
