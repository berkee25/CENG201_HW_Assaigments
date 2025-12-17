class DisChargeRecord {
    int patientID; //ID of discharged patient
    long discardTime; //Timestamp of discharge
    DisChargeRecord next;
    DisChargeRecord(int patient ) {
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
    void push(DisChargeRecord record) { //pushing element in the stack
        record.next = top;
        top = record;
    }
    public int pop(){ //removing element in the stack depending on LIFO (last in first out)
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        int value = top.patientID;
        top = top.next; //removed top element on the stack
        return value;
    }
    public int peek(){
        if (isEmpty()) {return -1;}
        return top.patientID;
    }
    public void printStack(){
        DisChargeRecord temp = top; // node named temp stores top value
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }
        while (temp != null) {
            System.out.println("Patient ID: "+temp.patientID + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
