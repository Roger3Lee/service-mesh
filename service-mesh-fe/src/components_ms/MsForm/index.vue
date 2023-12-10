<template>
    <div style="margin:20px;">
        <el-form :ref="$props.formId" :model="model">
            <div class="grid-container"
                :style="{ 'grid-template-columns': 'repeat(' + layoutCol + ',' + layoutColWidth + ')' }">
                <ms-form-element v-for="(  element, index  ) in   elements  " :key="index" :element="elementItem(element)"
                    :model="model" :validators="$props.validators" @changed="valueChange">
                </ms-form-element>
            </div>
            <el-form-item :style="{ 'margin-left': labelWidth }">
                <el-button v-for="(   btn, index   ) in    buttons   " :key="index"
                    @click.prevent="triggerEvent($event, btn.beforeClick)" @click="triggerEvent($event, btn.click)"
                    :type="btn.type" :class="btn.class">{{ btn.label }}</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script lang="ts">
import Vue from 'vue'
import MsFormElement from './MsFormElement.vue'
import common from './common'

const defaultFrom = {
    layoutCol: "3",
    layoutColWidth: "3fr",
    labelWidth: "80px",
    elements: [],
    buttons: [],
    data: {}
}

const elementDefault = {
    controlType: "input",
    spanRange: 1,
    disabled: false,
    rules: []
}

export default {
    name: 'ms-form',
    components: {
        MsFormElement
    },
    props: common.formProps,
    inject: ['$refpage'],
    provide() {
        return {
            $refpage: this.$refpage || this.$parent
        }
    },
    data() {
        let fromData = {
            ...defaultFrom, ...this.$props.config
        }
        //添加属性
        let dataExt = {}
        fromData.elements.forEach(element => {
            let field = element.bind || element.name
            if (!fromData.data.hasOwnProperty(element.name)) {
                Object.defineProperty(dataExt, element.name, {
                    configurable: true,
                    enumerable: true,
                    writable: true,
                    value: common.defaultValue(fromData.data[field], element)
                });
            }
        })
        return { ...fromData, ...{ model: { ...fromData.data, ...dataExt } } }
    },
    methods: {
        triggerEvent(e, eventName) {
            // console.log(this, eventName)
            if (typeof eventName === 'string' && eventName != '') {
                if (eventName.indexOf('.valid') >= 0) {
                    this.$refs[this.$props.formId].validate((valid) => {
                        if (valid) {
                            this.callEvent(eventName.replace('.valid', ''))
                            return
                        }
                    });
                } else {
                    this.callEvent(eventName)
                }
            }
        },
        callEvent(eventName) {
            if (eventName === 'reset') {
                //reset form
                this.$refs[this.$props.formId].resetFields();
            }
            this.$emit(eventName, this.data)
        },
        valueChange(code, value) {
            this.data[code] = value;
            // console.log("data:", this.data)
        },
    },
    computed: {
        elementItem() {
            return function (element) {
                return {
                    formId: this.$props.formId,
                    ...elementDefault, ...element
                }
            }
        }
    }
}
</script>
<style scoped>
.form {
    margin: 0 14px;
}

.grid-container {
    display: grid;
    column-gap: 10px;
}
</style>
