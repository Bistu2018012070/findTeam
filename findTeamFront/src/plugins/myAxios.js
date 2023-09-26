import axios from "axios";

const myAxios = axios.create({
    baseURL: 'http://localhost:8080/api'
});

export default myAxios;

myAxios.defaults.withCredentials = true;
myAxios.interceptors.request.use(function (request) {
    console.log("开始发送请求",request)
    return request;
}, function (error) {
    return Promise.reject(error);
})

myAxios.interceptors.response.use(function (response) {
    console.log("收到响应",response)
    return response.data;
}, function (error) {
    return Promise.reject(error);
})
