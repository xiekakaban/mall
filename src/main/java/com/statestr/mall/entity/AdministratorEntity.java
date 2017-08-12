package com.statestr.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by e604845 on 8/12/2017.
 */
@Entity
@Table(name="tb_administrator")
public class AdministratorEntity {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="username")
    private String username;

    @Column(name="pwd")
    private String pwd;

    @Column(name="avator")
    private String avator;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="extern_info")
    private String externInfo;

    public AdministratorEntity() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExternInfo() {
        return externInfo;
    }

    public void setExternInfo(String externInfo) {
        this.externInfo = externInfo;
    }
}
