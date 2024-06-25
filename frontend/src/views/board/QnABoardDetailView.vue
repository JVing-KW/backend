<template>
    <section id="examples" class="section section-default">
        <div class="container">
            <section class="card card-admin">
                <header class="card-header">
                    <div class="card-actions">
                        <a href="#" class="card-action card-action-toggle" data-card-toggle=""></a>
                        <a href="#" class="card-action card-action-dismiss" data-card-dismiss=""></a>
                    </div>
                    <h2 class="card-title">상세페이지</h2>
                </header>
            </section>
    
            <div class="row">
                <div class="col-md-8">
                    <div class="mb-3">
                        <label for="brdTl" class="form-label">제목</label>
                        <input type="text" v-model="board.brdTl" class="form-control" id="brdTl" placeholder="제목" readonly>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="col d-flex justify-content-end">
                        <div class="col-5">
                            <label class="form-label">작성자: {{ board.insrtMbrSq.mbrId }} </label>
                        </div>
                        <div class="col-5">
                            <label class="form-label">등록일: {{ formatDate(board.insrtDtm) }}</label>
                        </div>
                        <div class="col-5">
                            <label class="form-label">조회수: {{ board.brdHits }}</label>
                        </div> 
                        <div class="col-5">
                            <label class="form-label">댓글수: </label>
                        </div> 
                    </div>
                </div>
            </div>
    
            <div class="mb-3">
                <label for="brdCntnt" class="form-label">내용</label>
                <textarea class="form-control" v-model="board.brdCntnt" id="brdCntnt" rows="3" placeholder="내용" readonly></textarea>
            </div>

            <div class="row">
                <div class="col d-flex justify-content-end">     
                    <button class="btn btn-success" @click="goUpdatePage" v-if="isAuthor(board.insrtMbrSq.mbrId)">수정</button>
                    <button class="btn btn-danger" @click="confirmDelete" v-if="isAuthor(board.insrtMbrSq.mbrId)">삭제</button>
                </div>
            </div>
        </div>

    </section>
    </template>
    
    <script setup>
    import { ref, onMounted } from 'vue';
    import axios from 'axios';
    import { useRoute, useRouter } from 'vue-router';
    
    
    const board = ref({
      brdSq: 0,
      brdTl: '',
      brdRegDt: '',
      brdHits: 0,
      brdCtgryCd: '',
      brdCntnt: '',
      insrtMbrSq: ''
    });
    
    const router = useRouter();
    
    const formatDate = (dateString) => {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1 필요
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    };


    const fetchBoardDetail = () => {
        const route = useRoute();
        const brdSq = route.params.brdSq;
    
        axios.get(`/board/detail/${brdSq}`)
        .then(response => {
            board.value = response.data;
        })
        .catch(error => {
            console.error('Error fetching board detail:', error);
        });
    };
    
    const deleteBoard = () => {
        const brdSq = board.value.brdSq;
    
        axios.delete(`/board/delete/${brdSq}`)
        .then(response => {
            console.log('게시글이 삭제 되었습니다:', response.data);
            router.push(`/board/list/${board.value.brdCtgryCd}`);
        })
        .catch(error => {
            console.error('게시글 삭제가 실패 되었습니다:', error);
        });
    };
    
    const confirmDelete = () => {
        if (window.confirm('게시글을 삭제 하시겠습니까?')) {
            deleteBoard();
            alert('게시글이 삭제되었습니다.');
        }
    };
    
    const incrementHits = () => {
        const brdSq = board.value.brdSq;

        axios.post(`/board/detail/${brdSq}/hits`)
            .then(response => {
                console.log('조회수가 증가되었습니다.');
                board.value.brdHits++;
                console.log(response.data);
            })
            .catch(error => {
                console.error('조회수 증가에 실패하였습니다:', error);
            });
        };

    const goUpdatePage = () => {
        router.push(`/board/update/${board.value.brdSq}`);
    };

    const isAuthor = (authorId) => {
        const currentUser = JSON.parse(sessionStorage.getItem('member'));
        return currentUser && currentUser.mbrId === authorId;
    };
    
    onMounted(() => {
        fetchBoardDetail();
        incrementHits();
    });
    
    </script>
    
    <style>
    
    </style>