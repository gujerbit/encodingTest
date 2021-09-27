<template>
  <main>
    <div class="input-field">
      <section>
        <input class="input" type="text" v-model="inputStr.str">
        <button @click="sendData()">전송</button>
      </section>
      <button class="random" @click="createRandomStr()">랜덤 생성</button>
    </div>
    <div class="view-field">
      <content-component
      :none="store.state.getEncoding.none"
      :encoding="store.state.getEncoding.encoding"
      :base64="store.state.getEncoding.base64">
        <template v-slot:title>
          <p class="title">GET</p>
        </template>
      </content-component>
      <content-component
      :none="store.state.postEncoding.none"
      :encoding="store.state.postEncoding.encoding"
      :base64="store.state.postEncoding.base64">
        <template v-slot:title>
          <p class="title">POST</p>
        </template>
      </content-component>
    </div>
  </main>
</template>

<script>
import { ref } from 'vue'; //동적 변수 할당
import axios from 'axios';
import { useStore } from 'vuex';
import { createRandomCode } from '../js/createRandomCode';
import { sendGet, sendPost, encodingGet, encodingPost, base64Get, base64Post } from '../js/send';
import contentComponent from './ContentComponent.vue';

export default {
    setup() {
      axios.defaults.baseURL = 'http://localhost:8090';
      const store = useStore();
      let inputStr = ref({str: ''}); //input값
      //formdata - ajax 써야함
      //get&post로 그냥 보내기 / get&post url encoding하고 보내기 / base64 encoding해서 보내고 백엔드에서 decode / 백엔드는 decode만 하면 됨
      
      const createRandomStr = () => { //랜덤 문자열 생성
        inputStr.value.str = createRandomCode();
      };

      const sendData = () => {
        sendGet(inputStr.value.str, store);
        sendPost(inputStr.value.str, store);
        encodingGet(inputStr.value.str, store);
        encodingPost(inputStr.value.str, store);
        base64Get(inputStr.value.str, store);
        base64Post(inputStr.value.str, store);
      };

      return { createRandomStr, sendData, inputStr, store }; //return 해야 쓸 수 있음
    },
    components: {
      contentComponent
    }
}
</script>

<style scoped>
@import "../css/main.css";
</style>