<template>
  <div>
    <ms-table-page :formConfig="formConfig" :tableConfig="tableConfig" :validators="validators"
      :service="service"></ms-table-page>
    <!-- <ms-modal></ms-modal> -->
  </div>
</template>
  
<script>
import { getList } from '@/api/table'
import MsTablePage from '@/components_ms/MsTablePage'
import config from '@/config/data-source'

export default {
  name: 'Dashboard',
  components: {
    MsTablePage
  },
  data() {
    return {
      tableConfig: {
        ...config.pageTableConfig
        , tableEvents: {
          deleteItem(id) {
            console.log("delete", id)
          },
          editItem(id) {
            console.log("edit", id)
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