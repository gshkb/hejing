package cn.gshkb.elasticsearch.model;

import java.io.*;

/**
 * @author hkb
 * @create 2019-07-19 16:35 v1.0
 **/
public class Author implements Serializable {
    /**
     * 作者ID
     */
    private Long id;
    /**
     * 作者姓名
     */
    private String name;
    /**
     * 作者简介
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}