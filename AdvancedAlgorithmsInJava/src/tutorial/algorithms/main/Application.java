package tutorial.algorithms.main;

import tutorial.algorithms.breadthfirstsearch.BreadthFirstSearch;
import tutorial.algorithms.breadthfirstsearch.Vertex;
import tutorial.algorithms.breadthfirstsearch.WebCrawler;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello");

		/*
		 * Select algorithm to test:
		 *
		 * 1. Breadth-first search (BFS) algorithm
		 * 		>> "runLocalBFS"
		 * 		>> "runWebCrawler"
		 *
		 * 2. Depth-first search (DPS) algorithm
		 *
		 */

		String command = "runWebCrawler";
		runAlgorithm(command);
		
		System.out.println("End.");
	}

	/**
	 * Conveniently execute the different algorithms by simply passing the
	 * appropriate string command
	 * 
	 * @param val specifies the algorithm to execute.
	 */
	public static void runAlgorithm(String val) {

		switch (val) {
		case "runLocalBFS":
			Vertex vertex1 = new Vertex(1);
			Vertex vertex2 = new Vertex(2);
			Vertex vertex3 = new Vertex(3);
			Vertex vertex4 = new Vertex(4);
			Vertex vertex5 = new Vertex(5);

			vertex1.addNeighbourVertex(vertex2);
			vertex1.addNeighbourVertex(vertex4);
			vertex4.addNeighbourVertex(vertex5);
			vertex2.addNeighbourVertex(vertex3);

			BreadthFirstSearch bfs = new BreadthFirstSearch();
			bfs.execute(vertex1);
			break;
		case "runWebCrawler":
			WebCrawler crawler = new WebCrawler();
			String rootUrl = "http://www.bbc.com";
			crawler.discover(rootUrl);
			break;

		default:
			break;
		}

	}

}
