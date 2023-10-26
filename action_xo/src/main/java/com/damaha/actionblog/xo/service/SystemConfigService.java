package com.damaha.actionblog.xo.service;

import com.damaha.actionblog.commons.entity.SystemConfig;
import com.damaha.actionblog.xo.vo.SystemConfigVO;
import com.damaha.actionblog.base.service.SuperService;

import java.util.List;

/**
 * @author Dabu9
 * @Date 2023/10/24 9:39
 * 
 */
public interface SystemConfigService extends SuperService<SystemConfig> {

    /**
     * 获取系统配置
     *
     * @return
     */
    public SystemConfig getConfig();

    /**
     * 通过Key前缀清空Redis缓存
     *
     * @param key
     * @return
     */
    public String cleanRedisByKey(List<String> key);

    /**
     * 修改系统配置
     *
     * @param systemConfigVO
     * @return
     */
    public String editSystemConfig(SystemConfigVO systemConfigVO);

    /**
     * 获取系统配置中的搜索模式
     * @return
     */
    public String getSearchModel();

}
