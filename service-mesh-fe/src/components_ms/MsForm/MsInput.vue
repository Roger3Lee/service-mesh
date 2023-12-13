<template>
  <el-form-item
    v-if="evaluateCondition(condition)"
    :prop="name"
    :label="label"
    label-position="left"
    :label-width="labelWidth"
    :rules="rules"
  >
    <template v-if="type === 'number'">
      <el-input-number v-bind="$data" v-model="modelData[name]" @change="valueChange" :style="{ width: '100%' }" />
    </template>
    <template v-else>
      <el-input v-bind="$data" v-model="modelData[name]" @change="valueChange" />
    </template>
  </el-form-item>
</template>
<script>
import common from "./common.jsx"
const defaultProp = {
  condition: () => {
    return 1 === 1
  },
  name: "input",
  labelWidth: "80px",
  disabled: false,
  clearable: true,
  type: "text", //textarea
  placeholder: "请输入",
  min: undefined,
  max: undefined,
  step: 1
}
export default {
  name: "ms-input",
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
