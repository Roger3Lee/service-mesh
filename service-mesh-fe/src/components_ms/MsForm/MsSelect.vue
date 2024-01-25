<template>
  <el-form-item :prop="name" :rules="rules" :label="label" label-position="left" :label-width="labelWidth">
    <el-select v-model="modelData[name]" v-bind="$data">
      <el-option v-for="item in sources" :key="item.value" :label="item.label" :value="item.value" />
    </el-select>
  </el-form-item>
</template>
<script>
import common from "./common.jsx"
const defaultProp = {
  condition: true,
  name: "select",
  labelWidth: "80px",
  filterable: true,
  multiple: false,
  sources: [],
  disabled: false,
  clearable: true,
  placeholder: "请选择"
}
export default {
  name: "ms-select",
  props: common.elementProps,
  inject: ["$refpage"],
  async mounted() {
    if (typeof this.sources === 'string') {
      if (typeof this.$refpage[this.sources] === 'function') {
        let result = this.$refpage[this.sources].apply(this.$refpage, [])
        if (Promise.resolve(result) === result) {
          this.sources = await result;
        } else {
          this.sources = result
        }
      }
      if (typeof this.$refpage[this.sources] === 'object') {
        this.sources = this.$refpage[this.sources]
      }
    }
  },
  data() {
    return {
      ...defaultProp,
      ...this.$props.element,
      ...{ modelData: this.$props.model },
      ...{ rules: common.decorationValidateRule(this.$props, this.element?.rules) }
    }
  }
}
</script>
