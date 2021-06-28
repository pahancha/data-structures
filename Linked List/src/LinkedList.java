public class LinkedList {
    Node head;

    //inserting an element to the end of the linked list
    public void append(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while (head != null){ //checking the last node of the linked list
            current = current.next;
        }
        current.next = new Node(data);
    }

    // adding an element to the beginning of the linked list aka changing the head of the linked list
    public void  prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    //deleting an element from the linked list
    public void deleteWithValue(int data){
        if (head == null){
            return;
        }
        if (head.data == data){ // if the removing data is the head
            head = head.next;
        }

        Node current = head;
        while (current.next !=null){
            if (current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
