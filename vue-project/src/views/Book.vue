<template>
  <div>
    <search-page @search="getSearch"></search-page>
    <page v-for="item in book" :key="item.id" :book="item" @getBookId="putBook" />
    <pageination
      :pageTotal="pageTotal"
      v-show="book.length >=5 "
      @getPage="getPage"
      @pageAdd="pageAdd"
      @pageSub="pageSub"
    />
    <div v-show="book == 0" style="margin:10%">沒有資料,請重新搜尋</div>
  </div>
</template>

<script>
import Page from "../components/content/Page";
import SearchPage from "@/components/content/SearchPage.vue";
import Pageination from "@/components/content/Pageination.vue";
import { useUserStore } from "@/stores/user";
import { mapState } from "pinia";

import { bookAPI, putBookAPI } from "@/apis/book";

export default {
  created() {
    this.getBookAPI();
  },
  inject: ["reload"],
  components: { Page, SearchPage, Pageination },
  data() {
    return {
      book: [],
      total: "",
      rows: { default: 5 },
      pageTotal: "",
      page: ""
    };
  },
  computed: {
    ...mapState(useUserStore, ["id"])
  },
  methods: {
    getSearch(val) {
      this.book = val;
    },
    getPage(val) {
      this.page = val;
      const page = this.page;
      bookAPI({ page }).then(res => {
        this.book = res.data.data.rows;
      });
    },
    pageAdd(val) {
      this.page = val;
      const page = this.page;
      bookAPI({ page }).then(res => {
        this.book = res.data.data.rows;
      });
    },
    pageSub(val) {
      this.page = val;
      const page = this.page;
      bookAPI({ page }).then(res => {
        this.book = res.data.data.rows;
      });
    },
    getBookAPI() {
      bookAPI({}).then(res => {
        this.book = res.data.data.rows;
        this.total = res.data.data.total;
        this.rows = this.book.length;
        this.pageTotal = this.total / this.rows;
        console.log(this.book);
        console.log(res);
      });
    },
    async putBook(bookId, bookName, statusId) {
      console.log(bookId, bookName, statusId);
      const userId = this.id;
      await putBookAPI({ bookName, bookId, userId, statusId });
      window.alert("借書成功");
      await this.getBookAPI();
      this.reload();
    }
  }
};
</script>

<style>
</style>