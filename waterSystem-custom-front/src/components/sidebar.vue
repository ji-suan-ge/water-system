<template>
  <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
    <div class="nano">
      <div class="nano-content">
        <ul>
          <div class="logo">
            <router-link :to="{name: 'index'}"><span>送水系统</span></router-link>
          </div>
          <li><router-link :to="{name: 'order'}"><i class="ti-email"></i> 下单 </router-link></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'sidebar',
  data: function () {
    return {}
  }
}
</script>

<style scoped>

</style>
