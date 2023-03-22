package se.iths.Laboration1.business;

public class PlayerAverage {
    private String name;
    private Double averageResult;

    public PlayerAverage(String name, Double averageResult){
        this.name = name;
        this.averageResult = averageResult;
    }

    public String getName(){
        return name;
    }

    public double getAverageResult(){
        return averageResult;
    }
}
