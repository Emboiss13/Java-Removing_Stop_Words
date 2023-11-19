import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Removing_Stop_Words {

    public static void main( String[] args ) {

        ArrayList<String> listofWords_insertionSort = new ArrayList<String>();
        ArrayList<String> listofWords_MergeSort = new ArrayList<String>();

        if( args.length == 0) {
            System.out.println( "Please enter a text file as an argument to continue...");
        }
        else if ( args.length == 2){
            String StopWordFilePath = args[0];
            String input = args[1];
            listofWords_insertionSort = (ArrayList<String>)deleteStopwords(input, Read_File(StopWordFilePath));
            insertionSort(listofWords_insertionSort);
            listofWords_MergeSort = (ArrayList<String>)deleteStopwords(input, Read_File(StopWordFilePath));
            Integer r = listofWords_MergeSort.size();
            mergeSort(listofWords_MergeSort, 0, r-1);

            System.out.println(" ");
            System.out.println("This is the sorted text, without stop words and using the Insertion-Sort method:");
            System.out.println(" ");
            System.out.println(listofWords_insertionSort);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("This is the sorted text, without stop words and using the Merge-Sort method:");
            System.out.println(" ");
            System.out.println(listofWords_MergeSort);
            System.out.println(" ");
        }
                
        else{

            System.out.println("We couldn't find a text file in your argument."); 
            System.out.println("Make sure to separate the 2 text files with quotes, a space and to write .txt after the name of the file");
            System.out.println("PS: Remember not to separarate the files with a comma");     
            
        }
    }


    public static ArrayList<String> Read_File( String StopWordFilePath ){

        File fileIn = new File( StopWordFilePath );
        String line = "";
        try {
            Scanner in = new Scanner( fileIn );
            ArrayList<String> stopwords = new ArrayList<String>();

                //Iterates on every line within the file
                while( in.hasNextLine() ) {
                        // Get a line of the text file
                        line = in.nextLine();
                        stopwords.add(line);
                }
                in.close();
                return stopwords;
            }

        catch ( FileNotFoundException FileEx) {
        System.out.println("File not found exception");
        return null;

        }
    }

    public static List<String> deleteStopwords(String input , ArrayList<String> stopwords){

        File DSWfileIn = new File( input );
        String line2 = "";
        List<String> remainingWords = new ArrayList<>();

        try {
            Scanner scanner = new Scanner( DSWfileIn );

                //Iterates on every line within the file
                while( scanner.hasNextLine() ) {
                    // Get a line of the text file
                    line2 = scanner.nextLine();
                    String[] words = line2.split(" ");

                    List<String> wordList = new ArrayList<>(Arrays.asList(words));
                    wordList.removeAll(stopwords);

                    remainingWords.addAll(wordList);
                }
                scanner.close();
                return (List<String>)remainingWords;
                
            }

        catch ( FileNotFoundException e) {
        System.out.println("File not found exception");
        e.printStackTrace();
        return null;

        }
    }

    public static void insertionSort(ArrayList<String>listofWords_insertionSort) {
        int n = listofWords_insertionSort.size();
        
        for (int i = 1; i < n; i++) {
            String item = listofWords_insertionSort.get(i);
            int j = i - 1;
            
            while (j >= 0 && listofWords_insertionSort.get(j).compareTo(item) > 0) {
                listofWords_insertionSort.set(j + 1, listofWords_insertionSort.get(j));
                j--;
            }
            
            listofWords_insertionSort.set(j + 1, item);
        }
    }


    
    public static void mergeSort(ArrayList<String>listofWords_MergeSort, int p , int r) {

        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(listofWords_MergeSort, p, q);
            mergeSort(listofWords_MergeSort, q + 1, r);
            merge(listofWords_MergeSort, p, q, r);
        }

    }


    public static void merge(ArrayList<String>listofWords_MergeSort, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            left.add(listofWords_MergeSort.get(p + i));
        }

        for (int j = 0; j < n2; j++) {
            right.add(listofWords_MergeSort.get(q + j + 1));
        }

        int i = 0, j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                listofWords_MergeSort.set(k, left.get(i));
                i++;
            } else {
                listofWords_MergeSort.set(k, right.get(j));
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            listofWords_MergeSort.set(k, left.get(i));
            i++;
            k++;
        }
        
        while (j < n2) {
            listofWords_MergeSort.set(k, right.get(j));
            j++;
            k++;
        }
    }


}


    




