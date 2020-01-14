package cn.gshkb.shardingsphere.business.pojo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TOrderBizPojo extends TOrderPojo{
    private Long orderItemId;
    private String orderItemName;
    private Integer count;
}
