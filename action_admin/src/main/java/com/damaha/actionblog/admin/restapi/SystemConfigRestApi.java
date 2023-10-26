package com.damaha.actionblog.admin.restapi;


import com.damaha.actionblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.damaha.actionblog.admin.annotion.OperationLogger.OperationLogger;
import com.damaha.actionblog.utils.ResultUtil;
import com.damaha.actionblog.xo.service.SystemConfigService;
import com.damaha.actionblog.xo.vo.SystemConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dabu9
 * @Date 2023/10/24 9:39
 * 系统配置
 */
@Api(value = "系统配置相关接口", tags = {"系统配置相关接口"})
@RestController
@RequestMapping("/systemConfig")
@Slf4j
public class SystemConfigRestApi {

    @Autowired
    private SystemConfigService systemConfigService;

    @AuthorityVerify
    @ApiOperation(value = "获取系统配置", notes = "获取系统配置")
    @GetMapping("/getSystemConfig")
    public String getSystemConfig() {
        return ResultUtil.successWithData(systemConfigService.getConfig());
    }

    @AuthorityVerify
    @ApiOperation(value = "通过Key前缀清空Redis缓存", notes = "通过Key前缀清空Redis缓存")
    @PostMapping("/cleanRedisByKey")
    public String cleanRedisByKey(@RequestBody List<String> key) {
        return systemConfigService.cleanRedisByKey(key);
    }

    @AuthorityVerify
    @OperationLogger(value = "修改系统配置")
    @ApiOperation(value = "修改系统配置", notes = "修改系统配置")
    @PostMapping("/editSystemConfig")
    public String editSystemConfig(@RequestBody SystemConfigVO systemConfigVO) {
        return systemConfigService.editSystemConfig(systemConfigVO);
    }
}

