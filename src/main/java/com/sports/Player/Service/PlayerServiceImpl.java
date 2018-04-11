package com.sports.Player.Service;

import com.sports.Player.Model.Player;

import java.util.List;
import java.util.Optional;

/**
 * Created by sahin on 07.03.2018.
 */
public interface PlayerServiceImpl {

    public void addPlayer(Player player);
    public void deletePlayer(Integer id);
    public void updatePlayer(Integer id, Player player);
    public Optional<Player> getPlayerById(Integer id);
    public List<Player> findAllPlayers();
    public List<Player> findByCountry(Integer id);
}
