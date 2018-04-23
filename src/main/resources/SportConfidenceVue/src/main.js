import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter);
import VueResource from 'vue-resource'
Vue.use(VueResource);

import App from './App.vue'
import PlayerList from './components/PlayerList.vue'
import PlayerProfile from './components/PlayerProfile.vue'
import PlayerAdd from './components/PlayerAdd.vue'
import UserList from './components/UserList.vue'
import UserAdd from './components/UserAdd.vue'
import UserProfile from './components/UserProfile.vue'
import EditPlayer from './components/EditPlayer.vue'
import EditUser from './components/EditUser.vue'

const router =new VueRouter({

  routes:[
    { path: '/players', component : PlayerList, name : 'playerList'},
    { path :'/players/:playerId', component : PlayerProfile, name : 'playerProfile'},
    { path: '/player_add', component : PlayerAdd, name : 'playerAdd'},
    { path: '/users', component : UserList, name : 'userList'},
    { path: '/user_add', component : UserAdd, name : 'userAdd'},
    { path :'/users/:userId', component : UserProfile, name : 'userProfile'},
    { path: '/players/edit/:playerId', component : EditPlayer, name : 'editPlayer'},
    { path: '/users/edit/:userId', component : EditUser, name : 'editUser'},

  ],
  mode :'history'
})

new Vue({
  el: '#app',
  render: h => h(App),
  router
})
