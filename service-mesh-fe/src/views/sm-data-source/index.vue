<template>
  <div>
    <ms-table-page ref="tablePage" :formConfig="formConfig" :tableConfig="tableConfig"
      :tableOperateButtons="tableOperateButtons" :service="service.page" />
    <ms-modal ref="addDialog" title="新增" :config="createFormConfig" @confirm="addItem" :validators="validators" />
    <ms-modal ref="editDialog" title="修改" :config="editFormConfig" @confirm="editItem" :validators="validators"
      :service="service.findItem" />
  </div>
</template>

<script lang="ts">
import * as DS from '@/api/datasource'
import MsTablePage from "@/components_ms/MsTablePage/index.vue"
import MsModal from "@/components_ms/MsModal/index.vue"
import config from "@/pageconfigs/data-source/index.jsx"
import validators from "@/validators/index.jsx"
import { ElMessage, ElMessageBox } from 'element-plus'

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
      createFormConfig: config.createFormConfig,
      editFormConfig: config.editFormConfig,
      validators: validators,
      service: DS
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
      ElMessageBox.confirm("确定删除？").then(() => {
        DS.deleteItem(row.id).then(resp => {
          if (resp.code !== 0) {
            ElMessage.error(resp.message)
          } else {
            this.reloadData();
            ElMessage.success("删除成功。")
          }
        })
      })
    },
    editItemDialogShow(row: any) {
      this.$refs.editDialog.show({ key: row.id })
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
