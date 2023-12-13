export default {
  props: {
    config: {
      type: Object,
      require: true,
    },
    formatters: {
      type: Object,
      require: false,
      default: null,
    },
    service: {
      type: Function,
      require: true,
    },
    responseCallback: {
      type: Function,
      require: false,
      default: function (response) {
        if (this.pagination) {
          return response;
        } else {
          return response.data;
        }
      },
    },
  },
  defaultFormat(h, row, cellValue, index) {
    return <span>{cellValue}</span>;
  },
  seqFormat(h, row, cellValue, index) {
    return <span>{index + 1}</span>;
  },
  buildColumns(columns, defaultValue, formatters) {
    let list = [];
    columns.forEach((element) => {
      if (element.field === "#seq") {
        element.formatter = this.seqFormat;
      } else {
        if (element.formatter) {
          if (
            typeof element.formatter === "string" &&
            formatters &&
            formatters.hasOwnProperty(element.formatter)
          ) {
            element.formatter = formatters[element.formatter];
          }
        }
      }
      list.push({ ...defaultValue, ...element });
    });
    return list;
  },
};
