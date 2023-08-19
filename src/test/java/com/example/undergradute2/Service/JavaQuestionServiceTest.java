package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import com.example.undergradute2.Repository.JavaQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    private JavaQuestionRepository javaQuestionRepository = mock(JavaQuestionRepository.class);

    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    void add() {
        Set<Question> questions = new HashSet<>();

        Question question = new Question("Question1", "Answer1");
        Question expected = question;

        when(javaQuestionService.getAll()).thenReturn(questions);

        Question actual = javaQuestionService.add(question);
        assertEquals(expected, actual);
    }


    @Test
    void remove() {
        Set<Question> questions = new HashSet<>();

        Question question = new Question("Question1", "Answer1");
        Question question1 = new Question("Question2", "Answer2");

        Set<Question> expected = Set.of(question);

        when(javaQuestionService.getAll()).thenReturn(questions);

        questions.add(question);
        questions.add(question1);

        questions.remove(question1);
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void removeNotFound() {
        String expected = "Такой вопрос не найден";
        Set<Question> questions = new HashSet<>();
        when(javaQuestionService.getAll()).thenReturn(questions);
        javaQuestionService.add("Question1", "Answer1");
        Exception exception = assertThrows(
                QuestionNotFoundException.class,
                () -> {
                    javaQuestionService.remove(new Question("Question2", "Answer2"));
                });

        assertEquals(expected, exception.getMessage());
    }


    @Test
    void getAll() {
        Set<Question> expected = new HashSet<>();

        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");

        expected.add(question1);
        expected.add(question2);
        Set<Question> questions = new HashSet<>();
        when(javaQuestionService.getAll()).thenReturn(questions);

        questions.add(question1);
        questions.add(question2);

        Collection<Question> actual = javaQuestionService.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {


        Question expected = new Question("Question1", "Answer1");

        Set<Question> questions = new HashSet<>();
        when(javaQuestionService.getAll()).thenReturn(questions);

        questions.add(expected);

        Question actual = javaQuestionService.getRandomQuestion();

        assertEquals(expected, actual);
    }




}