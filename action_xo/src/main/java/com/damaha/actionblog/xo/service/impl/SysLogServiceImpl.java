package com.damaha.actionblog.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.damaha.actionblog.xo.service.SysLogService;
import com.damaha.actionblog.commons.entity.SysLog;
import com.damaha.actionblog.utils.DateUtils;
import com.damaha.actionblog.utils.StringUtils;
import com.damaha.actionblog.xo.global.SQLConf;
import com.damaha.actionblog.xo.global.SysConf;
import com.damaha.actionblog.xo.mapper.SysLogMapper;
import com.damaha.actionblog.xo.vo.SysLogVO;
import com.damaha.actionblog.base.enums.EStatus;
import com.damaha.actionblog.base.global.Constants;
import com.damaha.actionblog.base.serviceImpl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author limbo
 * @since 2018-09-30
 */
@Service
public class SysLogServiceImpl extends SuperServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    SysLogService sysLogService;

    @Override
    public IPage<SysLog> getPageList(SysLogVO sysLogVO) {

        QueryWrapper<SysLog> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(sysLogVO.getUserName())) {
            queryWrapper.eq(SQLConf.USER_NAME, sysLogVO.getUserName().trim());
        }

        if (StringUtils.isNotBlank(sysLogVO.getOperation())) {
            queryWrapper.eq(SQLConf.OPERATION, sysLogVO.getOperation());
        }

        if (StringUtils.isNotBlank(sysLogVO.getIp())) {
            queryWrapper.eq(SQLConf.IP, sysLogVO.getIp());
        }

        if (StringUtils.isNotBlank(sysLogVO.getStartTime())) {
            String[] time = sysLogVO.getStartTime().split(SysConf.FILE_SEGMENTATION);
            if (time.length == Constants.NUM_TWO) {
                queryWrapper.between(SQLConf.CREATE_TIME, DateUtils.str2Date(time[0]), DateUtils.str2Date(time[1]));
            }
        }

        if (StringUtils.isNotBlank(sysLogVO.getSpendTimeStr())) {
            String[] spendTimeList = StringUtils.split(sysLogVO.getSpendTimeStr(), Constants.SYMBOL_UNDERLINE);
            if (spendTimeList.length == Constants.NUM_TWO) {
                queryWrapper.between(SQLConf.SPEND_TIME, Integer.valueOf(spendTimeList[0]), Integer.valueOf(spendTimeList[1]));
            }
        }

        Page<SysLog> page = new Page<>();
        page.setCurrent(sysLogVO.getCurrentPage());
        page.setSize(sysLogVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);
        IPage<SysLog> pageList = sysLogService.page(page, queryWrapper);
        return pageList;
    }
}
