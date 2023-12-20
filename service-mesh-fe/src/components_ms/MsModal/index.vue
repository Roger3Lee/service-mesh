<template>
  <el-dialog :title="$props.title" v-model="dialogVisible">
    <ms-form ref="dialogForm" :formId="$props.formId" :config="$props.config" :validators="$props.validators" />
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false"> 取消 </el-button>
      <el-button type="primary" @click="handleConfirm">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import formCommon from "../MsForm/common.jsx"
import MsForm from "../MsForm/index.vue"
const defaultServiceCallback = (resp) => { return resp?.data }
export default {
  name: "ms-modal",
  components: {
    MsForm
  },
  props: {
    title: {
      type: String,
      require: true
    },
    ...formCommon.formProps,
    service: {
      type: Function,
      require: false
    },
    serviceCallback: {
      type: Function,
      require: false
    }
  },
  inject: ["$refpage"],
  provide() {
    return {
      $refpage: this.$refpage || this.$parent
    }
  },
  data() {
    return {
      dialogVisible: false
    }
  },
  methods: {
    show(params) {
      this.dialogVisible = true
      if (this.$props.service) {
        this.$props.service.call(this, params).then(resp => {
          const serviceCallback = this.$props.serviceCallback || defaultServiceCallback
          this.$refs.dialogForm.setFormData(serviceCallback.apply(this, [resp]))
        })
      }
    },
    close() {
      this.dialogVisible = false
    },
    handleConfirm() {
      this.$refs.dialogForm.validate((valid, data) => {
        if (valid) {
          this.$emit("confirm", data, (result) => {
            //当回调confirm返回true时，关闭窗口
            if (result) {
              this.dialogVisible = false
            }
          })
          return
        }
      })
    },
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done()
        })
    }
  }
}

</script>
<style scoped>
.dialog-footer {
  text-align: center;
}
</style>