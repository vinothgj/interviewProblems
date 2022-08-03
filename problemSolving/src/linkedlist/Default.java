package linkedlist;

public interface Default {

    void log();
    void logWithParam();
    default void print() {
        System.out.println("Test");
    }

    default void printTest() {
        System.out.println("Test");
    }
}
