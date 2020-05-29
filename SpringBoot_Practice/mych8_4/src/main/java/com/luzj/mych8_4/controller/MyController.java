package com.luzj.mych8_4.controller;

import com.luzj.mych8_4.domain.Person;
import com.luzj.mych8_4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luzj
 * @description:
 * @date 2018/7/13
 */
@RestController
public class MyController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/roll")
    public Person rollback(Person person){
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/noRoll")
    public Person noRollBack(Person person){
        return demoService.savePersonWithoutRollBack(person);
    }
}
