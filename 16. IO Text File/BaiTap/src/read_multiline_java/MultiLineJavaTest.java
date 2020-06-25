package read_multiline_java;

import java.util.Scanner;

class MultiLineJavaTest
{
    // Read multi-line input from console in Java using Scanner class
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line,str="";
        while(true){
            line = scanner.nextLine();
            str += line+"\n";
            if(line.equals("")){
                break;
            }
        }
        System.out.println(str);
    }
}

