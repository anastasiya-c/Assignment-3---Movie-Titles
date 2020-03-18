import java.util.*;
public class MoviesBST {

	private Movie root;


	/*Method find - the method finds a movie object in the BST by the title provided
	 * Input: 
	 * string key     
	 * Process: 
	 * Starts at the root of the BST and compares the parameter with the current value
	 * If the key goes before the current value in alphabetical order, then move to the left child
	 * Otherwise, move to the right child
	 * If there are no more movies left in the tree, return null
	 * Output:
	 * Return the object if found and null otherwise
	 */
	public Movie find(String key) {

		if (root!=null) {
			Movie current = root;
			// start at root

			while(!current.title.equalsIgnoreCase(key)) {
				//if the title entered is alphabetically less than the current then go to the left child
				if(key.compareTo(current.title)<0)
					current = current.leftChild;
				//otherwise, go to the right child
				else
					current = current.rightChild;
				//if the movie was not found, return null
				if(current == null) 
					return null;
			}
			return current;
		}
		//if the tree is empty	
		else	
			return null;

	}


	/*method insert - inserts a new movie object into the tree in the alphabetical order of titles
	 * Input: string s (title), int y (release year)
	 * Process:
	 * Creates new movie object
	 * Assigns its' title and release year values s and y 
	 * If the tree  is empty adds the new movie as the root
	 * Otherwise, start at the root and compare the new movie's title with the current title
	 * If the new movie's title goes before the current in alphabetical order, go to the left child
	 * Otherwise, go to the right child
	 * If in both cases we reach a leaf, assign the new movie to be left/right child respectively
	 * Output:
	 * None
	 * */
	public void insert(String s, int y) {

		//create a new Movie object
		Movie newMovie = new Movie(); 
		newMovie.title = s; 
		newMovie.releaseYear = y; 

		//if the tree is empty, add the movie as the root
		if(root==null)
			root = newMovie; 
		//non-empty tree
		else
		{
			//start at the root
			Movie current = root; 
			//create a parent to keep track
			Movie parent; 

			while(true)
			{
				parent = current; 

				//if the title of the new movie is less than the title of the current
				if(s.compareTo(current.title)<0)

					//move to the left child
				{
					current = current.leftChild;

					//if we reach a leaf
					if(current == null) 
					{
						//new movie becomes the left child of a parent
						parent.leftChild=newMovie;
						return;
					}
				}
				//otherwise
				else {
					//move to the right child
					current = current.rightChild;
					//if we reach a leaf
					if (current == null) {
						//new movie becomes the right child of a parent
						parent.rightChild=newMovie;
						return;
					}
				}
			}
		}

	}


	/*method traverse - the method traverses the tree starting at the movie passed as a parameter and adds the movies to the set as it visits them
	 * Input:
	 * Movie m - movie object from which to start traversing
	 * TreeSet<String> set - a set of movie titles
	 * Process:
	 * Start at the movie m as the root
	 * Recursively call the method on its' left child
	 * Then add the title of the movie m to the set
	 * Recursively call the method on its' right child
	 * Output:
	 * None
	 *  */
	public void traverse(Movie m, TreeSet<String> set) 
	{ 

		if (m == null) 
			return; 

		/* first recur on left child */  	
		traverse(m.leftChild, set); 

		/* then add the movie to the set */  	
		set.add(m.title);

		/* now recur on right child */ 
		traverse(m.rightChild, set); 

	} 




	/*method subset 
	 * Input: 
	 * String s - movie title to start from
	 * String e - movie title to end with
	 * Process:
	 * Creates a new TreeSet
	 * Calls the traverse method, and passes an empty TreeSet as a parameter to get a set with all elements from the tree
	 * Gets a subset of the set with movies from start value to end value
	 * Output:
	 * Returns the subset*/
	public TreeSet<String> subSet(String s, String e) 
	{ 

		//create an empty TreeSet	
		TreeSet <String> set= new TreeSet<String>();
		//traverse the tree from the root
		traverse(root, set);
		//extract the needed subset
		set=(TreeSet<String>) set.subSet(s, true, e, true);

		//return the subset
		return set;

	} 

	
	
    }


