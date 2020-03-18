//Anastasiya Chabotska
//Assignment 3
import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class HW3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub



		//create an array of files from the folder
		File [] fileArray = new File(
				"/Users/anastasiyachabotska/Desktop/Workspace/HW3/ml-latest-small").listFiles();

		//create a new binary search tree
		MoviesBST movies = new MoviesBST();


		//open the file from the array named "movies.csv"
		for (File f: fileArray) {
			//check the name of the file
			if (f.getName().equals("movies.csv")) {

				//create a Scanner object
				Scanner sc = new Scanner(f);
				//go to the next line
				String line = sc.nextLine();
				//go to the next line to skip the headline
				line = sc.nextLine();


				//start reading the file
				while (sc.hasNext()) {


					//if there are quotation marks in the line, split it with q.m. as delimiters
					if (line.contains("\"")) {
						String [] tokens = line.split("\"");
						String temp = tokens[1];
						//extract the year from the string
						String year = temp.substring(temp.length()-6);
						//convert the string to integer
						int relYear = Integer.parseInt(year.replaceAll("[()]", ""));
						//extract the title
						String title = temp.substring(0, temp.length()-6).trim();
						//add the movie to the tree
						movies.insert(title, relYear);
					}


					//otherwise, if no quotation marks
					else {
						//split the line with commas as delimiters
						String [] tokens = line.split(",");
						String temp = tokens[1];

						//check if the title contains the release year
						int digits =0;
						for (int i=0; i<temp.length(); i++) {
							if (temp.charAt(i) >= '0' && temp.charAt(i) <= '9')
								digits++;	
						}

						//if there are more than 4 digits in the title
						if(digits>=4) {
							//extract the year
							String year = temp.substring(temp.length()-6);
							//convert string to integer
							int relYear = Integer.parseInt(year.replaceAll("[( )]", ""));
							//extract the title
							String title = temp.substring(0, temp.length()-6).trim();
							//add the movie to the tree
							movies.insert(title, relYear);

						}



					}

					//go to the next line
					line=sc.nextLine();

				}
				//close the scanner
				sc.close();
				
			}



		}	





		ArrayList<TreeSet<String>> array = new ArrayList<TreeSet<String>>();


		TreeSet<String> sample1 = movies.subSet("Jumanji", "K-9");
		array.add(sample1);
		
		TreeSet<String> sample2 = movies.subSet("Bug's Life", "Heima");
		array.add(sample2);

		TreeSet<String> sample3 = movies.subSet("Back to the Future", "Hulk");
		array.add(sample3);
		
		TreeSet<String> sample4 = movies.subSet("Toy Story", "Twilight");
		array.add(sample4);
		
		TreeSet<String> sample5 = movies.subSet("Antichrist", "Gran Torino");
		array.add(sample5);

		
	for (int i=0; i<array.size(); i++) {
		PrintWriter outFile = new PrintWriter ("/Users/anastasiyachabotska/Desktop/Workspace/HW3/output data/"+array.get(i).first()+" - "+array.get(i).last()+".txt");
		for (String s: array.get(i))
			outFile.println(s);
		outFile.close();
	}
		
		

		


	}
}



	


	
