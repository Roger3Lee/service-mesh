import { request } from "@/utils/service"
import * as DS from "./types/index"


/** 增 */
export function createItem(data: any) {
    return request<ApiResponseData<object>>({
        ...DS.URL.Add,
        data
    })
}

/** 删 */
export function updateItem(data: any) {
    return request<ApiResponseData<object>>({
        ...DS.URL.Update,
        data
    })
}

/** 删 */
export function deleteItem(data: String) {
    return request<ApiResponseData<object>>({
        url: `${DS.URL.Delete.url}?key=${data}`,
        method: DS.URL.Delete.method
    })
}

/** 查 */
export function findItem(data: any) {
    return request<ApiResponseData<object>>({
        ...DS.URL.Query,
        data
    })
}
export function page(data: any) {
    return request<ApiResponseData<{
        records: object[],
        total: number
    }>>({
        ...DS.URL.Page,
        data
    })
}