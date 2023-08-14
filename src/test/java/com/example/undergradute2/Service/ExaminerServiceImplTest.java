package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {



    private final JavaQuestionService questionService = mock(JavaQuestionService.class);

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Set<Question> questions = new LinkedHashSet<>();
        Question q1 = new Question("Question1", "Answer1");
        Question q2 = new Question("Question2", "Answer2");
        questions.add(q1);
        questions.add(q2);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(q2);
        Collection<Question> expected = Set.of(q2);
        Collection <Question> actual = examinerService.getQuestions(1);

        assertEquals(expected, actual);


    }
}