package cn.gshkb.springbootaop.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * 测试Controller
 *
 * @author hkb
 * @create 2019-04-23 11:57 v1.0
 **/

@Controller
public class TestController {

	@RequestMapping("/test1")
	@ResponseBody
	public void test(){

	}

}
