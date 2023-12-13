<template>
  <div>
    <div class="table-wrapper">
      <el-table
        :v-loading="loading"
        :data="list"
        :element-loading-text="loadingText"
        border
        fit
        highlight-current-row
        :max-height="height"
        :stripe="stripe"
        :header-row-class-name="headerClass"
      >
        <el-table-column v-for="(column, index) in columns" :key="index" :prop="column.field" v-bind="column">
          <template #default="scope">
            <col-template
              v-if="typeof column.formatter === 'function'"
              :render="column.formatter"
              :row="scope.row"
              :index="scope.$index"
              :cellValue="scope.row[column.field]"
            />
            <span v-else v-html="scope.row[column.field]" />
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 分页器 -->
    <div v-if="pagination" class="pager-wrapper">
      <el-pagination
        align="center"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageConfig.currentPage"
        :page-sizes="pageConfig.pageSizeSetting"
        :page-size="pageConfig.pageSize"
        :layout="pageConfig.pageLayout"
        :total="pageConfig.total"
      />
    </div>
  </div>
</template>

<script>
import common from "./common.jsx"
import colTemplate from "./colTemplate.jsx"

const defaultConfig = {
  pagination: true, // 是否分页
  initLoading: true, //默认加载数据
  loading: true, //是否显示loading
  loadingText: "加载中...",
  height: "600px",
  headerClass: "",
  stripe: false,
  columns: [],
  list: [],
  pageConfig: {
    currentPage: 1,
    pageSize: 10,
    total: 0,
    pageSizeSetting: [1, 5, 10, 20],
    pageLayout: "total, sizes, prev, pager, next, jumper"
  }
}

const defaultColumnConfig = {
  label: "",
  align: "center",
  fixed: false,
  field: "",
  tooltip: true
}

export default {
  props: common.props,
  components: {
    colTemplate
  },
  data() {
    return {
      ...defaultConfig,
      ...this.$props.config,
      ...{ columns: common.buildColumns(this.$props.config.columns, defaultColumnConfig, this.$props.formatters) }
    }
  },
  created() {
    //加载数据
    if (this.initLoading) {
      this.fetchData(this.$props.config?.defaultParams || {})
    }
  },
  inject: ["$refpage"],
  provide() {
    return {
      tableEvents: this.$props.config?.tableEvents || {},
      $refpage: this.$refpage || this.$parent
    }
  },
  methods: {
    fetchData(params) {
      this._params = params
      if (this.pagination) {
        params = {
          ...params,
          ...{ currentPage: this.pageConfig.currentPage, pageSize: this.pageConfig.pageSize }
        }
      }
      this.loading = true
      if (typeof this.$props.service === "function") {
        this.$props.service.call(this, params).then((response) => {
          if (this.pagination) {
            const resp = this.$props.responseCallback.call(this, response)
            // 默認格式data:{records:Array,total:Number}
            this.list = resp.data?.records || []
            this.pageConfig.total = resp.data?.total || 0
          } else {
            this.list = this.$props.responseCallback.call(this, response)
          }

          this.loading = false
        })
      } else {
        console.warn("未设置加载方法")
      }
    }, //每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
      this.pageConfig.currentPage = 1
      this.pageConfig.pageSize = val
      this.fetchData(this._params)
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      this.pageConfig.currentPage = val
      this.fetchData(this._params)
    }
  }
}
</script>
<style lang="scss" scoped>
.table-wrapper {
  margin-bottom: 20px;
}

.pager-wrapper {
  display: flex;
  justify-content: flex-end;
}
</style>
