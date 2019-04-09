// 请求接口文件
import * as axios from './api'
// 将所有接口统一起来便于维护
// 登录接口
export const login = params => {
    return axios.post('/login', params)
}
// 登出接口
export const logout = params => {
    return axios.get('/logout', params)
}
// 获取信息(菜单)
export const info = params => {
    return axios.get('/info', params)
}
// 获取菜单管理信息
export const permission = params => {
    return axios.get('/system/permission', params)
}
// 获取角色信息
export const role = params => {
    return axios.get('/system/role', params)
}
// 获取用户信息
export const user = params => {
    return axios.get('/system/user', params)
}