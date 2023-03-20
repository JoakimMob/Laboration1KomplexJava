package se.iths.Laboration1.business;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GissaService {

    private int secret;

    private List<String> replies;
    Random random = new Random();

    private List<String> topList;


    private void init(){
        secret = random.nextInt(1,11);
        replies = new ArrayList<>();
    }
    public String gissa(int guess) {
        String answer;
        if (guess < secret) {
            answer =  guess+ ", is too small";
            replies.add(answer);
        } else if (guess> secret) {
            answer = guess + ", is too large (thats what she said)";
            replies.add(answer);
        }else {
            init();
            answer= guess + ", is correct";
            //HÄR SKA VÄL LÄGGA TILL TOPLIST TYP PLAYERAVERAGE.CALCULATE = TOPLIST
        }
        return answer;
    }

    public void login(String pName) {
    }

    public List<String> getTopList() {
        return topList;
    }

    public void setTopList(List<String> topList) {
        this.topList = topList;
    }
}
