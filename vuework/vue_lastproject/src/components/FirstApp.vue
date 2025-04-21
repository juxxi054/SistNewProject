<template>
    <div>
        <h2 class="alert alert-info">FirstApp 입니다</h2>
        <h3>버튼으로 숫자 증감하기</h3>
        <h3>{{ couter }}</h3>

        <button class="btn btn-success">증가</button>
        <button class="btn btn-danger">감소</button>
    </div>
</template>

<script>

import { ref} from 'vue';

export default {
    setup () {
        

        const couter=ref(0);
        return {couter}
    }
}
</script>

<style lang="scss" scoped>

</style>