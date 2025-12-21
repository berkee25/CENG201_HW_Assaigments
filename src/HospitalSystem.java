class HashMap<K, V> {
    //what we create here is a node hashtable , so table can hold ANY data type
    //local node class
    class Node {
        K key;
        V value;
        Node next;

        //constructor
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    //HASHTABLE, we always choose the size of it AS A PRIME NUMBER
    // since prime number provides us mor randomness
    private int size ; //It holds the number of indexes that the hash table will consist of.

    private Object[] Hashtable; //The type of the hashtable array must be Node[].

    HashMap(int size) {
        this.size = size;
        this.Hashtable = new Object[size];//the assaigments wants that create a generic hash table so we use that
        //if we use int key and int value not generic type of hash table we can use this.table = new Node[size];
    }

    private int hash(K key) {                   //key.hashCode() → converts the key to a number
        return Math.abs(key.hashCode()) % size; //Math.abs(.key.hashCode() → converts the key to a number
    }                                           //Math.abs(...) → no negative index

    public void put(K key, V value) {
        int index = hash(key); // an index between 0-12
        Node head = (Node) Hashtable[index];//head  is the first element of the linked list in that index

        if (head == null) {
            //if table is empty insert key in the table
            Hashtable[index] = new Node(key, value);
        } else {
            Node temp = head;
            Node prev = null;

            while (temp != null) {
                if (temp.key.equals(key)) {
                    temp.value = value; //new key added
                }
                prev = temp;
                temp = temp.next;
            }

            prev.next = new Node(key, value); //that code line solves collusion by chaining.
            //Chaining is a structure that prevents collusion that occur
            //when multiple keys with the same value are sorted  consecutively in a hash table!!
        }
    }

    public V get(K key) {  //find
        int index = hash(key); // keep the value
        Node head = (Node) Hashtable[index]; // assaign value to head

        while (head != null) { //search
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Not found
    }

    public void remove(K key) {
        int index = hash(key);
        Node head = (Node) Hashtable[index];
        Node prev = null;

        while (head != null) {
            if (head.key.equals(key)) {                             //Note: head.key == key	,  head.key.equals(key) are not the same!!
                if (prev == null) Hashtable[index] = head.next;     //head.key == key	compares simple values
                else prev.next = head.next;                         //but ead.key.equals(key) compares the value of the referenced object !!!
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
class HospitalSystem {

    private patientList admittedPatients; // Inpatients
    private TreatmentQueue waitingQueue;  // Queue for pending treatment requests
    private DisChargeStack dischargedPatients;  // Discharged patient records (LIFO)

    private HashMap<Integer, patient> lookup;
    //The reason I created a generic hashtable like the one above is so that I can run this line because it is requested in the given direction.
    HospitalSystem() {
        admittedPatients = new patientList();
        waitingQueue = new TreatmentQueue();
        dischargedPatients = new DisChargeStack();
        lookup = new HashMap<>(13);
    }
    // 1.Adding new patient in the system
    public void addNewPatient(patient p) {
        admittedPatients.addPatient(p.id, p.name, p.severity, p.age);
        lookup.put(p.id, p);// Adds the new patient into the HashMap. //Time complexity is (O(1)) searching by ID.
    }

    public void addTreatmentRequest(int patientId) { //The purpose of the method is to create a treatment request for a patient when the patient ID is given and to store it in the queue.
        if (lookup.get(patientId) == null) {
            System.out.println("ERROR → Patient not found: " + patientId);
        }
        boolean isPriority = (lookup.get(patientId).severity >= 5); // Determine priority based on severity
        TreatmentRequest request = new TreatmentRequest(patientId,isPriority);
        //So the parameter of the enqueue method must be a TreatmentRequest object. Just sending the patientId is not enough, because both the ID and time information are stored in the queue!!
        waitingQueue.enqueue(request);
        System.out.println("SYSTEM → Treatment request added for " + patientId);
    }
    // 3. Add discharge record
    public void addDischargeRecord(int patientId) {
        if (lookup.get(patientId) == null) {
            System.out.println("ERROR → Patient not found: " + patientId);
        }
        dischargedPatients.push(new DisChargeRecord(patientId));
        System.out.println("SYSTEM → Discharge record added for Patient " + patientId);
    }


    public void processTreatment() {
        if (waitingQueue.isEmpty()) {
            System.out.println("SYSTEM → No requests to process");
        }
        //remove patients from queue (priority patients first)
        int patientId = waitingQueue.dequeue();
        //then delete the patient record because the treatment has ended
        admittedPatients.removePatient(patientId);
        //move to discharge stack
        dischargedPatients.push(new DisChargeRecord(patientId));
        System.out.println("SYSTEM → Patient " + patientId + " processed and moved to discharge stack.");
    }

    public void bubbleSearch() {
        //1. check list is empty or not
        if (admittedPatients.head == null) {
            System.out.println("No admitted patients.");
        }
        // add a counter to find length of list
        int count = 0;
        patient temp = admittedPatients.head;
        //traverse the list
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        // create a array
        patient[] patients = new patient[count];

        // Linked list → array
        temp = admittedPatients.head;
        int k = 0;
        while (temp != null) {
            patients[k++] = temp;
            temp = temp.next;
        }

        // Bubble sort (order by severity)
        for (int i = patients.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i ; j++) {

                if (patients[j].severity > patients[j + 1].severity) {
                    patient swap = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = swap;
                }
            }
        }
        //print ordered list
        System.out.println("\nPATIENTS SORTED BY SEVERITY (LOW → HIGH)");
        for (patient p : patients) {
            System.out.println(p.name + " - Severity: " + p.severity);
        }

       }

    public void printSystemState() {
        System.out.println("\n--- CURRENT HOSPITAL SYSTEM STATE ---");
        admittedPatients.printList();
        waitingQueue.printQueue();
        dischargedPatients.printStack();
    }
}


//The diamond operator (<>) is used with generics to avoid repeating the type on the right-hand side of an assignment.

//Purpose of the diamond operator:

//Removes duplicate type declarations
//Makes code cleaner and shorter
//Still keeps full type safety
//Compiler infers the type automatically


