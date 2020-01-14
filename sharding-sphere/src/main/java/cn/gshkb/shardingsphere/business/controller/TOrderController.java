package cn.gshkb.shardingsphere.business.controller;


import cn.gshkb.shardingsphere.business.pojo.TOrderBizPojo;
import cn.gshkb.shardingsphere.business.pojo.TOrderPojo;
import cn.gshkb.shardingsphere.common.ResultDo;
import cn.gshkb.shardingsphere.domain.tables.TOrder;
import cn.gshkb.shardingsphere.service.TOrderService;

import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/tOrder")
@Api(value = "tOrder", description = "订单")
public class TOrderController  {

    @Autowired
    private TOrderService tOrderService;



    @ApiOperation(value = "订单列表", notes = "对应权限项:tOrder:indexPage, url后跟&page=0&size=10&sort=排序字段,desc/asc")
    @RequestMapping(value = "indexPage", method = RequestMethod.GET)
    @RequiresPermissions("tOrder:indexPage")
    @ResponseBody
    public ResultDo<Page> indexPage(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
                                    ,TOrderPojo pojo) {
        ResultDo<Page> resultDo = ResultDo.build();
        Collection<Condition> collections = Lists.newArrayList();
        collections.add(TOrder.T_ORDER.ID.eq(pojo.getId()));
        Page<TOrderPojo> page =tOrderService.findbyPageAndCondition(pageable, collections);
        resultDo.setResult(page);
        return resultDo;
    }


    @ApiOperation(value = "订单查看", notes = "对应权限项:tOrder:view")
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    @RequiresPermissions("tOrder:view")
    @ResponseBody
    public ResultDo<TOrderPojo> view(@PathVariable Long id){
        ResultDo<TOrderPojo> resultDo = ResultDo.build();
        TOrderPojo pojo = tOrderService.findById(id);
        if(pojo == null){
         resultDo.setErrorCode( "error");
        }else{
         resultDo.setResult(pojo);
        }
        return resultDo;
    }


    @ApiOperation(value = "订单新增", notes = "对应权限项:tOrder:create")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresPermissions("tOrder:create")
    @ResponseBody
    public ResultDo<TOrderPojo> create( @Valid @RequestBody TOrderPojo pojo){
        ResultDo<TOrderPojo> resultDo = ResultDo.build();
        pojo = tOrderService.insert(pojo);
        resultDo.setResult(pojo);
        return resultDo;
    }


    @ApiOperation(value = "订单修改", notes = "对应权限项:tOrder:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("tOrder:update")
    @ResponseBody
    public ResultDo<TOrderPojo>  update(@Valid @RequestBody TOrderPojo pojo){
        ResultDo<TOrderPojo> resultDo = ResultDo.build();
        pojo = tOrderService.update(pojo);
        resultDo.setResult(pojo);
        return resultDo;
    }

    @ApiOperation(value = "订单删除", notes = "对应权限项:tOrder:delete")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @RequiresPermissions("tOrder:delete")
    @ResponseBody
    public ResultDo delete(@PathVariable Long id){
        ResultDo resultDo = ResultDo.build();
        tOrderService.delete(id);
        return resultDo;
    }

    @ApiOperation(value = "分组连表查询", notes = "对应权限项:tOrder:delete")
    @RequestMapping(value = "findByJoin", method = RequestMethod.GET)
    @RequiresPermissions("tOrder:delete")
    @ResponseBody
    public ResultDo findByJoin(){
        ResultDo resultDo = ResultDo.build();
        List<TOrderBizPojo>list = tOrderService.findByJoin();
        resultDo.setResult(list);
        return resultDo;
    }
}
