<template>

  <div class="col-md-3 col-sm-5 text-center">
    <div class="row wow animated zoomIn" data-wow-delay="0.1s">
      <div class="col-md-8 col-md-offset-2">
        <img class="img-circle img-responsive center-block" src="src/assets/img/Syed-Rezwanul-Haque.jpg" alt="Syed Rezwanul Haque Rubel">
      </div>
    </div>
    <h4 class="wow animated fadeInUp" data-wow-delay= "0.2s">
      <router-link :to="profileLink">
        {{player.playerId}}- {{player.name}} {{player.surname}}
      </router-link>
    </h4>
    <p class= "member-title wow animated fadeIn" data-wow-delay= "0.3s">{{player.sportClub.name}}</p>
    <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Citizenship : </b>{{player.country.countryName}}</p>
    <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s"><b>Disability State : </b>{{player.disabilityState}}</p>
    <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
      <div class= "team-member-contact">
          <button class="btn btn-danger" @click="delPlayer(player.playerId)">Delete</button>
      </div>
    </div>
    <div v-if="deleteInfo" class="alert alert-warning">
        <strong>Player Deleted!</strong> {{deleteInfo}}
    </div>
  </div>


</template>

<script>

export default {
  name: 'PlayerItem',

  props:{

    player: { type: Object, required:true }
  },
  data:{
    deleteInfo:null
  },
  methods:{

    delPlayer(id){

      var url = 'http://localhost:8080/players/'+ id;
      console.log("RUNNING INFORMATION : DeletePlayer is Running for " + url);

      this.$http.delete(url).then(function (res) {

        console.log("INFO : " + url + ' - ID: ' + id + ' => DELETED PLAYER...');
        this.deleteInfo="DELETE";
      })

    }
  },

  computed: {
    profileLink() {
      return `/players/${this.player.playerId}`;
    }
  }

}
</script>
