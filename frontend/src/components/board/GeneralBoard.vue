<template lang="">
    <div>
        <li v-for="(item, idx) in state.items" :key="idx">{{ item.st_TEL }}</li>
    </div>
</template>
<script setup>
import axios from "axios";
import { reactive } from "vue";

const state = reactive({
    items:[]
})

axios.get("/api/list").then(({data})=>{
    state.items = data;
});
</script>
<style lang="">
      
</style>

