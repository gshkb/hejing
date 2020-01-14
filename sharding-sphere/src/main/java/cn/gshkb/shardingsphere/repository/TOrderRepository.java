package cn.gshkb.shardingsphere.repository;


import cn.gshkb.shardingsphere.business.pojo.TOrderBizPojo;
import cn.gshkb.shardingsphere.business.pojo.TOrderPojo;
import cn.gshkb.shardingsphere.domain.tables.records.TOrderRecord;
import cn.gshkb.shardingsphere.repository.AbstractCRUDRepository;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    public List<TOrderBizPojo> findByJoin() {
        List<Field<?>> fieldsCol = Lists.newArrayList(T_ORDER.fields());
        fieldsCol.add(T_ORDER_ITEM.ID.as("orderItemId"));
        fieldsCol.add(T_ORDER_ITEM.NAME.as("orderItemName"));
        fieldsCol.add(DSL.field("( select count(t_order_item.id) from t_order_item where" +
                " del_flag=0 )", Integer.class).as("count"));
       // String sql = "select  to.id, to.name, ti.name, to.user_name    from t_order to left join t_order_item ti on  to.id = ti.order_id group by to.user_Id";

       return dslContext.select(fieldsCol)
                .from(T_ORDER).leftJoin(T_ORDER_ITEM).on(T_ORDER.ID.eq(T_ORDER_ITEM.ORDER_ID))
                .where(T_ORDER.DEL_FLAG.eq(false).and(T_ORDER_ITEM.DEL_FLAG.eq(false)))
                .groupBy(T_ORDER.USER_ID)
                .orderBy(T_ORDER.ID.desc())
                .limit(1,10)
                .fetchInto(TOrderBizPojo.class);
    }
}
