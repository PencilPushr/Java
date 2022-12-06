package Excer.Excercises2;

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
        //First checks if it's the same object
        if (this == o) return true;
        //otherwise check if the object is null or if the getClass() is not equal to the object Class
        if (o == null || getClass() != o.getClass()) return false;
        //if the code makes it this far, create a new patient, casting it to the input object
        // and return -> age, brainRegion and method
        Patient patient = (Patient) o;
        return age == patient.age && Objects.equals(brainRegion, patient.brainRegion) && Objects.equals(method, patient.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brainRegion, method, age);
    }

    //getters

    public int getAge() {
        return this.age;
    }

    public String getBrainRegion() {
        return this.brainRegion;
    }

    public String getMethod() {
        return this.method;
    }

    //setters

    public void setAge(int age) {
        this.age = age;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setBrainRegion(String brainRegion) {
        this.brainRegion = brainRegion;
    }
}
