# Producer Consumer Pattern in Java

All approaches to implement Producer-Consumer pattern, ranked from **best to worst**:

---

## 1. ⭐ Using BlockingQueue (Best - Recommended)
```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Produced: " + i);
                    queue.put(i); // Blocks if queue is full
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int value = queue.take(); // Blocks if queue is empty
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```
**Pros**: Simple, thread-safe, no manual synchronization needed

---

## 2. Using wait() and notify()
```java
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWaitNotify {
    private static final int MAX_SIZE = 5;
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Object lock = new Object();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    synchronized (lock) {
                        while (queue.size() == MAX_SIZE) {
                            System.out.println("Queue full, producer waiting...");
                            lock.wait();
                        }

                        queue.add(i);
                        System.out.println("Produced: " + i + " | Queue size: " + queue.size());
                        lock.notifyAll();
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    synchronized (lock) {
                        while (queue.isEmpty()) {
                            System.out.println("Queue empty, consumer waiting...");
                            lock.wait();
                        }

                        int value = queue.poll();
                        System.out.println("Consumed: " + value + " | Queue size: " + queue.size());
                        lock.notifyAll();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

## 3. Using ReentrantLock + Condition
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerReentrantLock {
    private static final int MAX_SIZE = 5;
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    lock.lock();
                    try {
                        while (queue.size() == MAX_SIZE) {
                            System.out.println("Queue full, producer waiting...");
                            notFull.await();
                        }

                        queue.add(i);
                        System.out.println("Produced: " + i + " | Queue size: " + queue.size());
                        notEmpty.signal();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    lock.lock();
                    try {
                        while (queue.isEmpty()) {
                            System.out.println("Queue empty, consumer waiting...");
                            notEmpty.await();
                        }

                        int value = queue.poll();
                        System.out.println("Consumed: " + value + " | Queue size: " + queue.size());
                        notFull.signal();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

## 4. Multiple Producers and Consumers
```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiProducerConsumer {
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {
        // 2 Producers
        for (int i = 1; i <= 2; i++) {
            final int producerId = i;
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 5; j++) {
                        int value = producerId * 100 + j;
                        queue.put(value);
                        System.out.println("Producer-" + producerId + " produced: " + value);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Producer-" + i).start();
        }

        // 3 Consumers
        for (int i = 1; i <= 3; i++) {
            final int consumerId = i;
            new Thread(() -> {
                try {
                    while (true) {
                        int value = queue.take();
                        System.out.println("Consumer-" + consumerId + " consumed: " + value);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Consumer-" + i).start();
        }
    }
}
```

---

## 5. Using Semaphore
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphore {
    private static final int MAX_SIZE = 5;
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final Semaphore empty = new Semaphore(MAX_SIZE); // Available slots
    private static final Semaphore full = new Semaphore(0);         // Filled slots
    private static final Semaphore mutex = new Semaphore(1);        // Mutual exclusion

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    empty.acquire(); // Wait if queue is full
                    mutex.acquire(); // Lock

                    queue.add(i);
                    System.out.println("Produced: " + i + " | Queue size: " + queue.size());

                    mutex.release(); // Unlock
                    full.release();  // Signal consumer
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    full.acquire();  // Wait if queue is empty
                    mutex.acquire(); // Lock

                    int value = queue.poll();
                    System.out.println("Consumed: " + value + " | Queue size: " + queue.size());

                    mutex.release(); // Unlock
                    empty.release(); // Signal producer
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

## Visual Flow:
```
Producer                Queue (max=5)              Consumer
   |                    [  ] [  ] [  ] [  ] [  ]      |
   |--- put(1) ------> [1 ] [  ] [  ] [  ] [  ]      |
   |--- put(2) ------> [1 ] [2 ] [  ] [  ] [  ]      |
   |                    [2 ] [  ] [  ] [  ] [  ] <--- take() = 1
   |--- put(3) ------> [2 ] [3 ] [  ] [  ] [  ]      |
   |                    [3 ] [  ] [  ] [  ] [  ] <--- take() = 2
```

---

## Comparison Table:

| Feature | BlockingQueue | wait/notify | ReentrantLock | Semaphore |
|---------|--------------|-------------|---------------|-----------|
| Simplicity | ✅ Simple | ⚠️ Medium | ⚠️ Medium | ❌ Complex |
| Thread-safe | ✅ Built-in | ⚠️ Manual | ⚠️ Manual | ⚠️ Manual |
| Fairness | ✅ Optional | ❌ No | ✅ Yes | ✅ Yes |
| Multiple conditions | ❌ No | ❌ No | ✅ Yes | ✅ Yes |
| Bounded buffer | ✅ Built-in | ⚠️ Manual | ⚠️ Manual | ⚠️ Manual |
| Multiple producers/consumers | ✅ Easy | ⚠️ Hard | ⚠️ Medium | ⚠️ Medium |

---

## 🏆 Ranking (Best to Worst):

1. **BlockingQueue** - Best: Simple, thread-safe, production-ready ⭐
2. **ReentrantLock + Condition** - Good: Separate conditions for full/empty
3. **Semaphore** - Good: Classic OS approach
4. **wait/notify** - Basic: Good for understanding concepts

---

## 💡 Recommendation:

### For production code (BEST):
```java
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);
// Producer: queue.put(item)
// Consumer: queue.take()
```

### For interviews (Know this):
```java
// wait/notify approach - shows understanding of threading concepts
```

**Use BlockingQueue for real projects, know wait/notify for interviews!**
