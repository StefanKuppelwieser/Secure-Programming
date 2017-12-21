import java.io.*;
import java.util.*;

/**
 * This class contain the task two, three and four
 *
 * @author Stefan Kuppelwieser <edelblistar@online.de>
 */
public class Task {

    /**
     * Declare object Base64Crypt
     */
    private Base64Crypt base64Crypt;

    /**
     * Overloaded constructor
     *
     * @param base64Crypt It expect the initialized object of type Base64Crypt
     */
    public Task(final Base64Crypt base64Crypt) {
        // Initialize variables
        this.base64Crypt = base64Crypt;
    }

    /**
     * <p>The task two works off</p>
     * <p>Write a program, which does base64-encoding with input given from a file and output it to a second file.</p>
     *
     * @param file It expect the path of the file and filename
     */
    public void two(final String file) {
        ArrayList<String> inputArrayList = readFile(file);

        System.out.println("----- Task 2 -----");

        for(int i = 0; i < inputArrayList.size(); i++){
            System.out.println("The encoded Code number " + (i + 1) + " of type based64 " + inputArrayList.get(i) + " was decoded to: " + this.base64Crypt.decode(inputArrayList.get(i)));
        }

        System.out.println("");
    }

    /**
     * <p>The task three works off</p>
     * <p>Create 10.000 128-bit random keys in Windows-7 (using WinAPI), encode it with base64, save it to a file and check if 2 identical keys appeared.</p>
     *
     * @param file It expect the path of the file and filename
     */
    public void three(final String file) {

        ArrayList<String> keyArrayList = new ArrayList<>();

        System.out.println("----- Task 3 -----");

        System.out.print("Start task 3!");

        System.out.println("");

        for(int i = 0; i < 10000; i++){
            String key = this.base64Crypt.keyToString(this.base64Crypt.generateBase64Key());
            keyArrayList.add(i, key);
        }


        if(deleteExistingFile(file)){
            crateFile(file);
            writeFileAndEncode(file, keyArrayList);
        }

        System.out.println("In the file " + file + " are " + recordDuplicateEntrys(keyArrayList) + " entrys duplicate!");

        System.out.println("Task 3 was successful!");
    }

    /**
     * <p>It takes a existing file and save each entry from the param keyArrayList in a new line</p>
     *
     * @param file It expect the path of the file and filename
     * @param keyArrayList It expect the keyArraayList with all keys
     */
    private void writeFileAndEncode(final String file, final ArrayList<String> keyArrayList){

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            String newLine = System.getProperty("line.separator");

            for(int i = 0; i < keyArrayList.size(); i++){
                if(i != 0){
                    dos.writeBytes(newLine);
                }
                dos.writeBytes(this.base64Crypt.encode(keyArrayList.get(i)));
            }

            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>It record duplicate entrys of a ArrayList and return it as integer</p>
     *
     * @param arrayList It expect the path of the file and filename
     * @return The amount of duplicate entries
     */
    private int recordDuplicateEntrys(final ArrayList<String> arrayList){

        int recorder = 0;

        Set<String> uniqueSet = new HashSet<String>(arrayList);
        for (String temp : uniqueSet) {
            recorder += Collections.frequency(arrayList, temp) -1;
        }

        return recorder;
    }

    /**
     * <p>If the file already exists, it will be deleted</p>
     *
     * @param file It expect the path of the file and filename
     * @return the status if it was successful (true) or not (false)
     */
    private static boolean deleteExistingFile(final String file){

        File f = new File(file);

        if(f.exists()) {
            if(f.delete()){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Create a new file
     *
     * @param file It expect the path to the file and filename
     * @return the status if it was successful (true) or not (false)
     */
    private boolean crateFile(final String file){

        try {
            // Use relative path for Unix systems
            File f = new File(file);

            f.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * It reads the file and save each row as additional ArrayList entry
     *
     * @param file It expect the path to the file and filename
     * @return
     */
    private static ArrayList<String> readFile(final String file){

        ArrayList<String> arrayList = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                arrayList.add(line);
                line = br.readLine();
            }

        }  catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return arrayList;
    }
}
