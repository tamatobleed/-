package com.yk.controller;

import com.yk.domain.Guess;
import com.yk.service.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess")
public class GuessController {

    @Autowired
    private GuessService guessService;

    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable Integer id) {
        return guessService.getquestion(id);
    }

    @PostMapping("/isRight")
    public boolean isRight(@RequestBody Guess guess) {
        return guessService.isRight(guess.getQuestion(),guess.getAnswer());
    }

    @PostMapping("/answer ")
    public String getAnswer(@RequestBody Guess guess) {
        return guessService.getAnswer(guess.getQuestion());
    }
}
