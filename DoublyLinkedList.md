# Doubly Linked List in Java

Complete implementation covering all common interview questions.

---

## Complete Implementation:

```java
public class DoublyLinkedList {

    private Node head;
    private Node tail;

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // 3. Insert at position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }

    // 4. Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // 5. Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // 6. Delete by value
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Head node
        if (head.data == data) {
            deleteFromBeginning();
            return;
        }

        // Tail node
        if (tail.data == data) {
            deleteFromEnd();
            return;
        }

        // Middle node
        Node current = head.next;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println(data + " not found");
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    // 7. Search
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 8. Get size
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 9. Reverse
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to next (which is now prev)
        }

        // Swap head and tail
        temp = head;
        head = tail;
        tail = temp;
    }

    // 10. Find middle element
    public int findMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // 11. Print forward
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 12. Print backward
    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // 13. Check if palindrome
    public boolean isPalindrome() {
        Node front = head;
        Node back = tail;

        while (front != back && front.prev != back) {
            if (front.data != back.data) {
                return false;
            }
            front = front.next;
            back = back.prev;
        }

        return true;
    }

    // 14. Remove duplicates (sorted list)
    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                Node duplicate = current.next;

                current.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = current;
                } else {
                    tail = current;
                }
            } else {
                current = current.next;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtBeginning(5);
        list.insertAtPosition(25, 3);

        System.out.println("=== Doubly Linked List ===");
        list.printForward();              // 5 <-> 10 <-> 20 <-> 25 <-> 30 <-> 40 <-> null
        list.printBackward();             // 40 <-> 30 <-> 25 <-> 20 <-> 10 <-> 5 <-> null
        System.out.println("Size: " + list.size());  // 6

        // Search
        System.out.println("\n=== Search ===");
        System.out.println("Search 25: " + list.search(25));  // true
        System.out.println("Search 99: " + list.search(99));  // false

        // Middle
        System.out.println("\n=== Middle ===");
        System.out.println("Middle: " + list.findMiddle());   // 25

        // Delete
        System.out.println("\n=== Delete ===");
        list.deleteByValue(25);
        list.printForward();              // 5 <-> 10 <-> 20 <-> 30 <-> 40 <-> null

        list.deleteFromBeginning();
        list.printForward();              // 10 <-> 20 <-> 30 <-> 40 <-> null

        list.deleteFromEnd();
        list.printForward();              // 10 <-> 20 <-> 30 <-> null

        // Reverse
        System.out.println("\n=== Reverse ===");
        list.reverse();
        list.printForward();              // 30 <-> 20 <-> 10 <-> null
        list.printBackward();             // 10 <-> 20 <-> 30 <-> null

        // Palindrome
        System.out.println("\n=== Palindrome ===");
        DoublyLinkedList palindrome = new DoublyLinkedList();
        palindrome.insertAtEnd(1);
        palindrome.insertAtEnd(2);
        palindrome.insertAtEnd(1);
        palindrome.printForward();
        System.out.println("Is palindrome: " + palindrome.isPalindrome()); // true
    }
}
```

---

## Output:
```
=== Doubly Linked List ===
5 <-> 10 <-> 20 <-> 25 <-> 30 <-> 40 <-> null
40 <-> 30 <-> 25 <-> 20 <-> 10 <-> 5 <-> null
Size: 6

=== Search ===
Search 25: true
Search 99: false

=== Middle ===
Middle: 25

=== Delete ===
5 <-> 10 <-> 20 <-> 30 <-> 40 <-> null
10 <-> 20 <-> 30 <-> 40 <-> null
10 <-> 20 <-> 30 <-> null

=== Reverse ===
30 <-> 20 <-> 10 <-> null
10 <-> 20 <-> 30 <-> null

=== Palindrome ===
1 <-> 2 <-> 1 <-> null
Is palindrome: true
```

---

## Visual - Insert at End:
```
Before: 10 <-> 20 <-> 30 <-> null
Insert 40:

Step 1: Create newNode(40)
Step 2: tail.next = newNode     → 30.next = 40
Step 3: newNode.prev = tail     → 40.prev = 30
Step 4: tail = newNode          → tail = 40

After: 10 <-> 20 <-> 30 <-> 40 <-> null
```

---

## Visual - Delete Middle Node:
```
Before: 10 <-> 20 <-> 30 <-> 40 <-> null
Delete 20:

Step 1: Find node with data 20
Step 2: current.prev.next = current.next  → 10.next = 30
Step 3: current.next.prev = current.prev  → 30.prev = 10

After: 10 <-> 30 <-> 40 <-> null
```

---

## Visual - Reverse:
```
Before: 10 <-> 20 <-> 30 <-> null

Step 1: curr=10 → swap prev/next → null <- 10 -> null
Step 2: curr=20 → swap prev/next → 10 <- 20 -> null
Step 3: curr=30 → swap prev/next → 20 <- 30 -> null
Step 4: Swap head and tail

After: 30 <-> 20 <-> 10 <-> null
```

---

## Singly vs Doubly Linked List:

| Feature | Singly | Doubly |
|---------|--------|--------|
| Node size | data + next | data + prev + next |
| Traverse forward | ✅ | ✅ |
| Traverse backward | ❌ | ✅ |
| Delete from end | O(n) | O(1) with tail |
| Delete given node | O(n) need prev | O(1) has prev |
| Memory | Less | More (extra prev pointer) |
| Palindrome check | O(n) complex | O(n) simple |

---

## Operations Complexity:

| Operation | Time | Space |
|-----------|------|-------|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(1) | O(1) |
| Insert at position | O(n) | O(1) |
| Delete from beginning | O(1) | O(1) |
| Delete from end | O(1) | O(1) |
| Delete by value | O(n) | O(1) |
| Search | O(n) | O(1) |
| Reverse | O(n) | O(1) |
| Find middle | O(n) | O(1) |
| Palindrome check | O(n) | O(1) |

---

## 💡 Key Advantages over Singly Linked List:

1. ✅ **Delete from end** is O(1) - has tail pointer
2. ✅ **Traverse backward** - has prev pointer
3. ✅ **Palindrome check** is simpler - use front and back pointers
4. ✅ **Delete given node** is O(1) - has prev reference

**This covers all common doubly linked list interview questions!**
