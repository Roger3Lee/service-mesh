<template>
  <el-dialog title="xxx" v-model="dialogVisible">
    <ms-form ref="form" :formId="formId" :config="$props.config" :validators="$props.validators" />
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false"> 取消 </el-button>
      <el-button type="primary" @click="handleConfirm">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import MsForm from "../MsForm/index.vue"
export default {
  name: "ms-modal",
  components: {
    MsForm
  },
  // props: formCommon.formProps,
  inject: ["$refpage"],
  provide() {
    return {
      $refpage: this.$refpage || this.$parent
    }
  },
  data() {
    return {
      dialogVisible: true
    }
  },
  methods: {
    show() {
      debugger
      this.dialogVisible = true
    },
    close() {
      this.dialogVisible = false
    },
    handleConfirm() {
      this.$refs[this.formId].validate((valid) => {
        if (valid) {
          this.$emit("confirm", this.$refs.form.data, (result) => {
            //当回调confirm返回true时，关闭窗口
            if (result) {
              dialogVisible = false
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
