<template>
    <div style="margin-left: 100px;">
        <h2 class="alert alert-info">FourApp 입니다</h2>
        <table class="table table-borderd" style="width: 800px;">
            <caption align="top"><b>배열객체 출력</b></caption>
            <thead clas="table-success">
                <tr>
                   <th width="100">번호</th>
                    <th width="150">사진</th>
                    <th width="400">제목</th>
                    <th width="150">작성자</th>
                </tr>
            <tbody>

                 

            </tbody>
            <tr v-for="(row,index) in boards" :key="'row'+index">
                <td>{{ row.no }}</td>
            </tr>
            </thead>
        </table>
    </div>
</template>

<script>
 import{reactive} from 'vue';

export default {
    setup () {
        
        const boards=reactive(


        [ {no:1,writer:'이선재',subject:'오늘 더워',photo:'1'},
        {no:2,writer:'송하연',subject:'점메추',photo:'3'},
        {no:1,writer:'김주은',subject:'시험 일정 공유',photo:'2'},
        {no:1,writer:'최성하',subject:'다시 이클립스 한대여',photo:'4'},
        {no:1,writer:'김지민',subject:'아...',photo:'5'},
        {no:1,writer:'오성희희',subject:'빨리 쉬는날',photo:'6'}



        ]
        )
    
        return { boards}
    }
}
</script>

<style lang="scss" scoped>

</style>