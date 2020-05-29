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
@Table(name = "redAppJrjCommunity")
public class RedAppJrjCommunity {
    @Id
    private String grid;
    private String jrjId;
    private String communityId;
    private String communityName;
    private String gridName;
    private String gridRange;

    public RedAppJrjCommunity(String grid, String jrjId, String communityId, String communityName, String gridName, String gridRange) {
        this.grid = grid;
        this.jrjId = jrjId;
        this.communityId = communityId;
        this.communityName = communityName;
        this.gridName = gridName;
        this.gridRange = gridRange;
    }

    public RedAppJrjCommunity() {
    }

    @Override
    public String toString() {
        return "RedAppJrjCommunity{" +
                "grid='" + grid + '\'' +
                ", jrjId='" + jrjId + '\'' +
                ", communityId='" + communityId + '\'' +
                ", communityName='" + communityName + '\'' +
                ", gridName='" + gridName + '\'' +
                ", gridRange='" + gridRange + '\'' +
                '}';
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getJrjId() {
        return jrjId;
    }

    public void setJrjId(String jrjId) {
        this.jrjId = jrjId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public String getGridRange() {
        return gridRange;
    }

    public void setGridRange(String gridRange) {
        this.gridRange = gridRange;
    }
}
