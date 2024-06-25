<template lang="">
    <table class="table table-striped mb-0 text-white"> 
        <thead>
             <tr>
                <th>제목</th>
                <th>작성자</th>
                <th>카테고리</th>
             </tr>
         </thead>
         <tbody>
    <tr v-for="(item, idx) in state.items" :key="idx">
        <td>{{ item.brdTl }}</router-link></td>
        <td>{{ item.brdCntnt }}</td>
        <td>{{ item.brdHits}}</td>
      </tr>
    </tbody>
</table>
</template>
<script setup>
import axios from "axios";
import { reactive } from "vue";

    const state = reactive({
        items:[]
    })

    axios.get("/board/list").then((response)=>{
        state.items = response.data;
    }).catch(error => {
        console.error(error);
      
    });

</script>
<style lang="">
    
</style>
