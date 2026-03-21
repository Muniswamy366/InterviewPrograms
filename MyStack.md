If the interviewer asks **“implement your own Stack in Java”**, the simplest approach is using an **array (LIFO – Last In First Out)**.

---

# Custom Stack Implementation (Using Array)

```java
class MyStack<T> {

    private Object[] data;
    private int top = -1;
    private int capacity = 10;

    public MyStack() {
        data = new Object[capacity];
    }

    public void push(T element) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        data[++top] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        T value = (T) data[top];
        data[top--] = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
```

---

# Example Usage

```java
public class Main {

    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop());  // 30
        System.out.println(stack.pop());  // 20
        System.out.println(stack.size()); // 1
    }
}
```

---

# Stack Operations

| Operation | Description        | Complexity |
| --------- | ------------------ | ---------- |
| push()    | Add element to top | O(1)       |
| pop()     | Remove top element | O(1)       |
| peek()    | View top element   | O(1)       |
| isEmpty() | Check empty stack  | O(1)       |

---

# Follow-up Interview Questions

### 1️⃣ Stack using LinkedList

Instead of array:

```java
Node -> Node -> Node
```

No size limitation.

---

### 2️⃣ Java built-in Stack alternatives

Better to use:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

Because `Stack` class is **legacy**.

---

### 3️⃣ Real Stack Applications

* **Undo operations**
* **Function call stack**
* **Expression evaluation**
* **Parentheses validation**
* **DFS traversal**

---

### Short Interview Answer

You can say:

> A stack follows LIFO order. We can implement it using an array by maintaining a top pointer. Push adds an element to the top, pop removes the top element, and peek returns the top element without removing it.

---

If you want, I can also show **a very impressive interview problem: implementing Stack using two Queues (asked in many Java interviews)**.
