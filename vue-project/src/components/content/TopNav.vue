<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <router-link to="/home" class="navbar-brand" href="#">
        <img
          src="../../assets/logo.png"
          alt
          width="30"
          height="24"
          class="d-inline-block align-text-top"
        />
        首頁
      </router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/home" class="nav-link active" aria-current="page" href="#">首頁</router-link>
          </li>

          <li class="nav-item" v-if="userInfo.data">
            <router-link :to="{name:'user',params:{id:id} }" class="nav-link" href="#">個人</router-link>
          </li>
          <li class="nav-item" v-if="userInfo.data">
            <router-link to="/books" class="nav-link" href="#">書單</router-link>
          </li>
          <li class="nav-item" v-if="userInfo.data">
            <a class="nav-link" href="#" @click="clearUser">登出</a>
          </li>
          <li class="nav-item" v-else>
            <router-link to="/login" class="nav-link" href="#">登錄</router-link>
          </li>
        </ul>
        <li class="nav-item d-flex" v-if="userInfo.data">
          <router-link
            :to="{name:'user',params:{id:id} }"
            class="nav-link text-dark"
            href="#"
          >親愛的:{{name}}</router-link>
        </li>
      </div>
    </div>
  </nav>
</template>

<script>
import { useUserStore } from "@/stores/user";
import { useBookStatus } from "@/stores/bookStatus";
import { mapState, mapActions } from "pinia";

import router from "@/router";
export default {
  components: { router },
  computed: {
    // 可以访问组件中的 this.count
    // 与从 store.count 中读取的数据相同
    ...mapState(useUserStore, ["userInfo", "id", "name"])
  },
  methods: {
    ...mapActions(useUserStore, ["clearUserInfo"]),
    ...mapActions(useBookStatus, ["clearBookStatus"]),
    clearUser() {
      this.clearUserInfo();
      this.clearBookStatus()
      window.alert("成功登出");
      this.$router.replace("/home");
    }
  }
};
</script>

<style>
</style>