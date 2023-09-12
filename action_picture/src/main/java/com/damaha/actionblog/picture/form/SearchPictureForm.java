package com.damaha.actionblog.picture.form;

import com.damaha.actionblog.base.vo.FileVO;
import lombok.Data;

@Data
public class SearchPictureForm extends FileVO {
    private String searchKey;
    private Integer count;
}
