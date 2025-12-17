public static void main (String[] args){
    //The name of the class and the name of the object must be the same.
    //PART 1 Linked List
    System.out.println("Linked list");
    patientList patient = new patientList();
    patient.addPatient(230444062, "Berke Ozdemir", 5, 30);
    patient.addPatient(230444016, "Enes Ozcan", 7, 40);
    patient.addPatient(230444048, "Bünyamin Ekici", 8, 40);
    patient.addPatient(230444059,"Efecan Talay",3,23);
    patient.addPatient(230444031,"Ulas Arda Canbolat",6,60);

    //printing results
    patient.printList();
    System.out.println(" ");
    // removing one by id
    patient.removePatient(230444048);
    patient.printList();
    // searching one by id
    patient.findPatient(230444059);
    System.out.println(" ");

    //For treatmentRequest class test
    //PART 2 Queue
    System.out.println("Queue");
    TreatmentQueue q = new TreatmentQueue();
    q.enqueue(new TreatmentRequest(101));   //to make it more readable and ordered we can do that
    q.enqueue(new TreatmentRequest(102)); //for (int i = 101; i <= 105; i++) {
    q.enqueue(new TreatmentRequest(103)); //    q.enqueue(new TreatmentRequest(i, System.currentTimeMillis()));
    q.enqueue(new TreatmentRequest(104));// }
    q.enqueue(new TreatmentRequest(105));
    q.printQueue();
    //  Because of the TreatmentRequest request parameter that I have to get in enqueue, the code is correct if it is written into an object in this way when calling the enqueue method
    //size of queue
    System.out.println("The size of queue: " + q.size());
    //dequeue
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.printQueue();
    System.out.println(" ");
//  As seen in the output, the queue also works on a FIFO.

//  PART 3 Stack
    System.out.println("Stack");
    DisChargeStack stack = new DisChargeStack();
    stack.push(new DisChargeRecord(10)); //for (int id = 10; id <= 50; id += 10) {
    stack.push(new DisChargeRecord(20)); //   stack.push(new DischargeRecord(id, System.currentTimeMillis()));
    stack.push(new DisChargeRecord(30)); //}
    stack.push(new DisChargeRecord(40));
    stack.push(new DisChargeRecord(50));
    System.out.println("Top element: "+stack.peek());//return top
    stack.printStack(); //print stack


    stack.pop();//remove last element (top)
    System.out.println("Top element: "+stack.peek());
    stack.printStack(); //print stack

    stack.pop();//remove last element (top) again
    System.out.println("Top element: "+stack.peek());
    stack.printStack(); //print stack

    //Hospital System
    HospitalSystem hospitalSystem = new HospitalSystem();

    hospitalSystem.addNewPatient(new patient(1, "Patient1", 2, 21));
    hospitalSystem.addNewPatient(new patient(2, "Patient2", 3, 22));
    hospitalSystem.addNewPatient(new patient(3, "Patient3", 4, 23)); //    for (int i = 1; i <= 10; i++) {
    hospitalSystem.addNewPatient(new patient(4, "Patient4", 5, 24)); //          hospitalSystem.addNewPatient(new patient(i, "Patient" + i, i % 5 + 1, 20 + i));
    hospitalSystem.addNewPatient(new patient(5, "Patient5", 1, 25));//}
    hospitalSystem.addNewPatient(new patient(6, "Patient6", 2, 26));
    hospitalSystem.addNewPatient(new patient(7, "Patient7", 3, 27));
    hospitalSystem.addNewPatient(new patient(8, "Patient8", 4, 28));
    hospitalSystem.addNewPatient(new patient(9, "Patient9", 5, 29));
    hospitalSystem.addNewPatient(new patient(10, "Patient10", 1, 30));

    hospitalSystem.addTreatmentRequest(1);
    hospitalSystem.addTreatmentRequest(2);
    hospitalSystem.addTreatmentRequest(3);
    hospitalSystem.addTreatmentRequest(4);

    hospitalSystem.processTreatment();
    hospitalSystem.processTreatment();
    hospitalSystem.processTreatment();
    hospitalSystem.processTreatment();

    hospitalSystem.printSystemState();
}

// For making comments Use this Shortcut -> CTRL + K + C
// For Undo this, Use -> CTRL + K + U