package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppJrjCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
public interface JrjCommunityRepository extends JpaRepository<RedAppJrjCommunity,String> {
    RedAppJrjCommunity findTopByCommunityId(String communityId);
    RedAppJrjCommunity findTopByGrid(String grid);
}
