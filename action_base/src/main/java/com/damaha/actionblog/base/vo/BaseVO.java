package com.damaha.actionblog.base.vo;

import com.damaha.actionblog.base.validator.annotion.IdValid;
import com.damaha.actionblog.base.validator.group.Delete;
import com.damaha.actionblog.base.validator.group.Update;
import lombok.Data;


/**
 * @author Dabu9
 * @Date 2023/10/23 21:04
 * view object 表现层 基类对象
 */
@Data
public class BaseVO<T> extends PageInfo<T> {

    /**
     * 唯一UID
     */
    @IdValid(groups = {Update.class, Delete.class})
    private String uid;

    private Integer status;
}
