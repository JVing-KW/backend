<template>
   <section class="page-header page-header-modern bg-color-grey page-header-md">
      <div class="container">
         <div class="row">
            <div class="col-md-12 align-self-center p-static order-2 text-center">
               <h1 class="text-dark font-weight-bold text-8">일반게시판</h1>
               <span class="sub-title text-dark">자유로운 글 작성!</span>
            </div>
            <div class="col-md-12 align-self-center order-1">
               <ul class="breadcrumb d-block text-center">
                  <li><a href="/">Home</a></li>
                  <li class="active">일반게시판</li>
               </ul>
            </div>
         </div>
      </div>
   </section>

   <section id="examples" class="section section-default">
       <section class="card card-admin">
         <div class="container py-4">
            <router-link to="/board/insert">등록</router-link>
            <div class="row justify-content-center">
          <BoardList />
          </div>
          </div>
       </section>
   </section>
   
   </template>
   
   <script setup>
   import BoardList from '../../components/board/BoardList.vue';
   </script>
   
   <style scoped>
   
   </style>