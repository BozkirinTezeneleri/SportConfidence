<template>

  <div>
  <template v-for="player in players">
    <player-item :player=player></player-item>
  </template>
  </div>
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
