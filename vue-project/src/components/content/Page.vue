<template>
  <div class="card border-danger mb-3" style="max-width: 20rem;margin: 30px">
    <div class="card-header">{{book.name}}</div>
    <div class="card-body text-danger">
      <h5 class="card-title" v-if="book.categoryId == 1">分類:金融類</h5>
      <h5 class="card-title" v-else-if="book.categoryId == 2">分類:科技類</h5>
      <h5 class="card-title" v-else-if="book.categoryId == 3">分類:社會類</h5>
      <h5 class="card-title" v-else-if="book.categoryId == 4">分類:心理與健康類</h5>
      <h5 class="card-title" v-else-if="book.categoryId == 5">分類:旅遊類</h5>
      <button
        type="button"
        class="btn btn-outline-danger position-absolute top-0 end-0"
        v-if="book.statusId == 1"
        disabled
      >已借</button>
      <button
        type="button"
        class="btn btn-outline-danger position-absolute top-0 end-0"
        v-else
        @click="getBookId"
      >可借出</button>
      <p class="card-text">建立時間:{{ book.createTime }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    book: {}
  },
  methods: {
    getBookId() {
      console.log('書id'+this.book.id,'書名'+this.book.name,this.book.statusId);
      this.$emit('getBookId',this.book.id,this.book.name,1)
    }
  }
};
</script>

<style>
</style>