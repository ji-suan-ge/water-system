<template>
  <div>
    <sidebar></sidebar>
    <div class="content-wrap main ">
      <div class="container-fluids">
        <section id="main-content">
          <router-view/>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import sidebar from '@/components/sidebar'
export default {
  name: 'custom',
  components: {sidebar}
}
</script>

<style scoped>

</style>
