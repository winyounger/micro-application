package com.supconit.dao.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CollectDo {

    private Long id;
    private String openid;
    private Long courseId;
    private Integer courseType;

}
