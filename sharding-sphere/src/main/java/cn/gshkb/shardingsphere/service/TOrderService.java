package cn.gshkb.shardingsphere.service;


import cn.gshkb.shardingsphere.business.pojo.TOrderBizPojo;
import cn.gshkb.shardingsphere.business.pojo.TOrderPojo;
import cn.gshkb.shardingsphere.repository.TOrderRepository;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static cn.gshkb.shardingsphere.domain.Tables.*;
/**
 * 订单
 */
@Slf4j
@Service
public class TOrderService  {

    @Autowired
    private TOrderRepository tOrderRepository;



     public Page<TOrderPojo> findbyPageAndCondition(Pageable pageable, Collection<? extends Condition> condition) {
         return  tOrderRepository.findByPageable(pageable, condition);
}


    public TOrderPojo findById(Long id){
        return tOrderRepository.fetchOne(T_ORDER.ID,id);
    }
    public TOrderPojo insert(TOrderPojo pojo){
        pojo.setDelFlag(false);
        pojo = tOrderRepository.insert(pojo);
        log.info("新增订单成功。{}。", pojo.toString());
        return pojo;
    }
    public TOrderPojo update(TOrderPojo pojo){
        TOrderPojo dbPojo = this.findById(pojo.getId());
        if(dbPojo==null){
         return null;}
        tOrderRepository.update(dbPojo);
        log.info("修改订单成功。{}。", dbPojo.toString());
        return dbPojo;
    }
    public void delete(Long id){
        TOrderPojo dbPojo = this.findById(id);
        dbPojo.setDelFlag(true);
        tOrderRepository.update(dbPojo);
        log.info("删除订单成功。{}。", dbPojo.toString());
    }

    /**
     * 分组连表查询
     * @return
     */
    public List<TOrderBizPojo> findByJoin() {
        List<TOrderBizPojo> list = new ArrayList<>();
        try{
            list= tOrderRepository.findByJoin();
        }catch (Exception e){
            log.error("分组连表查询异常",e);
        }
      return  list;
    }
}
