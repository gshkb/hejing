package cn.gshkb.trasaction.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

import java.sql.*;

/**
 * @author hkb
 * @create 2019-04-30 16:37 v1.0
 **/
@Aspect
@Component
public class DataSourceAspect {

	//@Around("execution(* javax.sql.DataSource.getConnection(..))")
	/*public Connection around() {

	}*/
}
