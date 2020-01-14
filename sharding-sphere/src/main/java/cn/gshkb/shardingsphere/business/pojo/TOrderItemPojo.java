package cn.gshkb.shardingsphere.business.pojo;

import cn.gshkb.shardingsphere.business.pojo.AbstractBasePojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@ApiModel(value = "TOrderItemPojo", description = "订单详情")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TOrderItemPojo extends AbstractBasePojo {

	@ApiModelProperty(value = "主键")
	protected Long id;
	@ApiModelProperty(value = "用ID")
	protected Integer userId;
	@ApiModelProperty(value = "订单ID")
	protected Integer orderId;
	@ApiModelProperty(value = "姓名")
	protected String name;
}