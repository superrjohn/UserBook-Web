<template>
  <form style="margin-left: 15px">
    <div class="mb-3 w-50 p-3">
      <label for="exampleInputEmail1" class="form-label">用戶帳號</label>
      <input
        type="text"
        class="form-control"
        v-model="user.username"
        id="exampleInputEmail1"
        aria-describedby="emailHelp"
      />
      <div id="emailHelp" class="form-text">請填寫你要申請的帳號密碼</div>
    </div>
    <div class="mb-3 w-50 p-3">
      <label for="exampleInputEmail2" class="form-label">用戶名稱</label>
      <input
        type="text"
        class="form-control"
        v-model="user.name"
        id="exampleInputEmail2"
        aria-describedby="emailHelp"
      />
    </div>
    <div class="mb-3 w-50 p-3">
      <label for="exampleInputPassword1" class="form-label">用戶密碼</label>
      <input
        type="password"
        class="form-control"
        v-model="user.password"
        id="exampleInputPassword1"
      />
    </div>
    <button type="button" class="btn btn-primary " @click="register" style="margin-left: 15px">申請註冊</button>
  </form>
</template>

<script>
import { registerAPI } from "@/apis/register";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
        name: ""
      }
    };
  },
  methods: {
    async register() {
      const { username, password, name } = this.user;
      const { data: res } = await registerAPI({ username, password, name });
      if (res.code == 1) {
        window.alert('註冊成功')
        this.$router.push('/login')
      } else {
        window.alert('帳號已經被註冊,請重新輸入')
      }
    }
  }
};
</script>

<style>
</style>