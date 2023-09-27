package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Game;
import com.example.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class GameEndpoints {
    @Autowired
    private final GameService gameService;

    public GameEndpoints(GameService gameService) {
        this.gameService = gameService;
    }

    @Permission({"Create","Read","Edit"})
    @PostMapping("/games")
    public ResponseEntity<Void> addGame(@RequestBody Game game){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
