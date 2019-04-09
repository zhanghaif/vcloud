<template>
  <div id="app">
    <Header v-if="headerSign" @headerEvent="parentVal"></Header>
    <div class="container">
      <Left v-if="headerSign"></Left>
      <router-view @headerEvent="parentVal"></router-view>
    </div>
    
  </div>
</template>

<script>
import Header from '@/components/Header'
import Left from '@/components/Left'
export default {
  name: 'App',
  data () {
    return {
      headerSign: false
    }
  },
  created () {
    if (sessionStorage.getItem('headerSign') == 'true') {
      this.headerSign = true
    } else {
      this.headerSign = false
    }
  },
  components: {
    Header,
    Left
  },
  methods: {
    parentVal (data) {
      console.log(data)
      if (data == true || data == 'true') {
        this.headerSign = true
        sessionStorage.setItem('headerSign',true)
      } else {
        this.headerSign = false
        sessionStorage.setItem('headerSign',false)
      }
    }
  },
}
</script>

<style>
html,body{
  margin: 0;
  padding: 0;
}
body{
  height: 100%;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
}
.container{
  display: -webkit-flex;
  display: -moz-flex;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
</style>
