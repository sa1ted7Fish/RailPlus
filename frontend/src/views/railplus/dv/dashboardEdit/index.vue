<template>
  <div class="app-container">
    <el-row>
      <el-col :span="6">
        <el-card>
          <div style="height: calc(100vh - 86px - 35px); overflow-y: auto">
            <el-form label-width="80px">
              <el-form-item label="仪表板名称">
                <el-input v-model="dashboardName" disabled></el-input>
              </el-form-item>
              <el-form-item>
                <el-button @click="addChart">新增</el-button>
                <el-button @click="saveDashboard">保存</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </el-col>
      <el-col :span="18">
        <div style="width: 100%; min-height: calc(100vh - 84px)">
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
      </el-col>
    </el-row>
    <!-- 添加或修改Dashboard对话框 -->
    <el-dialog title="添加图表" :visible.sync="open" width="500px" append-to-body>
      <el-form label-width="80px">
        <el-form-item label="图表名称" prop="chartName">
          <el-input v-model="chartName" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submit">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getChart } from "@/api/railplus/dv/common";
import { addDashboardDetails } from "@/api/railplus/dv/dashboardDetails";

export default {
  data() {
    return {
      dashboardId: null,
      dashboardName: null,
      chartName: null,

      open: false,

      layout: [],
      draggable: true,
      resizable: true,
      colNum: 12,
    }
  },
  methods: {
    addItem: function (chart) {
      let layoutItem = {
        x: (this.layout.length * 2) % (this.colNum || 12),
        y: this.layout.length + (this.colNum || 12),
        w: 2,
        h: 2,
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
    removeItem: function (val) {
      const index = this.layout.map(item => item.i).indexOf(val);
      this.layout.splice(index, 1);
    },

    resizedEvent(i) {
      this.$refs[i][0].chartResize();
    },

    addChart() {
      this.chartName = null;
      this.open = true;
    },

    saveDashboard() {
      for (let i = 0; i < this.layout.length; i++) {
        const data = {
          chartId: this.layout[i].i,
          dashboardId: this.dashboardId,
          x: this.layout[i].x,
          y: this.layout[i].y,
          w: this.layout[i].w,
          h: this.layout[i].h,
        }

        addDashboardDetails(data).then(res => {
          this.$modal.msgSuccess("新增成功");
        })
      }
    },
    cancel() {
      this.open = false;
      this.reset();
    },
    reset() {
      this.chartName = null;
    },
    submit() {
      getChart(this.chartName).then(res => {
        this.addItem(res.data)
        this.open = false;
      })
    }
  },
  mounted() {
    this.dashboardId = this.$route.params.dashboardId;
    this.dashboardName = this.$route.params.dashboardName;
  }
}
</script>

<style scoped>
.app-container {
  padding: 0;
}

</style>
