package tutorial.algorithms.breadthfirstsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This webcrawler application is developed by implementing the principles of
 * breadth-first searh algorithm.
 * 
 * @author Operation7412
 *
 */
public class WebCrawler {

	/**
	 * Attributes
	 */
	private Queue<String> queue;
	private List<String> discoveredWebsitesList;

	/**
	 * Constructor
	 */
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebsitesList = new ArrayList<String>();
	}

	/**
	 * Primary method to execute the webcrawler
	 * 
	 * @param root
	 */
	public void discover(String root) {
		this.queue.add(root);
		this.discoveredWebsitesList.add(root); // This will add the first url queue

		// IMPORTANT: Understand how the while loop alongside the 'queue.add(xx)'
		// command is used to recursively scout all the diff urls
		while (!queue.isEmpty()) {
			String vertex = this.queue.remove();
			String rawHtml = readURL(vertex);

			// Creating our a regex pattern from string
			String regexExpr = "(http|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
			Pattern pattern = Pattern.compile(regexExpr);

			// Applying our regex pattern to our html text
			Matcher matcher = pattern.matcher(rawHtml);

			// Loop will be processed only if something is found using the given regex
			// expression
			while (matcher.find()) {
				// Use .group() to retrieve the url found
				String actualUrl = matcher.group();

				// If its not yet been visited, then it proceeds
				if (!discoveredWebsitesList.contains(actualUrl)) {
					discoveredWebsitesList.add(actualUrl);
					System.out.println("Website found: " + actualUrl);
					queue.add(actualUrl);
				}
			}
		}
	}

	/**
	 * Supporting method to read and parse the entire html code of a specific url to
	 * String format
	 * 
	 * @param vertex
	 * @return
	 */
	private String readURL(String vertex) {
		String rawHtml = "";

		try {
			URL url = new URL(vertex);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine = "";

			// Retrieves each line and then checks if its null. If its not null, the while
			// loop will continue.
			while ((inputLine = in.readLine()) != null) {
				rawHtml += inputLine; // This will just append to the opt line.
			}

			in.close();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("!!!!!!!!! ERROR FOUND: " + e.getMessage());
		}
		return rawHtml;
	}
}
