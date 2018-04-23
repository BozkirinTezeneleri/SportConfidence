<template>
  <div id="app">

    <router-link to="/users">--USER LIST --</router-link>
    <router-link to="/user_add"> ++ ADD NEW USER ++</router-link>
    <router-link to="/players">--PLAYER LIST --</router-link>
    <router-link to="/player_add"> ++ ADD NEW PLAYER ++</router-link>

    <router-view></router-view>


  </div>
</template>

<script>
export default {
  name: 'app',

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;

  color: #2c3e50;
  margin-top: 10px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {

  margin: 0 10px;
}

a {
  color: #42b983;
}

button {
  margin-top:10px;
  height:35px;
  background-color:#42b983;
  color:white;
  border-radius:20px;
}
</style>
