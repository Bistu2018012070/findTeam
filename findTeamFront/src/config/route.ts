import Index from '../pages/Index.vue';
import Team from '../pages/Team.vue';
import User from '../pages/UserPage.vue';
import UserEdit from '../pages/UserEditPage.vue';
import Search from '../pages/SearchPage.vue';
import SearchResultPage from "../pages/SearchResultPage.vue";
import UserLoginPage from "../pages/UserLoginPage.vue";

const routes = [
    {path: '/', component: Index},
    {path: '/team', component: Team},
    {path: '/user', component: User},
    {path: '/search', component: Search},
    {path: '/user/edit', component: UserEdit},
    { path: '/user/list', component:SearchResultPage },
    { path: '/user/login', component:UserLoginPage },
]

export default routes;
