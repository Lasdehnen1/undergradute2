package com.example.undergradute2.Controller;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import com.example.undergradute2.Service.MathQuestionService;
import com.example.undergradute2.Service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/exam/")
@RestController
public class MathQuestionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(QuestionNotFoundException.class)
    public String handlerException(QuestionNotFoundException e) {
        return e.getMessage();
    }
    @Qualifier("mathQuestionService")
    QuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/math/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/math/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return mathQuestionService.remove(new Question(question, answer));
    }

    @GetMapping("/math/")
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
