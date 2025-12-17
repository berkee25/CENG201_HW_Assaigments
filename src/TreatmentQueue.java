class TreatmentRequest {
    int patientId;
    long arrivalTime;
    TreatmentRequest next;

    TreatmentRequest(int patientId) { //constructor
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
    } // isEmpty checks front and rear are null or not


    //function to add an element to the queue
    public void enqueue(TreatmentRequest request) {
        //Thanks to the received object parameter,  adding to the queue becomes easier.
        if (isEmpty()){ // check the queue is empty or not
            front = rear = request; // insert to first element
            System.out.println("Request added → Patient ID: " + request.patientId);
        }
        //add the new node at the end of the queue and change the rear
        rear.next = request;
        rear = request;
        System.out.println("Request added → Patient ID: " + request.patientId);
    }
    // FIFO
    // front → [A] → [B] → [C] → null
    // dequeue → removes [A]
    // front → [B] → [C]
    public int dequeue(){ //remove element from queue depending on FIFO (first in first out)
        if  (isEmpty()){ //check queue is empty or not
            System.out.println("Queue is empty, no request to remove");
            return -1; //-1 means “deletion failed” because it is empty.
        }
        int value = front.patientId; // store the before remove
        System.out.println("Request removed → Patient ID: " + value);
        front = front.next; //removing part
        if (front == null) {  //If the deleted element is the last element
            rear = null;     //front will now be null
        }                   //In this case: rear should also be set to null.
        return value; // returning removed element
    }


    //The basic logic in Queue's size() method is very simple:
    // there are two solutions here.
    // 1. Counting how many nodes (nodes / requests) there are in the queue and rotating them.
    // 2. Maintaining a size counter helps count the size of the queue in the enqueue and dequeue methods.
    //    this is the case when the time complexity is at least O(1)
    //    When enqueue() is called, size++
    //    When dequeue() is called, size--

    public int size (){ // i choose the first one because i wanted learn but time complexity affected badly
        int count = 0;                              // first way of time complexity is O(n)
        TreatmentRequest current = front.next;      // second way of time complxity is O(1)
        while (current != null){                    //The while loop goes to each node 1 time
            count++;                                //but size++ , size--  Only one variable is being returned
            current = current.next;
        }
        System.out.println("Current queue size: " + count);
        return count;
    }
    //printing method by using printf to align message and make output more readeable
    public void printQueue(){
        TreatmentRequest temp = front;
        System.out.println("\nTREATMENT QUEUE");
        System.out.println("-------------------------------------------");
        System.out.println("Patient ID      Arrival Time");
        System.out.println("-------------------------------------------");
        while (temp != null){
            System.out.printf("%-15d %-20d\n",
                    temp.patientId, temp.arrivalTime);
            temp = temp.next;
        }
        System.out.println("-------------------------------------------\n");
    }

}
