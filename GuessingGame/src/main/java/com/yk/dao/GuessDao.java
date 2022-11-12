package com.yk.dao;

import com.yk.domain.Guess;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GuessDao {
    @Select("select * from guess_tab where id = #{id}")
    public Guess getQuestionById(Integer id);

    @Select("select * from guess_tab where question = #{question}")
    public Guess getAnswerByQuestion(String question);
}
