import { createApp } from 'vue'
import App from './App.vue'
import { NavBar} from 'vant';
import 'vant/lib/index.css';
import * as VueRouter from 'vue-router'
import routes from "./config/route";


const app = createApp(App)
const router = VueRouter.createRouter( {
    history: VueRouter.createWebHashHistory(),
    routes,
})
app.use(router)
app.use(NavBar);
app.mount('#app')
