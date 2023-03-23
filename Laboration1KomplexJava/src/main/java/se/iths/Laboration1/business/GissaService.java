package se.iths.Laboration1.business;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.Laboration1.storage.PlayerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@SessionScope
public class GissaService {

    int secret;
    int guessCount;

    Player player;

    boolean isLoggedIn;
    Result result;

    @Autowired
    PlayerRepository playerRepository;

    Random random = new Random();


    @PostConstruct
    private void init() {
        secret = random.nextInt(1, 11);
        guessCount = 0;
    }

    public List<PlayerAverage> getResults() {
        return playerRepository
                .findAll()
                .stream()
                .map(player -> new PlayerAverage(
                        player.getName(), player.getResults()
                        .stream().map(Result::getResult).reduce(0, Integer::sum) * 1.0 / player.getResults().size()))
                .toList();
    }

    public String gissa(int guess) {
        if (!isLoggedIn) throw new IllegalStateException("Not logged in");
        guessCount++;
        if (guess < secret) {
            return "För lågt";
        }
        if (guess > secret) {
            return "För stort";
        }
        int resultat = guessCount;
        result.setResult(resultat);
        init();
        player.addResult(result);
        playerRepository.save(player);

        return "Rätt svar på " + resultat + " gissningar! Nytt tal startar!";
    }

    public void login(String playerName) {
        if (isLoggedIn) return;

        Optional<Player> players = playerRepository.findByName(playerName);
        if (players.isPresent()) {
            player = players.get();
        } else {
            player = new Player(playerName);
            playerRepository.save(player);
        }
        result = new Result();
        isLoggedIn = true;

    }


}
