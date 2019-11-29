package cn.gshkb.annotation;

import cn.gshkb.annotation.annotation.MethodAnnotation;
import cn.gshkb.annotation.annotation.PropertyAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMethodAnnotation() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Method method = this.getClass().getMethod("testMethod");
		method.invoke(this.getClass().newInstance());
		Annotation annotation = method.getAnnotation(MethodAnnotation.class);
		System.out.println( ((MethodAnnotation) annotation).name()+"/"+((MethodAnnotation) annotation).type());
	}

	@Test
	public void testPropertyAnnotation() {
		User user = new User();
		Class<? extends User> aClass = user.getClass();
		Field[] fields= aClass.getDeclaredFields();
		for (Field field:fields){
			PropertyAnnotation annotation = field.getAnnotation(PropertyAnnotation.class);
			      System.out.println(annotation.name()+"/"+annotation.value()+"/"+annotation.sort());
		}

	}
    @Test
	@MethodAnnotation(name = "测试",type = MethodAnnotation.TypeEnum.ADD)
	public void testMethod(){
		System.out.println("测试方法注解");
	}
}
