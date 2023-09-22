import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import { NavBar,Button} from 'vant';
import 'vant/lib/index.css';

const app = createApp(App)
app.use(NavBar, Button);
app.mount('#app')
