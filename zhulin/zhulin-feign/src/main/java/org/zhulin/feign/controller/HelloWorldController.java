package org.zhulin.feign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zhulin.feign.service.SchedualServiceHi;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * json 接口开发 spring boot只需要类添加 @RestController 即可 默认类中的方法都会以json的格式返回
 */
@RestController
public class HelloWorldController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne( name );
    }

}
