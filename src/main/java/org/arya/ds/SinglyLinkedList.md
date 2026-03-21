# Singly Linked List in Java

Complete implementation covering all common interview questions.

---

## Complete Implementation:

```java
public class SinglyLinkedList {

    private Node head;

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
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
        current.next = newNode;
    }

    // 4. Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // 5. Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 6. Delete by value
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(data + " not found");
            return;
        }

        current.next = current.next.next;
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
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
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

    // 11. Detect cycle
    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 12. Find Nth node from end
    public int findNthFromEnd(int n) {
        Node first = head;
        Node second = head;

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                throw new IllegalArgumentException("n is greater than list size");
            }
            first = first.next;
        }

        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    // 13. Remove duplicates (sorted list)
    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // 14. Check if palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Find middle
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        // Compare
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private Node reverse(Node node) {
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    // 15. Print list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtBeginning(5);
        list.insertAtPosition(25, 3);

        System.out.println("=== Linked List ===");
        list.print();                    // 5 -> 10 -> 20 -> 25 -> 30 -> 40 -> null
        System.out.println("Size: " + list.size());  // 6

        // Search
        System.out.println("\n=== Search ===");
        System.out.println("Search 25: " + list.search(25));  // true
        System.out.println("Search 99: " + list.search(99));  // false

        // Middle element
        System.out.println("\n=== Middle ===");
        System.out.println("Middle: " + list.findMiddle());   // 25

        // Nth from end
        System.out.println("\n=== Nth From End ===");
        System.out.println("2nd from end: " + list.findNthFromEnd(2)); // 30

        // Delete
        System.out.println("\n=== Delete ===");
        list.deleteByValue(25);
        list.print();                    // 5 -> 10 -> 20 -> 30 -> 40 -> null

        list.deleteFromBeginning();
        list.print();                    // 10 -> 20 -> 30 -> 40 -> null

        list.deleteFromEnd();
        list.print();                    // 10 -> 20 -> 30 -> null

        // Reverse
        System.out.println("\n=== Reverse ===");
        list.reverse();
        list.print();                    // 30 -> 20 -> 10 -> null

        // Palindrome
        System.out.println("\n=== Palindrome ===");
        SinglyLinkedList palindrome = new SinglyLinkedList();
        palindrome.insertAtEnd(1);
        palindrome.insertAtEnd(2);
        palindrome.insertAtEnd(1);
        palindrome.print();
        System.out.println("Is palindrome: " + palindrome.isPalindrome()); // true
    }
}
```

---

## Output:
```
=== Linked List ===
5 -> 10 -> 20 -> 25 -> 30 -> 40 -> null
Size: 6

=== Search ===
Search 25: true
Search 99: false

=== Middle ===
Middle: 25

=== Nth From End ===
2nd from end: 30

=== Delete ===
5 -> 10 -> 20 -> 30 -> 40 -> null
10 -> 20 -> 30 -> 40 -> null
10 -> 20 -> 30 -> null

=== Reverse ===
30 -> 20 -> 10 -> null

=== Palindrome ===
1 -> 2 -> 1 -> null
Is palindrome: true
```

---

## Visual - Reverse Operation:
```
Before: 10 -> 20 -> 30 -> null

Step 1: prev=null, curr=10
        null <- 10    20 -> 30 -> null

Step 2: prev=10, curr=20
        null <- 10 <- 20    30 -> null

Step 3: prev=20, curr=30
        null <- 10 <- 20 <- 30

Step 4: curr=null, head=prev=30

After:  30 -> 20 -> 10 -> null
```

---

## Visual - Find Middle (Slow/Fast Pointer):
```
List: 5 -> 10 -> 20 -> 25 -> 30 -> 40 -> null

Step 1: slow=5,  fast=5
Step 2: slow=10, fast=20
Step 3: slow=20, fast=30
Step 4: slow=25, fast=null  → STOP!

Middle: 25
```

---

## Operations Complexity:

| Operation | Time | Space |
|-----------|------|-------|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) |
| Insert at position | O(n) | O(1) |
| Delete from beginning | O(1) | O(1) |
| Delete from end | O(n) | O(1) |
| Delete by value | O(n) | O(1) |
| Search | O(n) | O(1) |
| Reverse | O(n) | O(1) |
| Find middle | O(n) | O(1) |
| Detect cycle | O(n) | O(1) |
| Nth from end | O(n) | O(1) |

---

## 💡 Key Interview Questions Covered:

1. ✅ Insert (beginning, end, position)
2. ✅ Delete (beginning, end, by value)
3. ✅ Reverse a linked list
4. ✅ Find middle element
5. ✅ Detect cycle
6. ✅ Find Nth node from end
7. ✅ Remove duplicates
8. ✅ Check palindrome

**This covers all common linked list interview questions!**
