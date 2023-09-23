<template>
  <van-cell title="昵称" is-link  :value="user.username" @click = "toEdit('username','昵称',user.username)" />
  <van-cell title="账号"  :value="user.userAccount" />
  <van-cell title="头像" is-link to="/user/edit"  :value="user.avatarUrl" >
    <img style="height:48px"  :src="user.avatarUrl" >
  </van-cell>
  <van-cell title="性别" is-link :value="user.gender" @click = "toEdit('gender','性别',user.gender)" />
  <van-cell title="电话" is-link :value="user.phone" @click = "toEdit('phone','电话',user.phone)" />
  <van-cell title="邮箱" is-link :value="user.email" @click = "toEdit('email','邮箱',user.email)"  />
  <van-cell title="星球编号"  :value="user.planetCode" />
  <van-cell title="注册时间"  :value="user.createTime.toISOString()" />

</template>

<script setup lang="ts">
import {useRouter} from "vue-router";

const user={
  id: 1,
  username: '老瑾',
  userAccount: 'coderhyx',
  avatarUrl: 'http://pic.vxmsgpush.xyz/images/2023/07/31/pic.md.jpg',
  gender:'男',
  phone: '18777778888',
  email: 'coderhyx@qq.com',
  planetCode: '12345',
  createTime:new Date(),
}
const router = useRouter();

const toEdit = (editKey: string,editName: string,currentValue: string) => {
  router.push({
    path:'/user/edit',
    query:{
      editKey,
      editName,
      currentValue
    }
  })
}
</script>

<style scoped>

</style>
