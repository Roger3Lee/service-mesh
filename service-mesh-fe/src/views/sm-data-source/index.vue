<template>
  <div>
    <ms-table-page :formConfig="formConfig" :tableConfig="tableConfig" :validators="validators"
      :service="service"></ms-table-page>
    <ms-modal ref="m-edit" :></ms-modal>
  </div>
</template>
  
<script>
import { getList } from '@/api/table'
import MsTablePage from '@/components_ms/MsTablePage'
import MsModal from '@/components_ms/MsModal'
import config from '@/config/data-source'

export default {
  name: 'Dashboard',
  components: {
    MsTablePage,
    MsModal
  },
  data() {
    return {
      tableConfig: {
        ...config.pageTableConfig
        , tableEvents: {
          deleteItem(row) {
            console.log("delete", row)
          },
          editItem(row) {
            console.log("edit", row, this)
            this.$refs["m-edit"].show();
          }
        }
      },
      formConfig: config.pageQueryFormConfig,
      service: getList,
      validators: config.validators
    }
  },
  methods: {
    submit(data) {
      console.log('submit', data)
      alert('submit')
    },
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