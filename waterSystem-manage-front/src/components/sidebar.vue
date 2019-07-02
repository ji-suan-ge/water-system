<template>
  <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
    <div class="nano">
      <div class="nano-content">
        <ul>
          <div class="logo">
            <router-link :to="{name: 'index'}"><span>送水系统</span></router-link>
          </div>

          <li><a><i class="ti-home"></i> 信息管理<span class="sidebar-collapse-icon ti-angle-down"></span></a></li>
          <ul class="second-list">
            <li>
              <router-link :to="{name: 'staff'}"><i class="ti-email"></i> 工作人员</router-link>
            </li>
            <li>
              <router-link :to="{name: 'custom'}"><i class="ti-email"></i> 客户信息</router-link>
            </li>
            <li>
              <router-link :to="{name: 'water'}"><i class="ti-email"></i> 矿泉水信息</router-link>
            </li>
          </ul>

          <li>
            <router-link :to="{name: 'order'}"><i class="ti-email"></i> 订单管理</router-link>
          </li>

          <li><a><i class="ti-home"></i> 数据统计<span class="sidebar-collapse-icon ti-angle-down"></span></a></li>
          <ul class="second-list">
            <li>
              <router-link :to="{name: 'profit'}"><i class="ti-email"></i> 月度收支</router-link>
            </li>
            <li>
              <router-link :to="{name: 'delivery'}"><i class="ti-email"></i> 月度工单</router-link>
            </li>
            <li>
              <router-link :to="{name: 'sales'}"><i class="ti-email"></i> 月度销售</router-link>
            </li>
            <li>
              <router-link :to="{name: 'backup'}"><i class="ti-email"></i> 系统备份与恢复</router-link>
            </li>
          </ul>

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
