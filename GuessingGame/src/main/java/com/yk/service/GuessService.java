package com.yk.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GuessService {

    public String getquestion(Integer id);

    public boolean isRight(String question,String answer);

    public String getAnswer(String question);
}
