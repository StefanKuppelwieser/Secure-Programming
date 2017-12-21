/**
 * This is the contain the main method
 *
 * @author Stefan Kuppelwieser <edelblistar@online.de>
 */
public class Main {

    public static void main(String[] args) {

        // Initialize objects
        Base64Crypt base64Crypt = new Base64Crypt();
        Task task = new Task(base64Crypt);

        // Work the task off
        task.two("input.txt");
        task.three("input2.txt");
    }
}
