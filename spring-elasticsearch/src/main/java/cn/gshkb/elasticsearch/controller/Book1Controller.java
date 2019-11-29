package cn.gshkb.elasticsearch.controller;

import cn.gshkb.elasticsearch.model.*;
import org.elasticsearch.action.delete.*;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.*;
import org.elasticsearch.action.update.*;
import org.elasticsearch.client.transport.*;
import org.elasticsearch.common.xcontent.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @deprecated 方式1整合
 * @author hkb
 * @create 2019-07-30 17:44 v1.0
 **/
@RestController
@RequestMapping("/es")
public class Book1Controller {
	@Autowired
	private TransportClient client;

	@RequestMapping(value = "/go")
	public String go() {
		return "go1";
	}

	/**
	 * 根据id查询
	 *
	 * @param id book id
	 */
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> get(@RequestParam("id") String id) {
		GetResponse result = client.prepareGet("book", "novel", id).get();
		return new ResponseEntity<>(result.getSource(), HttpStatus.OK);
	}

	/**
	 * 添加文档
	 *
	 * @param id   book id
	 * @param name book name
	 */
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestParam("id") String id, @RequestParam("name") String name) {
		try {
			// 构造ES的文档，这里注意startObject()开始构造，结束构造一定要加上endObject()
			XContentBuilder content = XContentFactory.jsonBuilder().startObject().
					field("id", id)
					.field("name", name)
					.endObject();
			IndexResponse result = client.prepareIndex("book", "novel")
					.setSource(content).get();
			return new ResponseEntity<>(result.getId(), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据id删除book
	 * @param id book id
	 */
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
		DeleteResponse result = client.prepareDelete("book", "novel", id).get();
		return new ResponseEntity<>(result.getResult().toString(), HttpStatus.OK);
	}

	/**
	 * 更新文档，这里的Book可以不管他，这样做是为了解决PUT请求的问题，随便搞
	 */
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> update(String name,Long id) {
		Book book = new Book();
		book.setId(id);

		System.out.println(book);
		// 根据id查询
		UpdateRequest updateRequest = new UpdateRequest("book", "novel", book.getId().toString());
		try {
			XContentBuilder contentBuilder = XContentFactory.jsonBuilder().startObject();
			if (!StringUtils.isEmpty(name)) {
				contentBuilder.field("name", name);
			}
			contentBuilder.endObject();
			updateRequest.doc(contentBuilder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 进行更新
		UpdateResponse updateResponse = new UpdateResponse();
		try {
			updateResponse = client.update(updateRequest).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(updateResponse.getResult().toString(), HttpStatus.OK);
	}

}
