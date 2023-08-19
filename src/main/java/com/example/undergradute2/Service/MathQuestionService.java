package com.example.undergradute2.Service;

import com.example.undergradute2.Entity.Question;
import com.example.undergradute2.Exception.MethodNotAllowedException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Метод не разрешен");
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException("Метод не разрешен");
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException("Метод не разрешен");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Метод не разрешен");
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        String sign = signGenerator();
        String question = " ";
        String answer = " ";
        double result;
        int num1 = r.nextInt(10);
        int num2 = r.nextInt( 10);
        switch (sign) {
            case "+":
                question = num1 + " " + sign + " " + num2 + " = ";
                result = num1 + num2;
                answer = String.valueOf(result);
                break;
            case "-":
                question = num1 + " " + sign + " " + num2 + " = ";
                result = num1 - num2;
                answer = String.valueOf(result);
                break;
            case "*":
                question = num1 + " " + sign + " " + num2 + " = ";
                result = num1 * num2;
                answer = String.valueOf(result);
                break;
            case "/":
                question = num1 + " " + sign + " " + num2 + " = ";
                result = (double) num1 / num2;
                answer = String.valueOf(result);
                break;
            default:
                throw new RuntimeException("Конец");
        }

        return new Question(question, answer);

    }


    private static String signGenerator() {
        Random r = new Random();
        int signValue = r.nextInt(4);
        switch (signValue) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
            default:
                throw new RuntimeException("Конец");

        }
    }

}
