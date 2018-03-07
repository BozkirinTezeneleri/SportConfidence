package com.sports.Player.Repository;

import com.sports.Player.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahin on 07.03.2018.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{
}
