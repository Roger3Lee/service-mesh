
export default {
  props: {
    row: {
      type: Object,
    },
    index: {
      type: Number,
    },
    cellValue: {
      type: null,
    },
    render: {
      type: Function,
    },
  },
  inject: ['tableEvents'],
  render(h) {
    return this.render.call(this, h, this.row, this.cellValue, this.index)
  },
  methods: {
    bindEvent(event, row) {
      let invoker = this.tableEvents[event];
      if (invoker && typeof invoker === 'function') {
        invoker.call(this, row)
      }
    }
  }
}