const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,/* 關閉多詞命名*/
  devServer:{
    port: 7000
  }
})
