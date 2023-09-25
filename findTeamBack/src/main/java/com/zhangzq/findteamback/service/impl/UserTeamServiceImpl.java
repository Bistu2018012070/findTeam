package com.zhangzq.findteamback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangzq.findteamback.service.UserTeamService;
import com.zhangzq.findteamback.model.domain.UserTeam;
import com.zhangzq.findteamback.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
 * 用户队伍服务实现类
 *
 */
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
        implements UserTeamService {

}




