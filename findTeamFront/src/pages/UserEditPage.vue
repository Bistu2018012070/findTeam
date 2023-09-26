<template>
  <van-form @submit="onSubmit">
    <van-field
        v-model="editUser.currentValue"
        :name="editUser.editKey"
        :label="editUser.editName"
        :placeholder="`请输入${editUser.editName}`"
        :rules="[{ required: true, message: '请填写xxx' }]"
    />
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>

</template>

<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import {getCurrentUser} from "../service/users";
import {showFailToast, showSuccessToast} from "vant";
const route  = useRoute();
const router = useRouter();
import MyAxios from "../plugins/myAxios";

const editUser = ref({
  editKey:route.query.editKey,
  currentValue:route.query.currentValue,
  editName:route.query.editName,
})

// const onSubmit = (values) => {
//   //todo 把editKey currentValue editName 提交到后台
//   console.log('onSubmit',values);
// };

const onSubmit = async () => {
  const currentUser = await getCurrentUser();
  if (!currentUser){
    showFailToast("用户未登录")
    return;
  }
  const res = await MyAxios.post('user/update',{
    'id': currentUser.id,
    [editUser.value.editKey as String]: editUser.value.currentValue,
  })
  if (res.code===0 && res.data > 0){
    showSuccessToast("修改成功");
    router.back();
  } else {
    showFailToast("更新失败");
  }

}
</script>

<style scoped>

</style>
