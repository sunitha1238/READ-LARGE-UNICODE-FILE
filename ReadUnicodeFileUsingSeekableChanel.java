package practice;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadUnicodeFileUsingSeekableChanel {

	
	public static void main(String[] args) throws IOException {
		try {
			Path path = Paths.get("c:\\itcont.txt");
			 SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.READ);
			 ByteBuffer bf = ByteBuffer.allocate(2048);
		         int i = 0;
		         int wordcount = 0;
		         Instant wordcountStart = Instant.now();
		         //provide the Search String here..
		         String searchString = "LINCOLN";
					System.out.println("Reading file using SeekableByteChannel");
			 while((i=sbc.read(bf))>0){
				bf.flip();
				String Line = new String(bf.array());
				String[] wordsPerLine = Line.split(" ");
				
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
				bf.clear();
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
