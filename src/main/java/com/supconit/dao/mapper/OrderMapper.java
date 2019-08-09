package com.supconit.dao.mapper;

import com.supconit.dao.domain.OrderDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int creatOrder(OrderDo orderDo);
}
