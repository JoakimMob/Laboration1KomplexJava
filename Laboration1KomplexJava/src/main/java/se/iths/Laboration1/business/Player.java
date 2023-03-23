package se.iths.Laboration1.business;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    List<Result> results;

    public Player(String name) {
        this.name = name;
        this.results=new ArrayList<>();
    }

    public Player() {

    }

    public void addResult(Result result) {
        results.add(result);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Result> getResults() {
        return results;
    }
}
