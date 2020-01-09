package cn.gshkb.hejing.interview.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer Id;

    private String name;

    private Integer count;

    private Boolean aBoolean;
}
