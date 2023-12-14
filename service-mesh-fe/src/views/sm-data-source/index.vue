<template>
  <div>
    <ms-table-page :formConfig="formConfig" :tableConfig="tableConfig" :tableOperateButtons="tableOperateButtons"
      :validators="validators" :service="service" @addItem="addItem" />
    <ms-modal ref="m-edit" />
  </div>
</template>

<script>
import { getTableDataApi as getList } from "@/api/table/index"
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
          deleteItem(row) {
            console.log("delete", row)
          },
          editItem(row) {
            console.log("edit", row, this)
            this.$refs["m-edit"].show()
          }
        }
      },
      formConfig: config.pageQueryFormConfig,
      tableOperateButtons: config.tableOperateButtons,
      service: getList,
      validators: config.validators
    }
  },
  methods: {
    submit(data) {
      console.log("submit", data)
      alert("submit")
    },
    addItem() {
      this.$refs["m-edit"].show();
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
