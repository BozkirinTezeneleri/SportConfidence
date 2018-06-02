<template>

  <div class="container">
    <div class="row text-center" id="heading">
      <div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
          <h3>Sport Clubs</h3>
              <p>Select a Sport Club</p>
              <hr class= "full">
              <br/>
        </div>
    </div>
    <div class= "row text-center main_content">
      <div class= "col-md-6 col-md-offset-3 text-center">
        <h2>Sport Club Informations</h2>

        <div class="input-group margin-bottom-sm">
            <span class="input-group-addon">
              <i class="fa fa-tags fa-fw"></i> Country
            </span>
          <select class="form-control" id="country" v-model="selectedCountryId" v-on:change="getLeagues(selectedCountryId)">

            <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

          </select>
        </div>
        <div v-if="selectedCountryId" class="input-group margin-bottom-sm">
            <span class="input-group-addon">
              <i class="fa fa-tags fa-fw"></i> League
            </span>
          <select class="form-control" id="league" v-model="selectedLeagueId" v-on:change="getSportClubs(selectedLeagueId)">

            <option v-for="league in leagues" :value="league.leagueId"> {{league.leagueName}} </option>

          </select>
        </div>
        <div v-if="selectedLeagueId" class="input-group margin-bottom-sm">
            <span class="input-group-addon">
              <i class="fa fa-tags fa-fw"></i> Sport Club
            </span>
          <select class="form-control" id="sportClub" v-model="selectedClubId" v-on:change="getSportClubPlayers(selectedClubId)">

            <option v-for="sportClub in sportClubs" :value="sportClub.sportClubId"> {{sportClub.name}} </option>

          </select>
        </div>
      </div>

    </div>	<!-- main_content -->

    <div v-if="selectedClubId" class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                TEAM PLAYERS
                            </h2>
                        </div>
                        <div class="body table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                      <th>Id</th>
                                      <th>Photo</th>
                                      <th>Name Surname</th>
                                      <th>Citizenship</th>
                                      <th>Position</th>
                                      <th>Height</th>
                                      <th>Weight</th>
                                      <th>Disability State</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="sportClubPlayer in sportClubPlayers">
                                        <th scope="row">{{sportClubPlayer.playerId}}</th>

                                        <td>
                                          <div class="row wow animated zoomIn" data-wow-delay="0.1s">

                                              <img class="img-circle img-responsive center-block" style="height:50px;" src="src/assets/img/player.png">

                                          </div>
                                        </td>

                                        <td style="color: rgb(32, 178, 170);">{{sportClubPlayer.name}} {{sportClubPlayer.surname}}</td>
                                        <td>{{sportClubPlayer.country.countryName}}</td>
                                        <td>{{sportClubPlayer.position}}</td>
                                        <td>{{sportClubPlayer.height}}</td>
                                        <td>{{sportClubPlayer.weight}}</td>
                                        <td style="color: rgb(32, 178, 170);">{{sportClubPlayer.disabilityState}}</td>
                                        <td><button class="btn btn-primary send" @click="getPlayerProfile(sportClubPlayer.playerId)">SHOW PROFILE</button></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

    <!-- <p v-model="yazi">{{yazi}}</p> -->
    <!-- Players -->
	  <section id="player_list">

        <player-profile v-if="selectedClubPlayerId" :selectedPlayer=selectedClubPlayer :headerInfo=headerInfo :session=session></player-profile>

	  </section><!-- players -->
  </div>	<!-- container -->

</template>

<script>
export default {

  name: 'SportClubs',

  props:{
    headerInfo:null,
    session:null
  },

  data(){
    return{
      countries:{},
      selectedCountryId:null,

      leagues:{},
      selectedLeagueId:null,

      sportClubs:{},
      selectedClubId:null,

      sportClubPlayers:{},
      selectedClubPlayer:{},
      selectedClubPlayerId:null,

      headerInfoAuth:this.headerInfo,

    }
  },

  methods:{

    getPlayerProfile(playerId){
      this.selectedClubPlayerId=playerId;

      console.log("RUNNING INFORMATION : FetchData is running for selected Player...");

      var url=`http://localhost:8080/players/`+playerId;

      this.$http.get(url,
      {
        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }
      }).then(function (resp) {
        this.selectedClubPlayer=resp.data;
      });

    },

    getCountries(){

      console.log("RUNNING INFORMATION : GetCountries is running for All Country...");

      var url = 'http://localhost:8080/countries';

      this.$http.get(url,
      {
        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }
      }

      ).then(function (resp) {
        //console.log(resp);
        if (resp.status == 200) {
            console.log("INFO : Accepted All Country and Added Countries...");

            this.countries = resp.data;
            cosole.log("*****************")
            console.log(JSON.stringify(this.countries))
        }
      });
    },

    getLeagues(countryId){

      console.log("RUNNING INFORMATION : GetLeagues is running for Selected Country...");

      var url = 'http://localhost:8080/leagues/country/'+countryId;
      this.$http.get(url, {

        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }

      }).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All Leagues for Selected Country...");

          this.leagues = resp.data;

        }
      });
    },

    getSportClubs(leagueId){

      console.log("RUNNING INFORMATION : GetSportClubs is running for Selected League...");

      var url = 'http://localhost:8080/sportclubs/league/'+leagueId;
      this.$http.get(url, {

        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }

      }).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All SportClub and Added SportClubs for Selected Leagues...");

          this.sportClubs = resp.data;

        }
      });
    },

    getSportClubPlayers(clubId){

      console.log("RUNNING INFORMATION : GetSportClubs is running for Selected League...");

      var url = 'http://localhost:8080/players/sportclub/'+clubId;
      this.$http.get(url, {

        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }

      }).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All Player and Added Players for Selected SportClub...");

          this.sportClubPlayers = resp.data;


        }
      });
    },


  },

  created(){

    this.getCountries();
    //this.getLeagues();
    //this.getSportClubs();
  },

}
</script>
