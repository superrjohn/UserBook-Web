<template>
  <div>
    <user-book
      v-for="(item,index) in bookStatus"
      :key="item.bookId+index"
      :userBorrow="item"
      @returnBook="returnbook"
    />
  </div>
</template>

<script>
import UserBook from "@/components/content/UserBook.vue";
import { useBookStatus } from "@/stores/bookStatus";
import { mapActions, mapState } from "pinia";
import { putUserBookAPI } from "@/apis/user";

export default {
  created() {
    const id = this.$route.params.id;
    this.getBookStatus(id);
  },
  inject:['reload'],
  components: { UserBook },
  data() {
    return {};
  },
  computed: {
    ...mapState(useBookStatus, ["bookStatus"])
  },
  methods: {
    ...mapActions(useBookStatus, ["getBookStatus"]),

  async  returnbook(statusId, bookName, bookId) {
      const userId = this.$route.params.id;
      console.log(statusId, bookName, bookId, userId);
      //修改個人頁借書狀態(還書)
   await   putUserBookAPI({ bookName, bookId, userId, statusId }).then(res =>
        console.log(res)
      );
      window.alert("還書成功");
      //再新顯示個人借書記錄
    await  this.getBookStatus(userId);
    this.reload()
    }
  }
};
</script>

<style>
</style>