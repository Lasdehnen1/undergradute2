package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {



    private final JavaQuestionService questionService = mock(JavaQuestionService.class);
    private final MathQuestionService mathQuestionService = mock(MathQuestionService.class);

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {


        Question question = new Question("JavaQuestion1", "Answer1");
        Question question2 = new Question("MathQuestion2", "Answer2");
        Set<Question> expected1 = new HashSet<>(Set.of(
                new Question("JavaQuestion1", "Answer1"),
                new Question("MathQuestion2", "Answer2")
        ));

        when(questionService.getRandomQuestion()).thenReturn(question);
        when(mathQuestionService.getRandomQuestion()).thenReturn(question2);
        Collection<Question> actual = examinerService.getQuestions(2);
        assertThat(Objects.equals(expected1, actual)).isTrue();

    }


}