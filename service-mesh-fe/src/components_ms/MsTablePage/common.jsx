export default {
  props: {
    formConfig: {
      type: Object,
      require: false,
      default: undefined
    },
    validators: {
      type: Object,
      default: undefined,
      require: false
    },
    tableConfig: {
      type: Object,
      require: false,
      default: undefined
    },
    tableOperateButtons: {
      type: Array,
      default: () => [],
      require: false
    },
    service: {
      type: Function,
      require: true
    },
    responseCallback: {
      type: Function,
      default: undefined,
      require: false
    },
    formatters: {
      type: Object,
      default: undefined,
      require: false
    }
  }
}
