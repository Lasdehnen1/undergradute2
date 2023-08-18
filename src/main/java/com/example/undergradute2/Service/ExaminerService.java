package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
