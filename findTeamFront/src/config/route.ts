import Index from '../pages/Index.vue';
import Team from '../pages/Team.vue';
import User from '../pages/UserPage.vue';
import UserEdit from '../pages/UserEditPage.vue';


const routes = [
    {path: '/', component: Index},
    {path: '/team', component: Team},
    {path: '/user', component: User},
    {path: '/user/edit', component: UserEdit},
]

export default routes;
