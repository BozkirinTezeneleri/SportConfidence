import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter);
import VueResource from 'vue-resource'
Vue.use(VueResource);

//main-component
import App from './App.vue'
//About us
import AboutUs from './components/AboutUs.vue'
Vue.component('about-us', AboutUs)
//PlayerProfile
import PlayerProfile from './components/PlayerProfile.vue'
Vue.component('player-profile', PlayerProfile)
//PlayerAdd
import PlayerAdd from './components/PlayerAdd.vue'
Vue.component('player-add', PlayerAdd)
//UserList
import UserList from './components/UserList.vue'
Vue.component('user-list', UserList)
//UserAdd
import UserAdd from './components/UserAdd.vue'
Vue.component('user-add', UserAdd)
//UserProfile
import UserProfile from './components/UserProfile.vue'
Vue.component('user-profile', UserProfile)
//EditPlayer
import EditPlayer from './components/EditPlayer.vue'
Vue.component('edit-player', EditPlayer)
//EditUser
import EditUser from './components/EditUser.vue'
Vue.component('edit-user', EditUser)
//SportClubs
import SportClubs from './components/SportClubs.vue'
Vue.component('sport-clubs', SportClubs)
//Contact us
import ContactUs from './components/ContactUs.vue'
Vue.component('contact-us', ContactUs)


const router =new VueRouter({

  routes:[
    //{ path: '/about_us', component : AboutUs, name : 'aboutUs'},
    //{ path: '/players', component : PlayerList, name : 'playerList'},
    //{ path :'/sportClubs/:sportClubId/players/:playerId', component : PlayerProfile, name : 'playerProfile'},
    //{ path: '/add_player', component : PlayerAdd, name : 'playerAdd'},
    //{ path: '/users', component : UserList, name : 'userList'},
    //{ path: '/add_user', component : UserAdd, name : 'userAdd'},
    //{ path :'/users/:userId', component : UserProfile, name : 'userProfile'},
    //{ path: '/players/edit/:playerId', component : EditPlayer, name : 'editPlayer'},
    //{ path: '/users/edit/:userId', component : EditUser, name : 'editUser'},
    //{ path: '/sport_clubs', component : SportClubs, name : 'sportClubs'},
    //{ path: '/contact_us', component : ContactUs, name : 'contactUs'},

  ],
  mode :'history'
})

new Vue({
  el: '#app',
  render: h => h(App),
  router
})
