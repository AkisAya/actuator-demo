package me.aki.demo.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author akis on 2020/2/14
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService service;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/recommend")
    public String recommend() {
        try {
            return service.recommend();
        } catch (Exception e) {
            return "error";
        }
    }
}
