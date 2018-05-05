<template>

  <div class="col-md-3 col-sm-5 text-center">
    <div class="row wow animated zoomIn" data-wow-delay="0.1s">
      <div class="col-md-8 col-md-offset-2">
        <img class="img-circle img-responsive center-block" src="src/assets/img/Syed-Rezwanul-Haque.jpg" alt="Syed Rezwanul Haque Rubel">
      </div>
    </div>
    <h4 class="wow animated fadeInUp" data-wow-delay= "0.2s">
      <router-link :to="profileLink">
        {{user.userId}}- {{user.name}} {{user.surname}}
      </router-link>
    </h4>
    <p class= "member-title wow animated fadeIn" data-wow-delay= "0.3s">{{user.role}}</p>
    <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Email : </b>{{user.email}}</p>
    <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Phone : </b>{{user.phone}}</p>
    <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
      <div class= "team-member-contact">
          <button class="btn btn-danger" @click="delUser(user.userId)">Delete</button>
      </div>
    </div>

    <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
        <strong>User Deleted!</strong> {{deleteInfo}}
    </div>

  </div>

</template>

<script>

export default {
  name: 'UserItem',

  props:{

    user: { type: Object, required:true }
  },
  data(){
    return{
      deleteInfo:null
    }
  },
  methods:{

    delUser(id){

      var url = 'http://localhost:8080/users/'+ id;
      console.log("RUNNING INFORMATION : DeleteUser is Running for " + url);

      this.$http.delete(url).then(function (res) {

        console.log("INFO : " + url + ' - ID: ' + id + ' =>DELETED USER...');

        this.deleteInfo="DELETE";
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
