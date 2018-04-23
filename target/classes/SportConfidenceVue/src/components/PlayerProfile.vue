<template>

  <div>
    <button @click="goBack">Go Back to Player List</button>
    <button @click="editPlayer">Edit Player Information</button>
    <h2><b>{{playerData.playerId}} -</b> {{playerData.name}} {{playerData.surname}}</h2>
    <ul>

      <li><b>Citizenship(Country) :</b> {{playerData.country.countryName}}</li>
      <li><b>Birth Date :</b> {{playerData.birthDate}}</li>
      <li><h4>-PYSICAL PROPERTIES</h4><li>
      <li><b>Height :</b> {{playerData.height}} cm</li>
      <li><b>Weight :</b> {{playerData.weight}} kg</li>
      <li><h4>-TEAM & CONTRACT INFORMATION</h4><li>
      <li><b>Sport Club :</b> {{playerData.sportClub.name}}</li>
      <li><b>Contract Time Start :</b> {{playerData.contractTimeStart}}</li>
      <li><b>Contract Time End :</b> {{playerData.contractTimeEnd}}</li>
      <li><h4>-DISABILITY STATEMENT</h4><li>
      <li><b>Disability State :</b> {{playerData.disabilityState}}</li>
      <li><b>Disability Information :</b> {{playerData.disabilityInformation}}</li>
      <li><h4>-TESTIMONIAL INFORMATION</h4><li>
      <li><b>Testimonial :</b> {{playerData.testimonial}} $</li>


    </ul>

    <br>
    <router-link :to="prevPlayerLink">Previous Player</router-link>
    <router-link :to="nextPlayerLink">Next Player</router-link>

  </div>

</template>

<script>

export default {
  name: 'PlayerProfile',

  data(){
    return{
      playerData:{}//Object temsil eder
    }
  },
  methods : {
    fetchData(){

      console.log("RUNNING INFORMATION : FetchData is running for Player...");

      fetch(`http://localhost:8080/players/${this.$route.params.playerId}`)//istek
      .then((res) => {return res.json()})//response json a cevrildi
      .then((player) => { this.playerData=player;})
    },
    goBack(){

        this.$router.push({ name : 'playerList' })//syfa yonlendirme

    },
    editPlayer(){

        this.$router.push({ name : 'editPlayer' })//syfa yonlendirme

    }
  },
  watch:{//olmazsa route degisir ama data degismez...
    '$route' : 'fetchData' // route dinle...fetchData metodu yeniden calistir.
  },
  computed :{

    nextPlayerLink(){
      console.log("RUNNING INFORMATION : NextPlayerLink is running...");

      return `/players/${parseInt(this.$route.params.playerId,10)+1}`;
    },
    prevPlayerLink(){
      console.log("RUNNING INFORMATION : PrevPlayerLink is running...");

      return `/players/${parseInt(this.$route.params.playerId,10)-1}`;
    }
  },

  created(){
    console.log("RUNNING INFORMATION : PlayerProfile is Running...")
    this.fetchData();
  }

}
</script>
