<template>
  <div class="app-container">
    <el-row>
      <el-col :span="6">
        <el-card>
          <div style="height: calc(100vh - 86px - 35px); overflow-y: auto">
            <el-form label-width="68px">
              <el-form-item label="接口名称">
                <el-input v-model="apiName" disabled />
              </el-form-item>
              <el-form-item label="图表名称">
                <el-input v-model="chartName" />
              </el-form-item>
              <el-form-item label="图表类型">
                <el-select v-model="chartType">
                  <el-option
                    v-for="item in chartTypeList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
              <div v-show="chartType === 'bar'">
                <el-form-item label="X轴">
                </el-form-item>
                <el-form-item label="X轴维度">
                  <el-input v-model="barOption.series[0].encode.x"></el-input>
                </el-form-item>
                <el-form-item label="X轴类型">
                  <el-select v-model="barOption.xAxis.type">
                    <el-option
                      v-for="item in dimensionTypeList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="Y轴">
                </el-form-item>
                <el-form-item label="Y轴维度">
                  <el-input v-model="barOption.series[0].encode.y"></el-input>
                </el-form-item>
                <el-form-item label="Y轴类型">
                  <el-select v-model="barOption.yAxis.type">
                    <el-option
                      v-for="item in dimensionTypeList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </div>
              <div v-show="chartType === 'line'">
                <el-form-item label="X轴">
                </el-form-item>
                <el-form-item label="X轴维度">
                  <el-input v-model="lineOption.series[0].encode.x"></el-input>
                </el-form-item>
                <el-form-item label="X轴类型">
                  <el-select v-model="lineOption.xAxis.type">
                    <el-option
                      v-for="item in dimensionTypeList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="Y轴">
                </el-form-item>
                <el-form-item label="Y轴维度">
                  <el-input v-model="lineOption.series[0].encode.y"></el-input>
                </el-form-item>
                <el-form-item label="Y轴类型">
                  <el-select v-model="lineOption.yAxis.type">
                    <el-option
                      v-for="item in dimensionTypeList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </div>
              <div v-show="chartType === 'pie'">
                <el-form-item label="数据项名称">
                  <el-input v-model="pieOption.series[0].encode.itemName"></el-input>
                </el-form-item>
                <el-form-item label="数据项">
                  <el-input v-model="pieOption.series[0].encode.value"></el-input>
                </el-form-item>
              </div>
            </el-form>
            <el-form>
              <el-form-item>
                <el-button @click="">取消</el-button>
                <el-button @click="chartPreview">预览</el-button>
                <el-button @click="chartSave">保存</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </el-col>
      <el-col :span="18">
        <el-card>
          <div id="preview" style="width: 100%; height: calc(100vh - 86px - 35px)">

          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { fetchGet } from '@/api/railplus/dv/common'

require('echarts/theme/macarons') // echarts theme

export default {
  name: 'chartEdit',
  data() {
    return {
      apiName: null,
      api: null,
      apiId: null,
      method: null,
      apiParams: [],
      query: {},

      chart: null,
      chartName: null,
      chartType: null,
      chartTypeList: [
        {
          label: "柱形图",
          value: "bar"
        },
        {
          label: "折线图",
          value: "line"
        },
        {
          label: "饼图",
          value: "pie"
        },
      ],

      dimensionTypeList: [
        {
          value: 'category',
          label: '类目'
        },
        {
          value: 'value',
          label: '数值'
        },
        {
          value: 'date',
          label: '时间'
        },
      ],

      chartOption: null,

      barOption: {
        dataset: {
          source: [],
        },
        xAxis: {
          type: null,
        },
        yAxis: {
          type: null,
        },
        series: [
          {
            type: 'bar',
            encode: {
              x: null,
              y: null
            }
          }
        ]
      },
      lineOption: {
        dataset: {
          source: [],
        },
        xAxis: {
          type: null,
        },
        yAxis: {
          type: null,
        },
        series: [
          {
            type: 'line',
            encode: {
              x: null,
              y: null
            }
          }
        ]
      },
      pieOption: {
        dataset: {
          source: [],
        },
        series: [
          {
            type: 'pie',
            encode: {
              itemName: null,
              value: null
            }
          }
        ]
      },
    }
  },

  methods: {
    initChart() {
      this.chart = this.$echarts.init(document.getElementById('preview'), 'macarons')
    },

    initApi() {
      this.apiName = this.$route.params.apiName
      this.api = this.$route.params.api
      this.method = this.$route.params.method
      this.apiParams = JSON.parse(this.$route.params.apiParams);

      this.apiParams.forEach((item) => {
        this.query[item.paramName] = item.default;
      })
    },

    chartPreview() {
      fetchGet(this.api, this.query).then(res => {
        if (this.chartType === 'bar') {
          this.barOption.dataset.source = res
          this.chartOption = this.barOption
        } else if (this.chartType === 'line') {
          this.lineOption.dataset.source = res
          this.chartOption = this.lineOption
        } else if (this.chartType === 'pie') {
          this.pieOption.dataset.source = res
          this.chartOption = this.pieOption
        }

        console.log(this.chartOption)

        this.chart.setOption(this.chartOption)
      })
    },

    chartSave() {

    },
  },

  mounted() {
    this.$nextTick(() => {
      this.initChart()
    });

    this.initApi();
  },

  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
}
</script>

<style scoped>
.app-container {
  padding: 0;
}

</style>
