<template>
    <div>
        <ms-table-page ref="tablePage" :formConfig="pageConfig.pageQueryFormConfig"
            :tableConfig="pageConfig.pageTableConfig" :tableOperateButtons="pageConfig.tableOperateButtons" :service="page"
            @addButtonClick="addItemDialogShow" />
        <ms-modal ref="addDialog" title="新增" :config="pageConfig.createFormConfig" @confirm="addItem"
            :validators="validators" />
        <ms-modal ref="editDialog" title="修改" :config="pageConfig.editFormConfig" @confirm="editItem"
            :validators="validators" :service="findItem" />
    </div>
</template>
<script lang="ts" setup>
import { ref, reactive, provide } from 'vue'
import { ElMessage, ElMessageBox } from "element-plus"
import MsTablePage from "@/components_ms/MsTablePage/index.vue"
import MsModal from "@/components_ms/MsModal/index.vue"
import { createItem, updateItem, deleteItem as DELETE, page, findItem } from "@/api/service/index"
import { page as DSpage } from '@/api/datasource'
import { default as pageConfigV } from "@/pageconfigs/data-source/data-service/index.jsx"
import { default as validators } from "@/validators/index.jsx"

const pageConfig = reactive(pageConfigV)
const addDialog = ref<any>(null)
const editDialog = ref<any>(null)
const tablePage = ref<any>(null)


const addItemDialogShow = () => {
    addDialog.value.show();
}
const addItem = (data: any, callback: Function) => {
    createItem(data).then((resp: any) => {
        if (resp.code === 0) {
            callback(true)
            reloadData();
        } else {
            ElMessage.error(resp.message)
        }
    });
}
const editItem = (data: any, callback: Function) => {
    updateItem(data).then((resp: any) => {
        if (resp.code === 0) {
            callback(true)
            reloadData();
        } else {
            ElMessage.error(resp.message)
        }
    });
}
const deleteItem = (row: any) => {
    ElMessageBox.confirm("确定删除？").then(() => {
        DELETE(row.id).then((resp: any) => {
            if (resp.code !== 0) {
                ElMessage.error(resp.message)
            } else {
                reloadData();
                ElMessage.success("删除成功。")
            }
        })
    })
}
const editItemDialogShow = (row: any) => {
    editDialog.value.show({ key: row.id })
}
const reloadData = () => {
    tablePage.value.reloadTable();
}
const getDatasource = () => {
    return DSpage({ pageNum: 1, pageSize: 9999 }).then((resp: any) => {
        let response: { label: any; value: any }[] = [];
        if (resp.code === 0) {
            resp.data.records.forEach((element: { name: any; id: any }) => {
                response.push({ label: element.name, value: element.id })
            });
        }
        return response;
    })
}
provide("$refpage", { getDatasource, editItemDialogShow, deleteItem });
</script>