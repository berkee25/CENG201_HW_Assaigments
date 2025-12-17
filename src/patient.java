//Node class
public class patient {
    int id;
    String name;
    int severity; //severity means level of illness(1-10)
    int age;
    patient next;
    //constructor
    patient(int id, String name, int severity, int age) { //parameterized constructor method
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.age = age;
        this.next = null;
    }
}
class patientList{
    patient head; //node

    /*
    Example:
    head → [10 | •] → null
    current → [10 | •]
    Adding new node:
    newNode = [20 | null]
    current.next = newNode; → 10 of next show 20 now.
    */

    //adding patients to the list
    public void addPatient(int id, String name, int severity, int age){
        patient pat = new patient(id, name, severity, age); // create add an object to add element and its features in the linked list
        //that "if" is checking whether list is empty or not
        if (head ==null){ //check the list empty
            head = pat; //add 1st element
            System.out.println("Patient added  → ID: " + id + ", Name: " + name);
        }else{ //if it is not empty
            patient temp = head; // store the adding element in the node
            while (temp.next != null && temp.next.id < pat.id){ // temp.next.id < pat.id we can use " < " instead of " != "
                temp = temp.next; //so tmp moves forward one!!
            }
            pat.next = temp.next; // Connect the new node to the following node.
            temp.next = pat;    // so we can insert it in between without breaking the list.
            System.out.println("Patient added  → ID: " + id + ", Name: " + name);
        }
    }

    //removing patients by id
    public void removePatient(int id) {
        patient temp = head; //store values of head in the node
        if  (head ==null){ // check the list is empty
            System.out.println("Patient list is empty"); // print empty message
        }
        if (head.id == id) { // if the head itself is the one to remove !!
            System.out.println("Patient removed → ID: " + id + ", Name: " + head.name); //print the element is removed message
            head = head.next; // deleting first element in linked list
        }
        while (temp.next != null && temp.next.id != id) { // traverse to find element in the list while temp.next node does not equal null and temp.next.id does not equal id
            temp = temp.next;
        }
        // when that 2 condition are met , check the if condition
        if (temp.next == null) { // element does not exist
            System.out.println("Patient not found → ID: " + id);
        }
        else { // element is removed
            System.out.println("Patient removed → ID: " + id + ", Name: " + temp.next.name);
            temp.next = temp.next.next;
        }
    }

    //seeking elements
    public void findPatient(int id){
        if(head == null){
            System.out.println("Patient list is EMPTY!");
            return;
        }
        patient temp = head;
        while (temp != null) { //traverse the list when the find the node wanted
            if (temp.id == id){
                System.out.println("\nPATIENT FOUND");
                System.out.println("ID: " + temp.id +
                        "   Name: " + temp.name +
                        "   Severity: " + temp.severity +
                        "   Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Patient not found → ID: " + id);
    }
    //printing method by using printf to align message and make output more readable
    public void printList(){
        patient temp = head;
        System.out.println("\nPATIENT LIST");
        System.out.println("---------------------------------------------------------------");
        System.out.println("ID        Name                     Severity     Age");
        System.out.println("---------------------------------------------------------------");
        while(temp != null){
            System.out.printf("%-10d %-25s %-10d %-5d\n",
                    temp.id, temp.name, temp.severity, temp.age);
            temp = temp.next;
        }
        System.out.println("---------------------------------------------------------------");
    }
}
