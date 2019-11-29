package cn.gshkb.annotation;

import cn.gshkb.annotation.annotation.PropertyAnnotation;
import lombok.Data;

/**
 * @author hkb
 * @create 2019-08-22 16:12 v1.0
 **/
@Data
public class User {

	@PropertyAnnotation(name = "姓名",value = "张三",sort = 0)
	private String name;
	@PropertyAnnotation(name = "年龄",value = "18",sort = 1)
	private Integer age;
}
