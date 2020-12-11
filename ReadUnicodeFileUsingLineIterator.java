package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class ReadUnicodeFileUsingLineIterator {
	
	public static void main(String[] args) throws IOException {
		try {
			File fileDir = new File("c:\\itcont.txt");
			  //provide the Search String here..
			String searchString = "LINCOLN";
		
			LineIterator lineIterator = FileUtils.lineIterator(fileDir,"UTF-8");
			Instant wordcountStart = Instant.now();
			int wordcount = 0;
			System.out.println("Reading file using org.apache.commons.io.LineIterator");
			while (lineIterator.hasNext()) {
				String line = lineIterator.nextLine();
				String[] wordsPerLine = line.split(" ");
				
				/*for (String word : wordsPerLine) {
	                 if (word.equals(searchString))   //Search for the given word
	                 {
	                   wordcount++;    //If Present increase the count by one
	                 }
		        }*/
				//observed little less time taken when used ArrayList for searching a word
				ArrayList<String> wordsPerLineList = new ArrayList<String>(Arrays.asList(wordsPerLine));
				if (wordsPerLineList.contains(searchString))
					wordcount++;
				
			}
			Instant wordcountend = Instant.now();
			long timeTaken = Duration.between(wordcountStart, wordcountend)
					.toMillis();
			System.out.println("Time taken for Reading the File and count the word occurance:  "
					+ timeTaken);
			System.out.println("Total Occurances of the Given Search String:  " + wordcount);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
