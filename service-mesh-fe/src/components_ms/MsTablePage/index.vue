<template>
    <div>
        <!-- <span>{{ $props }}</span> -->
        <ms-form :config="$props.formConfig" :validators="$props.validators" @submit="submit" @reset="reset" />
        <div>
            <el-button v-for="(   btn, index   ) in    $props.buttons" :v-if="btn.display" :key="index"
                @click.prevent="triggerEvent($event, btn.beforeClick)" @click="triggerEvent($event, btn.click)"
                :type="btn.type" :class="btn.class">{{ btn.label }}</el-button>
        </div>
        <ms-table ref="table" :config="$props.tableConfig" :service="$props.service"
            :responseCallback="$props.responseCallback" :formatters="$props.formatters" />
    </div>
</template>
<script>
import common from './common'
import MsTable from '../MsTable'
import MsForm from '../MsForm'
export default {
    name: 'ms-table-page',
    components: {
        MsTable,
        MsForm
    },
    props: common.props,
    inject: ['$refpage'],
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
            this.$refs.table.fetchData({ ...this.$props.tableConfig?.defaultParams, ...queryData });
        },
        reset() {
            this.$refs.table.fetchData(this.$props.tableConfig?.defaultParams);
        }
    }
}
</script>
