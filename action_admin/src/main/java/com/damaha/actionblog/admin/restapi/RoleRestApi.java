package com.damaha.actionblog.admin.restapi;

import com.damaha.actionblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.damaha.actionblog.admin.annotion.AvoidRepeatableCommit.AvoidRepeatableCommit;
import com.damaha.actionblog.admin.annotion.OperationLogger.OperationLogger;
import com.damaha.actionblog.utils.ResultUtil;
import com.damaha.actionblog.xo.service.RoleService;
import com.damaha.actionblog.xo.vo.RoleVO;
import com.damaha.actionblog.base.exception.ThrowableUtils;
import com.damaha.actionblog.base.validator.group.Delete;
import com.damaha.actionblog.base.validator.group.GetList;
import com.damaha.actionblog.base.validator.group.Insert;
import com.damaha.actionblog.base.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色表 RestApi
 *
 * @author 陌溪
 * @date 2018-09-04
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色相关接口", tags = {"角色相关接口"})
@Slf4j
public class RoleRestApi {

    @Autowired
    private RoleService roleService;

    @AuthorityVerify
    @ApiOperation(value = "获取角色信息列表", notes = "获取角色信息列表")
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody RoleVO roleVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取角色信息列表");
        return ResultUtil.successWithData(roleService.getPageList(roleVO));
    }

    @AvoidRepeatableCommit
    @AuthorityVerify
    @OperationLogger(value = "新增角色信息")
    @ApiOperation(value = "新增角色信息", notes = "新增角色信息")
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody RoleVO roleVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return roleService.addRole(roleVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "更新角色信息")
    @ApiOperation(value = "更新角色信息", notes = "更新角色信息")
    @PostMapping("/edit")
    public String update(@Validated({Update.class}) @RequestBody RoleVO roleVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return roleService.editRole(roleVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "删除角色信息")
    @ApiOperation(value = "删除角色信息", notes = "删除角色信息")
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody RoleVO roleVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return roleService.deleteRole(roleVO);
    }
}