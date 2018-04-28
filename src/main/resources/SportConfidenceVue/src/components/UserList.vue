<template>

  <div>
  <template v-for="user in users">
    <user-item :user=user></user-item>
  </template>
  </div>
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
  watch : {
    users: 'getUser'
  },

  created(){
    console.log("RUNNING INFORMATION : UserList is running...");

    this.getUser();

  },

  components:{ UserItem }

}
</script>
