package cn.gshkb.elasticsearch.model;

import java.io.*;

/**
 * @author hkb
 * @create 2019-07-19 16:36 v1.0
 **/
public class Tutorial implements Serializable {
    private Long id;
    //教程名称
    private String name;

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
}