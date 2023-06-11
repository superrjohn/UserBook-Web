<template>
  <form style="margin-left: 30px">
    <div class="mb-3 w-50 p-3">
      <label for="exampleInputEmail1" class="form-label">用戶帳號</label>
      <input
        type="text"
        class="form-control"
        name="user.username"
        v-model.trim="user.username"
        id="exampleInputEmail1"
        aria-describedby="emailHelp"
      />
      <div id="text" class="form-text">請輸入你的帳號密碼</div>
    </div>
    <div class="mb-3 w-50 p-3">
      <label for="exampleInputPassword1" class="form-label">用戶密碼</label>
      <input
        type="password"
        name="user.password"
        v-model.trim="user.password"
        class="form-control"
        id="exampleInputPassword1"
      />
    </div>
    <div class="mb-3 form-check">
      <input type="checkbox" class="form-check-input" id="exampleCheck1" />
      <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary" @click.prevent="login">登錄</button>

    <button type="button" class="btn btn-primary" @click="register" style="margin-left: 15px">註冊</button>
  </form>
</template>

<script>
import router from "@/router";
import { useUserStore } from "@/stores/user";
import { mapActions, mapState } from "pinia";

export default {
  data() {
    return {
      user: { username: "", password: "" },
      test: { ac: "abcd123", qw: "123456" }
    };
  },
  computed: {
    // 可以访问组件中的 this.count
    // 与从 store.count 中读取的数据相同
    ...mapState(useUserStore, ["userInfo"])
  },
  methods: {
    // 访问组件内的 this.increment()
    // 与从 store.increment() 调用相同
    ...mapActions(useUserStore, ["getUserInfo"]),
    async login() {
      const { username, password } = this.user;
      await this.getUserInfo({ username, password });
      if (this.userInfo.data) {
        window.alert('登錄成功')
        router.replace("/home");
      } else {
        window.alert('帳號密碼有錯,請重新輸入')
      }
    },
    register() {
      router.push("/register");
    }
  }
};
</script>

<style>
</style>