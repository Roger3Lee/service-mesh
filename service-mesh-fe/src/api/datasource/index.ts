import { request } from "@/utils/service"
import * as DS from "./types/index"

/** 增 */
export function createItem(data: any) {
    return request({
        ...DS.URL.Add,
        data
    })
}

/** 删 */
export function updateItem(data: any) {
    return request({
        ...DS.URL.Update,
        data
    })
}

/** 删 */
export function deleteItem(data: String) {
    return request({
        ...DS.URL.Delete,
        data
    })
}

/** 查 */
export function findItem(data: any) {
    return request({
        ...DS.URL.Query,
        data
    })
}
export function page(data: any) {
    return request({
        ...DS.URL.Page,
        data
    })
}