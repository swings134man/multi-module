<template>
    <div>
      <h2>Test One</h2>
      {{ data }}
    </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
  import axios from "axios";
import {api} from "boot/axios";

  const data = ref({});

  onMounted(() => {
    init();
  });

  function init() {
    console.log('test-one init');
    retrieve();
  }

  function retrieve() {
    api.get('/test/get')
      .then((res) => {
        console.log(res.data);
        data.value = res.data;
      })
      .catch((err) => {
        console.log(err);
      })
    // axios.get('/test/get')
    //   .then((res) => {
    //     console.log(res.data);
    //     data.value = res.data;
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   })
  }
</script>

<style scoped>

</style>
