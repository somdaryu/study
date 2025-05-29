package com.example.demo.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    /*@ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
        return new ResponseEntity<>("서버 오류가 발생했습니다:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(CustomException.class)
    public ModelAndView handleCustomException(CustomException ex) {
        ModelAndView mav = new ModelAndView("custom-error"); // templates/custom-error.html
        mav.addObject("message", ex.getMessage());
        mav.addObject("redirectUrl", "/");
        mav.addObject("delay", 3); // 3초 뒤 이동
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex) {
        ModelAndView mav = new ModelAndView("custom-error");
        mav.addObject("message", "예기치 못한 오류가 발생했습니다: " + ex.getMessage());
        mav.addObject("redirectUrl", "/");
        mav.addObject("delay", 5);
        return mav;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handle404(NoHandlerFoundException ex) {
        ModelAndView mav = new ModelAndView("custom-error");
        mav.addObject("message", "존재하지 않는 페이지입니다. 입력한 주소를 다시 확인해주세요.");
        mav.addObject("redirectUrl", "/");
        mav.addObject("delay", 5);
        return mav;
    }

}
