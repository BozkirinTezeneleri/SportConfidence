<template>

  <div class="container">
    <div class="row text-center" id="heading">
      <div class="col-md-6 col-md-offset-3 wow animated zoomInDown" id="heading-text">
          <h3>Player</h3>
              <p>Selected Player Information</p>
              <hr class="full">
              <br/>
        </div>
    </div>	<!-- row -->
    <div class="row main_content">
        <div class="row" id="heading">

          <!--PROFILE-->

          <div class="col-md-4 col-sm-5 text-center">
            <div class="row wow animated zoomIn" data-wow-delay="0.1s">
              <div class="col-md-8 col-md-offset-2">
                <img class="img-circle img-responsive center-block" src="src/assets/img/player.png" alt="Syed Rezwanul Haque Rubel">
              </div>
            </div>
            <h4 class="wow animated fadeInUp" data-wow-delay= "0.2s" style="color: rgb(32, 178, 170);">

                {{selectedPlayer.playerId}} - {{selectedPlayer.name}} {{selectedPlayer.surname}}

            </h4>
            <p class= "member-title wow animated fadeIn" data-wow-delay= "0.3s">{{selectedPlayer.sportClub.name}}</p>


            <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
                <strong>User Deleted!</strong> {{deleteInfo}}
            </div>

          </div>

          <!--PROFILE-->

          <!--PROFILE INFORMATION-->
          <div class="col-md-8 col-sm-5" style="margin-top:25px;">
            <div class="col-md-5 col-sm-5">
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Position : </b>{{selectedPlayer.position}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Citizenship : </b>{{selectedPlayer.country.countryName}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Birth Date : </b>{{selectedPlayer.birthDate}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Height : </b>{{selectedPlayer.height}} cm.</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Weight : </b>{{selectedPlayer.weight}} kg.</p>

                <div v-if="deleteInfo" class="alert alert-warning wow animated zoomInDown">
                    <strong>User Deleted!</strong> {{deleteInfo}}
                </div>

            </div>

            <div class="col-md-5 col-sm-5">
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Contract Start : </b>{{selectedPlayer.contractTimeStart}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Contract Finish : </b>{{selectedPlayer.contractTimeEnd}}</p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Testimonial: $ {{selectedPlayer.testimonial}} </b></p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Disability State : {{selectedPlayer.disabilityState}} </b></p>
                <p class= "team-member-description wow animated fadeIn" data-wow-delay= "0.4s" style="text-align:left;"><b>Disability Information : </b>{{selectedPlayer.disabilityInformation}}</p>
            </div>

          </div>
          <div v-if="session.role==='ADMIN'" class="col-md-8 col-sm-5">
            <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
              <div class= "team-member-contact">
                  <button class="btn btn-info" @click="editPlayerProfile(selectedPlayer.playerId)">EDIT INFORMATION</button>
                  <button class="btn btn-grey" @click="getPlayerHealthInfo(selectedPlayer.playerId)">SHOW ALL HEALTH INFORMATION</button>
                  <button class="btn btn-danger" @click="closeProfile()">CLOSE</button>
              </div>
            </div>
          </div>

          <div v-if="session.role==='DOCTOR'" class="col-md-8 col-sm-5">
            <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
              <div class= "team-member-contact">
                  <button class="btn btn-info" @click="editPlayerProfile(selectedPlayer.playerId)">EDIT INFORMATION</button>
                  <button class="btn btn-danger" @click="closeProfile()">CLOSE</button>
              </div>
            </div>
          </div>

          <div v-if="session.role==='MANAGER'" class="col-md-8 col-sm-5">
            <div class= "row text-center wow animated fadeInDown" data-wow-delay= "0.5s">
              <div class= "team-member-contact">
                  <button class="btn btn-info" @click="getPlayerHealthInfo(selectedPlayer.playerId)">SHOW ALL HEALTH INFORMATION</button>
                  <button class="btn btn-danger" @click="closeProfile()">CLOSE</button>
              </div>
            </div>
          </div>

          <!--PROFILE INFORMATION-->

        </div>
    </div>	<!-- row main_content -->

    <!-- Edit Players -->
	  <section v-if="session.role==='ADMIN' || session.role==='DOCTOR'" id="player_list">

        <edit-player v-if="editPlayerId" @cancelEdit="closeEdit" :editPlayerInfo=editPlayer :headerInfo=headerInfo :session=session></edit-player>

	  </section><!-- edit-players -->

    <hr>

    <section v-if="healthInfo" id="player_healthInfo">

        <center><h5><b><p>{{selectedPlayer.playerId}}-{{selectedPlayer.name}}-{{selectedPlayer.surname}}</p></b></h5></center>
        <center><b>Total Block Number for Used System </b> <p>{{showBlockNumber}}</p></center>
        <center><b>MetaMask Account Information </b> <p>{{showAccount}}</p></center>
        <center><b>BLOCK DATA</b> <p>{{confirmPlayer}}</p></center>
        <center><button class="btn btn-danger" @click="closeHealthInfo()">CLOSE</button></center>

	  </section><!-- players -->

  </div>	<!-- container -->


</template>

<script>
////////
import web3 from 'web3'

let provider = new Web3(new Web3.providers.HttpProvider('http://localhost:8545'));
provider.eth.defaultAccount = provider.eth.accounts[0];
let MyContract = provider.eth.contract([
	{
		"constant": true,
		"inputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"name": "Players",
		"outputs": [
			{
				"name": "id",
				"type": "uint256"
			},
			{
				"name": "healthState",
				"type": "bool"
			},
			{
				"name": "healthInformation",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_healthState",
				"type": "bool"
			},
			{
				"name": "_healthInformation",
				"type": "string"
			}
		],
		"name": "dedicatePlayer",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerDedicated",
		"outputs": [
			{
				"name": "",
				"type": "uint256[]"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getNumberOfPlayer",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	}
]);
let contract = MyContract.at('0xde5adcada4f4a5979b1b7269b52b575566abcfc0');
let balance = provider.eth.getBalance(provider.eth.defaultAccount);

//////////////

export default {
  name: 'PlayerProfile',

  props:{

    selectedPlayer: { type: Object, required:true },
    headerInfo:null,
    session:null

  },

  data(){
    return{
      ////////////0xf997a045fd4b526e1fe8ade56aa4ade1068aa8ac
      msg: ' ',
      word: '',
      confirmPlayer: '',

      balance: null,
      blockMsg: ' ',
      gasPrice: null,
      /////////////
      editPlayer:{},
      editPlayerId:null,
      headerInfoAuth:this.headerInfo,

      healthInfo:null
    }
  },
  methods:{

    closeEdit(value){
        this.editPlayerId=value
    },

    closeHealthInfo(){

      this.healthInfo=null
    },

    closeProfile(){
        this.$emit('closeView',null)
    },
    //BLOCKCHAIN method
    getPlayerHealthInfo(playerId){

      this.healthInfo=true

      this.confirmPlayer=(contract.Players(playerId))

    },
    //////////////////////
    editPlayerProfile(PlayerId){
      this.editPlayerId=PlayerId;

      console.log("RUNNING INFORMATION : FetchData is running for selected Player...");

      var url=`http://localhost:8080/players/`+PlayerId;

      this.$http.get(url,
      {
        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }
      }

      ).then(function (resp) {
        this.editPlayer=resp.data;


      });

    },

   },

   ////////////////////
   computed:{
       showAccount: function() {
         return this.msg + provider.eth.defaultAccount
       },
       showBlockNumber: function () {
         return this.blockMsg + provider.eth.blockNumber
       }
     },
   ////////////////

}
</script>
