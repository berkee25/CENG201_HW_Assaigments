import java.util.*;
public static void main (String[] args){
    //The name of the class and the name of the object must be the same.
    patientList patient = new patientList();
    patient.addPatient(1, "Ali", 5, 30);
    patient.addPatient(2, "Veli", 7, 40);
    patient.addPatient(3, "Mari", 8, 40);
    patient.addPatient(4,"Ayşe",3,23);
    patient.addPatient(5,"Fatma",6,60);

    //printing results
    patient.printList();
    System.out.println("");
    // removing one by id
    patient.removePatient(1); //first one
    patient.removePatient(3); //middle one
    patient.removePatient(5); //last one
    System.out.println("");
    // searching one by id
    patient.findPatient(4);


}

// For this Use this Shortcut -> CTRL + K + C
// For Undo this, Use -> CTRL + K + U