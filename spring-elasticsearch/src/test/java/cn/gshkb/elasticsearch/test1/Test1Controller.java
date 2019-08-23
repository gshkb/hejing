package cn.gshkb.elasticsearch.test1;

import cn.gshkb.elasticsearch.model.*;
import com.alibaba.fastjson.*;
import org.junit.*;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * 测试整合方案一
 *
 * @author hkb
 * @create 2019-07-30 18:01 v1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class Test1Controller {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("测试方法es1/book")
	public void test() throws Exception {

		Book param = new Book();
		param.setId(1L);
		param.setName("课本一");
		param.setDesc("描述一");
		param.setAuthor("冯嘉人");
		param.setContext("测试文章内容啊 啊啊啊啊啊 啊啊啊啊啊");
		MvcResult mvcResult = mockMvc.perform(
				post("/es/book")
						.contentType(MediaType.APPLICATION_JSON)
						.content(JSON.toJSONString(param)))
				.andReturn();

		System.out.println(mvcResult.getResponse().getContentAsString());
	}

	@Test
	@DisplayName("测试方法es1/book")
	public void test1() throws Exception {

		Book param = new Book();
		param.setId(1L);
		MvcResult mvcResult = mockMvc.perform(
				get("/es/book/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(JSON.toJSONString(param)))
				.andReturn();

		System.out.println(mvcResult.getResponse().getContentAsString());
	}

}
