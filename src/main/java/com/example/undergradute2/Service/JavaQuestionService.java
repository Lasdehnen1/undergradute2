package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import com.example.undergradute2.Repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        javaQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!javaQuestionRepository.getAll().contains(question)) {
            throw new QuestionNotFoundException("Такой вопрос не найден");
        }
        for (Question q : javaQuestionRepository.getAll()) {
            if (q.equals(question)) {
                javaQuestionRepository.remove(question);
                return q;
            }
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionArrayList = new ArrayList<>(javaQuestionRepository.getAll());
        Random r = new Random();
        return questionArrayList.get(r.nextInt(javaQuestionRepository.getAll().size()));
    }
}
