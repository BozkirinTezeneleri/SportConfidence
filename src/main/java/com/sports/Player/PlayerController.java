package com.sports.Player;

import com.sports.Player.Model.Player;
import com.sports.Player.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author eray
 */
@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public String getPlayerList(Model model){
        List<Player> playerList = playerService.findAllPlayers();
        model.addAttribute("players",playerList);
        return "player/playerList";
    }

    @GetMapping(value = "/{id}")
    public String getPlayerById(@PathVariable("id") Integer id, Model model){
        Optional<Player> playerOptional=playerService.getPlayerById(id);
        if(!playerOptional.isPresent()){
            return "redirect:/";
        }
        else{
            model.addAttribute("player", playerOptional.get());
            return "player/showPlayer";
        }
    }

    @GetMapping(value = "/{id}/delete")
    public String getDeleteById(@PathVariable("id") Integer id){
        Optional <Player> playerOptional = playerService.getPlayerById(id);
        if(!playerOptional.isPresent()){
            return "redirect:/veriyok";
        }
        else{
            playerService.deletePlayer(id);
            return "player/playerList";
        }

    }

    @GetMapping(value = "/{id}/update")
    public String getUpdateById(@PathVariable("id") Integer id, Model model){
        Optional<Player> playerOptional = playerService.getPlayerById(id);
        if(!playerOptional.isPresent()){
            return "redirect:/veriyok";
        }
        else{
            model.addAttribute("updatePlayer",playerOptional);
            return "player/showPlayer";
        }
    }

    @PostMapping(value = "/{id}/update")
    public String postUpdateById(@Valid @ModelAttribute Player player, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "player/showPlayer";
        }
        else{
            playerService.updatePlayer(player.getPlayerId(),player);
            return "player/showPlayer";
        }
    }


}
