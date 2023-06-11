<template>
  <div class="card border-success mb-3" style="max-width: 20rem;margin: 30px">
    <div class="card-header">{{userBorrow.bookName}}</div>
    <div class="card-body text-success">
      <h5 class="card-title" v-if="userBorrow.statusId == 1">
        借書記錄: 已借
        <button type="button" class="btn btn-outline-danger" v-show="status" @click="returnBook">還書</button>
      </h5>

      <h5 class="card-title" v-else>借書記錄: 已還書</h5>
      <p class="card-text">最後操作時間: {{userBorrow.updateTime}}</p>
    </div>
  </div>
</template>

<script>
import { useBookStatus } from "@/stores/bookStatus";
import { mapState } from "pinia";

export default {
  props: {
    userBorrow: []
  },
  created() {
    this.checkStatus();
  },
  data() {
    return {
      status: true
    };
  },
  computed: {
    ...mapState(useBookStatus, ["bookStatus"])
  },
  methods: {
    checkStatus() {
      const bookStatus = this.bookStatus;
      //在所有借書記錄中,找跟這本書一樣ID的組數
      const arr = bookStatus.filter(
        item => item.bookId === this.userBorrow.bookId
      );
      //判斷是否找到己還的記錄,找到的話不顯示已還
    const result =  arr.find(item => item.statusId != this.userBorrow.statusId);
    if(result){
      this.status = false
    }
    else{
      this.status = true
    }
    },
    returnBook(){
      console.log(this.userBorrow.statusId)
      this.$emit('returnBook',2,this.userBorrow.bookName,this.userBorrow.bookId)
    }
  }
};
</script>

<style>
</style>