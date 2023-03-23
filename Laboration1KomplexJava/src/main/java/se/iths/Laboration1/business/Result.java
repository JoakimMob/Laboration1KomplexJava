package se.iths.Laboration1.business;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Result() {
        this.result=0;
    }


    public Result(int result) {
        this.result = result;
    }

    public Result(Long id, int result) {
        this.id = id;
        this.result = result;
    }
}
