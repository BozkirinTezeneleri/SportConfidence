<template>

  <div class="row main_content">

    <div v-if="submitInfo" class="alert alert-success">
        <strong>Succesful Record!</strong> {{submitInfo}}
    </div>
    <div class= "row text-center main_content">
      <h2>NEW PLAYER INFORMATION</h2>
      <hr>
      <div class= "col-md-6 col-md-offset-3 text-center">

        <form v-if="!submitData" v-on:submit.prevent="addPlayer" id="PlayerAdd" method="post" action="#">
          <div class= "form">

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-user fa-fw"></i>
                </span>
              <input class="form-control" type="text" id="name" v-model="newPlayer.name" placeholder="Name" required>
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-envelope-o fa-fw"></i>
                </span>
              <input class="form-control" type="text" id="surname" v-model="newPlayer.surname" placeholder="Surname" required>
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i> BirthDate
                </span>
              <input class="form-control" type="date" id="birthDate" v-model="newPlayer.birthDate">

            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i> Weight (kg.)
                </span>
              <input class="form-control" type="range" step="0.1" min="40" max="120" id="weight" v-model="newPlayer.weight" placeholder="73.0" style="width:75%;">
              <input class="form-control" type="text" id="height" v-model="newPlayer.weight" placeholder="73.0" style="width:25%;">
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i> Height (cm.)
                </span>
              <input class="form-control" type="range" step="0.1" min="100" max="210" id="height" v-model="newPlayer.height" placeholder="180.0" style="width:75%;">
              <input class="form-control" type="text" id="height" v-model="newPlayer.height" placeholder="180.0" style="width:25%;">
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i> Contract Time Start
                </span>
              <input class="form-control" type="date" id="contractTimeStart" v-model="newPlayer.contractTimeStart">

            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i> Contract Time End
                </span>
              <input class="form-control" type="date" id="contractTimeEnd" v-model="newPlayer.contractTimeEnd">

            </div>


            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i>
                </span>
              <select class="form-control" id="country" >
                <option>COUNTRIES</option>
              </select>
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i>Disability State
                </span>
              <select class="form-control" id="disabilityState" v-model="newPlayer.disabilityState" >
                <option>true</option>
                <option>false</option>
              </select>
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-comment-o fa-fw"></i>
                </span>
              <textarea class="form-control" rows="6" type= "text"  v-model="newPlayer.disabilityInformation" placeholder="Enter Disability Information" required></textarea>
            </div>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i>
                </span>
              <input class="form-control" type="text" v-model="newPlayer.testimonial" placeholder="Testimonial (150.0 $)">
            </div>

            <hr>
            <h2>TEAM INFORMATION</h2>

            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i>
                </span>
              <select class="form-control" id="country" >
                <option>Turkey</option>
              </select>
            </div>
            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i>
                </span>
              <select class="form-control" id="league">
                <option>Turkish Super League</option>
              </select>
            </div>
            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-tags fa-fw"></i>
                </span>
              <select class="form-control" id="sportClub">
                <option>Fenerbahçe</option>
              </select>
            </div>
            <hr>

            <button class="btn btn-primary send" type="submit">ADD NEW PLAYER</button>
          </div>
        </form>

      </div>
    </div>
    <hr>

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
            this.newPlayer.weight=null
            this.newPlayer.contractTimeStart=null
            this.newPlayer.contractTimeEnd=null
            this.newPlayer.country.countryId=1
            this.newPlayer.sportClub.sportClubId=1
            this.newPlayer.disabilityInformation=null
            this.newPlayer.disabilityState=null
            this.newPlayer.testimonial=null
            this.newPlayer.height=null
            this.submitInfo='...Succesful Record Operation for New Player...'
          }

      })
        .catch((err)=>console.error(err))

      //////// END-FETCH-POST/////////////////////



    }
  }



}
</script>
