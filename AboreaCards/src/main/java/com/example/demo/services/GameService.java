package com.example.demo.services;

import com.example.demo.model.Game;
import com.example.demo.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void addGame(Game game){
        gameRepository.save(game);
    }

    public void deleteGame(Game game){
        gameRepository.delete(game);
    }
}
