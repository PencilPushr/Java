package Assignment;

public class Astronaut{

    private String nationality;
    private String rank;
    private int rankNum;
    private int age;


    public Astronaut(String nationality, String rank, int rankNum, int age) {
        this.nationality = nationality;
        this.rank = rank;
        this.rankNum = rankNum;
        this.age = age;
    }

    @Override
    public String toString() {
        return 
    }

    public String getNationality() {
        return nationality;
    }

    public String getRank() {
        return rank;
    }

    public int getRankNum() {
        return rankNum;
    }

    public int getAge() {
        return age;
    }
}