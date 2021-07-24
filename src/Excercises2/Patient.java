package Excercises2;

import java.util.Objects;

public class Patient implements Comparable<Patient>{

    private String brainRegion;
    private String method;
    private int age;

    public Patient(String brainRegion, String method, int age){
        this.brainRegion = brainRegion;
        this.method = method;
        this.age = age;
    }

    @Override
    public String toString(){
        return (this.method + "; " + this.brainRegion + "; " + this.age);
    }

    @Override
    public int compareTo(Patient otherPatient){
        int result = this.method.compareTo(otherPatient.method);
        if (result == 0) {
            result = this.brainRegion.compareTo(otherPatient.brainRegion);
            if (result == 0){
                result = this.age - otherPatient.age;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age && Objects.equals(brainRegion, patient.brainRegion) && Objects.equals(method, patient.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brainRegion, method, age);
    }
}
