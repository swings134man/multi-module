<template>
  <h2>Main Page</h2>

  <q-page class="row items-center justify-evenly">

    <!--  임시   -->
    <q-list v-model="list">
      <q-btn
        v-for="item in list"
        :key="item.label"
        :label="item.label"
        color="primary"
        @click="$router.push(item.link)">
      </q-btn>
    </q-list>

  </q-page>
</template>


<script setup lang="ts">

const list = [
  {label: 'test1', link: '/test1'},
]

</script>

<style scoped>
</style>
