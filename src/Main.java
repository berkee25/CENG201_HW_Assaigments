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
    // searching one by id
    patient.findPatient(230444059);
    System.out.println(" ");

    //For treatmentRequest class test
    //PART 2 Queue
    System.out.println("Queue");
    TreatmentQueue q = new TreatmentQueue();
    q.enqueue(new TreatmentRequest(101));
    q.enqueue(new TreatmentRequest(102));
    q.enqueue(new TreatmentRequest(103));
    q.enqueue(new TreatmentRequest(104));
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
    stack.push(new DisChargeRecord(10));
    stack.push(new DisChargeRecord(20));
    stack.push(new DisChargeRecord(30));
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

}

// For making comments Use this Shortcut -> CTRL + K + C
// For Undo this, Use -> CTRL + K + U