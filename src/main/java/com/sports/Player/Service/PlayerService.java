package com.sports.Player.Service;

import com.sports.Player.Model.Player;
import com.sports.Player.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sahin on 07.03.2018.
 */
@Service
public class PlayerService implements PlayerServiceImpl {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void updatePlayer(Integer id, Player player) {
        Optional<Player> playerTempObject = playerRepository.findById(id);
        if(playerTempObject == null) {
            throw new RuntimeException();
        }
        else {
            playerRepository.deleteById(id);
            playerRepository.save(player);
        }
    }

    @Override
    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }
}
