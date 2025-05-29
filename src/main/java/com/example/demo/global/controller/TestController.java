package com.example.demo.global.controller;

import com.example.demo.global.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    /*@GetMapping("/error")
    public String throwError() {
        throw new CustomException("이건 사용자 정의 예외야");
    }

    @GetMapping("/runtime")
    public String throwRuntimeError() {
        throw new RuntimeException("이건 일반 런타임 예외야!");
    }*/

    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html
    }

    // 예외 강제 발생
    @GetMapping("/test/error")
    public String throwError() {
        throw new CustomException("테스트용 사용자 정의 예외입니다.");
    }

    // 또 다른 예외도 추가 가능
    @GetMapping("/test/null")
    public String throwNullPointer() {
        String x = null;
        x.length(); // NullPointerException 강제 발생
        return "index";
    }

    // 404 강제 유도 (없는 페이지로 리다이렉트)
    @GetMapping("/test/404")
    public String force404() {
        return "redirect:/없는페이지";
    }

    // 500 강제 유도 (Exception 발생)
    @GetMapping("/test/500")
    public String force500() {
        throw new RuntimeException("강제로 발생시킨 500 서버 에러입니다.");
    }
}
