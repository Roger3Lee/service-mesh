const Mock = require("mockjs");

const data = Mock.mock({
  "records|30": [
    {
      id: "@id",
      code: "@sentence(10, 20)",
      "status|1": ["published", "draft", "deleted"],
      name: "@sentence(10)",
      "type|1": ["API", "DB"],
      updateTime: "@datetime",
    },
  ],
});

module.exports = [
  {
    url: "/vue-element-admin/table/list",
    type: "get",
    caches: false,
    response: (config) => {
      const items = data.records;
      return {
        code: 20000,
        data: {
          total: items.length,
          records: items,
        },
      };
    },
  },
];
