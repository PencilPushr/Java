package Excercises2;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PatientDB {

    private static final String[] METHODS = new String[]{"Computer Tomography (CT)", "Electrocorticogram (ECoG)",
                                                         "Electroencephalography (EEG)", "Magnetic Resonance Imaging (MRI)",
                                                         "Positron Emission Tomography (PET)"}; // what are these names??
    private String[] brainRegions;
    private List<Patient> patientDB;

    public PatientDB(String input){


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
