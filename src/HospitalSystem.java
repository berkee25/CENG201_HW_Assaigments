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

    private Node[] Hashtable; //The type of the hashtable array must be Node[].

    HashMap(int size) {
        this.size = size;
        this.Hashtable = (Node[]) new Object[size];//the assaigments wants that create a generic hash table so we use that
        //if we use int key and int value not generic type of hash table we can use this.table = new Node[size];
    }

    private int hash(K key) {                   //key.hashCode() → converts the key to a number
        return Math.abs(key.hashCode()) % size; //Math.abs(.key.hashCode() → converts the key to a number
    }                                           //Math.abs(...) → no negative index

    public void put(K key, V value) {
        int index = hash(key); // an index between 0-12
        Node head = Hashtable[index];//head  is the first element of the linked list in that index

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
        Node head = Hashtable[index]; // assaign value to head

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
        Node head = Hashtable[index];
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
        System.out.println("Patient " + p.id + " added.");
    }

    public void addTreatmentRequest(int patientId) {
        if (lookup.get(patientId) == null) {
            System.out.println("ERROR → Patient not found: " + patientId);
        }
        TreatmentRequest request = new TreatmentRequest(patientId);
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
        int patientId = waitingQueue.dequeue();
        dischargedPatients.push(new DisChargeRecord(patientId));
        System.out.println("SYSTEM → Patient treated & discharged: " + patientId);
    }

    public void printSystemState() {
        System.out.println("\n--- CURRENT SYSTEM STATE ---");
        System.out.println("Patients:");
        admittedPatients.printList();
        System.out.println("Discharged:");
        dischargedPatients.printStack();
    }
}


//The diamond operator (<>) is used with generics to avoid repeating the type on the right-hand side of an assignment.

//Purpose of the diamond operator:

//Removes duplicate type declarations
//Makes code cleaner and shorter
//Still keeps full type safety
//Compiler infers the type automatically


