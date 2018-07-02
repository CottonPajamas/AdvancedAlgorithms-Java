package tutorial.algorithms.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of the breadth-first search algorithm using the Vertex class.
 * 
 * @author Operation7412
 *
 */
public class BreadthFirstSearch {

	public void execute(Vertex root) {

		// NOTE: WHAT IS A QUEUE COLLECTION OBJECT?
		// It is essentially a collection that has the FIFO structure in-built.
		// So the first item we insert is going to be the first item that we take out.
		Queue<Vertex> queue = new LinkedList<>(); // LinkedList implements the queue interface

		root.setVisited(true);
		queue.add(root);

		while (!queue.isEmpty()) {

			// Retrieve while at the same time removing the specific vertex from the queue.
			Vertex actualVertex = queue.remove();
			System.out.println("Processing vertex>> " + actualVertex + " ");

			// Visiting all the neighbours of the vertex
			for (Vertex v : actualVertex.getNeighbourList()) {

				// If a neighbour has not been visited, we will set the 'visited' property and
				// then store it to the queue.
				if (!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}
