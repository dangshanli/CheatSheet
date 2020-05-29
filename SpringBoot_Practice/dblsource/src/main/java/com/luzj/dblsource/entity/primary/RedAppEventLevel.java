package com.luzj.dblsource.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
@Entity
@Table(name = "redAppEventLevel")
public class RedAppEventLevel {
    @Id
    private String levelId;
    private String levelName;

    public RedAppEventLevel(String levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public RedAppEventLevel() {
    }

    @Override
    public String toString() {
        return "RedAppEventLevel{" +
                "levelId='" + levelId + '\'' +
                ", levelName='" + levelName + '\'' +
                '}';
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
