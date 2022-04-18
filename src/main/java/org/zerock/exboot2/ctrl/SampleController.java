package org.zerock.exboot2.ctrl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.exboot2.dto.SampleDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @GetMapping({"/ex2", "/exLink"})
    public void getEx2Model(Model model) {
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().
                mapToObj(i -> {
                    SampleDTO sampleDTO = SampleDTO.builder()
                            .sno(i)
                            .first("First : "+i)
                            .last("Last : "+i)
                            .regTime(LocalDateTime.now())
                            .build();
                    return sampleDTO;
                }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){
        log.info("exInline..............");

        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First : 100")
                .last("Last : 100")
                .regTime(LocalDateTime.now())
                .build();
        
        // RedirectAttributes를 이용하여 result와 dto라는 이름의 데이터를 심어 전달
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public void getEx3(){
        log.info("ex3..............");
    }

    @GetMapping({"/exLayout1", "/exLayout2"})
    public void exLayout1() {
        log.info("exLayout..............");
    }



}
