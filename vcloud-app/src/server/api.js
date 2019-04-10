// axios默认设置,二次封装，拦截器等
import axios from 'axios'
import { Message } from 'element-ui'
import router from '../router'
// axios默认设置

let HOST = process.env.HOST
axios.defaults.timeout = 5000
axios.defaults.baseURL = 'http://localhost:10003/v1'
axios.defaults.headers.post['Content-Type'] = 'application/json'
// http request 拦截器
axios.interceptors.request.use(
    config => {
        // console.log(config)
        var authorization = sessionStorage.getItem('authorization')
        if (authorization) {
            config.headers['Authorization'] = authorization
        } else {
            router.push({
                path: '/'
            })
        }
        return config
    },
    error => {
        // error回调信息弹窗
        Message({
            'showClose': true,
            'message': error && error.data.error.message,
            'type': 'error'
        })
        return Promise.reject(error)
    }
)
// 响应拦截器即异常处理
axios.interceptors.response.use(response => {
    return response
}, error => {
    console.log(error)
    if (error && error.response) {
        switch (error.response.status) {
            case 400:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '错误请求'
                })
                break
            case 401:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '未授权，请重新登录'
                })
                break
            case 403:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '拒绝访问'
                })
                break
            case 404:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '请求错误,未找到该资源'
                })
                break
            case 405:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '请求方法未允许'
                })
                break
            case 408:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '请求超时'
                })
                break
            case 500:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '服务器端出错'
                })
                break
            case 501:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '网络未实现'
                })
                break
            case 502:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '网络错误'
                })
                break
            case 503:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '服务不可用'
                })
                break
            case 504:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': '网络超时'
                })
                break
            case 505:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': 'http版本不支持该请求'
                })
                break
            default:
                Message({
                    'type': 'error',
                    'showClose': true,
                    'message': `连接错误${error.response.status}`
                })
        }
    } else {
        Message({
            'type': 'error',
            'showClose': true,
            'message': `连接到服务器失败`
        })
    }
    let errorInfo = error.data.error ? error.data.error.message : error.data
    return Promise.resolve(errorInfo)
})
 /* 封装get方法
 * @param url
 * @param data
 * @returns {Promise}
 */
export function get (url, params = {}) {
    return new Promise((resolve, reject) => {
        axios.get(url, {
                params: params
            })
            .then(res => {
                resolve(res.data)
            })
            .catch(err => {
                reject(err)
            })
    })
}
 /* 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */
export function post (url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.post(url, data)
            .then(res => {
                resolve(res.data)
            }, err => {
                reject(err)
            })
    })
}
 /* 封装put请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function put (url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.put(url, data)
            .then(res => {
                resolve(res.data)
            }, err => {
                reject(err)
            })
    })
}
 /* 封装delete请求
  * @param url
  * @param data
  * @returns {Promise}
  */

export function Delete (url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.delete(url, data)
            .then(res => {
                resolve(res.data)
            }, err => {
                reject(err)
            })
    })
 }
