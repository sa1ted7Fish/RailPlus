<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="接口名称" prop="apiName">
        <el-input
          v-model="queryParams.apiName"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dv:api:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dv:api:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dv:api:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="apiList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="接口名称" align="center" prop="apiName" />
      <el-table-column label="编辑图表" align="center" >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleChartEdit(scope.row)"
          >编辑</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dv:api:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dv:api:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改API对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="接口名称" prop="apiName">
              <el-input v-model="form.apiName"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="请求方式" prop="method">
              <el-input v-model="form.method"/>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="接口" prop="api">
              <el-input v-model="form.api"/>
            </el-form-item>
          </el-col>
        </el-row>
        <div v-for="(item, i) in form.apiParams">
          <el-row>
            <el-col :span="8">
              <el-form-item label="参数名">
                <el-input v-model="form.apiParams[i].paramName" />
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="默认值">
                <el-input v-model="form.apiParams[i].default"  />
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="">
                <el-button type="danger" @click.prevent="removeParam(i)">删除</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <el-row>
          <el-col :span="6">
            <el-form-item label="">
              <el-button type="primary" @click="addParam">添加参数</el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listApi, getApi, delApi, addApi, updateApi } from "@/api/railplus/dv/api";

export default {
  name: "Api",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // API表格数据
      apiList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        apiName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询API列表 */
    getList() {
      this.loading = true;
      listApi(this.queryParams).then(response => {
        this.apiList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        apiName: null,
        api: null,
        apiParams: [],
        method: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.apiId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加API";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const apiId = row.apiId || this.ids
      getApi(apiId).then(response => {
        var apiParams = JSON.parse(response.data.apiParams)
        this.form = response.data;
        this.form.apiParams = apiParams;
        this.open = true;
        this.title = "修改API";
      });
    },
    /** 提交按钮 */
    submitForm() {
      var apiParams = this.form.apiParams
      this.form.apiParams = JSON.stringify(apiParams)

      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.apiId != null) {
            updateApi(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addApi(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const apiIds = row.apiId || this.ids;
      this.$modal.confirm('是否确认删除API编号为"' + apiIds + '"的数据项？').then(function() {
        return delApi(apiIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },

    removeParam(index) {
      if (index !== -1) {
        this.form.apiParams.splice(index, 1)
      }
    },
    addParam() {
      this.form.apiParams.push({
        paramName: null,
        default: null,
      });
    },


    handleChartEdit(row) {
      this.$router.push({
        name: 'ChartEdit',
        params: row
      })
    }

  }
};
</script>
