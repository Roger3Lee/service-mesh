<template>
  <el-form-item v-if="evaluateCondition(condition)" :prop="name" :rules="rules" :label-width="labelWidth">
    <template v-if="type === 'single'">
      <el-checkbox v-bind="$data" v-model="modelData[name]" @change="valueChange">{{ label }}</el-checkbox>
    </template>
    <template v-else>
      <el-checkbox-group v-model="modelData[name]" @change="valueChange">
        <el-checkbox
          v-for="(child, index) in children"
          :key="index"
          :disabled="disabled"
          :true-label="child.trueLabel"
          :false-label="child.falseLabel"
          :label="child.value || child.name"
          >{{ child.label }}</el-checkbox
        >
      </el-checkbox-group>
    </template>
  </el-form-item>
</template>
<script>
import common from "./common.jsx"
const defaultProp = {
  condition: () => {
    return 1 === 1
  },
  name: "checkbox",
  labelWidth: "80px",
  disabled: false,
  placeholder: "请输入",
  type: "single",
  children: [],
  trueValue: undefined,
  falseValue: undefined
}
export default {
  name: "ms-checkbox",
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
