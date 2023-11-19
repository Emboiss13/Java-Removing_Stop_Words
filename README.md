# Removing Stop Words - Text Sorting Utility
This Java program provides functionality to process a text file, removing specified stop words, and then sorting the remaining words using both Insertion Sort and Merge Sort algorithms.

_____

## ⌨️Usage

To run the program, use the following command:
-     java Removing_Stop_Words [stopWordsFile] [inputTextFile]
- **stopWordsFile:** Path to the file containing stop words.
- **inputTextFile:** Path to the text file to be processed.
- Ensure that the file paths are enclosed in quotes if they contain spaces, and that the text file has a ".txt" extension.

______

## 🕵🏽‍♂️Implementation Details
### Input Validation
The program checks the command-line arguments to ensure that both the stop words file and the input text file are provided. If not, it displays an appropriate message.

### Stop Words Removal
The deleteStopwords method reads the input text file, splits it into words, and removes the stop words specified in the stop words file. The result is a list of words without stop words.

### Sorting Algorithms
- Two sorting algorithms are applied to the list of words without stop words:

- Insertion Sort: The insertionSort method is used to sort the words in ascending order.

- Merge Sort: The mergeSort method implements the Merge Sort algorithm to sort the words in ascending order.

### Output
The program outputs the sorted list of words using both Insertion Sort and Merge Sort, displaying them separately for comparison.

### Error Handling
The program handles file not found exceptions and provides appropriate error messages.

______

### 📝Notes
Make sure to enclose file paths in quotes if they contain spaces.
The program assumes that the input text file is formatted with words separated by spaces.
