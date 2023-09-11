package com.damaha.actionblog.xo.service.impl;

import com.damaha.actionblog.xo.service.VisitorService;
import com.damaha.actionblog.commons.entity.Visitor;
import com.damaha.actionblog.xo.mapper.VisitorMapper;
import com.damaha.actionblog.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博主表 服务实现类
 * </p>
 *
 * @author 陌溪
 * @since 2018-09-08
 */
@Service
public class VisitorServiceImpl extends SuperServiceImpl<VisitorMapper, Visitor> implements VisitorService {

}
