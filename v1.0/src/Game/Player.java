package Game;

public class Player {
    private String name;
    private double[] results = new double[3];
    private int timesPlayed = 0;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getResults() {
        return results;
    }

    public void setResults(double[] results) {
        this.results = results;
    }

    public void addResult(double result){
        results[timesPlayed] = result;
        timesPlayed++;
    }

}
