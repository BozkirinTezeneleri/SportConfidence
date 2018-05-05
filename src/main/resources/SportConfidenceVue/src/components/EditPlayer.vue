<template>

  <div class="container">
    <div class="team-members">
      <div class="row text-center" id="heading">

          <div class= "col-md-6 col-md-offset-3 wow animated zoomInDown" id= "heading-text">
              <h3>Edit Player</h3>
                  <p>Enter New Information For This Player</p>
                  <hr class= "full">
                  <br/>
          </div>

      </div>

      <div class="row main_content">

        <div class= "row text-center main_content">

          <div class= "col-md-6 col-md-offset-3 text-center">

            <form v-on:submit.prevent="updatePlayer(editPlayerInfo.playerId)" id="PlayerAdd" method="post" action="#">
              <div class= "form">

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="name" v-model.trim="editPlayerInfo.name" placeholder="Name" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-envelope-o fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="surname" v-model.trim="editPlayerInfo.surname" placeholder="Surname" required>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> BirthDate
                    </span>
                  <input class="form-control" type="date" id="birthDate" v-model="editPlayerInfo.birthDate">

                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Weight (kg.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="40" max="120" id="weight" v-model="editPlayerInfo.weight" placeholder="73.0" style="width:75%;">
                  <input class="form-control" type="text" id="weight" v-model.trim="editPlayerInfo.weight" placeholder="73.0" style="width:25%;">
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Height (cm.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="100" max="210" id="height" v-model="editPlayerInfo.height" placeholder="180.0" style="width:75%;">
                  <input class="form-control" type="text" id="height" v-model.trim="editPlayerInfo.height" placeholder="180.0" style="width:25%;">
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Citizenship
                    </span>
                  <select class="form-control" id="country" v-model="editPlayerInfo.country.countryId">

                    <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

                  </select>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Position
                    </span>
                  <select class="form-control" id="position" v-model="editPlayerInfo.position" required>

                    <option>Goalkeeper</option>
                    <option>Defence</option>
                    <option>Midfielder</option>
                    <option>Striker</option>

                  </select>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i>Disability State
                    </span>
                  <select class="form-control" id="disabilityState" v-model="editPlayerInfo.disabilityState" required>
                    <option>true</option>
                    <option>false</option>
                  </select>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-comment-o fa-fw"></i>
                    </span>
                  <textarea class="form-control" id="disabilityInformation" rows="6" type= "text"  v-model="editPlayerInfo.disabilityInformation" placeholder="Enter Disability Information" required></textarea>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Testimonial ($)
                    </span>
                  <input class="form-control" id="testimonial" type="text" v-model.trim="editPlayerInfo.testimonial" placeholder="150.0 $" required>
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
                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> League
                    </span>
                  <select class="form-control" id="league" v-model="selectedLeagueId" v-on:change="getSportClubs(selectedLeagueId)" required>

                    <option v-for="league in leagues" :value="league.leagueId"> {{league.leagueName}} </option>

                  </select>
                </div>
                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Sport Club
                    </span>
                  <select class="form-control" id="sportClub" v-model="selectedSportClubId" required>

                    <option v-for="sportclub in sportclubs" :value="sportclub.sportClubId"> {{sportclub.name}} </option>

                  </select>
                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time Start
                    </span>
                  <input class="form-control" type="date" id="contractTimeStart" v-model="editPlayerInfo.contractTimeStart" required>

                </div>

                <div class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time End
                    </span>
                  <input class="form-control" type="date" id="contractTimeEnd" v-model="editPlayerInfo.contractTimeEnd" required>

                </div>
                <hr>

                <button class="btn btn-primary send" type="submit">UPDATE INFORMATIONS</button>
              </div>

            </form>

          </div>
        </div>


      </div>

    </div>	<!-- team-members -->
    <br>
    <div v-if="editInfo" class="alert alert-info animated zoomInDown">
        <strong>Succesful Update!</strong> {{editInfo}}
    </div>


  </div>	<!-- container -->


</template>

<script>

export default {
  name: 'EditPlayer',

  props:{

    editPlayerInfo: { type: Object, required:true }

  },

  data(){
    return{
      editPlayer:{
        name: null,
        surname: null,
        birthDate:null,
        weight:null,
        height:null,
        position:null,
        disabilityState:null,
        disabilityInformation:null,
        contractTimeStart:null,
        contractTimeEnd:null,
        testimonial:null,
        country:{
          countryId:null,
          //countryName:null
        },
        sportClub:{
          sportClubId:null,

          league:{
            leagueId:null,
            //leagueName:'Turkish Super League',
            country:{
              countryId:null,
              //id:90,
              //countryName:'turkey'
            }
          }
        }

      },
      editData: null,
      editInfo:null,

      isThereHisClub:false,

      countries:{},
      selectedCountryId:null,

      leagues:{},
      selectedLeagueId:null,

      sportclubs:{},
      selectedSportClubId:null
    }
  },

  created(){

    this.getCountries();
    //this.getLeagues();
    //this.getSportClubs();
  },

  methods:{

    updatePlayer(playerId){

      this.editPlayer.name=this.editPlayerInfo.name;
      this.editPlayer.surname=this.editPlayerInfo.surname;
      this.editPlayer.birthDate=this.editPlayerInfo.birthDate;
      this.editPlayer.weight=this.editPlayerInfo.weight;
      this.editPlayer.height=this.editPlayerInfo.height;
      this.editPlayer.position=this.editPlayerInfo.position;
      this.editPlayer.disabilityState=this.editPlayerInfo.disabilityState;
      this.editPlayer.disabilityInformation=this.editPlayerInfo.disabilityInformation;
      this.editPlayer.contractTimeStart=this.editPlayerInfo.contractTimeStart;
      this.editPlayer.contractTimeEnd=this.editPlayerInfo.contractTimeEnd;
      this.editPlayer.testimonial=this.editPlayerInfo.testimonial;
      this.editPlayer.country.countryId=this.editPlayerInfo.country.countryId;
      this.editPlayer.sportClub.sportClubId=this.selectedSportClubId;
      this.editPlayer.sportClub.league.leagueId=this.selectedLeagueId;
      this.editPlayer.sportClub.league.country.countryId=this.selectedCountryId;

      this.editData = JSON.stringify(this.editPlayer);

      //console.log(this.editData);

      console.log("RUNNING INFORMATION : UpdatePlayer is running...");

      var url = `http://localhost:8080/players/`+playerId;

      //////////// START-VueResource-PUT ////////////////////
       this.$http.put(url, this.editData).then(function(resp) {

          //console.log(resp.status);
          //console.log(resp.data);

         if (resp.status == 202) {

            console.log("INFO : " +url + "- SUCCESSFUL PUT(UPDATE) Operation for This PLAYER...");

             this.editPlayer.name=null
             this.editPlayer.surname=null
             this.editPlayer.birthDate=null
             this.editPlayer.weight=null
             this.editPlayer.contractTimeStart=null
             this.editPlayer.contractTimeEnd=null
             this.editPlayer.country.countryId=null
             this.editPlayer.sportClub.sportClubId=1
             this.editPlayer.disabilityInformation=null
             this.editPlayer.disabilityState=null
             this.editPlayer.testimonial=null
             this.editPlayer.height=null
             this.editInfo='...Succesful Update Operation for This Player...'

         }
       },function(error){
          console.error(error);
       })
         .catch((err)=>console.error(err))
      //////////// END-VueResource-PUT ////////////////////
    },

    getCountries(){

      console.log("RUNNING INFORMATION : GetUser is running for All Users...");

      var url = 'http://localhost:8080/countries';
      this.$http.get(url).then(function (resp) {
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
      this.$http.get(url).then(function (resp) {
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
      this.$http.get(url).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added SportClubs for Selected Leagues...");

          this.sportclubs = resp.data;

        }
      });
    }
  },





}
</script>
