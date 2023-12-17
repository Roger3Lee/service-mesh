<template>
  <div>
    <ms-table-page ref="tablePage" :formConfig="formConfig" :tableConfig="tableConfig"
      :tableOperateButtons="tableOperateButtons" :service="service" @addItem="addItemDialogShow" @deleteItem="deleteItem"
      @editItem="editItemDialogShow" />
    <ms-modal ref="addDialog" title="新增" :config="createFormConfig" @confirm="addItem" :validators="validators" />
    <ms-modal ref="editDialog" title="修改" :config="createFormConfig" @confirm="editItem" :validators="validators" />
  </div>
</template>

<script lang="ts">
import * as DS from '@/api/datasource'
import MsTablePage from "@/components_ms/MsTablePage/index.vue"
import MsModal from "@/components_ms/MsModal/index.vue"
import config from "@/pageconfigs/data-source/index.jsx"
import validators from "@/validators/index.jsx"
import { ElMessage } from "element-plus"

export default {
  name: "Dashboard",
  components: {
    MsTablePage,
    MsModal
  },
  data() {
    return {
      tableConfig: {
        ...config.pageTableConfig
      },
      formConfig: config.pageQueryFormConfig,
      tableOperateButtons: config.tableOperateButtons,
      service: DS.page,
      createFormConfig: config.createFormConfig,
      editFormConfig: config.editFormConfig,
      validators: validators
    }
  },
  methods: {
    submit(data: any) {
      console.log("submit", data)
      alert("submit")
    },
    addItemDialogShow() {
      this.$refs.addDialog.show();
    },
    addItem(data: any, callback: Function) {
      DS.createItem(data).then(resp => {
        if (resp.code === 0) {
          callback(true)
          this.reloadData();
        } else {
          ElMessage.error(resp.message)
        }
      });
    },
    editItem(data: any, callback: Function) {
      DS.updateItem(data).then(resp => {
        return callback(true)
      });
    },
    deleteItem(row: any) {
      DS.deleteItem(row.id).then(resp => {
        if (resp.code !== 0) {
          ElMessage.error(resp.message)
        } else {
          this.reloadData();
        }
      })
    },
    editItemDialogShow(row: any) {
      console.log("edit", row, this)
      this.$refs.editDialog.show()
    },
    reloadData() {
      this.$refs.tablePage.reloadTable();
    }
  }
}
</script>
<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }

  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
