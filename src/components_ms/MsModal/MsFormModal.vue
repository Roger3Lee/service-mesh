<template>
    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <ms-form ref="form" :formId="formId" :config="$props.config" :validators="$props.validators" />
        <div slot="footer" class="dialog-footer">
            <el-button @click="modalCancel"> 取 消 </el-button>
            <el-button type=" primary" @click="modalConfirm">确 定</el-button>
        </div>
    </el-dialog>
</template>
  
<script>
import formCommon from '../MsForm/common'
const defaultConfig = {

}
export default {
    name: 'ms-form-modal',
    props: formCommon.formProps,
    data() {
        return {
            dialogVisible: false,
        };
    },
    methods: {
        modalCancel() {
            dialogVisible = false
        },
        modalConfirm() {
            this.$refs[this.formId].validate((valid) => {
                if (valid) {
                    this.$emit('confirm', this.$refs.form.data, (result) => {
                        //当回调confirm返回true时，关闭窗口
                        if (result) {
                            dialogVisible = false
                        }
                    })
                    return
                }
            });
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => { });
        }
    }
};
</script>