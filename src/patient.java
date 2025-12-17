//Node class
public class patient {
    int id;
    String name;
    int severity; //severity means level of illness(1-10)
    int age;
    patient next;
    //constructor
    patient(int id, String name, int severity, int age) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.age = age;
        this.next = null;
    }
}
class patientList{
    patient head;

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
        patient pat = new patient(id, name, severity, age);
        //that "if" is checking whether list is empty or not
        if (head ==null){ //if the list is empty
            head = pat; //add 1st element on top
        }else{
            patient temp = head;
            while (temp.next != null && temp.next.id < pat.id){ // temp.next.id < pat.id we can use " < " instead of " != "
                temp = temp.next; //so tmp moves forward one!!
            }
            pat.next = temp.next; // Connect the new node to the following node,
            temp.next = pat;    // so we can insert it in between without breaking the list.
        }
    }
    //removing patients by id
    public void removePatient(int id) {
        patient temp = head;
        if  (head ==null){
            System.out.println("Patient list is empty");
        }
        if (head.id == id) { // if the head itself is the one to remove !!
            System.out.println("Removing patient with id " + id + " " + head.name);
            head = head.next; // deleting first element in linked list
        }
        while (temp.next != null && temp.id == id) { // traverse to find element in the list
            System.out.println("Removing patient with id " + id + " " + temp.next.name);
                temp.next = temp.next.next;
                break;
            }
    }
    //seeking elements
    public void findPatient(int id){
        if(head == null){
            System.out.println("Patient list is empty!");
        }
        patient temp = head;
        while (temp != null) { //traverse the list when the find out the node wanted
            if (temp.id == id){
                System.out.println("Patient found: " + temp.name + " ID: " + temp.id + ", severity: " + temp.severity + ", age: " + temp.age);
            }
            temp = temp.next;
        }
    }
    //printing all elements
    public void printList(){
        patient temp = head;
        while(temp != null){
            System.out.println("-------------");
            System.out.println(temp.id + " " + temp.name + " " + temp.severity + " " + temp.age + " ");
            temp = temp.next;
        }
    }
}
