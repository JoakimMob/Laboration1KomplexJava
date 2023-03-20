package se.iths.Laboration1.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.Laboration1.business.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository {
    List<Player> findByName(String playerName);

    List<Player> findById(int id);
}
