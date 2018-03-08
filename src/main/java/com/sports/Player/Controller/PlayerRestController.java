package com.sports.Player.Controller;

import com.sports.Player.Model.Player;
import com.sports.Player.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created on 08-March-2018
 *
 * @author eray
 */
@RestController
@RequestMapping("/players")
public class PlayerRestController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Player> getAllPlayers(){
        return playerService.findAllPlayers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Player> getPlayerById(@PathVariable Integer id){
         return playerService.getPlayerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayer(@Valid @RequestBody Player player){
        playerService.addPlayer(player);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePlayerById(@PathVariable Integer id,@RequestBody Player player){
        playerService.updatePlayer(id,player);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlayerById(@PathVariable Integer id){
        playerService.deletePlayer(id);
    }


}
