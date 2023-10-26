package com.damaha.actionblog.picture.vo;

import com.damaha.actionblog.base.vo.BaseVO;
import lombok.Data;

/**
 * @author Dabu9
 * @Date 2023/10/23 21:09
 * 
 */
@Data
public class StorageVO extends BaseVO<StorageVO> {

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 存储大小
     */
    private long storagesize;
}
