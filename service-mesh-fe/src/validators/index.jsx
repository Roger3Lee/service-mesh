export default {
    validateCode(rule, value, callback) {
        let patten = new RegExp('^[a-z0-9A-Z]+$');
        if (patten.test(value)) {
            callback()
        } else {
            callback('只能包含大小写字母或数字')
        }
    }
} 