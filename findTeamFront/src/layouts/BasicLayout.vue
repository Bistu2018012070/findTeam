<template>
  <van-nav-bar
      title="标题"
      left-text="返回"
      right-text="按钮"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  >
    <template #right>
      <van-icon name="search" size="18" />
    </template>
  </van-nav-bar>
  <div id="content">
    <template v-if="active === 'index'">
      <index></index>
    </template>
    <template v-if="active === 'team'">
      <team></team>
    </template>
  </div>

  <van-tabbar v-model="active" @change="onChange">
    <van-tabbar-item icon="home-o" name="index">主页</van-tabbar-item>
    <van-tabbar-item icon="search" name="team">队伍</van-tabbar-item>
    <van-tabbar-item icon="friends-o" name="user">个人</van-tabbar-item>
  </van-tabbar>
</template>

<script>

import {showToast} from "vant";
import { ref } from 'vue';
import Index from "../pages/Index.vue";
import Team from "../pages/Team.vue";

export default {
  name: "BasicLayout",
  components: {Team, Index},
  setup() {
    const active = ref('index');
    const onChange = (index) => showToast(`标签 ${index}`);
    const onClickLeft = () => history.back();
    const onClickRight = () => showToast('按钮');
    return {
      onClickLeft,
      onClickRight,
      active,
      onChange,
    };
  },
}
</script>

<style scoped>

</style>
