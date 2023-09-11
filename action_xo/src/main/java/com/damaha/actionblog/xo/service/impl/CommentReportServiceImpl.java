package com.damaha.actionblog.xo.service.impl;

import com.damaha.actionblog.xo.service.CommentReportService;
import com.damaha.actionblog.commons.entity.CommentReport;
import com.damaha.actionblog.xo.mapper.CommentReportMapper;
import com.damaha.actionblog.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 评论举报表 服务实现类
 *
 * @author 陌溪
 * @date 2020年1月12日15:47:47
 */
@Service
public class CommentReportServiceImpl extends SuperServiceImpl<CommentReportMapper, CommentReport> implements CommentReportService {

}
