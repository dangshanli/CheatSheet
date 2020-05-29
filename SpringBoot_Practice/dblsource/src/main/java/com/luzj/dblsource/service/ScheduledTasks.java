package com.luzj.dblsource.service;

import com.luzj.dblsource.entity.primary.*;
import com.luzj.dblsource.entity.secondary.EndAffairInfo;
import com.luzj.dblsource.entity.secondary.RegisterAffairInfo;
import com.luzj.dblsource.repository.primary.*;
import com.luzj.dblsource.repository.secondary.EndAffairInfoRepository;
import com.luzj.dblsource.repository.secondary.RegisterAffairInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @author luzj
 * @description: 定时任务，定时每日23点将当日redapp的数据刷到mid库中
 * @date 2018/8/21
 */
@Component
public class ScheduledTasks {
    @Autowired
    private ProcessRunExampleRepository runExampleRepository;
    @Autowired
    private ProcessHistoryRepository historyRepository;
    @Autowired
    private ProcessExampleRepository exampleRepository;
    @Autowired
    private EndAffairInfoRepository endAffairInfoRepository;
    @Autowired
    private RegisterAffairInfoRepository registerAffairInfoRepository;
    @Autowired
    private EventCategoryRepository eventCategoryRepository;
    @Autowired
    private EventLevelRepository eventLevelRepository;
    @Autowired
    private JrjCommunityRepository jrjCommunityRepository;
    @Autowired
    private RedAppImageRepository imageRepository;
    @Autowired
    private UserRepository userRepository;

    public static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final String HEADER = "http://222.128.14.106:3780/";
    public static final String OPERATET_TYPE = "申请条件";

    /*@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.err.println("现在时间:" + sdf.format(new Date()));
    }*/

    //        @Scheduled(cron = "0 0 23 ? * *") //每天 23:00:00 触发
//    @Scheduled(cron = "30 0 5 ? * *")//每天  10:12:30 触发
    public void sayHello() {
//        System.out.println("Hello,现在时间是:" + sdf.format(new Date()));
    }


    public static final String STATUS = "2";
    public static final String STEPID = "000";

    //数据转换
    @Transactional(rollbackFor = {Exception.class})
    @Scheduled(cron = "30 0 5 ? * *")//每天  10:12:30 触发
    public void dataTransfer() {
        //todo 获取今日符合条件的exampleId， step = '000' ,status = 2,为事件上报或者结案上报
        String startTime = sdf2.format(new Date());
        List<String> exampleIds = runExampleRepository.findByStarTimeLikeAndStatusAndStepId(startTime, STATUS, STEPID);
        List<String> pureExamples = new ArrayList<>();
        for (String s : exampleIds) {
            if (s.startsWith("sjsb") || s.startsWith("jasb")) {
                pureExamples.add(s);
            }
        }
        logger.info(pureExamples.toString());

        //todo 获取example实例记录   获取history记录
        List<RedAppProcessExample> processExamples = new ArrayList<>();
        List<RedAppProcessHistory> processHistories = new ArrayList<>();
        for (String s : pureExamples) {
            // 查询example实例
            RedAppProcessExample example = exampleRepository.findByExampleId(s);
            if (example != null)
                processExamples.add(example);
            //查询run实例，只限于104 和 202步骤
            List<String> steps = new ArrayList<>();
            steps.add("104");
            steps.add("202");
            RedAppProcessHistory history = historyRepository.findTopByExampleIdAndStepIdInOrderByEndTimeDesc(s, steps);
            if (history != null)
                processHistories.add(history);
        }

        //todo 转换实体类，his->endAffair , example->registerAffair
        //todo 插入全部的实体类，理论上 his表和run表的条数应该完全一样，一一对应
        if (processExamples.size() > 0) {
            List<RegisterAffairInfo> registerAffairInfos = exampleToRegisterAffair(processExamples);
            registerAffairInfoRepository.saveAll(registerAffairInfos);
        }
        if (processHistories.size() > 0) {
            List<EndAffairInfo> endAffairInfos = historyToEndAffair(processHistories);
            endAffairInfoRepository.saveAll(endAffairInfos);
        }

    }

