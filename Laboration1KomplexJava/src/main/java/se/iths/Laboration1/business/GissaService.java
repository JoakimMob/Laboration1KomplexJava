package se.iths.Laboration1.business;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.Laboration1.storage.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GissaService {

    int secret;
    int guessCount;

    Player player;

    boolean isLoggedIn;

    @Autowired
    PlayerRepository playerRepository;

    private List<String> replies;
    Random random = new Random();

    private List<String> topList;


    @PostConstruct
    private void init(){
        secret = random.nextInt(1,11);
        guessCount=0;
    }
    public String gissa(int guess) {
        if (!isLoggedIn) throw new IllegalStateException("Not logged in");
        guessCount++;
        if (guess < secret) {
            return "För lågt";
        }
        if (guess> secret) {
            return "För stort";
        }
        int resultat = guessCount;

        init();
        registerResult(resultat);
        return "Rätt svar på " + resultat + " gissningar! Nytt tal startar!";
    }

    public void login(String playerName) {
        if (isLoggedIn) return;

        List<Player> players = playerRepository.findByName(playerName);
        if (players.size()>0){
            player = players.get(0);
        } else {
            player = new Player(playerName);
            playerRepository.save(player);
        }
        isLoggedIn = true;

    }

    public void registerResult(int nGuesses){
        if (!isLoggedIn) return;
        Player playerInDB = playerRepository.findById(player.getId()).get();
        playerInDB.addResult(nGuesses);
    }

    public List<String> getTopList() {
        return topList;
    }

    public void setTopList(List<String> topList) {
        this.topList = topList;
    }
}
