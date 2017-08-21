package com.statestr.mall.entity;

import com.statestr.mall.annotation.ExcludeFromJson;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by e604845 on 8/16/2017.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_category")
public class CategoryEntity extends AbstractEntity {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="title")
    private String title;

    @Column(name="banner")
    private String banner;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="create_by",referencedColumnName = "id")
    private AdministratorEntity createBy;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
    private Set<ProductProps> productProps;

    @Column(name="last_modify_time")
    private Date lastModifyTime;

    public CategoryEntity() {
    }

    public CategoryEntity(String id, String title, AdministratorEntity createBy, Set<ProductProps> productProps) {
        this.id = id;
        this.title = title;
        this.createBy = createBy;
        this.productProps = productProps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public AdministratorEntity getCreateBy() {
        return createBy;
    }

    public void setCreateBy(AdministratorEntity createBy) {
        this.createBy = createBy;
    }

    public Set<ProductProps> getProductProps() {
        return productProps;
    }

    public void setProductProps(Set<ProductProps> productProps) {
        this.productProps = productProps;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
