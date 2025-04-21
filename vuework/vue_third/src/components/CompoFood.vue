<template>
    <div class="container">
        <div v-for="(food,idx) in foods" :key="'food'+idx" class="photo">
           <img :src="food.imgsrc">
           <i class="bi bi-heart-fill"></i>
            <h5>{{food.foodname }}</h5>
            <p>{{ food.foodprice }}</p>
            <i class="bi bi-heart-fill" style="color: red;"
            @click="onLikeChu(idx)"></i>
            &nbsp; <span>{{ food.chu }}</span>
            


        </div>

    </div>
</template>

 

<script>

import { reactive } from "vue";

export default {
    setup () {
        
        const foods = reactive([
        
         {foodname:'에그샌드위치',foodprice:'20000원',
          imgsrc:require('@/assets/음식이미지/1.jpg'),chu:0
         },
         {foodname:'망고빙수',foodprice:'25000원',
         imgsrc:require('@/assets/음식이미지/11.jpg'),chu:0},
         {foodname:'꼬치구이',foodprice:'19000원',
         imgsrc:require('@/assets/음식이미지/2.jpg'),chu:0},
         {foodname:'그라탕',foodprice:'35000원',
         imgsrc:require('@/assets/음식이미지/3.jpg'),chu:0}
         


        ]);
        

        //추천증가
        const onLikeChu=(index)=>{
          foods[index].chu++;
        }

        return {foods,onLikeChu}
    }
}
</script>

<style>
.photo img{
    width: 80px;
    height: 80px;
    border-radius: 10px;
    margin: 10px;
}

</style>