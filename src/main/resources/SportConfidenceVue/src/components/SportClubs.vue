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
          <select class="form-control" id="country" v-model="selectedCountryId" :onchange="getLeagues(selectedCountryId)">

            <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

          </select>
        </div>
        <div v-if="selectedCountryId" class="input-group margin-bottom-sm">
            <span class="input-group-addon">
              <i class="fa fa-tags fa-fw"></i> League
            </span>
          <select class="form-control" id="league" v-model="selectedLeagueId" :onchange="getSportClubs(selectedLeagueId)">

            <option v-for="league in leagues" :value="league.leagueId"> {{league.leagueName}} </option>

          </select>
        </div>
        <div v-if="selectedLeagueId" class="input-group margin-bottom-sm">
            <span class="input-group-addon">
              <i class="fa fa-tags fa-fw"></i> Sport Club
            </span>
          <select class="form-control" id="sportClub" v-model="selectedClubId" :onchange="getSportClubPlayers(selectedClubId)">

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

                                              <img class="img-circle img-responsive center-block" style="height:50px;" src="src/assets/img/Syed-Rezwanul-Haque.jpg">

                                          </div>
                                        </td>

                                        <td><router-link href="#playerProfile" :to="profileLink(sportClubPlayer.playerId)"> {{sportClubPlayer.name}} {{sportClubPlayer.surname}} </router-link></td>
                                        <td>{{sportClubPlayer.country.countryName}}</td>
                                        <td>{{sportClubPlayer.position}}</td>
                                        <td>{{sportClubPlayer.height}}</td>
                                        <td>{{sportClubPlayer.weight}}</td>
                                        <td>{{sportClubPlayer.disabilityState}}</td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

    <hr>
  </div>	<!-- container -->

</template>

<script>
export default {

  name: 'SportClubs',

  data(){
    return{
      countries:{},
      selectedCountryId:null,

      leagues:{},
      selectedLeagueId:null,

      sportClubs:{},
      selectedClubId:null,

      sportClubPlayers:{},
      selectedClubPlayerId:null,

    }
  },

  methods:{

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

          this.sportClubs = resp.data;

        }
      });
    },

    getSportClubPlayers(clubId){

      console.log("RUNNING INFORMATION : GetSportClubs is running for Selected League...");

      var url = 'http://localhost:8080/players/sportclub/'+clubId;
      this.$http.get(url).then(function (resp) {
        //console.log(resp.status);
        if (resp.status == 200) {
          console.log("INFO : Accepted All User and Added SportClubs for Selected Leagues...");

          this.sportClubPlayers = resp.data;


        }
      });
    },

    profileLink(playerId) {

      return `/players/`+playerId;
    },

  },

  created(){

    this.getCountries();
    //this.getLeagues();
    //this.getSportClubs();
  },


}
</script>
