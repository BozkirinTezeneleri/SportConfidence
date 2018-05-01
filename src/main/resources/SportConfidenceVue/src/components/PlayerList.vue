<template>

  <div class="container">
    <div class="row text-center" id="heading">
      <div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
          <h3>Players</h3>
              <p>Player List</p>
              <hr class="full">
              <br/>
        </div>
    </div>	<!-- row -->
    <div class="row main_content">
        <div class="row text-center" id="heading">
          <template v-for="player in players">
            <player-item :player=player></player-item>
          </template>
        </div>
    </div>	<!-- row main_content -->

  </div>	<!-- container -->


</template>

<script>

import PlayerItem from './PlayerItem.vue'

export default {
  name: 'PlayerList',

  data(){
    return{
      players:{}
    }
  },
  methods:{

    getPlayer(){
      console.log("RUNNING INFORMATION : GetPlayer is running for All Players...");

      var url = 'http://localhost:8080/players';
      this.$http.get(url).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {

          console.log("INFO : Accepted All Player and Added PlayerList...");
          this.players = resp.data;
        }
      });
    }
  },
  watch : {
    players: 'getPlayer'
  },

  created(){
    console.log("RUNNING INFORMATION : PlayerList is running...");

    this.getPlayer();

  },

  components:{ PlayerItem }

}
</script>
