package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Qualifier("javaQuestionService")
    QuestionService javaQuestionService;
    @Qualifier("mathQuestionService")
    QuestionService mathQuestionService;

    @Autowired
    public void setJavaQuestionService(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Autowired
    public void setMathQuestionService(QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Random r = new Random();
        Set<Question> result = new HashSet<>();
        int javaAmount = r.nextInt(amount);
        int mathAmount = amount - javaAmount;

        result.addAll(getJavaQuestions(javaAmount));
        result.addAll(getMathQuestions(mathAmount));

        return result;
    }
    public Collection<Question> getJavaQuestions(int amount) {
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(javaQuestionService.getRandomQuestion());
        }
        return result;
    }

    public Collection<Question> getMathQuestions(int amount) {
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(mathQuestionService.getRandomQuestion());
        }
        return result;
    }

}
