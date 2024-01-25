let randomString = (e) => {
  //形参e,需要产生随机字符串的长度
  //如果没有传参，默认生成32位长度随机字符串
  e = e || 32;
  //模拟随机字符串库
  var t = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678",
    a = t.length, //字符串t的长度，随机数生成最大值
    n = "";
  for (var i = 0; i < e; i++) {
    //随机生成长度为e的随机字符串拼接
    n += t.charAt(Math.floor(Math.random() * a));
  }
  //返回随机组合字符串
  return n;
};
export default {
  formProps: {
    formId: {
      type: String,
      require: false,
      default: randomString(10),
    },
    config: {
      type: Object,
      default: null,
    },
    validators: {
      type: Object,
      default: undefined,
      require: false,
    },
  },
  elementProps: {
    element: {
      default: null,
      type: Object,
      require: true,
    },
    model: {
      type: Object,
      default: undefined,
      require: false,
    },
    validators: {
      type: Object,
      default: undefined,
      require: false,
    },
  },
  decorationValidateRule(props, rules) {
    console.debug("decorationValidateRule", props, rules);
    if (!rules) {
      return rules;
    }

    if (!Array.isArray(rules)) {
      rules = new Array(rules);
    }
    rules.forEach((element) => {
      let validator = element?.validator;
      if (
        typeof validator == "string" &&
        props.validators &&
        props.validators[validator]
      ) {
        element.validator = props.validators[validator];
      }
    });

    return rules;
  },
  defaultValue(formData, element) {
    //checkbox group数据必须是数组
    if (element.controlType == "checkbox" && element.type == "group") {
      if (!Array.isArray(formData)) {
        return [];
      }
    }
    return formData;
  },
  defaultMethods: {
    evaluateCondition(value) {
      try {
        if (typeof value === 'boolean') {
          return value;
        } else if (typeof value === "function") {
          return value.apply(this);
        } else if (typeof value === 'string') {
          if (value in this) {
            if (typeof this[value] == "function") {
              return this[value].apply(this);
            } else {
              return value;
            }
          } else {
            let f = new Function(`with(this.modelData){return ${value}}`)
            console.log(f)
            return f.call();
          }
        }
      }
      catch (error) {
        console.log(value + "execute error.")
        return true;
      }
    }
  },
  randomString,
};
