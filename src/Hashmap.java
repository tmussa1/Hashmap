import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args){

        HashMap<Integer,String> mymap = new HashMap<Integer, String>();

        Scanner input = new Scanner(System.in);

        System.out.println("Tell the map to add this values ");
        mymap.put(10, "Ten");
        mymap.put(11, "Eleven");
        mymap.put(12, "Twelve");

        String filename = System.getProperty("user.dir") + File.separatorChar + "map.txt";

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
            oos.writeObject(mymap);
            oos.flush();
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{


            File myfile = new File(filename);
            FileInputStream fis = new FileInputStream(myfile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            mymap = (HashMap<Integer, String>)ois.readObject();
            ois.close();
            fis.close();

            /*
            BufferedReader BR = new BufferedReader(new FileReader(new File(filename)));
            String line = BR.readLine();
            while(line != null){
                String [] parts = line.split(" ");
                mymap.put(Integer.valueOf(parts[0]), parts[1]);
            }
            BR.close();
            */
            for(Integer key : mymap.keySet()){
                System.out.println("Keys: " + key);
            }
            for(String value: mymap.values()){
                System.out.println("Values: " + value);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Enter a number: ");
        Integer keyboard = input.nextInt();

        if(mymap.containsKey(keyboard)) {
            System.out.println("You entered " + mymap.get(keyboard));
        }
    }
}
