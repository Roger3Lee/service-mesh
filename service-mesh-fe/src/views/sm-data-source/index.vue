<template>
  <div>
    <ms-table-page :formConfig="formConfig" :tableConfig="tableConfig" :tableOperateButtons="tableOperateButtons"
      :validators="validators" :service="service" @addItem="addItemDialogShow" />
    <ms-modal ref="m-add" title="新增" :config="createFormConfig" @confirm="addItem" />
    <ms-modal ref="m-edit" title="修改" :config="createFormConfig" @confirm="editItem" />
  </div>
</template>

<script lang="ts">
import * as DS from '@/api/datasource'
import MsTablePage from "@/components_ms/MsTablePage/index.vue"
import MsModal from "@/components_ms/MsModal/index.vue"
import config from "@/pageconfigs/data-source/index.jsx"

export default {
  name: "Dashboard",
  components: {
    MsTablePage,
    MsModal
  },
  data() {
    return {
      tableConfig: {
        ...config.pageTableConfig,
        tableEvents: {
          deleteItem(row: Object) {
            console.log("delete", row)
          },
          editItem(row: Object) {
            console.log("edit", row, this)
            this.$refs["m-edit"].show()
          }
        }
      },
      formConfig: config.pageQueryFormConfig,
      tableOperateButtons: config.tableOperateButtons,
      service: DS.page,
      createFormConfig: config.createFormConfig,
      editFormConfig: config.editFormConfig,
    }
  },
  methods: {
    submit(data: Object) {
      console.log("submit", data)
      alert("submit")
    },
    addItemDialogShow() {
      this.$refs["m-edit"].show();
    },
    addItem(data: Object, callback: Function) {
      DS.createItem(data).then(resp => {
        return callback(true)
      });
    },
    editItemDialogShow(data: Object, callback: Function) {
      DS.updateItem(data).then(resp => {
        return callback(true)
      });
    },
    deleteItem(data) {
      debugger
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
