<template>

  <div>
    <p>
      <button @click="delUser(user.userId)">Delete</button>
      <router-link :to="profileLink">
        {{user.userId}}- {{user.name}} {{user.surname}}
      </router-link>
    </p>
  </div>
</template>

<script>

export default {
  name: 'UserItem',

  props:{

    user: { type: Object, required:true }
  },
  methods:{

    delUser(id){

      var url = 'http://localhost:8080/users/'+ id;
      console.log("RUNNING INFORMATION : DeleteUser is Running for " + url);

      this.$http.delete(url).then(function (res) {

        console.log("INFO : " + url + ' - ID: ' + id + ' =>DELETED USER...');
      })

    }
  },

  computed: {
    profileLink() {
      return `/users/${this.user.userId}`;
    }
  }

}
</script>
