<template>
  <div class="page-wrapper">
    <el-card class="search-wrapper">
      <ms-form ref="form" :config="$props.formConfig" :validators="$props.validators" @submit="submit" @reset="reset" />
    </el-card>
    <el-card>
      <div class="toolbar-wrapper">
        <el-button v-for="(btn, index) in $.props.tableOperateButtons" :key="index" v-bind="btn"
          @click.prevent="triggerEvent($event, btn.beforeClick)" @click="triggerEvent($event, btn.click)">{{ btn.label
          }}</el-button>
      </div>
      <ms-table ref="table" :config="$props.tableConfig" :service="$props.service"
        :responseCallback="$props.responseCallback" :formatters="$props.formatters" :v-bind="$attrs" />

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
    this._refpage = this.$refpage || this.$parent
    return {
      $refpage: this._refpage
    }
  },
  methods: {
    reloadTable() {
      this.submit(this.$refs.form.formData())
    },
    calcDefaultParams() {
      return this.$props.tableConfig?.defaultParams || {}
    },
    submit(queryData) {
      this.$refs.table.fetchData({ ...this.$props.tableConfig?.defaultParams, ...queryData })
    },
    reset() {
      this.$refs.table.fetchData(this.$props.tableConfig?.defaultParams)
    },
    triggerEvent(e, event) {
      if (typeof event === "string" && event != "") {
        this.$emit(event, e)
      } else if (typeof event === 'function') {
        event.call(this._refpage, e)
      }
    },
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

.el-link {
  margin-right: 8px;
}

.el-link .el-icon--right.el-icon {
  vertical-align: text-bottom;
}
</style>