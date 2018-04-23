<template>

  <div>
    <p>
      <button @click="delPlayer(player.playerId)">Delete</button>
      <router-link :to="profileLink">
        {{player.playerId}}- {{player.name}} {{player.surname}}
      </router-link>
    </p>
  </div>
</template>

<script>

export default {
  name: 'PlayerItem',

  props:{

    player: { type: Object, required:true }
  },
  methods:{

    delPlayer(id){

      var url = 'http://localhost:8080/players/'+ id;
      console.log("RUNNING INFORMATION : DeletePlayer is Running for " + url);

      this.$http.delete(url).then(function (res) {

        console.log("INFO : " + url + ' - ID: ' + id + ' => DELETED PLAYER...');
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
