package cn.gshkb.shardingsphere.service;


import cn.gshkb.shardingsphere.business.pojo.TOrderItemPojo;
import cn.gshkb.shardingsphere.repository.TOrderItemRepository;

import java.util.Collection;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static cn.gshkb.shardingsphere.domain.Tables.*;/**
 * 订单详情
 */
@Slf4j
@Service
public class TOrderItemService  {

    @Autowired
    private TOrderItemRepository tOrderItemRepository;



     public Page<TOrderItemPojo> findbyPageAndCondition(Pageable pageable, Collection<? extends Condition> condition) {
         return  tOrderItemRepository.findByPageable(pageable, condition);
}


    public TOrderItemPojo findById(Long id){
        return tOrderItemRepository.fetchOne(T_ORDER_ITEM.ID,id);
    }
    public TOrderItemPojo insert(TOrderItemPojo pojo){
        pojo.setDelFlag(false);
        pojo = tOrderItemRepository.insert(pojo);
        log.info("新增订单详情成功。{}。", pojo.toString());
        return pojo;
    }
    public TOrderItemPojo update(TOrderItemPojo pojo){
        TOrderItemPojo dbPojo = this.findById(pojo.getId());
        if(dbPojo==null){
         return null;}
        tOrderItemRepository.update(dbPojo);
        log.info("修改订单详情成功。{}。", dbPojo.toString());
        return dbPojo;
    }
    public void delete(Long id){
        TOrderItemPojo dbPojo = this.findById(id);
        dbPojo.setDelFlag(true);
        tOrderItemRepository.update(dbPojo);
        log.info("删除订单详情成功。{}。", dbPojo.toString());
    }
}
