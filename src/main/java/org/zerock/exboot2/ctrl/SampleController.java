package org.zerock.exboot2.ctrl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SampleController
 * - thymeleaf 동작을 위한 컨트롤러
 *
 * @author 류지헌
 * @created 2022-04-10
 */
@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    
    @GetMapping("/ex1")
    public void getEx1() {
        log.info("ex1..............."); // 컨트롤러 동작을 확인하기 위한 로깅
    }
}
