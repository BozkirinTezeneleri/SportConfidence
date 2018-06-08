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
        <div v-if="blockInfo" class= "row text-center main_content animated zoomInDown">
          <h2>BLOCK STRUCTURE</h2>
          <hr>

          <p><b>MetaMask Account Information :</b> {{ showAccount }} </p>


          <p><b>Name/Surname :</b> {{ confirmName }} {{ confirmSurname }}</p>
          <p><b>Weight :</b>  {{ confirmWeight }}</p>
          <p><b>Height :</b>  {{ confirmHeight }}</p>
          <p><b>Disability :</b>  {{ confirmDisabilityState }}</p>
          <p><b>Description :</b> {{ confirmDisabilityInformation }} </p>
          <p><b>SportClub ID :</b>  {{ confirmSportClub }}</p>
          <p><b>Contract Time Start :</b>  {{ confirmContractTimeStart }}</p>
          <p><b>Contract Time End :</b>  {{ confirmContractTimeEnd }}</p>
          <hr>
          <p><b>Balance :</b> {{ balance }}</p>
          <hr>
          <p><b>Total Block Number for Used System :</b> {{ showBlockNumber }}</p>
          <hr>
          <center>
              <button class="btn btn-danger" type="button" @click="closeBlock()">CLOSE </button>
          </center>

        </div>
        <!---->

      </div>

    </div>	<!-- team-members -->

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
		"inputs": [],
		"name": "getPlayerWeight",
		"outputs": [
			{
				"name": "",
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
				"name": "_name",
				"type": "string"
			},
			{
				"name": "_surname",
				"type": "string"
			},
			{
				"name": "_weight",
				"type": "string"
			}
		],
		"name": "setPlayer",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerDisabilityState",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerHeight",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerContractTimeStart",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerSportClubId",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerName",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerSurname",
		"outputs": [
			{
				"name": "",
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
				"name": "_sportClubId",
				"type": "uint256"
			},
			{
				"name": "_contractTimeStart",
				"type": "string"
			},
			{
				"name": "_contractTimeEnd",
				"type": "string"
			}
		],
		"name": "setPlayer2",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerDisabilityInformation",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "getPlayerContractTimeEnd",
		"outputs": [
			{
				"name": "",
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
				"name": "_height",
				"type": "string"
			},
			{
				"name": "_disabilityState",
				"type": "bool"
			},
			{
				"name": "_disabilityInformation",
				"type": "string"
			}
		],
		"name": "setPlayer1",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	}
]);
let contract = MyContract.at('0x75bc47282c37510065a9d615911d59c5545a9103');
let balance = provider.eth.getBalance(provider.eth.defaultAccount);

//////////////

export default {
  name: 'PlayerAdd',

  props:{

    headerInfo:null,
    session:null

  },

  data(){
    return{
      ////////////0xf997a045fd4b526e1fe8ade56aa4ade1068aa8ac
      msg: ' ',
      word: '',
      confirmName: '',
      confirmSurname:'',
      confirmBirthdate:'',
      confirmHeight:'',
      confirmWeight:'',
      confirmSportClub:'',
      confirmContractTimeStart:'',
      confirmContractTimeEnd:'',
      confirmDisabilityState:'',
      confirmDisabilityInformation:'',
      confirmTestimonial:'',
      balance: null,
      blockMsg: ' ',

      /////////////
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
          countryId:0,
          //id:90,
          //countryName:'turkey'
        },
        sportClub:{
          sportClubId:0,
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

      headerInfoAuth:this.headerInfo,

      blockInfo:null,

    }
  },

  methods:{

    closeBlock(){
      this.blockInfo=null
    },

    ////////////////
    getBalance() {
    this.balance = Number(balance)
    },

    storeData() {
      contract.setPlayer(this.newPlayer.name,this.newPlayer.surname,this.newPlayer.weight)
      this.storeData2()
      this.storeData3()
    },
    storeData2(){
      contract.setPlayer1(this.newPlayer.height,this.newPlayer.disabilityState,this.newPlayer.disabilityInformation)
    },
    storeData3(){
      contract.setPlayer2(this.newPlayer.sportClub.sportClubId,this.newPlayer.contractTimeStart,this.newPlayer.contractTimeEnd)
    },
    getData() {
      this.confirmName = (contract.getPlayerName())
      this.getDataSurname()
    //  this.getDataBirthdate()
      this.getDataHeight()
      this.getDataWeight()
      this.getDataSportClub()
      this.getDataContractTimeStart()
      this.getDataContractTimeEnd()
      this.getDataDisabilityState()   // hatalı
      this.getDataDisabilityInformation()
  //    this.getDataTestimonial()
    },
    getDataSurname(){
      this.confirmSurname=(contract.getPlayerSurname())
    }, /*
    getDataBirthdate(){
      this.confirmBirthdate=(contract.getPlayerBirthdate())
    },*/
    getDataHeight(){
      this.confirmHeight=(contract.getPlayerHeight())
    },
    getDataWeight(){
      this.confirmWeight=(contract.getPlayerWeight())
    },
    getDataSportClub(){
      this.confirmSportClub=(contract.getPlayerSportClubId())
    },
    getDataContractTimeStart(){
      this.confirmContractTimeStart=(contract.getPlayerContractTimeStart())
    },
    getDataContractTimeEnd(){
      this.confirmContractTimeEnd=(contract.getPlayerContractTimeEnd())
    },
    getDataDisabilityState(){
      this.confirmDisabilityState=(contract.getPlayerDisabilityState())
    },
    getDataDisabilityInformation(){
      this.confirmDisabilityInformation=(contract.getPlayerDisabilityInformation())
    }, /*
    getDataTestimonial(){
      this.confirmTestimonial=(contract.getPlayerTestimonial())
    },
*/

    //////////////

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
            setTimeout(() => {
                this.submitInfo=null

            },3000);
          }
      })
        .catch((err)=>console.error(err))
      //////// END-FETCH-POST/////////////////////

      ///// setData
       this.storeData()
       this.getData()
       this.getBalance()
       this.blockInfo=true
      //--////////////-----------------------------------
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

  created(){

    this.getCountries();
    //this.getLeagues();
    //this.getSportClubs();
  }



}
</script>
