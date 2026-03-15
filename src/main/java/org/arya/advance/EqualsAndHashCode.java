package org.arya.advance;

import org.arya.interview.Employee;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Emp {

    private int id;

    private String name;


    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        // 1. Check same reference
        if (this == o) return true;

        // 2. Check null and class type
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Cast and compare fields
        Emp employee = (Emp) o;
        return this.id == employee.getId() &&
                Objects.equals(this.name, employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}

public class EqualsAndHashCode {

    public static void main(String[] args) {

        Emp e1 = new Emp(1, "muni");
        Emp e2 = new Emp(1, "muni");
        Emp e3 = new Emp(1, "muni");

        Set<Emp> emps = new HashSet<>();

        emps.add(e1);
        emps.add(e2);
        emps.add(e3);

        System.out.println(emps);

    }
}
