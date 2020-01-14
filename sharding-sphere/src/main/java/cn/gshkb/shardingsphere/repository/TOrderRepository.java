package cn.gshkb.shardingsphere.repository;


import cn.gshkb.shardingsphere.business.pojo.TOrderPojo;
import cn.gshkb.shardingsphere.domain.tables.records.TOrderRecord;
import cn.gshkb.shardingsphere.repository.AbstractCRUDRepository;

import lombok.extern.slf4j.Slf4j;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static cn.gshkb.shardingsphere.domain.Tables.*;
/**
 * 订单
 */
@Slf4j
@Repository
public class TOrderRepository extends AbstractCRUDRepository<TOrderRecord, Long, TOrderPojo> {

    @Autowired
    public TOrderRepository(DSLContext dslContext) {
        super(dslContext, T_ORDER, T_ORDER.ID, TOrderPojo.class);
    }
}
