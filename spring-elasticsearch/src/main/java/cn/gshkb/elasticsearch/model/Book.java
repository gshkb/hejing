package cn.gshkb.elasticsearch.model;

/**
 * testModel
 *
 * @author hkb
 * @create 2019-07-30 17:48 v1.0
 **/

public class Book {

    private Long id;
    private String name;
    private String desc;
    private String context;
    private String author;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
