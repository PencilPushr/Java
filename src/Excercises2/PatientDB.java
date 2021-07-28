package Excercises2;

import java.util.*;

public class PatientDB {

    private static final String[] METHODS = new String[]{"Computer Tomography (CT)", "Electrocorticogram (ECoG)",
                                                         "Electroencephalography (EEG)", "Magnetic Resonance Imaging (MRI)",
                                                         "Positron Emission Tomography (PET)"}; // what are these names??
    private String[] brainRegions;
    private List<Patient> patientDB;

    public PatientDB(String input){

        //TODO: needs a try catch block in case person attempts give file with incorrect values
        // -> this might be smarter if we attempt it in PatientMAIN

        //try catch block?
        brainRegions = brainTxtToArray(input);



    }

    //TODO: this isn't actually a todo
    // however I'm questioning whether or not I simply make this void and it assigns brainRegions instead?
    public String[] brainTxtToArray(String input){
        List<String> stringArrayList = new ArrayList<String>();
        String[] strings;
        Scanner s = new Scanner(input);

        while(s.hasNextLine()){
            stringArrayList.add(s.nextLine());
        }
        s.close();

        strings = stringArrayList.toArray(new String[stringArrayList.size()]);

        return strings;
    }

    public int randomAge(){

    }

    public void initalisePatient(){

    }

    public void printPatientDB(){

    }

    public void sortDB(){
        Collections.sort(patientDB);
    }

    public void shuffleDB(){
        Collections.shuffle(patientDB);
    }

    public Map<String, Patient> generatePatientSample(){
        return null;
    }

}
