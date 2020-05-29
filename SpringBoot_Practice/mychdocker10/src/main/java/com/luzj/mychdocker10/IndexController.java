package com.luzj.mychdocker10;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luzj
 * @description:
 * @date 2018/7/27
 */
@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "hello docker 3";
    }

    @RequestMapping("/tips")
    public String tips(){
        return "是莉娜呀!!!";
    }
}
