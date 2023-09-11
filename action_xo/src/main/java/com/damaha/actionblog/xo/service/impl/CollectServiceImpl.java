package com.damaha.actionblog.xo.service.impl;

import com.damaha.actionblog.xo.service.CollectService;
import com.damaha.actionblog.commons.entity.Collect;
import com.damaha.actionblog.xo.mapper.CollectMapper;
import com.damaha.actionblog.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 收藏表 服务实现类
 *
 * @author 陌溪
 * @since 2018-09-08
 */
@Service
public class CollectServiceImpl extends SuperServiceImpl<CollectMapper, Collect> implements CollectService {

}
