package com.example.undergradute2.Repository;

import com.example.undergradute2.Entity.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
