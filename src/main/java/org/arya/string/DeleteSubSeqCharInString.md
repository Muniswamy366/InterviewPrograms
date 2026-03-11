# Delete Duplicate Characters in String

All approaches to delete duplicate characters from a string, ranked from **best to worst**:

---

## 1. ⭐ LinkedHashSet (Best - Preserves Order)
```java
public static String removeDuplicates(String str) {
    Set<Character> set = new LinkedHashSet<>();
    for (char c : str.toCharArray()) {
        set.add(c);
    }
    StringBuilder result = new StringBuilder();
    for (char c : set) {
        result.append(c);
    }
    return result.toString();
}

// Usage:
String str = "programming";
System.out.println(removeDuplicates(str)); // Output: "progamin"
```
**Time**: O(n) | **Space**: O(n) | **Preserves order**: ✅

---

## 2. ⭐ StringBuilder with indexOf (Good - No Extra Collection)
```java
public static String removeDuplicates(String str) {
    StringBuilder result = new StringBuilder();
    for (char c : str.toCharArray()) {
        if (result.indexOf(String.valueOf(c)) == -1) {
            result.append(c);
        }
    }
    return result.toString();
}
```
**Time**: O(n²) | **Space**: O(n) | **Preserves order**: ✅

---

## 3. ⭐ Using Streams (Java 8+ - Functional Style)
```java
public static String removeDuplicates(String str) {
    return str.chars()
        .mapToObj(c -> (char) c)
        .distinct()
        .map(String::valueOf)
        .collect(Collectors.joining());
}
```
**Time**: O(n) | **Space**: O(n) | **Preserves order**: ✅

---

## 4. 👍 Boolean Array (Fast for ASCII)
```java
public static String removeDuplicates(String str) {
    boolean[] seen = new boolean[128]; // ASCII
    StringBuilder result = new StringBuilder();
    
    for (char c : str.toCharArray()) {
        if (!seen[c]) {
            seen[c] = true;
            result.append(c);
        }
    }
    return result.toString();
}
```
**Time**: O(n) | **Space**: O(1) - fixed size | **Preserves order**: ✅

---

## 5. 👍 HashSet + StringBuilder (Good Balance)
```java
public static String removeDuplicates(String str) {
    Set<Character> seen = new HashSet<>();
    StringBuilder result = new StringBuilder();
    
    for (char c : str.toCharArray()) {
        if (seen.add(c)) { // add returns false if already exists
            result.append(c);
        }
    }
    return result.toString();
}
```
**Time**: O(n) | **Space**: O(n) | **Preserves order**: ✅

---

## 6. 👎 Two Loops (No Extra Space but Slow)
```java
public static String removeDuplicates(String str) {
    StringBuilder result = new StringBuilder();
    
    for (int i = 0; i < str.length(); i++) {
        boolean isDuplicate = false;
        for (int j = 0; j < i; j++) {
            if (str.charAt(i) == str.charAt(j)) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            result.append(str.charAt(i));
        }
    }
    return result.toString();
}
```
**Time**: O(n²) | **Space**: O(n) | **Preserves order**: ✅

---

## 7. 👎 Recursion (Inefficient)
```java
public static String removeDuplicates(String str) {
    if (str.length() <= 1) return str;
    
    char first = str.charAt(0);
    String rest = removeDuplicates(str.substring(1));
    
    if (rest.indexOf(first) != -1) {
        return rest;
    }
    return first + rest;
}
```
**Time**: O(n²) | **Space**: O(n) - call stack | **Preserves order**: ✅

---

## 8. ❌ Sorting (Destroys Order - Worst)
```java
public static String removeDuplicates(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    
    StringBuilder result = new StringBuilder();
    result.append(chars[0]);
    
    for (int i = 1; i < chars.length; i++) {
        if (chars[i] != chars[i - 1]) {
            result.append(chars[i]);
        }
    }
    return result.toString();
}

// "programming" -> "agimnopr" (order lost!)
```
**Time**: O(n log n) | **Space**: O(n) | **Preserves order**: ❌

---

## 9. ❌ Using replace() in Loop (Very Inefficient)
```java
public static String removeDuplicates(String str) {
    StringBuilder result = new StringBuilder();
    String temp = str;
    
    while (!temp.isEmpty()) {
        char c = temp.charAt(0);
        result.append(c);
        temp = temp.replace(String.valueOf(c), "");
    }
    return result.toString();
}
```
**Time**: O(n²) | **Space**: O(n) | **Creates many String objects**: ❌

---

## 🏆 Ranking Summary (Best to Worst):

1. **LinkedHashSet** - Best overall (O(n), preserves order, clean)
2. **Boolean Array** - Fastest for ASCII (O(n), O(1) space)
3. **HashSet + StringBuilder** - Good balance
4. **Streams (distinct)** - Modern, functional
5. **StringBuilder with indexOf** - Simple, no extra collection
6. **Two Loops** - No extra space but slow
7. **Recursion** - Elegant but inefficient
8. **Sorting** - Destroys order
9. **replace() in Loop** - Very inefficient

---

## 💡 Recommendation:

### For general use (BEST):
```java
public static String removeDuplicates(String str) {
    Set<Character> seen = new HashSet<>();
    StringBuilder result = new StringBuilder();
    for (char c : str.toCharArray()) {
        if (seen.add(c)) {
            result.append(c);
        }
    }
    return result.toString();
}
```

### For ASCII only (FASTEST):
```java
public static String removeDuplicates(String str) {
    boolean[] seen = new boolean[128];
    StringBuilder result = new StringBuilder();
    for (char c : str.toCharArray()) {
        if (!seen[c]) {
            seen[c] = true;
            result.append(c);
        }
    }
    return result.toString();
}
```
