class TreatmentRequest {
    int patientId;
    long arrivalTime;
    TreatmentRequest next;

    TreatmentRequest(int patientId) {
        this.patientId = patientId;
        arrivalTime = System.currentTimeMillis();
        next = null;
    }
}
//Queue -Linked list implementation
class TreatmentQueue {
    TreatmentRequest front;
    TreatmentRequest rear;

    TreatmentQueue(){
        front = rear = null;
    }

    boolean isEmpty(){
        return front == null && rear == null;
    }


    //function to add an element to the queue
    public void enqueue(TreatmentRequest request) {
        // Using the add method of the constructor of the TreatRequest class using the stored parameter
        // PatientId, it provides the add part by id without calling the object.
        if (isEmpty()){
            front = rear = request;
            return;
        }
        //add the new node at the end of the queue and change the rear
        rear.next = request;
        rear = request;
    }
    public int dequeue(){

        if  (isEmpty()){
            return -1;
        }
        int value = front.patientId;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }


//The basic logic in Queue's size() method is very simple:
// there are two solutions here.
// 1. Counting how many nodes (nodes / requests) there are in the queue and rotating them.
// 2. Maintaining a size counter helps count the size of the queue in the enqueue and dequeue methods.
//    this is the case when the time complexity is at least O(1)
//    When enqueue() is called, size++
//    When dequeue() is called, size--

    public int size (){
        int count = 0;
        TreatmentRequest current = front.next;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    //The reason I chose the first way was that I wanted to learn the first way, even though the time complexity of the first way is higher.
    public void printQueue(){
        TreatmentRequest temp = front;
        while (temp != null){
            System.out.print("ID: "+temp.patientId);
            System.out.println(" Arrival time: "+ temp.arrivalTime);
            temp = temp.next;
        }
        System.out.println();
    }

}
