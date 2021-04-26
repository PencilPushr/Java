package Excercises;

import java.util.Objects;

public class Astronaut implements Comparable<Astronaut>{

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
        return this.rank + " (" + this.nationality + ", " + this.age +")";
    }

    @Override
    public int compareTo(Astronaut otherAstronaut) {
        int result = this.rankNum - otherAstronaut.rankNum;
        if (result == 0) {
            result = this.nationality.compareTo(otherAstronaut.nationality);
            if (result == 0){
                result = this.age - otherAstronaut.age;
            }
        }
        return result;

        /* Retard code -- it was the only way I could see it returning in an ascending order.
        if (astronaut.rankNum == rankNum){
            if (astronaut.nationality == nationality){
                if (astronaut.age == age){
                    return 0;
                } else if (astronaut.age < age){
                    return 1;
                }
            } else if (astronaut.nationality != nationality){
                return 1;
            }
        } else if (astronaut.rankNum < rankNum){
            return 1;
        }

        return -1;

         */
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Astronaut astronaut = (Astronaut) o;
        return rankNum == astronaut.rankNum && age == astronaut.age && Objects.equals(nationality, astronaut.nationality) && Objects.equals(rank, astronaut.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationality, rank, rankNum, age);
    }

    public String getNationality() {

        return this.nationality;
    }

    public String getRank() {

        return this.rank;
    }

    public int getRankNum() {

        return this.rankNum;
    }

    public int getAge() {

        return this.age;
    }
}