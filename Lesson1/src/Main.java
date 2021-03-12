//This program convert number of bytes by comfortable view
//

//library for comfortable work with output data
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This program convert number of bytes by comfortable view.");
        System.out.println("Enter number of bytes:");

        try{
            convertByte(in.nextLong());
        } catch(Exception e) {
            System.out.println("Data is not correct!");
            System.out.println("You can only enter natural numbers!");
        }
    }//end main

    private static void convertByte(long bytes){

        if (bytes <= 0){
            System.out.print("Data is not correct!");
            System.out.println("You can only enter natural numbers!");
            return;
        }
        double temp = (double) bytes;
        int i = 0;                                                      //counter for cycle and switch
        for (; temp > 1024.0; ++i){
            temp /= 1024;
        }

        String numberBytes = String.format("%.1f", temp);               //convert format
        switch (i){
            case 0: System.out.println(numberBytes + " B");break;
            case 1: System.out.println(numberBytes + " KiB");break;
            case 2: System.out.println(numberBytes + " MiB");break;
            case 3: System.out.println(numberBytes + " GiB");break;
            case 4: System.out.println(numberBytes + " TiB");break;
            case 5: System.out.println(numberBytes + " PiB");break;
            case 6: System.out.println(numberBytes + " EiB");break;
            case 7: System.out.println(numberBytes + " ZiB");break;
            case 8: System.out.println(numberBytes + " YiB");break;
        }
    }//end convertByte
}