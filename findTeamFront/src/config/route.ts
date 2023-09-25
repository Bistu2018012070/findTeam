import Index from '../pages/Index.vue';
import Team from '../pages/Team.vue';
import User from '../pages/UserPage.vue';
import UserEdit from '../pages/UserEditPage.vue';
import SearchResultPage from "../pages/SearchResultPage.vue";

const routes = [
    {path: '/', component: Index},
    {path: '/team', component: Team},
    {path: '/user', component: User},
    {path: '/user/edit', component: UserEdit},
    { path: '/user/list', component:SearchResultPage },
]

export default routes;
