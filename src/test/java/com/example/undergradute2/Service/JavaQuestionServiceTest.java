package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JavaQuestionServiceTest {
    JavaQuestionService j = new JavaQuestionService();

    @Test
    void add() {
        Question question = new Question("Question1", "Answer1");
        Question expected = question;
        Question actual = j.add("Question1", "Answer1");
        assertEquals(expected, actual);
    }


    @Test
    void remove() {
        Question question = new Question("Question1", "Answer1");
        Question expected = question;
        Question actual = j.add("Question1", "Answer1");

        j.remove(new Question("Question1", "Answer1"));

        assertEquals(expected, actual);
    }

    @Test
    void removeNotFound() {
        String expected = "Такой вопрос не найден";
        j.add("Question1", "Answer1");
        Exception exception = assertThrows(
                QuestionNotFoundException.class,
                () -> {
                    j.remove(new Question("Question2", "Answer2"));
                });

        assertEquals(expected, exception.getMessage());
    }

    @Test
    void getAll() {
        Set<Question> expected = new LinkedHashSet<>();

        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");

        expected.add(question1);
        expected.add(question2);
        j.add(question1);
        j.add(question2);

        Collection<Question> actual = j.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {


        Question expected = new Question("Question1", "Answer1");
        
        j.add(expected);


        Question actual = j.getRandomQuestion();

        assertEquals(expected, actual);


    }
}