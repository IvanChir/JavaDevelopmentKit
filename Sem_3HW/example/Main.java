package org.example;


public class Main {
    public static void main(String[] args) {
        InMemoryDatabase<String> db = new InMemoryDatabase<>();

        db.save("First Entry");
        db.save("Second Entry");

        System.out.println("Get by ID 0: " + db.getById(0));

        db.delete("First Entry");
        System.out.println("Get by ID 0 after deletion: " + db.getById(0));
    }
}