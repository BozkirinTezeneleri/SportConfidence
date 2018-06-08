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
                <!--NAME-->
                <div v-if="session.role==='ADMIN'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="name" v-model.trim="editPlayerInfo.name" placeholder="Name" required>
                </div>
                <div v-if="session.role==='MANAGER' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-user fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="name" v-model.trim="editPlayerInfo.name" placeholder="Name" required readonly>
                </div>
                <!--NAME-->
                <!--SURNAME-->
                <div v-if="session.role==='ADMIN'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-envelope-o fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="surname" v-model.trim="editPlayerInfo.surname" placeholder="Surname" required>
                </div>
                <div v-if="session.role==='MANAGER' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-envelope-o fa-fw"></i>
                    </span>
                  <input class="form-control" type="text" id="surname" v-model.trim="editPlayerInfo.surname" placeholder="Surname" required readonly>
                </div>
                <!--SURNAME-->
                <!--BIRTHDATE-->
                <div v-if="session.role==='ADMIN'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> BirthDate
                    </span>
                  <input class="form-control" type="date" id="birthDate" v-model="editPlayerInfo.birthDate">

                </div>
                <div v-if="session.role==='MANAGER' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> BirthDate
                    </span>
                  <input class="form-control" type="date" id="birthDate" v-model="editPlayerInfo.birthDate" readonly>

                </div>
                <!--BIRTHDATE-->
                <!--WEIGHT-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Weight (kg.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="40" max="120" id="weight" v-model="editPlayerInfo.weight" placeholder="73.0" style="width:75%;">
                  <input class="form-control" type="text" id="weight" v-model.trim="editPlayerInfo.weight" placeholder="73.0" style="width:25%;">
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Weight (kg.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="40" max="120" id="weight" v-model="editPlayerInfo.weight" placeholder="73.0" style="width:75%;" readonly>
                  <input class="form-control" type="text" id="weight" v-model.trim="editPlayerInfo.weight" placeholder="73.0" style="width:25%;" readonly>
                </div>
                <!--WEIGHT-->
                <!--HEIGHT-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Height (cm.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="100" max="210" id="height" v-model="editPlayerInfo.height" placeholder="180.0" style="width:75%;">
                  <input class="form-control" type="text" id="height" v-model.trim="editPlayerInfo.height" placeholder="180.0" style="width:25%;">
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Height (cm.)
                    </span>
                  <input class="form-control" type="range" step="0.1" min="100" max="210" id="height" v-model="editPlayerInfo.height" placeholder="180.0" style="width:75%;" readonly>
                  <input class="form-control" type="text" id="height" v-model.trim="editPlayerInfo.height" placeholder="180.0" style="width:25%;" readonly>
                </div>
                <!--HEIGHT-->
                <!--CITIZENSHIP-->
                <div v-if="session.role==='ADMIN'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Citizenship
                    </span>
                  <select class="form-control" id="country" v-model="editPlayerInfo.country.countryId">

                    <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

                  </select>
                </div>
                <div v-if="session.role==='MANAGER' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Citizenship
                    </span>
                    <input class="form-control" type="text" id="country" v-model.trim="editPlayerInfo.country.countryName" placeholder="country" required readonly>

                </div>
                <!--CITIZENSHIP-->
                <!--POSITION-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
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
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Position
                    </span>
                    <input class="form-control" type="text" id="position" v-model.trim="editPlayerInfo.position" placeholder="position" required readonly>
                </div>
                <!--POSITION-->
                <!--DISABILITY STATE-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i>Disability State
                    </span>
                  <select class="form-control" id="disabilityState" v-model="editPlayerInfo.disabilityState" required>
                    <option>true</option>
                    <option>false</option>
                  </select>
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i>Disability State
                    </span>
                    <input class="form-control" type="text" id="disabilityState" v-model.trim="editPlayerInfo.disabilityState" placeholder="disabilityState" required readonly>
                </div>
                <!--DISABILITY STATE-->
                <!--DISABILITY INFORMATION-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-comment-o fa-fw"></i>
                    </span>
                  <textarea class="form-control" id="disabilityInformation" rows="6" type= "text"  v-model="editPlayerInfo.disabilityInformation" placeholder="Enter Disability Information" required></textarea>
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-comment-o fa-fw"></i>
                    </span>
                  <textarea class="form-control" id="disabilityInformation" rows="6" type= "text"  v-model="editPlayerInfo.disabilityInformation" placeholder="Enter Disability Information" required readonly></textarea>
                </div>
                <!--DISABILITY INFORMATION-->
                <!--TESTIMONIAL-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Testimonial ($)
                    </span>
                  <input class="form-control" id="testimonial" type="text" v-model.trim="editPlayerInfo.testimonial" placeholder="150.0 $" required>
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Testimonial ($)
                    </span>
                  <input class="form-control" id="testimonial" type="text" v-model.trim="editPlayerInfo.testimonial" placeholder="150.0 $" required readonly>
                </div>
                <!--TESTIMONIAL-->
                <hr>
                <h2 v-if="session.role==='ADMIN' || session.role==='DOCTOR'">TEAM INFORMATION</h2>
                <!--COUNTRY-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Country
                    </span>
                  <select class="form-control" id="country" v-model="selectedCountryId" v-on:change="getLeagues(selectedCountryId)" required>

                    <option v-for="country in countries" :value="country.countryId"> {{country.countryName}} </option>

                  </select>
                </div>
                <!--COUNTRY-->
                <!--LEAGUE-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> League
                    </span>
                  <select class="form-control" id="league" v-model="selectedLeagueId" v-on:change="getSportClubs(selectedLeagueId)" required>

                    <option v-for="league in leagues" :value="league.leagueId"> {{league.leagueName}} </option>

                  </select>
                </div>
                <!--LEAGUE-->
                <!--SPORT CLUB-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Sport Club
                    </span>
                  <select class="form-control" id="sportClub" v-model="selectedSportClubId" required>

                    <option v-for="sportclub in sportclubs" :value="sportclub.sportClubId"> {{sportclub.name}} </option>

                  </select>
                </div>
                <!--SPORT CLUB-->
                <!--CONTRACT TIME START-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time Start
                    </span>
                  <input class="form-control" type="date" id="contractTimeStart" v-model="editPlayerInfo.contractTimeStart" required>
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time Start
                    </span>
                  <input class="form-control" type="date" id="contractTimeStart" v-model="editPlayerInfo.contractTimeStart" required readonly>
                </div>
                <!--CONTRACT TIME START-->
                <!--CONTRACT TIME END-->
                <div v-if="session.role==='ADMIN' || session.role==='DOCTOR'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time End
                    </span>
                  <input class="form-control" type="date" id="contractTimeEnd" v-model="editPlayerInfo.contractTimeEnd" required>
                </div>
                <div v-if="session.role==='MANAGER'" class="input-group margin-bottom-sm">
                    <span class="input-group-addon">
                      <i class="fa fa-tags fa-fw"></i> Contract Time End
                    </span>
                  <input class="form-control" type="date" id="contractTimeEnd" v-model="editPlayerInfo.contractTimeEnd" required>
                </div>
                <!--CONTRACT TIME END-->
                <hr>

                <button v-if="session.role!='MANAGER'" class="btn btn-primary send" type="submit">UPDATE INFORMATIONS</button>
                <button class="btn btn-danger send" style="margin-left:5px;" @click="cancelEdit()">CANCEL</button>
              </div>

            </form>

          </div>
        </div>


      </div>

    </div>	<!-- team-members -->
    <br>
    <div v-if="editInfo && session.role!='MANAGER'" class="alert alert-info animated zoomInDown">
        <strong>Succesful Update!</strong> {{editInfo}}
    </div>

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
  name: 'EditPlayer',

  props:{

    editPlayerInfo: { type: Object, required:true },
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
      selectedSportClubId:null,

      headerInfoAuth:this.headerInfo,

      blockInfo:null,
    }
  },

  created(){

    this.getCountries();
    //this.getLeagues();
    //this.getSportClubs();
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
      contract.setPlayer(this.editPlayer.name,this.editPlayer.surname,this.editPlayer.weight)
      this.storeData2()
      this.storeData3()
    },
    storeData2(){
      contract.setPlayer1(this.editPlayer.height,this.editPlayer.disabilityState,this.editPlayer.disabilityInformation)
    },
    storeData3(){
      contract.setPlayer2(this.editPlayer.sportClub.sportClubId,this.editPlayer.contractTimeStart,this.editPlayer.contractTimeEnd)
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


    cancelEdit(){

        this.$emit('cancelEdit', null)
    },

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
       this.$http.put(url, this.editData,{

         headers:{

           'Content-Type': 'application/json',
           'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
         }
       }).then(function(resp) {

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
             setTimeout(()=>{
               this.editInfo=null
             },3000)

         }
       },function(error){
          console.error(error);
       })
         .catch((err)=>console.error(err))
      //////////// END-VueResource-PUT ////////////////////

      /////BLOCKCHAIN setData
       this.storeData()
       this.getData()
       this.getBalance()
       this.blockInfo=true
      //--////////////-----------------------------------
    },

    getCountries(){

      console.log("RUNNING INFORMATION : GetUser is running for All Users...");

      var url = 'http://localhost:8080/countries';
      this.$http.get(url,{

        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }

      }).then(function (resp) {
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
      this.$http.get(url,{

        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }

      }).then(function (resp) {
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
      this.$http.get(url, {

        headers:{

          'Content-Type': 'application/json',
          'Authorization': 'Basic '+btoa(this.headerInfoAuth.username+ ':'+ this.headerInfoAuth.password)
        }

      }).then(function (resp) {
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

}
</script>
