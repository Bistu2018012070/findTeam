<template>
  <van-card
      v-for="user in userList"
      :desc="user.profile"
      :title="`${user.username} (${user.planetCode})`"
      :thumb="user.avatarUrl"
  >
    <template #tags>
      <van-tag plain type="danger" v-for="tag in user.tags" style="margin-right: 8px;margin-top: 8px">
        {{ tag }}
      </van-tag>
    </template>
    <template #footer>
      <van-button size="mini">联系我</van-button>
    </template>
  </van-card>
  <van-empty v-if="!userList||userList.length<1" image="search" description="搜索结果为空" />
</template>

<script setup >
import {onMounted, ref} from "vue";
import {useRoute} from "vue-router";
import myAxios from "../plugins/myAxios";
import qs from 'qs';
import { showSuccessToast, showFailToast } from 'vant';

const route =useRoute();

const { tags }=route.query;

const userList = ref([])

onMounted(async () =>{
  const userListData= await myAxios.get('/user/search/tags', {
    params: {
      tagsNameList: tags
    },
    paramsSerializer:params => {
      return qs.stringify(params,{indices:false})
    }
  })
      .then(function (response) {
        console.log('/user/search/tags===>succeed',response);
        showSuccessToast('请求成功')
        return response.data?.data;
      })
      .catch(function (error) {
        console.error('/user/search/tags===>error',error);
        showFailToast('请求失败')
      });
  if (userListData){
    userListData.forEach(user=>{
      if (user.tags){
        user.tags = JSON.parse(user.tags);
      }
    })
    userList.value = userListData;
  }

})



const mockUser={
  id: 12345,
  username: 'coderhyx',
  userAccount: '12312',
  profile:'是ikun，也是精神小伙，原神启动，原来你也玩原神。',
  avatarUrl: 'http://images/2023/07/31/pic.md.jpg',
  gender:0,
  phone: 12122223333,
  email: '455dssds@qq.com',
  userRole: 0,
  planetCode: '1234',
  tags:['java','emo','打工中','python','开心'],
  createTime: new Date(),
}


</script>

<style scoped>

</style>
