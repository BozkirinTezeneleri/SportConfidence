<template>

  <div>
    <h2>NEW PLAYER INFORMATION</h2>
    <hr>
    <form v-if="!submitData" v-on:submit.prevent="addPlayer" id="PlayerAdd">
      <div>
        <label for="name">Name :</label>
        <input type="text" id="name" v-model="newPlayer.name">
      </div>
      <div>
        <label for="surname">Surname :</label>
        <input type="text" id="name" v-model="newPlayer.surname">
      </div>
      <div>
        <label for="birthDate">BirthDate :</label>
        <input type="date" id="birthDate" v-model="newPlayer.birthDate" placeholder="DD-MM-YYYY">
      </div>

      <div>
        <label for="weight">Weight :</label>
        <input type="range" step="0.1" min="40" max="120" id="weight" v-model="newPlayer.weight" placeholder="73.0">
        <input type="text" id="weight" v-model="newPlayer.weight" placeholder="73.0" style="width:5%;">
        <label for="weight">kg.</label>
      </div>

      <div>
        <label for="height">Height :</label>
        <input type="range" step="0.1" min="100" max="210" id="height" v-model="newPlayer.height" placeholder="180.0" style="width:5%;">

        <input type="text" id="height" v-model="newPlayer.height" placeholder="180.0" style="width:5%;">
        <label for="height">cm.</label>
      </div>

      <div>
        <label for="contractTimeStart">Contract Time Start :</label>
        <input type="date" id="contractTimeStart" v-model="newPlayer.contractTimeStart" placeholder="DD-MM-YYYY">
      </div>

      <div>
        <label for="contractTimeEnd">Contract Time End :</label>
        <input type="date" id="contractTimeEnd" v-model="newPlayer.contractTimeEnd" placeholder="DD-MM-YYYY">
      </div>

      <div>
        <label for="country">Citizenship :</label>
        <select class="" id="country">
          <option>COUNTRIES</option>

        </select>
      </div>

      <div>
        <label for="disabilityState">Disability State :</label>
        <select class="" id="disabilityState" v-model="newPlayer.disabilityState">
          <option>true</option>
          <option>false</option>
        </select>
      </div>

      <div>
        <label for="disabilityInformation">Disability Information :</label>
        <textarea rows="3" cols="40" id="disabilityInformation" v-model="newPlayer.disabilityInformation"></textarea>
      </div>

      <div>
        <label for="testimonial">Testimonial :</label>
        <input type="text" id="testimonial" v-model="newPlayer.testimonial" placeholder="150.0" style="width:20%;">
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

      <button type="submit">SAVE</button>
      <hr>
      <p v-if="submitData">{{submitData}}</p>
      <hr>

    </form>
    <div v-if="submitInfo">
      <center>
        <b><p>{{submitInfo}}</p></b>
        <button @click="goBack">Go Back to Player List</button>
      </center>
    </div>
  </div>
</template>

<script>

export default {
  name: 'PlayerAdd',

  data(){
    return{
      newPlayer:{
        name: '',
        surname: '',
        birthDate:'',
        weight:'',
        height:'',
        disabilityState:'',
        disabilityInformation:'',
        contractTimeStart:'',
        contractTimeEnd:'',
        testimonial:'',
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
      submitData: null,
      submitInfo:null
    }
  },

  methods:{

    goBack(){

        this.$router.push({ name : 'playerList' })//syfa yonlendirme

    },
    addPlayer(){

      //console.log(this.newPlayer.birthDate)
      this.submitData = JSON.stringify(this.newPlayer);
      console.log("RUNNING INFORMATION : AddPlayer is running...");

      var url = 'http://localhost:8080/players';

      ////////// START- FETCH-POST //////////////
      fetch(url, {
        method: 'POST',
        headers: {
          "Content-type": "application/json"
        },

        body:this.submitData

      }).then((res) =>{
          console.log(res)

          if(res.status==201){
            console.log("INFO : " + url + "- SUCCESSFUL POST Operation for New PLAYER...");

            this.newPlayer.name=null
            this.newPlayer.surname=null
            this.newPlayer.birthDate=null
            this.newPlayer.weight=73.4
            this.newPlayer.contractTimeStart=null
            this.newPlayer.contractTimeEnd=null
            this.newPlayer.country.countryId=1
            this.newPlayer.sportClub.sportClubId=1
            this.newPlayer.disabilityInformation=null
            this.newPlayer.disabilityState=null
            this.newPlayer.testimonial=58.3
            this.newPlayer.height=180.2
            this.submitInfo='...Succesful Record Operation for New Player...'
          }

      })
        .catch((err)=>console.error(err))

      //////// END-FETCH-POST/////////////////////



    }
  }



}
</script>
