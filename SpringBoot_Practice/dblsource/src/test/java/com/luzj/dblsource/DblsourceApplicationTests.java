package com.luzj.dblsource;

import com.luzj.dblsource.entity.primary.ImageModel;
import com.luzj.dblsource.entity.primary.Person;
import com.luzj.dblsource.entity.secondary.CodeRiver;
import com.luzj.dblsource.repository.primary.ImageRepository;
import com.luzj.dblsource.repository.primary.PersonRepository;
import com.luzj.dblsource.repository.secondary.CodeRiverRepository;
import com.luzj.dblsource.service.ScheduledTasks;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DblsourceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CodeRiverRepository codeRiverRepository;
    @Autowired
    private ScheduledTasks tasks;
    @Autowired
    private ImageRepository imageRepository;

    //    @Test
    public void test() {
        personRepository.save(new Person("湖南", 23, "章邯"));
        personRepository.save(new Person("纽约", 27, "john"));
        personRepository.save(new Person("香港", 43, "张一山"));
        personRepository.save(new Person("北京", 44, "张朝阳"));
        personRepository.save(new Person("深圳", 53, "马化腾"));

        Assert.assertEquals(5, personRepository.findAll().size());

        codeRiverRepository.save(new CodeRiver("area110", "阿姆斯特朗回旋加速过海"));
        Assert.assertEquals(5, codeRiverRepository.findAll().size());
    }

    @Test
    public void findPic() throws IOException {
        for (ImageModel imageModel : imageRepository.findAll()) {
            Files.write(Paths.get("retrieve-dir/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
        }
    }

    @Test
    public void downloadToDataBase() throws IOException {
        String img = "http://222.128.14.106:3780/eventReport/image-c658a275-14b3-4202-940e-50abadbb41b3.jpg";
        int id = imageRepository.findAll().size() + 1;
        String type = img.substring(img.lastIndexOf(".") + 1);
        String name = img.substring(img.lastIndexOf("/") + 1, img.lastIndexOf("."));
        //todo 获取本地路径
        Path path = Paths.get("cache-img/"+name+"."+type);
        String file = path.toString();
        //todo 下载文件
        URL url = new URL(img);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream out = new FileOutputStream(file);
        FileChannel channel = out.getChannel();
        channel.transferFrom(readableByteChannel,0,Long.MAX_VALUE);
        //todo 上传文件
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[in.available()];
        in.read(b);
        ImageModel model = new ImageModel(id, name, type, b);
        imageRepository.save(model);
//        Files.delete(path);
    }


}
