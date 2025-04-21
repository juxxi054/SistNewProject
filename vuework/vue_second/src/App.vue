<template>
  <div>
    <img alt="Vue logo" src="./assets/logo.png">
    
    <div class="menu">
      <a v-for="(menu, i) in menus" :key="i">{{ menu }}</a>
    </div>
    
    <div v-for="(product, key) in products" :key="key">
      <img :src="product.imgSrc">
      <h4>{{ product.name }}</h4>
      <h4>{{ product.company }}</h4>
      <button @click="addLike(key)">좋아요</button>
      <span>좋아요 수: {{ product.likes }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      menus: ['Home', 'Shop', 'Board', 'About'],
      products: [
        { name: '김태희', company: '하이브', likes: 0, imgSrc: require('./assets/1.jpg') },
        { name: '유아인', company: 'JYP', likes: 0, imgSrc: require('./assets/2.jpg') },
        { name: '수지', company: '하이브', likes: 0, imgSrc: require('./assets/3.jpg') },
        { name: '강동원', company: 'SM', likes: 0, imgSrc: require('./assets/7.jpg') }
      ]
    }
  },
  methods: {
    addLike(index) {
      this.products[index].likes++;
    }
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

.menu {
  background-color: blue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;
}
</style>