<template>
  <el-card class="chart" style="height:100%; width: 100%" />
</template>

<script>
import { fetchGet } from '@/api/railplus/dv/common'

require('echarts/theme/macarons') // echarts theme

export default {
  name: 'RailNetChart',
  props: ["options"],
  data() {
    return {
      chart: null,
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
      this.drawChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$el, 'macarons')
    },
    drawChart() {
      var query = {};
      this.$props.options.apiParams = JSON.parse(this.$props.options.apiParams);

      this.$props.options.apiParams.forEach((item) => {
        query[item.paramName] = item.default;
      })
      fetchGet(this.$props.options.api, query).then(res => {
        var option = JSON.parse(this.$props.options.chartOption);
        option.dataset.source = res;
        this.chart.setOption(option)
      })
    },
    chartResize() {
      this.chart.resize();
    }
  }
}
</script>

<style scoped>

</style>
