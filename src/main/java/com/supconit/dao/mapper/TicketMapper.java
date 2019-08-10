package com.supconit.dao.mapper;

import com.supconit.dao.domain.TicketDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TicketMapper {

    TicketDo getTicketById(@Param("id") long id);

    int updateById(TicketDo ticketDo);
}
