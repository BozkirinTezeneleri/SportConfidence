<template>

  <div class="container">
    <div class="team-members">
      <div class="row text-center" id="heading">

          <div class= "col-md-6 col-md-offset-3 wow animated zoomInDown" id= "heading-text">
              <h3>Add New Player</h3>
                  <p>Enter New Player Information</p>
                  <hr class= "full">
                  <br/>
          </div>

      </div>

      <div class="row main_content">

        <div v-if="submitInfo" class="alert alert-success animated zoomInDown">
            <strong>Succesful Record!</strong> {{submitInfo}}
        </div>

        <div class= "row text-center main_content">
          <h2>NEW PLAYER INFORMATION</h2>
          <hr>
          <div class= "col-md-6 col-md-offset-3 text-center">

            <form v-on:submit.prevent="addPlayer" id="PlayerAdd" method="post" action="#">
              <div class= "form">

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="name" v-model.trim="newPlayer.name" placeholder="Name" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-envelope-o fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="surname" v-model.trim="newPlayer.surname" placeholder="Surname" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Position
                    </span>
                  <select class="form-control" id="position" v-model="newPlayer.position" required>

                    <option>Goalkeeper</option>
                    <option>Defence</option>
                    <option>Midfielder</option>
                    <option>Striker</option>

                  </select>
                </div>

                <div v-if="newPlayer.position" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> BirthDate
                    </span>
                  <input class="form-control" type="date" id="birthDate" v-model="newPlayer.birthDate">

                </div>

                <div v-if="newPlayer.position" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Weight (kg.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="40" max="120" id="weight" v-model="newPlayer.weight" placeholder="73.0" style="width:75%;">
                  <input class="form-control" type="text" id="weight" v-model.trim="newPlayer.weight" placeholder="73.0" style="width:25%;">
                </div>

                <div v-if="newPlayer.position" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Height (cm.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="100" max="210" id="height" v-model="newPlayer.height" placeholder="180.0" style="width:75%;">
                  <input class="form-control" type="text" id="height" v-model.trim="newPlayer.height" placeholder="180.0" style="width:25%;">
                </div>

                <div v-if="newPlayer.position" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Citizenship
                    </span>
                  <select class="form-control" id="country" v-model="newPlayer.country.countryId">

                    <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

                  </select>
                </div>

                <div v-if="newPlayer.height" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i>Disability State
                    </span>
                  <select class="form-control" id="disabilityState" v-model="newPlayer.disabilityState" required>
                    <option>True</option>
                    <option>False</option>
                  </select>
                </div>

                <div v-if="newPlayer.disabilityState" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-comment-o fa-fw"></i>
                    </span>
                  <textarea class="form-control" id="disabilityInformation" rows="6" type= "text"  v-model="newPlayer.disabilityInformation" placeholder="Enter Disability Information" required></textarea>
                </div>

                <div v-if="newPlayer.disabilityState" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Testimonial ($)
                    </span>
                  <input class="form-control" id="testimonial" type="text" v-model.trim="newPlayer.testimonial" placeholder="150.0 $" required>
                </div>

                <hr>
                <h2>TEAM INFORMATION</h2>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Country
                    </span>
                  <select class="form-control" id="country" v-model="selectedCountryId" v-on:change="getLeagues(selectedCountryId)" required>

                    <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

                  </select>
                </div>
                <div v-if="selectedCountryId" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> League
                    </span>
                  <select class="form-control" id="league" v-model="selectedLeagueId" v-on:change="getSportClubs(selectedLeagueId)" required>

                    <option v-for="league in leagues" :value="league.leagueId"> {{league.leagueName}} </option>

                  </select>
                </div>
                <div v-if="selectedLeagueId" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Sport Club
                    </span>
                  <select class="form-control" id="sportClub" v-model="newPlayer.sportClub.sportClubId" required>

                    <option v-for="sportclub in sportclubs" :value="sportclub.sportClubId"> {{sportclub.name}} </option>

                  </select>
                </div>

                <div v-if="selectedLeagueId" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time Start
                    </span>
                  <input class="form-control" type="date" id="contractTimeStart" v-model="newPlayer.contractTimeStart" required>

                </div>

                <div v-if="newPlayer.contractTimeStart" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time End
                    </span>
                  <input class="form-control" type="date" id="contractTimeEnd" v-model="newPlayer.contractTimeEnd" required>

                </div>
                <hr v-if="newPlayer.contractTimeEnd">

                <button v-if="newPlayer.contractTimeEnd" class="btn btn-primary send" type="submit">ADD NEW PLAYER</button>
              </div>
            </form>

          </div>
        </div>
        <hr>

      </div>

    </div>	<!-- team-members -->

    <!--<div class="">

      <p>SelectedCountryID : {{selectedCountryId}}</p>
      <p>SelectedLeagueID : {{selectedLeagueId}}</p>
      <p>NewPlayer.SelectedSportClubID : {{newPlayer.sportClub.sportClubId}}</p>
      <hr>
    </div>
  -->

  </div>	<!-- container -->


</template>

<script>

export default {
  name: 'PlayerAdd',

  props:{

    headerInfo:null,
    session:null

  },

  data(){
    return{
      newPlayer:{
        name: '',
        surname: '',
        birthDate:'',
        weight:'',
        height:'',
        position:'',
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
      submitInfo:null,

      countries:{},
      selectedCountryId:null,

      leagues:{},
      selectedLeagueId:null,

      sportclubs:{},
      selectedClubId:null,

      headerInfoAuth:this.headerInfo
    }
  },

  methods:{

    addPlayer(){

      this.submitData = JSON.stringify(this.newPlayer);
      console.log("RUNNING INFORMATION : AddPlayer is running...");

      var url = 'http://localhost:8080/players';

      ////////// START- FETCH-POST //////////////
      fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
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
            this.newPlayer.country.countryId=0
            this.newPlayer.sportClub.sportClubId=0
            this.newPlayer.disabilityInformation=null
            this.newPlayer.disabilityState=null
            this.newPlayer.testimonial=null
            this.newPlayer.height=null
            this.submitInfo='...Succesful Record Operation for New Player...'
          }
      })
        .catch((err)=>console.error(err))
      //////// END-FETCH-POST/////////////////////
    },


    getCountries(){

      console.log("RUNNING INFORMATION : GetUser is running for All Users...");

      var url = 'http://localhost:8080/countries';
      this.$http.get(url,
        {
          headers:{

            'Content-Type': 'application/json',
            'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
          }
        }
      ).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added Countries...");

          this.countries = resp.data;

        }
      });
    },

    getLeagues(countryId){

      console.log("RUNNING INFORMATION : GetLeagues is running for Selected Country...");

      var url = 'http://localhost:8080/leagues/country/'+countryId;
      this.$http.get(url,
        {
          headers:{

            'Content-Type': 'application/json',
            'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
          }
        }
      ).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added Leagues for Selected Country...");

          this.leagues = resp.data;

        }
      });
    },

    getSportClubs(leagueId){

      console.log("RUNNING INFORMATION : GetSportClubs is running for Selected League...");

      var url = 'http://localhost:8080/sportclubs/league/'+leagueId;
      this.$http.get(url,
        {
          headers:{

            'Content-Type': 'application/json',
            'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
          }
        }
      ).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added SportClubs for Selected Leagues...");

          this.sportclubs = resp.data;

        }
      });
    }
  },

  created(){

    this.getCountries();
    //this.getLeagues();
    //this.getSportClubs();
  }



}
</script>