    /**
     * 根据RedAppProcessExample包装RegisterAffairInfo
     *
     * @param processExamples
     * @return
     */
    private List<RegisterAffairInfo> exampleToRegisterAffair(List<RedAppProcessExample> processExamples) {
        List<RegisterAffairInfo> registerAffairInfos = new ArrayList<>();
        for (RedAppProcessExample ex : processExamples) {
            RegisterAffairInfo register = new RegisterAffairInfo();
            register.setSourceCode(ex.getExampleId());
            register.setDescription(ex.getEventTxt());
            register.setAddress(ex.getAddress());
            register.setOriginId("1");
            register.setCoordX((float) 0.0);
            register.setCoordY((float) 0.0);

            register.setTypeFirstId(ex.getCategoryId());
            String firstName = eventCategoryRepository.findTopByCategoryId(ex.getCategoryId()).getCategoryName();
            register.setTypeFirstName(firstName);
            String secondName = eventCategoryRepository.findTopByBigCategoryId(ex.getBigCategoryId()).getBigCategoryName();
            register.setTypeSecondId(ex.getBigCategoryId());
            register.setTypeSecondName(secondName);

            String thirdName = eventCategoryRepository.findTopBySmallCategoryId(ex.getSmallCategoryId()).getSmallCategoryName();
            String fourthName = eventCategoryRepository.findTopByDetailCategoryId(ex.getDetailCategoryId()).getDetailCategoryName();
            register.setTypeThreeId(ex.getSmallCategoryId());
            register.setTypeFourId(ex.getDetailCategoryId());
            register.setTypeThreeName(thirdName);
            register.setTypeFourName(fourthName);

            String levelName = eventLevelRepository.findByLevelId(ex.getLevelId()).getLevelName();
            register.setLevelId(ex.getLevelId());
            register.setLevelName(levelName);

            register.setStreetId(ex.getJrjId());
            register.setStreetName("金融街");

            String communityName = jrjCommunityRepository.findTopByCommunityId(ex.getCommunityId()).getCommunityName();
            register.setCommunityId(ex.getCommunityId());
            register.setCommunityName(communityName);
            String gridName = jrjCommunityRepository.findTopByGrid(ex.getGrid()).getGridName();
            register.setSmallDutyAreaId(ex.getGrid());
            register.setSmallDutyAreaName(gridName);
            try {
                register.setOccurTime(sdf3.parse(ex.getCreateTime()));
            } catch (ParseException e) {
                logger.debug("日期转格式失败", e);
                e.printStackTrace();
            }
            String u = ex.getUserId();
            RedAppUser user = userRepository.findByUserId(ex.getUserId());
            register.setReporterName(user.getUserName() == null ? null : user.getUserName());
            register.setReporterPhone(user.getUserTel() == null ? null : user.getUserTel());

            //TODO 填充图片附件
            List<RedAppImage> images = imageRepository.findByImageId(ex.getImageId());
            for (int i = 0; i < images.size(); i++) {
                RedAppImage img = images.get(i);
                String imgName = img.getImageName();
                byte[] bytes = null;
                try {
                    bytes = downloadImg(HEADER + img.getImagePath());
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.debug("图片下载出了故障！！！", e);
                }
                if (i == 0) {
                    register.setAttachmentName1(imgName);
                    if (bytes != null && bytes.length > 0)
                        register.setAttachment1(bytes);
                }

                if (i == 1) {
                    register.setAttachmentName2(imgName);
                    if (bytes != null && bytes.length > 0)
                        register.setAttachment2(bytes);
                }
                if (i == 2) {
                    register.setAttachmentName3(imgName);
                    if (bytes != null && bytes.length > 0)
                        register.setAttachment3(bytes);
                }
            }


            registerAffairInfos.add(register);
        }
        return registerAffairInfos;
    }

    /**
     * 根据RedAppProcessHistory包装EndAffairInfo
     *
     * @param processHistories
     * @return
     */
    private List<EndAffairInfo> historyToEndAffair(List<RedAppProcessHistory> processHistories) {
        List<EndAffairInfo> endAffairInfos = new ArrayList<>();
        for (RedAppProcessHistory hi : processHistories) {
            EndAffairInfo end = new EndAffairInfo();
            end.setSourceCode(hi.getExampleId());
            RedAppProcessRunExample runExample = runExampleRepository.findByExampleId(hi.getExampleId());
            try {
                end.setOverTime(sdf3.parse(runExample.getStarTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String userId = hi.getUserId();//科室办理人userId
            RedAppUser user = null;
            if (!StringUtils.isEmpty(userId)) {
                user = userRepository.findByUserId(userId);
            }
            end.setOperateName(user == null ? "王超" : user.getUserName());

            try {
                end.setOperateTime(sdf3.parse(hi.getEndTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            end.setOperatetType(OPERATET_TYPE);
            end.setOperateOpinion(hi.getReviews() == null ? null : hi.getReviews());

            //TODO 填充图片附件
            List<RedAppImage> images = imageRepository.findByImageId(hi.getImageId());
            for (int i = 0; i < images.size(); i++) {
                RedAppImage img = images.get(i);
                String imgName = img.getImageName();
                byte[] bytes = null;
                try {
                    bytes = downloadImg(HEADER + img.getImagePath());
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.debug("图片下载出了故障！！", e);
                }
                if (i == 0) {
                    end.setAttachmentName1(imgName);
                    if (bytes != null && bytes.length > 0)
                        end.setAttachment1(bytes);
                }

                if (i == 1) {
                    end.setAttachmentName2(imgName);
                    if (bytes != null && bytes.length > 0)
                        end.setAttachment2(bytes);
                }
                if (i == 2) {
                    end.setAttachmentName3(imgName);
                    if (bytes != null && bytes.length > 0)
                        end.setAttachment3(bytes);
                }
            }
            endAffairInfos.add(end);
        }
        return endAffairInfos;
    }

    /**
     * 从http协议下载图片文件
     *
     * @param img 文件路径
     * @return
     * @throws IOException
     */
    private byte[] downloadImg(String img) throws IOException {
//        img = "http://222.128.14.106:3780/eventReport/image-c658a275-14b3-4202-940e-50abadbb41b3.jpg";
        String pattern = "^http://222.128.14.106:3780/[\\D\\d-]+\\.(jpg|png|jpeg|bmp)$";
        if (StringUtils.isEmpty(img) || !Pattern.matches(pattern, img)) {
            logger.error("图片地址格式错误！！！");
            return null;
        }
        //todo 下载文件
        URL url = new URL(img);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        InputStream chIn = Channels.newInputStream(readableByteChannel);
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据
        int rc = 0;
        while ((rc = chIn.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] bytes = swapStream.toByteArray(); //in_b为转换之后的结果
        return bytes;
    }

    public static void main(String[] args) {
        try {
            Date d = sdf3.parse("2018/08/22 23:22:13");
            System.out.println(d);
            String img = "http://222.128.14.106:3780/eventReport/image-c658a275-14b3-4202-940e-50abadbb41b3.jpg";
            String pattern = "^http://222.128.14.106:3780/[\\D\\d-]+\\.(jpg|png|jpeg|bmp)$";
            boolean s = Pattern.matches(pattern, img);
            System.out.println(s);
            List<String> list = new ArrayList<>();
            list.add(null);
            list.add(null);
            System.out.println(list.size());
            System.out.println(list.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
