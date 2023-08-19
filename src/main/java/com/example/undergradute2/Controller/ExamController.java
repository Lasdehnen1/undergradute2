package com.example.undergradute2.Controller;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionAmountException;
import com.example.undergradute2.Service.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/exam/get")
@RestController
public class ExamController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(QuestionAmountException.class)
    public String handlerException(QuestionAmountException e) {
        return e.getMessage();
    }
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

}
