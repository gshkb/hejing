package cn.gshkb.shardingsphere.repository;


import cn.gshkb.shardingsphere.business.pojo.TOrderItemPojo;
import cn.gshkb.shardingsphere.domain.tables.records.TOrderItemRecord;
import cn.gshkb.shardingsphere.repository.AbstractCRUDRepository;

import lombok.extern.slf4j.Slf4j;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static cn.gshkb.shardingsphere.domain.Tables.*;
/**
 * 订单详情
 */
@Slf4j
@Repository
public class TOrderItemRepository extends AbstractCRUDRepository<TOrderItemRecord, Long, TOrderItemPojo> {

    @Autowired
    public TOrderItemRepository(DSLContext dslContext) {
        super(dslContext, T_ORDER_ITEM, T_ORDER_ITEM.ID, TOrderItemPojo.class);
    }
}
