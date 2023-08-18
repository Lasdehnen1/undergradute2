package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import com.example.undergradute2.Repository.MathQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        mathQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        mathQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!mathQuestionRepository.getAll().contains(question)) {
            throw new QuestionNotFoundException("Такой вопрос не найден");
        }
        for (Question q : mathQuestionRepository.getAll()) {
            if (q.equals(question)) {
                mathQuestionRepository.remove(question);
                return q;
            }
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionArrayList = new ArrayList<>(mathQuestionRepository.getAll());
        Random r = new Random();
        return questionArrayList.get(r.nextInt(mathQuestionRepository.getAll().size()));
    }


}
