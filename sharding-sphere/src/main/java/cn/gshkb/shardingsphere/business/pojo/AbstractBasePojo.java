package cn.gshkb.shardingsphere.business.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by hkb on 2016/12/10.
 */
public abstract class AbstractBasePojo implements Serializable {
  /*  *//**
     * 获取messageSource的消息
     *
     * @param code
     * @return //
     *//*
    protected static String messageSource(String code) {
        return SpringUtil.getBean(MessageSource.class).getMessage(code, null, code, null);
    }

    *//**
     * 获取messageSource的消息
     *
     * @param code
     * @return
     *//*
    protected static String messageSource(String code, Object[] objects) {
        return SpringUtil.getBean(MessageSource.class).getMessage(code, objects, code, null);
    }
*/


    @JsonIgnore
    protected Timestamp createAt;
    @JsonIgnore
    protected Timestamp updateAt;
    @JsonIgnore
    protected Boolean delFlag;
    @JsonIgnore
    protected Long version;



    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}