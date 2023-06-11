<template>
  <div style="margin:30px">
    <form class="row gy-2 gx-3 align-items-center">
      <div class="col-auto">
        <label class="visually-hidden" for="autoSizingInput">Name</label>
        <input
          type="text"
          class="form-control"
          id="autoSizingInput"
          placeholder="書本名稱"
          v-model.trim="params.name"
        />
      </div>
      <div class="col-auto">
        <label class="visually-hidden" for="autoSizingSelect">Preference</label>
        <select class="form-select" id="autoSizingSelect1" @change="category($event)">
          <option selected value=" ">分類</option>
          <option value="1">金融類</option>
          <option value="2">科技類</option>
          <option value="3">社會類</option>
          <option value="4">心理與健康類</option>
          <option value="5">旅遊類</option>
        </select>
      </div>
      <div class="col-auto">
        <label class="visually-hidden" for="autoSizingSelect">Preference</label>
        <select class="form-select" id="autoSizingSelect2" @change="status($event)">
          <option selected value=" ">書本狀態</option>
          <option value="1">已借</option>
          <option value="2">可借出</option>
        </select>
      </div>

      <div class="col-auto">
        <button type="submit" class="btn btn-primary" @click="search">搜尋</button>
      </div>
    </form>
  </div>
</template>

<script>
import { bookAPI } from "@/apis/book";
import router from "@/router";

export default {
  //router-link :to="{name:'books',query:{name:params.name,categoryId:params.categoryId,statusId:params.statusId}}"
  data() {
    return {
      params: {
        name: "",
        statusId: "",
        categoryId: ""
      },
      book: [],
      total: ""
    };
  },
  methods: {
    status(obj) {
      this.params.statusId = obj.target.value;
      console.log("狀太" + obj.target.value);
    },
    category(obj) {
      this.params.categoryId = obj.target.value;
      console.log("分類" + obj.target.value);
    },
    async search() {
      const { name, statusId, categoryId } = this.params;
      await bookAPI({ name, statusId, categoryId }).then(res => {
        this.book = res.data.data.rows;
      });
      this.$emit("search", this.book);
    }
  }
};
</script>

<style>
</style>