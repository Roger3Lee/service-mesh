<template>
  <div :style="{ 'grid-column-start': 'span ' + spanRange }" v-if="evaluateCondition(condition)">
    <ms-input v-if="controlType === 'input'" v-bind="$props" />
    <ms-date-picker v-if="controlType === 'date'" v-bind="$props" />
    <ms-select v-if="controlType === 'select'" v-bind="$props" />
    <ms-checkbox v-if="controlType === 'checkbox'" v-bind="$props" />
  </div>
</template>
<script lang="ts">
import MsInput from "./MsInput.vue"
import MsDatePicker from "./MsDatePicker.vue"
import MsSelect from "./MsSelect.vue"
import MsCheckbox from "./MsCheckbox.vue"
import common from "./common.jsx"

const defaultProp = {
  condition: true
}

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
    return {
      ...defaultProp, ...this.$props.element
    }
  },
  methods: {
    evaluateCondition(value) {
      try {
        if (typeof value === 'boolean') {
          return value;
        } else if (typeof value === "function") {
          return value.apply(this);
        } else if (typeof value === 'string') {
          let f = new Function(`with(this){return ${value}}`)
          return f.call(this.model);
        }
      }
      catch (error) {
        console.log(value + "execute error.", error)
        return false;
      }
    }
  }
}
</script>
