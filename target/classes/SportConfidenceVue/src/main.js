import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter);
import VueResource from 'vue-resource'
Vue.use(VueResource);

import App from './App.vue'
import PlayerList from './components/PlayerList.vue'
Vue.component('player-list', PlayerList)
import PlayerProfile from './components/PlayerProfile.vue'
Vue.component('player-profile', PlayerProfile)
import PlayerAdd from './components/PlayerAdd.vue'
Vue.component('player-add', PlayerAdd)
import UserList from './components/UserList.vue'
Vue.component('user-list', UserList)
import UserAdd from './components/UserAdd.vue'
Vue.component('user-add', UserAdd)
import UserProfile from './components/UserProfile.vue'
Vue.component('user-profile', UserProfile)
import EditPlayer from './components/EditPlayer.vue'
Vue.component('edit-player', EditPlayer)
import EditUser from './components/EditUser.vue'
Vue.component('edit-user', EditUser)

const router =new VueRouter({

  routes:[
    { path: '/', component : App, name : 'home'},
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
