package com.luzj.dblsource;

import com.luzj.dblsource.entity.primary.RedAppImage;
import com.luzj.dblsource.entity.primary.RedAppProcessExample;
import com.luzj.dblsource.entity.primary.RedAppProcessHistory;
import com.luzj.dblsource.entity.primary.RedAppUser;
import com.luzj.dblsource.repository.primary.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2018/8/29
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class RepositoryTest {
    @Autowired
    ProcessRunExampleRepository runExampleRepository;
    @Autowired
    ProcessExampleRepository exampleRepository;
    @Autowired
    ProcessHistoryRepository historyRepository;
    @Autowired
    EventCategoryRepository categoryRepository;
    @Autowired
    EventLevelRepository levelRepository;
    @Autowired
    JrjCommunityRepository communityRepository;
    @Autowired
    RedAppImageRepository imageRepository;
    @Autowired
    UserRepository userRepository;



//    @Test
    public void test() {
        /*List<String> exampleIds = runExampleRepository.
                findByStarTimeLikeAndStatusAndStepId("2018/08/28", "2", "000");
        System.out.println(exampleIds);*/

        /*RedAppProcessExample example = exampleRepository.findByExampleId("jasb20180828191637978");
        System.err.println(example);*/

       /* List<String> steps = new ArrayList<>();
        steps.add("104");
        steps.add("202");
        String s = "jasb20180828191637978";
        RedAppProcessHistory history = historyRepository.findByExampleIdAndStepIdIn(s, steps);
        System.out.println(history);*/

     /*   String firstName = categoryRepository.findTopByCategoryId("10").getCategoryName();
        String secondName = categoryRepository.findTopByBigCategoryId("20002").getBigCategoryName();
        System.out.println(firstName);
        System.out.println(secondName);*/

        /*String levelName = levelRepository.findByLevelId("01").getLevelName();
        System.out.println(levelName);*/

        /*String communityName =communityRepository.findTopByCommunityId("110102011001").getCommunityName();
        String gridName = communityRepository.findTopByGrid("110102011012001").getGridName();
        System.out.println(communityName);
        System.out.println(gridName);*/

        /*RedAppUser user = userRepository.findByUserId("115");
        System.out.println(user);*/
        List<RedAppImage> images = imageRepository.findByImageId("img20180904090522269");
        System.out.println(images);
    }
//    @Test
    public void testUser(){
        RedAppUser u = userRepository.findByUserId("06");
        System.out.println(u.getUserName());
        System.out.println(u.getUserTel());
    }
}
