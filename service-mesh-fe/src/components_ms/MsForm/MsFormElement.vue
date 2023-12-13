<template>
  <div :style="{ 'grid-column-start': 'span ' + spanRange }">
    <ms-input v-if="controlType === 'input'" v-bind="$props" @changed="valueChange" />
    <ms-date-picker v-if="controlType === 'date'" v-bind="$props" @changed="valueChange" />
    <ms-select v-if="controlType === 'select'" v-bind="$props" @changed="valueChange" />
    <ms-checkbox v-if="controlType === 'checkbox'" v-bind="$props" @changed="valueChange" />
  </div>
</template>
<script lang="ts">
import MsInput from "./MsInput.vue"
import MsDatePicker from "./MsDatePicker.vue"
import MsSelect from "./MsSelect.vue"
import MsCheckbox from "./MsCheckbox.vue"
import common from "./common.jsx"

export default {
  name: "ms-form-element",
  components: {
    MsInput,
    MsDatePicker,
    MsSelect,
    MsCheckbox
  },
  props: common.elementProps,
  data() {
    return { ...this.$props.element, ...{ modelData: this.$props.model } }
  },
  methods: {
    valueChange(code, value) {
      this.$emit("changed", code, value)
    }
  }
}
</script>
