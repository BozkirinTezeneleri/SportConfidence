package com.sports.Player.Service;

import com.sports.Player.Model.Player;
import com.sports.Player.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
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
        Player playerTempObject = playerRepository.findById(id).orElseThrow(()->new DataAccessResourceFailureException("Data is not available"));
        if(playerTempObject == null) {
            throw new RuntimeException();
        }
        else {
            playerTempObject.setPlayerId(id);
            playerTempObject.setName(player.getName());
            playerTempObject.setBirthDate(player.getBirthDate());
            playerTempObject.setHeight(player.getHeight());
            playerTempObject.setWeight(player.getWeight());
            playerTempObject.setContractTimeStart(player.getContractTimeStart());
            playerTempObject.setTeamId(player.getTeamId());
            playerTempObject.setDisabilityInformation(player.getDisabilityInformation());
            playerTempObject.setTestimonial(player.getTestimonial());
            playerTempObject.setCitizenShipId(player.getCitizenShipId());
            playerTempObject.setContractTimeEnd(player.getContractTimeEnd());
            playerTempObject.setDisabilityState(player.isDisabilityState());
            playerTempObject.setSurname(player.getSurname());
            playerRepository.save(playerTempObject);
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
