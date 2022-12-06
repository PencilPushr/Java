package Excer.Excercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PatientDB {

    private static final String[] METHODS = new String[]{"Computer Tomography (CT)", "Electrocorticogram (ECoG)",
                                                         "Electroencephalography (EEG)", "Magnetic Resonance Imaging (MRI)",
                                                         "Positron Emission Tomography (PET)"};
    private String[] brainRegions;
    private List<Patient> patientDB = new ArrayList<>();

    public PatientDB(String input) throws FileNotFoundException {

        //TODO: needs a try catch block in case person attempts give file with incorrect values
        // -> this might be smarter if we attempt it in PatientMAIN
        // or continuously attempt to through it until we reach main?

        //try catch block?

        brainTxtToArray(input);

        initialisePatients();


    }

    private void brainTxtToArray(String input) throws FileNotFoundException {
        File f = new File(input);

        List<String> stringArrayList = new ArrayList<String>();

        Scanner s = new Scanner(f);
        while(s.hasNextLine()) {
            stringArrayList.add(s.nextLine());
        }
        s.close();

        brainRegions = stringArrayList.toArray(new String[0]);
    }

    //we need to iterate through and assign brainRegion + method + age to a patient to produce --195 patients--
    //this function iterates through both global String arrays and we create a patient (with randomAge()) and add it,
    // until we have done so for all possible permutations
    private void initialisePatients(){
        for (int i = 0; i < brainRegions.length; i++) {
            for (int j = 0; j < METHODS.length; j++) {
                Patient patient = new Patient(this.brainRegions[i], this.METHODS[j], randomAge());
                patientDB.add(patient);
            }
        }
    }

    public int randomAge(){
        return 21 + (int) (Math.random() * (60 - 21 + 1)); //formula > loops
    }


    public void printPatientDB(){ //I am fully aware that by having a print function in sortDB and shuffleDB, makes this code redundant.
        for (int i = 0; i < patientDB.size(); i++) {
            System.out.println();
        }
    }

    public void sortDB(){
        Collections.sort(patientDB);
        for (int i = 0; i < patientDB.size(); i++) {
            System.out.println(patientDB.get(i));
        }
    }

    public void shuffleDB(){
        Collections.shuffle(patientDB);
        for (int i = 0; i < patientDB.size(); i++) {
            System.out.println(patientDB.get(i));
        }
    }

    public Map<String, Patient> generatePatientSample(){
        Map<String, Patient> PatientSample = new HashMap<String, Patient>();
        for (int i = 0; i < this.METHODS.length; i++) {
            PatientSample.put(this.METHODS[i], this.patientCorrespondingToMethod(this.METHODS[i]));
        }

        return PatientSample;
    }

    //There has to be an easier implementation than using this method in conjunction with generatePS()
    //but I can't seem to make generatePatientSample() return what I want, unless this function is created.
    //This is essentially a patientDB.get(i) but with extra steps -> checks if we already have a method existing and add the others that are not in the list into it.
    //but it annoys me to no end because I'm sure the overridden equals()+CompareTo() has its use, but I don't know where.
    private Patient patientCorrespondingToMethod(String method){
        List valid = Arrays.asList(this.METHODS); //Create a list to validate the method we are checking
        if (valid.contains(method)){ // if the list valid contains the inputted string shuffle
            Collections.shuffle(patientDB);
            for (int i = 0; i < this.patientDB.size(); i++){
                if (this.patientDB.get(i).getMethod().equals(method)){ // if the Patient of method x is equal to the String method
                    return this.patientDB.get(i);
                }
            }
            System.out.println("There is no Patient of this method | Error"); //this has been called before there are astronauts in the list.
        } else {
            System.out.println("Attempted to retrieve Patient of an invalid method | Error"); // Error: the string rank is out of bounds.
        }
        System.exit(0);
        return null;
    }

    public String[] getBrainRegions() {
        return brainRegions;
    }

    public static String[] getMETHODS() {
        return METHODS;
    }

    public void setBrainRegions(String[] brainRegions) {
        this.brainRegions = brainRegions;
    }

    public void setPatientDB(List<Patient> patientDB) {
        this.patientDB = patientDB;
    }

}
