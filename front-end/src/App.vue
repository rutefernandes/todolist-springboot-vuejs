<template>
  <div id="app">
  <Todos/>
  </div>
</template>

<script>
  import Todos from './components/Todos'
  const app = {
    name: 'app',
    components: {
      Todos
    },
    data: () => {
      return {
      }
    }
  }

  export default app
</script>

<style>
  [v-cloak] { display: none; }
</style>