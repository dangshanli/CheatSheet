package com.luzj.dblsource.entity.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luzj
 * @description: secondary数据库 测试实体类
 * @date 2018/8/20
 */
@Entity
@Table(name = "code_river")
public class CodeRiver {
    @Id
    @Column(name = "river_id")
    private String id;

    @Column(name = "river_desc")
    private String riverDesc;

    @Override
    public String toString() {
        return "CodeRiver{" +
                "id='" + id + '\'' +
                ", riverDesc='" + riverDesc + '\'' +
                '}';
    }

    public CodeRiver(String id, String riverDesc) {
        this.id = id;
        this.riverDesc = riverDesc;
    }

    public CodeRiver() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRiverDesc() {
        return riverDesc;
    }

    public void setRiverDesc(String riverDesc) {
        this.riverDesc = riverDesc;
    }
}
