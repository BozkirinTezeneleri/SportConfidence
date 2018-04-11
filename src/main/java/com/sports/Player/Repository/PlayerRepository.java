package com.sports.Player.Repository;

import com.sports.Player.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahin on 07.03.2018.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{

    List<Player> findPlayersByCountry_CountryId(Integer id);
}
