<template>
  <div class="sticky-top">
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item">
          <a class="page-link" @click="pageSub">Previous</a>
        </li>

        <li class="page-item" v-for="(item,index) in pageTotal" :key="item[index]">
          <a class="page-link" @click="getPage(index+1)">{{index+1}}</a>
        </li>

        <li class="page-item">
          <a class="page-link" @click="pageAdd">Next</a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  props: {
    pageTotal: ""
  },
  data() {
    return {
      index: 1
    };
  },
  methods: {
    getPage(index) {
      this.index = index;
      console.log(index);
      this.$emit("getPage", this.index);
    },
    pageAdd() {
      if (this.index < this.pageTotal) {
        this.index++;
        console.log(this.index);
        this.$emit("pageAdd", this.index);
      }
    },
    pageSub() {
      if (this.pageTotal >= this.index && this.index != 1) {
        this.index--;
        console.log(this.index);
        this.$emit("pageSub", this.index);
      }
    }
  }
};
</script>

<style>
</style>