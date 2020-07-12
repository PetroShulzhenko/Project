<template>
  <div id="app">
    
    <Nav></Nav>
    <router-view/>
    
  </div>
</template>

<script>
import Nav from './components/Nav-Footer.vue'

export default {
  name:'app',
  components:{
    Nav

  },
  data () {
    return {
      
    }
  }
}
</script>

<style>
#app {
  font-family: 'IBM Plex Sans', sans-serif;
   box-sizing: border-box;
   margin: 0;
}
.buttonTest{
  background-image: url('./images/School_Diary-512.png') ;
  background-repeat: no-repeat;
  background-size: cover;
  width: 60px;
  height: 60px;
}
</style>
