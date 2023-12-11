<template>
  <div class="app-container">
    <grid-layout :layout.sync="layout"
                 :col-num="colNum"
                 :row-height="30"
                 :is-draggable="draggable"
                 :is-resizable="resizable"
                 :vertical-compact="true"
                 :use-css-transforms="true"
    >
      <grid-item v-for="item in layout"
                 :static="item.static"
                 :x="item.x"
                 :y="item.y"
                 :w="item.w"
                 :h="item.h"
                 :i="item.i"
                 :key="item.i"
                 @resized="resizedEvent(item.i)"
      >
        <rp-chart :options="item.options" :ref="item.i"/>
      </grid-item>
    </grid-layout>
  </div>
</template>

<script setup>
import { getDashboardPreview } from "@/api/railplus/dv/common";

export default {
  data() {
    return {
      layout: [],
      draggable: false,
      resizable: false,
      colNum: 12,
    }
  },

  methods: {
    initData() {
      getDashboardPreview(this.$route.params.dashboardId).then(res => {
        for (let i = 0; i < res.data.length; i++) {
          this.addItem(res.data[i])
        }
      })
    },

    addItem: function (chart) {
      let layoutItem = {
        x: chart.x,
        y: chart.y,
        w: chart.w,
        h: chart.h,
        i: chart.chartId,
        options: {
          api: chart.api,
          apiParams: chart.apiParams,
          method: chart.method,
          chartOption: chart.chartOption,
        }
      };
      this.layout.push(layoutItem);
    },
  },

  mounted() {
    this.initData()
  },

}
</script>

<style scoped lang="scss">
.app-container {
  padding: 0;
}
</style>
