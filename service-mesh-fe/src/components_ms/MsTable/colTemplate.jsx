export default {
  props: {
    row: {
      type: Object
    },
    index: {
      type: Number
    },
    cellValue: {
      type: null
    },
    render: {
      type: Function
    }
  },
  inject: ["$refpage"],
  render(h) {
    return this.render.call(this, h, this.row, this.cellValue, this.index)
  },
  methods: {
    $trigger(event, args) {
      let invoker = event;
      if (typeof event === "string") {
        invoker = this.$refpage[event]
      }
      if (invoker && typeof invoker === "function") {
        if (Array.isArray(args)) {
          invoker.apply(this.$refpage, args)
        } else {
          invoker.call(this.$refpage, args)
        }
      }
    }
  }
}
