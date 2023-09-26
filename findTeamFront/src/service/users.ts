import MyAxios from "../plugins/myAxios";
import {getCurrentUserState} from "../states/user";

export const getCurrentUser = async () => {
    const currentUser = getCurrentUserState();
    if (currentUser){
        return currentUser;
    }

    const res = await MyAxios.get('/user/current');
    if (res.code === 0){
        return res.data;
    }
    return null;
}
