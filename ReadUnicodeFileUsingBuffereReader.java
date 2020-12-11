package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadUnicodeFileUsingBuffereReader {

	public static void main(String[] args) throws IOException {
		try {
			File fileDir = new File("c:\\itcont.txt");
			  //provide the Search String here..
			String searchString = "LINCOLN";
			BufferedReader input= new BufferedReader(new FileReader(fileDir));
			String readLine="";
			Instant wordcountStart = Instant.now();
			int wordcount = 0;
			System.out.println("Reading file using BufferReader");
			while ((readLine = input.readLine())!=null) {
				
				String[] wordsPerLine = readLine.split(" ");
				
				/*for (String word : wordsPerLine) {
	                 if (word.equals(searchString))   //Search for the given word
	                 {
	                   wordcount++;    //If Present increase the count by one
	                 }
		        }*/
				//observed little less time taken when used ArrayList for searching a word
				ArrayList<String> wordsPerLineList = new ArrayList<String>(
						Arrays.asList(wordsPerLine));
				
				if (wordsPerLineList.contains(searchString))
					wordcount++;
				
			}
			Instant wordcountend = Instant.now();
			long timeTaken = Duration.between(wordcountStart, wordcountend)
					.toMillis();
			System.out.println("Time taken for Reading the File and count the word occurance  :  "
					+ timeTaken);
			System.out.println("Total Occurances of the Given Search String:  " + wordcount);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
