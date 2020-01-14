package cn.gshkb.shardingsphere.business.pojo;

import cn.gshkb.shardingsphere.business.pojo.AbstractBasePojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@ApiModel(value = "TOrderPojo", description = "订单")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TOrderPojo extends AbstractBasePojo {

	@ApiModelProperty(value = "主键")
	protected Long id;
	@ApiModelProperty(value = "姓名")
	protected String name;
	@ApiModelProperty(value = "用户id")
	protected Long userId;
}