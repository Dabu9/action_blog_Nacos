package com.damaha.actionblog.xo.vo;

import com.damaha.actionblog.base.validator.annotion.NotBlank;
import com.damaha.actionblog.base.validator.group.Insert;
import com.damaha.actionblog.base.validator.group.Update;
import com.damaha.actionblog.base.vo.BaseVO;
import lombok.Data;
import lombok.ToString;

/**
 * ResourceSortVO
 *
 * @author: 陌溪
 * @create: 2020年1月9日19:09:00
 */
@ToString
@Data
public class ResourceSortVO extends BaseVO<ResourceSortVO> {

    /**
     * 分类名
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String sortName;
    /**
     * 分类介绍
     */
    private String content;

    /**
     * 分类图片UID
     */
    private String fileUid;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 无参构造方法
     */
    ResourceSortVO() {

    }

}
