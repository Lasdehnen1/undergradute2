package com.example.undergradute2.Repository;

import com.example.undergradute2.Entity.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
@Repository
public class MathQuestionRepository implements QuestionRepository {
    Set<Question> questions = new HashSet<>();

    @PostConstruct
    void init() {
        questions.add(new Question("MathQuestion1", "Answer1"));
        questions.add(new Question("MathQuestion2", "Answer2"));
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public  Question remove(Question question) {
        for (Question q : questions) {
            if (q.equals(question)) {
                questions.remove(question);
            }
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }


}
