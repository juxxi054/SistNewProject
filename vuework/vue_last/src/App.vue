<template>
<FirstAppPage></FirstAppPage>
<secondAppPage/>
<ThirdAppPage/>
<FourAppPage/>
<FifthAppPage/>

 
</template>

<script>

import FirstAppPage from './components/FirstApp.vue'
import secondAppPage from './components/FirstApp.vue'
import ThirdAppPage from './components/FirstApp.vue'
import FourAppPage from './components/FirstApp.vue'
import FifthAppPage from './components/FirstApp.vue'

export default {
  name: 'App',
  components: {
    FirstAppPage,
    secondAppPage,
    ThirdAppPage,
    FourAppPage,
    FifthAppPage

   
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
