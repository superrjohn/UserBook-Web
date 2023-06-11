<template>
  <div>
    <top-nav />
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
import TopNav from "@/components/content/TopNav.vue";
import Page from "@/components/content/Page.vue";
import router from "./router";

export default {
  components: { TopNav, Page, router },
  provide(){
    return{
      reload:this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    };
  },
  methods:{
    reload(){
      this.isRouterAlive = false
      this.$nextTick(function(){
        this.isRouterAlive = true
      })
    }
  }
};
</script>
<style>
</style>
