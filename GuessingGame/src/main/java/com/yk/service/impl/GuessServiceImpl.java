package com.yk.service.impl;

import com.yk.dao.GuessDao;
import com.yk.service.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuessServiceImpl implements GuessService {

    @Autowired
    private GuessDao guessDao;

    @Override
    public String getquestion(Integer id) {
        String question = guessDao.getQuestionById(id).getQuestion();
        return question;
    }

    @Override
    public boolean isRight(String question,String answer) {
        boolean result = false;
        if (answer.equals(guessDao.getAnswerByQuestion(question).getAnswer())) {
            result = true;
        } else {
            result = false;
        }
       return result;

    }

    @Override
    public String getAnswer(String question) {
        String answer = guessDao.getAnswerByQuestion(question).getAnswer();
        return answer;
    }
}
