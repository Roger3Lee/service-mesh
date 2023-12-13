<template>
  <el-form-item v-if="evaluateCondition(condition)" :prop="name" :rules="rules" :label="label" label-position="left"
    :label-width="labelWidth">
    <el-select v-model="modelData[name]" v-bind="$data" @change="valueChange">
      <el-option v-for="item in sources" :key="item.value" :label="item.label" :value="item.value" />
    </el-select>
  </el-form-item>
</template>
<script>
import common from "./common.jsx"
const defaultProp = {
  condition: () => {
    return 1 === 1
  },
  name: "select",
  labelWidth: "80px",
  filterable: true,
  multiple: true,
  sources: [],
  disabled: false,
  clearable: true,
  placeholder: "请选择"
}
export default {
  name: "ms-select",
  props: common.elementProps,
  data() {
    return {
      ...defaultProp,
      ...this.$props.element,
      ...{ modelData: this.$props.model },
      ...{ rules: common.decorationValidateRule(this.$props, this.element?.rules) }
    }
  },
  methods: {
    ...common.defaultMethods
  }
}
</script>
