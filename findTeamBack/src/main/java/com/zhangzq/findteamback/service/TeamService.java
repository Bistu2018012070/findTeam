package com.zhangzq.findteamback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangzq.findteamback.model.domain.User;
import com.zhangzq.findteamback.model.dto.TeamQuery;
import com.zhangzq.findteamback.model.request.TeamJoinRequest;
import com.zhangzq.findteamback.model.request.TeamQuitRequest;
import com.zhangzq.findteamback.model.request.TeamUpdateRequest;
import com.zhangzq.findteamback.model.vo.TeamUserVO;
import com.zhangzq.findteamback.model.domain.Team;

import java.util.List;

/**
 * 队伍服务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     *
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     *
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);
    /**
     * 删除（解散）队伍
     *
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
