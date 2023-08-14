package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionAmountException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new QuestionAmountException("Количество не может быть меньше 1");
        }
        if (amount > javaQuestionService.getAll().size()) {
            throw new QuestionAmountException("Такого количества вопросов не существует");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(javaQuestionService.getRandomQuestion());
        }
        return result;
    }


}
