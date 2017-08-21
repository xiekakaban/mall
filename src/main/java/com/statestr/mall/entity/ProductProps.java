package com.statestr.mall.entity;

import com.statestr.mall.annotation.ExcludeFromJson;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by e604845 on 8/16/2017.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_product_prop")

public class ProductProps extends AbstractEntity {

    @Id
    private String id;

    @Column(name="prop_name")
    private String propName;

    @Column(name="is_limit")
    @Type(type="yes_no")
    private Boolean isLimit;

    @Column(name="limit_props")
    private String limitProps; // split by  #

    @ManyToOne
    @JoinColumn(name="create_by")
    private AdministratorEntity createBy;

    @Column(name="last_modify_time")
    private Date lastModifyTime;

    @ManyToOne
    @ExcludeFromJson
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private CategoryEntity category;


    public ProductProps() {
    }

    public ProductProps(String id, String propName, Boolean isLimit, String limitProps, AdministratorEntity createBy) {
        this.id = id;
        this.propName = propName;
        this.isLimit = isLimit;
        this.limitProps = limitProps;
        this.createBy = createBy;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Boolean getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(Boolean isLimit) {
        this.isLimit = isLimit;
    }

    public String getLimitProps() {
        return limitProps;
    }

    public void setLimitProps(String limitProps) {
        this.limitProps = limitProps;
    }

    public AdministratorEntity getCreateBy() {
        return createBy;
    }

    public void setCreateBy(AdministratorEntity createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
