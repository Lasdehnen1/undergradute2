package com.example.undergradute2.Controller;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import com.example.undergradute2.Service.JavaQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/exam/")
@RestController
public class JavaQuestionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(QuestionNotFoundException.class)
    public String handlerException(QuestionNotFoundException e) {
        return e.getMessage();
    }
    private final JavaQuestionService javaQuestionService;
    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    @GetMapping("/java/")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
