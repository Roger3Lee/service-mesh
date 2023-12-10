<template>
    <el-form-item v-if="evaluateCondition(condition)" :prop="name" :rules="rules" :label="label" label-position="left"
        :label-width="labelWidth">
        <template v-if="children && Array.isArray(children) && children.length === 2">
            <el-col :span="11">
                <el-date-picker :type="type" :placeholder="placeholder" style="width: 100%;" :name="children[0].name"
                    :disabled="disabled" :value-format="dateFormat(type)" v-model="children[0].value"
                    @change="valueChange(children[0].name, $event)"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2" style="text-align:center">-</el-col>
            <el-col :span="11">
                <el-date-picker :type="type" :placeholder="placeholder" style="width: 100%;" :name="children[1].name"
                    :disabled="disabled" :value-format="dateFormat(type)" v-model="children[1].value"
                    @change="valueChange(children[1].name, $event)"></el-date-picker>
            </el-col>
        </template>
        <template v-else>
            <el-date-picker v-bind="$data" style="width: 100%;" :value-format="dateFormat(type)" v-model="modelData[name]"
                @change="valueChange(name, $event)"></el-date-picker>
        </template>
    </el-form-item>
</template>
<script>
import common from './common'
const defaultProp = {
    condition: () => { return 1 === 1; },
    labelWidth: "80px",
    disabled: false,
    clearable: true,
    type: 'date',
    placeholder: '请输入',
    format: undefined
}
const defaultFormat = {
    datetime: 'yyyy-MM-dd hh:mm:ss',
    date: 'yyyy-MM-dd'
}
export default {
    name: 'ms-date-picker',
    props: common.elementProps,
    data() {
        return {
            ...defaultProp, ...this.$props.element, ...{ modelData: this.$props.model }, ...{ rules: common.decorationValidateRule(this.$props, this.element?.rules) }
        }
    },
    methods: {
        ...common.defaultMethods,
        dateFormat(type) {
            return this.format ?? defaultFormat[type]
        },
        valueChange(name, newvalue) {
            //console.log("ms-date-picker", name)
            this.$emit("changed", name, newvalue)
        }
    }
}
</script>