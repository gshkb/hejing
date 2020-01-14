package cn.gshkb.shardingsphere.business.controller;


import cn.gshkb.shardingsphere.business.pojo.TOrderItemPojo;
import cn.gshkb.shardingsphere.common.ResultDo;
import cn.gshkb.shardingsphere.service.TOrderItemService;

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
 * 订单详情
 */
@Slf4j
@RestController
@RequestMapping("/tOrderItem")
@Api(value = "tOrderItem", description = "订单详情")
public class TOrderItemController  {

    @Autowired
    private TOrderItemService tOrderItemService;



    @ApiOperation(value = "订单详情列表", notes = "对应权限项:tOrderItem:indexPage, url后跟&page=0&size=10&sort=排序字段,desc/asc")
    @RequestMapping(value = "indexPage", method = RequestMethod.GET)
    @RequiresPermissions("tOrderItem:indexPage")
    @ResponseBody
    public ResultDo<Page> indexPage(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        ResultDo<Page> resultDo = ResultDo.build();
        Collection<Condition> collections = Lists.newArrayList();
        Page<TOrderItemPojo> page =tOrderItemService.findbyPageAndCondition(pageable, collections);
        resultDo.setResult(page);
        return resultDo;
    }


    @ApiOperation(value = "订单详情查看", notes = "对应权限项:tOrderItem:view")
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    @RequiresPermissions("tOrderItem:view")
    @ResponseBody
    public ResultDo<TOrderItemPojo> view(@PathVariable Long id){
        ResultDo<TOrderItemPojo> resultDo = ResultDo.build();
        TOrderItemPojo pojo = tOrderItemService.findById(id);
        if(pojo == null){
         resultDo.setErrorCode( "error");
        }else{
         resultDo.setResult(pojo);
        }
        return resultDo;
    }


    @ApiOperation(value = "订单详情新增", notes = "对应权限项:tOrderItem:create")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresPermissions("tOrderItem:create")
    @ResponseBody
    public ResultDo<TOrderItemPojo> create( @Valid @RequestBody TOrderItemPojo pojo){
        ResultDo<TOrderItemPojo> resultDo = ResultDo.build();
        pojo = tOrderItemService.insert(pojo);
        resultDo.setResult(pojo);
        return resultDo;
    }


    @ApiOperation(value = "订单详情修改", notes = "对应权限项:tOrderItem:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("tOrderItem:update")
    @ResponseBody
    public ResultDo<TOrderItemPojo>  update(@Valid @RequestBody TOrderItemPojo pojo){
        ResultDo<TOrderItemPojo> resultDo = ResultDo.build();
        pojo = tOrderItemService.update(pojo);
        resultDo.setResult(pojo);
        return resultDo;
    }
    @ApiOperation(value = "订单详情删除", notes = "对应权限项:tOrderItem:delete")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @RequiresPermissions("tOrderItem:delete")
    @ResponseBody
    public ResultDo delete(@PathVariable Long id){
        ResultDo resultDo = ResultDo.build();
        tOrderItemService.delete(id);
        return resultDo;
    }
}
