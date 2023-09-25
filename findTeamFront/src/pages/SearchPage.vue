<template>
  <form action="/">
    <van-search
        v-model="searchText"
        show-action
        placeholder="请输入搜索标签"
        @search="onSearch"
        @cancel="onCancel"
    />
  </form>

  <van-divider content-position="left">已选标签</van-divider>
  <div v-if="activeIds.length === 0">暂无已选标签</div>
  <van-row gutter="16" style="padding: 0 16px">
    <van-col v-for="tag in activeIds" >
      <van-tag closeable size="small" type="primary" @close = "doClose(tag)" >
        {{ tag }}
      </van-tag>
    </van-col>
  </van-row>
  <van-divider content-position="left">请选择标签</van-divider>
  <van-tree-select
      v-model:active-id="activeIds"
      v-model:main-active-index="activeIndex"
      :items="tagList"
  />
  <div style="padding: 12px">
    <van-button block type="primary" @click="doSearchResult">搜索</van-button>
  </div>

</template>

<script setup>
import { ref } from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();

const searchText = ref('');

//标签列表，之后要从数据库取值,元数据
const originTagList = [
  {
    text: '性别',
    children: [
      { text: '男', id: '男' },
      { text: '女', id: '女' },
      { text: '妖', id: '妖' },
    ],
  },
  {
    text: '年级',
    children: [
      { text: '大一', id: '大一' },
      { text: '大二', id: '大二' },
      { text: '大三', id: '大三' },
    ],
  },
];

//标签列表
let tagList = ref(originTagList);

const onSearch = (val) => {
  tagList.value = originTagList.map(parentTag => {
    //克隆原始数组
    const tempChildren = [...parentTag.children];
    const tempParentTag = {...parentTag};
    tempParentTag.children = tempChildren.filter(item => item.text.includes(searchText.value));
    return tempParentTag;
  });
  console.log(tagList.value)
}

//点击取消，清空搜索框
const onCancel = () => {
  searchText.value = '';
  tagList.value = originTagList;
}

//已选中标签
const activeIds = ref([]);//默认选中的标签数组
const activeIndex = ref(0);//默认选中的左侧索引

//标签的取消，移除
const doClose = (tag)=>{
  //过滤之后再赋值给刚才的标签数组
  activeIds.value = activeIds.value.filter(item =>{
    //表达式为true，filter保留
    return item !== tag;
  })
}

//执行搜索后
const doSearchResult = () =>{
  router.push({
    path:'/user/list',
    query:{
      tags:activeIds.value
    }
  })
}

</script>

<style scoped>

</style>
