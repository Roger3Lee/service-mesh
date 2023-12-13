<template>
  <div class="page-wrapper">
    <el-card class="search-wrapper">
      <ms-form :config="$props.formConfig" :validators="$props.validators" @submit="submit" @reset="reset" />
    </el-card>
    <el-card>
      <div class="toolbar-wrapper">
        <div>
          <el-button type="primary" :icon="CirclePlus" @click="dialogVisible = true">新增用户</el-button>
          <el-button type="danger" :icon="Delete">批量删除</el-button>
        </div>
      </div>
      <div>
        <ms-table
          ref="table"
          :config="$props.tableConfig"
          :service="$props.service"
          :responseCallback="$props.responseCallback"
          :formatters="$props.formatters"
        />
      </div>
    </el-card>
  </div>
</template>
<script>
import common from "./common.jsx"
import MsTable from "../MsTable/index.vue"
import MsForm from "../MsForm/index.vue"
export default {
  name: "ms-table-page",
  components: {
    MsTable,
    MsForm
  },
  props: common.props,
  inject: ["$refpage"],
  provide() {
    return {
      $refpage: this.$refpage || this.$parent
    }
  },
  methods: {
    calcDefaultParams() {
      return this.$props.tableConfig?.defaultParams || {}
    },
    submit(queryData) {
      this.$refs.table.fetchData({ ...this.$props.tableConfig?.defaultParams, ...queryData })
    },
    reset() {
      this.$refs.table.fetchData(this.$props.tableConfig?.defaultParams)
    }
  }
}
</script>

<style lang="scss" scoped>
.page-wrapper {
  margin: 20px;
}
.search-wrapper {
  margin-bottom: 20px;
  :deep(.el-card__body) {
    padding-bottom: 2px;
  }
}

.toolbar-wrapper {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}
</style>
