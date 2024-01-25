import { Search, Refresh, CirclePlus, Delete, Edit } from "@element-plus/icons-vue"
const type = [
  {
    value: "API",
    label: "接口"
  },
  {
    value: "DB",
    label: "数据库"
  }
]
export default {
  type: type,
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
      },
      {
        name: "type",
        controlType: "select",
        placeholder: "类型",
        label: "类型",
        multiple: true,
        sources: type
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
        field: "type",
        label: "类型",
        formatter(h, row, cellValue, index) {
          return <span>{type.find((x) => x.value === cellValue)?.label}</span>
        }
      },
      {
        field: "description",
        label: "描述"
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
        condition: "code==='1'",
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
        name: "type",
        controlType: "select",
        placeholder: "类型",
        label: "类型",
        sources: type,
        rules: [
          {
            required: true,
            message: "请输入类型",
            trigger: "blur"
          }
        ]
      },
      {
        name: "config",
        label: "配置",
        controlType: "input",
        type: "textarea",
        rows: 4,
        rules: [
          {
            required: true,
            message: "配置",
            trigger: "blur"
          }
        ]
      },
      {
        name: "description",
        label: "描述",
        controlType: "input",
        rows: 4,
        type: "textarea",
      }
    ]
  },
  editFormConfig: {
    elements: [
      {
        name: "code",
        label: "編碼",
        placeholder: "編碼",
        type: "text",
        disabled: true
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
        name: "type",
        controlType: "select",
        placeholder: "类型",
        label: "类型",
        sources: type,
        disabled: true,
        rules: [
          {
            required: true,
            message: "请输入类型",
            trigger: "blur"
          }
        ]
      },
      {
        name: "config",
        label: "配置",
        controlType: "input",
        type: "textarea",
        rows: 4,
        rules: [
          {
            required: true,
            message: "配置",
            trigger: "blur"
          }
        ]
      },
      {
        name: "description",
        label: "描述",
        controlType: "input",
        rows: 4,
        type: "textarea",
      },
      {
        name: "createBy",
        label: "更新人",
        disabled: true
      },
      {
        name: "createTime",
        label: "更新时间",
        disabled: true
      }
    ]
  }
}
