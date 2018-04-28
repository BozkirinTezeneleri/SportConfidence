<template>

  <div>
    <h2>NEW PLAYER INFORMATION</h2>
    <hr>
    <form v-if="!editData" v-on:submit.prevent="updatePlayer" id="editPlayer">
      <div>
        <label for="name">Name :</label>
        <input type="text" id="name" v-model="editPlayer.name">
      </div>
      <div>
        <label for="surname">Surname :</label>
        <input type="text" id="name" v-model="editPlayer.surname">
      </div>
      <div>
        <label for="birthDate">BirthDate :</label>
        <input type="date" id="birthDate" v-model="editPlayer.birthDate" placeholder="DD-MM-YYYY">
      </div>

      <div>
        <label for="weight">Weight :</label>
        <input type="range" step="0.1" min="40" max="120" id="weight" v-model="editPlayer.weight" placeholder="73.0">
        <input type="text" id="weight" v-model="editPlayer.weight" placeholder="73.0" style="width:5%;">
        <label for="weight">kg.</label>
      </div>

      <div>
        <label for="height">Height :</label>
        <input type="range" step="0.1" min="100" max="210" id="height" v-model="editPlayer.height" placeholder="180.0">
        <input type="text" id="height" v-model="editPlayer.height" placeholder="180.0" style="width:5%;">
        <label for="height">cm.</label>
      </div>

      <div>
        <label for="contractTimeStart">Contract Time Start :</label>
        <input type="date" id="contractTimeStart" v-model="editPlayer.contractTimeStart" placeholder="DD-MM-YYYY">
      </div>

      <div>
        <label for="contractTimeEnd">Contract Time End :</label>
        <input type="date" id="contractTimeEnd" v-model="editPlayer.contractTimeEnd" placeholder="DD-MM-YYYY">
      </div>

      <div>
        <label for="">Citizen(yazma) :</label>
        <input type="text"/>
      </div>

      <div>
        <label for="disabilityState">Disability State :</label>
        <select class="" id="disabilityState" v-model="editPlayer.disabilityState">
          <option>true</option>
          <option>false</option>
        </select>
      </div>

      <div>
        <label for="disabilityInformation">Disability Information :</label>
        <textarea rows="3" cols="40" id="disabilityInformation" v-model="editPlayer.disabilityInformation"></textarea>
      </div>

      <div>
        <label for="testimonial">Testimonial :</label>
        <input type="text" id="testimonial" v-model="editPlayer.testimonial" placeholder="example : 150.0">
        <label for="testimonial">$</label>
      </div>
      <hr>
      <h2>TEAM INFORMATION</h2>
      <div>
        <label for="">Country(yazma) :</label>
        <select class="">
          <option>Turkey</option>
        </select>
      </div>

      <div>
        <label for="">League(yazma) :</label>
        <select class="">
          <option>Turkish Super League</option>
        </select>
      </div>

      <div>
        <label for="">Sport Club(yazma) :</label>
        <select class="">
          <option>Fenerbahce</option>
        </select>
      </div>
      <hr>

      <button type="submit">UPDATE</button>
      <hr>
      <p v-if="editData">{{editData}}</p>
      <hr>

    </form>
    <div v-if="editInfo">
      <center>
        <b><p>{{editInfo}}</p></b>
        <button @click="goBack">Go Back to Player List</button>
      </center>
    </div>
  </div>
</template>

<script>

export default {
  name: 'EditPlayer',

  data(){
    return{
      editPlayer:{
        name: '',
        surname: '',
        birthDate:'',
        weight:58.3,
        height:180.6,
        disabilityState:'',
        disabilityInformation:'',
        contractTimeStart:'',
        contractTimeEnd:'',
        testimonial:58.5,
        country:{
          countryId:1,
          //id:90,
          //countryName:'turkey'
        },
        sportClub:{
          sportClubId:1,
          /*name:'fb',
          league:{
            leagueId:1,
            leagueName:'Turkish Super League',
            country:{
              countryId:1,
              //id:90,
              //countryName:'turkey'
            }
          }*/
        }

      },
      editData: null,
      editInfo:null
    }
  },

  created(){
    this.getPlayer();
  },

  methods:{

    goBack(){

        this.$router.push({ name : 'playerList' })//syfa yonlendirme

    },

    getPlayer(){
      console.log("RUNNING INFORMATION : GetPlayer is running for All Players...");

      var url = `http://localhost:8080/players/${this.$route.params.playerId}`;
      this.$http.get(url).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {

          console.log("INFO : Player informations added to form elements...");
          this.editPlayer = resp.data;
        }
      });
    },

    updatePlayer(){
      this.editData = JSON.stringify(this.editPlayer);
      console.log("RUNNING INFORMATION : UpdatePlayer is running...");

      var url = `http://localhost:8080/players/${this.$route.params.playerId}`;

      //////////// START-VueResource-PUT ////////////////////
       this.$http.put(url, this.editData).then(function(resp) {

          //console.log(resp.status);
          //console.log(resp.data);

         if (resp.status == 202) {

            console.log("INFO : " +url + "- SUCCESSFUL PUT(UPDATE) Operation for This PLAYER...");

             this.editPlayer.name=null
             this.editPlayer.surname=null
             this.editPlayer.birthDate=null
             this.editPlayer.weight=73.4
             this.editPlayer.contractTimeStart=null
             this.editPlayer.contractTimeEnd=null
             this.editPlayer.country.countryId=1
             this.editPlayer.sportClub.sportClubId=1
             this.editPlayer.disabilityInformation=null
             this.editPlayer.disabilityState=null
             this.editPlayer.testimonial=58.3
             this.editPlayer.height=180.2
             this.editInfo='...Succesful Update Operation for This Player...'

         }
       },function(error){
          console.error(error);
       })
         .catch((err)=>console.error(err))
      //////////// END-VueResource-PUT ////////////////////
    }
  }



}
</script>
