package se.iths.Laboration1.business;

public class PlayerAverage implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        PlayerAverage playerAverage = (PlayerAverage) o;
        return Double.compare(this.averageResult,playerAverage.averageResult);
    }
}
