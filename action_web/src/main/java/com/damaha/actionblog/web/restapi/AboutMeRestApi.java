package com.damaha.actionblog.web.restapi;


import com.damaha.actionblog.web.annotion.log.BussinessLog;
import com.damaha.actionblog.web.global.SysConf;
import com.damaha.actionblog.utils.ResultUtil;
import com.damaha.actionblog.xo.service.AdminService;
import com.damaha.actionblog.xo.service.WebConfigService;
import com.damaha.actionblog.base.enums.EBehavior;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于我 RestApi
 *
 * @author 陌溪
 * @date 2018年11月12日14:51:54
 */
@RestController
@RequestMapping("/about")
@Api(value = "关于我相关接口", tags = {"关于我相关接口"})
@Slf4j
public class AboutMeRestApi {

    @Autowired
    AdminService adminService;

    @Autowired
    WebConfigService webConfigService;

    /**
     * 获取关于我的信息
     */
    @BussinessLog(value = "关于我", behavior = EBehavior.VISIT_PAGE)
    @ApiOperation(value = "关于我", notes = "关于我")
    @GetMapping("/getMe")
    public String getMe() {

        log.info("获取关于我的信息");
        return ResultUtil.result(SysConf.SUCCESS, adminService.getAdminByUser(SysConf.ADMIN));
    }

    @ApiOperation(value = "获取联系方式", notes = "获取联系方式")
    @GetMapping("/getContact")
    public String getContact() {
        log.info("获取联系方式");
        return ResultUtil.result(SysConf.SUCCESS, webConfigService.getWebConfigByShowList());
    }

}

