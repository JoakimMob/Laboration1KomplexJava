package se.iths.Laboration1.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.Laboration1.business.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByName(String playerName);

}
