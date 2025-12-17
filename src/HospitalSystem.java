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
    private int size; //It holds the number of indexes that the hash table will consist of.

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
        int index = hash(key);
        Node head = Hashtable[index];

        while (head != null) {
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
class HospitalSystem{

    private patientList admittedPatients;         // Inpatients  //A patientList object that stores all patients currently admitted in the hospital.
    private TreatmentQueue waitingQueue;         // Queue for pending treatment requests //A queue (FIFO) that stores treatment requests using linked-list nodes (TreatmentRequest).
    private DisChargeStack dischargedPatients;  // Discharged patient records //A stack structure containing patients who have been discharged. //LIFO behavior

    HashMap<Integer, patient> lookup;
    //The reason I created a generic hashtable like the one above is so that I can run this line because it is requested in the given direction.

    HospitalSystem() {
        this.admittedPatients = new patientList();
        this.waitingQueue = new TreatmentQueue();
        this.dischargedPatients = new DisChargeStack();
        this.lookup = new HashMap<>(10);
    }

    // 1.Adding new patient in the system
    public void addNewPatient(patient p) {
        admittedPatients.addPatient(p.id, p.name, p.severity, p.age);
        lookup.put(p.id, p); // Adds the new patient into the HashMap. //Time complexity is (O(1)) searching by ID.
        System.out.println("SYSTEM: Patient " + p.id + " registered and mapped.");
    }

    // 2.Adding treatment request to the queue
    public void addWaitingRequest(int patientId) {
//        patient p = lookup.get(patientId); //Is there a patient with ID → Check from Lookup
//
//        if (p == null) {
//            System.out.println("SYSTEM ERROR: Patient ID " + patientId + " not found in the system.");
//        }
//
//        TreatmentRequest request = new TreatmentRequest(patientId);
//        //we create a object to get id from queue
//        waitingQueue.enqueue(request);
//        System.out.println("SYSTEM: Treatment request for Patient " + patientId + " added to the queue.");
    }

    // 3.Adding discharge record
    public void addDischargeRequest(int patientId) {
        DisChargeRecord record = new DisChargeRecord(patientId);

        dischargedPatients.push(record);
        System.out.println("SYSTEM: Discharge record for Patient " + patientId + " added to the stack.");
    }
}

//The diamond operator (<>) is used with generics to avoid repeating the type on the right-hand side of an assignment.

//Purpose of the diamond operator:

//Removes duplicate type declarations
//Makes code cleaner and shorter
//Still keeps full type safety
//Compiler infers the type automatically


