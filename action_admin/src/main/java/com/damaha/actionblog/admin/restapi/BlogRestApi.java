package com.damaha.actionblog.admin.restapi;


import com.damaha.actionblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.damaha.actionblog.admin.annotion.AvoidRepeatableCommit.AvoidRepeatableCommit;
import com.damaha.actionblog.admin.annotion.OperationLogger.OperationLogger;
import com.damaha.actionblog.utils.ResultUtil;
import com.damaha.actionblog.xo.service.BlogService;
import com.damaha.actionblog.xo.vo.BlogVO;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 博客表 RestApi
 *
 * @author 陌溪
 * @date 2018-09-08
 */

@RestController
@RequestMapping("/blog")
@Api(value = "博客相关接口", tags = {"博客相关接口"})
@Slf4j
public class BlogRestApi {

    @Autowired
    private BlogService blogService;

    @AuthorityVerify
    @ApiOperation(value = "获取博客列表", notes = "获取博客列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody BlogVO blogVO, BindingResult result) {

        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.successWithData(blogService.getPageList(blogVO));
    }

    @AvoidRepeatableCommit
    @AuthorityVerify
    @OperationLogger(value = "增加博客")
    @ApiOperation(value = "增加博客", notes = "增加博客", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody BlogVO blogVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogService.addBlog(blogVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "本地博客上传")
    @ApiOperation(value = "本地博客上传", notes = "本地博客上传", response = String.class)
    @PostMapping("/uploadLocalBlog")
    public String uploadPics(@RequestBody List<MultipartFile> filedatas) throws IOException {

        return blogService.uploadLocalBlog(filedatas);
    }

    @AuthorityVerify
    @OperationLogger(value = "编辑博客")
    @ApiOperation(value = "编辑博客", notes = "编辑博客", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody BlogVO blogVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogService.editBlog(blogVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "推荐博客排序调整")
    @ApiOperation(value = "推荐博客排序调整", notes = "推荐博客排序调整", response = String.class)
    @PostMapping("/editBatch")
    public String editBatch(@RequestBody List<BlogVO> blogVOList) {
        return blogService.editBatch(blogVOList);
    }

    @AuthorityVerify
    @OperationLogger(value = "删除博客")
    @ApiOperation(value = "删除博客", notes = "删除博客", response = String.class)
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody BlogVO blogVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogService.deleteBlog(blogVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "删除选中博客")
    @ApiOperation(value = "删除选中博客", notes = "删除选中博客", response = String.class)
    @PostMapping("/deleteBatch")
    public String deleteBatch(@RequestBody List<BlogVO> blogVoList) {
        return blogService.deleteBatchBlog(blogVoList);
    }

}