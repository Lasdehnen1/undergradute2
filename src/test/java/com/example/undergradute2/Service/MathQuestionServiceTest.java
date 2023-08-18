package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.QuestionNotFoundException;
import com.example.undergradute2.Repository.MathQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    private MathQuestionRepository mathQuestionRepository = mock(MathQuestionRepository.class);

    @InjectMocks
    MathQuestionService mathQuestionService;

    @Test
    void add() {
        Set<Question> questions = new HashSet<>();

        Question question = new Question("Question1", "Answer1");
        Question expected = question;

        when(mathQuestionService.getAll()).thenReturn(questions);

        Question actual = mathQuestionService.add(question);
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        Set<Question> questions = new HashSet<>();

        Question question = new Question("Question1", "Answer1");
        Question question1 = new Question("Question2", "Answer2");

        Set<Question> expected = Set.of(question);

        when(mathQuestionService.getAll()).thenReturn(questions);

        questions.add(question);
        questions.add(question1);

        questions.remove(question1);
        Collection<Question> actual = mathQuestionService.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void removeNotExisting() {
        String expected = "Такой вопрос не найден";
        Set<Question> questions = new HashSet<>();
        when(mathQuestionService.getAll()).thenReturn(questions);
        mathQuestionService.add("Question1", "Answer1");
        Exception exception = assertThrows(
                QuestionNotFoundException.class,
                () -> {
                    mathQuestionService.remove(new Question("Question2", "Answer2"));
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
        when(mathQuestionService.getAll()).thenReturn(questions);

        questions.add(question1);
        questions.add(question2);

        Collection<Question> actual = mathQuestionService.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {
        Question expected = new Question("Question1", "Answer1");

        Set<Question> questions = new HashSet<>();
        when(mathQuestionService.getAll()).thenReturn(questions);

        questions.add(expected);

        Question actual = mathQuestionService.getRandomQuestion();

        assertEquals(expected, actual);
    }
}