# Assignment-3---Movie-Titles
Assignment 3 - Movie Titles

Data Structures used in the Assignment:
1. Binary Search Tree : to store the movie objects(with String title and int releaseYear) 
2. TreeSet<String> : to store titles of movies when traversing a tree
3. ArrayList<TreeSet<String>> : to store subsets, to make the process of printing them to the output files easier and faster
  
A few issues arose with processing CSV file:
1. Some movie titles contain commas.
The creator of the csv file added quotation marks to the titles in such cases, so it was easy to fix the issue by splitting such lines with quotation marks as delimiters
2. Some movies did not have a release year.
My way of overcoming the issus was to check how many digits contain each line, and if the number is greater than 4, then extract the release year
