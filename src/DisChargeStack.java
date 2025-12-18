class DisChargeRecord {
    int patientID; //ID of discharged patient
    long discardTime; //Timestamp of discharge
    DisChargeRecord next;

    DisChargeRecord(int patient ) { // node constructor
        this.patientID = patient;
        this.discardTime= System.currentTimeMillis();
        next = null;
    }
}
class DisChargeStack {
    DisChargeRecord top;
    DisChargeStack() {
        top = null;
    }
    boolean isEmpty() { //checking if it is empty or not
        return top == null;
    }
    void push(DisChargeRecord record) { //pushing element in the stack with help of object parameter
        record.next = top;
        top = record;
    }
    // LIFO
    // top → [A] → [B] → [C]
    // pop → removes [C]
    // top → [A] → [B]
    public int pop(){ //removing element in the stack depending on LIFO (last in first out)
        if (isEmpty()) {
            System.out.println("STACK EMPTY → No discharge to remove");
            return -1; // -1 means "remove failed" because stack is empty
        }
        int value = top.patientID;
        System.out.println("DISCHARGE REMOVED → Patient ID: " + value);
        top = top.next; //removed top element on the stack
        return value;
    }
    public int peek(){
        if (isEmpty()) { //check stack is empty or not
            System.out.println("STACK EMPTY → No discharge to peek"); //empty message
            return -1; //-1 means "peek failed" because stack is empty
        }
        System.out.println("TOP Discharge → Patient ID: " + top.patientID);
        return top.patientID; // returning patient id
    }

    public void printStack(){
        DisChargeRecord temp = top; // node named temp stores top value
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }
        while (temp != null) { // traverse the stack
            System.out.println("Patient ID: "+temp.patientID + " "); //print stack and the message
            temp = temp.next;
        }
        System.out.println();
    }
}
