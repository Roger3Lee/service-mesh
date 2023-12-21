import { Search, Refresh, CirclePlus, Delete, Edit } from "@element-plus/icons-vue"

export default {
    pageQueryFormConfig: {
        layoutCol: "3",
        elements: [
            {
                name: "code",
                label: "編碼"
            },
            {
                name: "name",
                label: "名称"
            }
        ],
        buttons: [
            {
                label: "提交",
                type: "primary",
                click: "submit",
                icon: Search
            },
            {
                label: "清除",
                type: "default",
                click: "reset",
                icon: Refresh
            }
        ]
    },
    tableOperateButtons: [
        {
            label: "新增",
            type: "primary",
            click: "addButtonClick",
            icon: CirclePlus
        }
    ],
    pageTableConfig: {
        pagination: true,
        defaultParams: {},
        columns: [
            {
                field: "#seq",
                label: "序号",
                width: "60"
            },
            {
                field: "code",
                label: "编码"
            },
            {
                field: "name",
                label: "名称"
            },
            {
                field: "datasourceId",
                label: "类型",
                formatter(h, row, cellValue, index) {
                    return <span>cellValue</span>
                }
            },
            {
                field: "updateBy",
                label: "更新人"
            },
            {
                field: "updateTime",
                label: "更新時間"
            },
            {
                label: "操作",
                width: "150px",
                fixed: "right",
                formatter(h, row, cellValue, index) {
                    return (
                        <div>
                            <el-link
                                underline={false}
                                href="javascript:void(0)"
                                icon={Delete}
                                onClick={() => { this.$trigger("deleteItem", [row]) }}
                                type="danger"
                                style={{ "margin-right": "3px" }}
                            >
                                刪除
                            </el-link>
                            <el-link
                                underline={false}
                                href="javascript:void(0)"
                                icon={Edit}
                                onClick={() => this.$trigger("editItemDialogShow", [row])}
                                type="primary"
                            >
                                編輯
                            </el-link>
                        </div>
                    )
                }
            }
        ]
    },
    createFormConfig: {
        elements: [
            {
                name: "code",
                label: "編碼",
                placeholder: "編碼",
                type: "text",
                rules: [
                    {
                        required: true,
                        message: "请输入编码",
                        trigger: "blur"
                    },
                    {
                        max: 50,
                        message: "编码长度不能超过30位",
                        trigger: "blur"
                    },
                    {
                        validator: "validateCode",
                        trigger: "blur"
                    }
                ]
            },
            {
                name: "name",
                label: "名称",
                placeholder: "名称",
                rules: [
                    {
                        required: true,
                        message: "请输入名称",
                        trigger: "blur"
                    },
                    {
                        max: 200,
                        message: "名称长度不能超过200位"
                    }
                ]
            },
            {
                name: "datasourceId",
                controlType: "select",
                placeholder: "数据源",
                label: "数据源",
                sources: "getDatasource",
                rules: [
                    {
                        required: true,
                        message: "请选择类型",
                        trigger: "blur"
                    }
                ]
            },
            {
                name: "inputTemplate",
                label: "输入模板",
                controlType: "input",
                type: "textarea",
                rows: 4,
            },
            {
                name: "config",
                label: "配置",
                controlType: "input",
                rows: 4,
                type: "textarea",
                rules: [
                    {
                        required: true,
                        trigger: "blur"
                    }
                ]
            }, {
                name: "outputTemplate",
                label: "输出模板",
                controlType: "input",
                type: "textarea",
                rows: 4,
            }
        ]
    },
    editFormConfig: {
        elements: [
            {
                name: "code",
                label: "編碼",
                placeholder: "編碼",
                disabled: true,
                type: "text",
                rules: [
                    {
                        required: true,
                        message: "请输入编码",
                        trigger: "blur"
                    },
                    {
                        max: 50,
                        message: "编码长度不能超过30位",
                        trigger: "blur"
                    },
                    {
                        validator: "validateCode",
                        trigger: "blur"
                    }
                ]
            },
            {
                name: "name",
                label: "名称",
                placeholder: "名称",
                rules: [
                    {
                        required: true,
                        message: "请输入名称",
                        trigger: "blur"
                    },
                    {
                        max: 200,
                        message: "名称长度不能超过200位"
                    }
                ]
            },
            {
                name: "datasourceId",
                controlType: "select",
                placeholder: "数据源",
                label: "数据源",
                sources: "getDatasource",
                rules: [
                    {
                        required: true,
                        message: "请选择类型",
                        trigger: "blur"
                    }
                ]
            },
            {
                name: "inputTemplate",
                label: "输入模板",
                controlType: "input",
                type: "textarea",
                rows: 4,
            },
            {
                name: "config",
                label: "配置",
                rows: 4,
                type: "textarea",
                rules: [
                    {
                        required: true,
                        trigger: "blur"
                    }
                ]
            }, {
                name: "outputTemplate",
                label: "输出模板",
                type: "textarea",
                rows: 4,
            },
            {
                name: "updateBy",
                label: "更新人",
                disabled: true
            },
            {
                name: "updateTime",
                label: "更新时间",
                disabled: true
            }
        ]
    }
}
