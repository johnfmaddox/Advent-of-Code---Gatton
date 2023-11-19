import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class djikstra_dk {

	static class edge implements Comparable<edge> {

		int node;
		double weight;

		public edge(int node, double weight) {
			this.weight = weight;
			this.node = node;
		}

		public int compareTo(edge other) {
			return Double.compare(this.weight, other.weight);
		}

		@Override
		public boolean equals(Object otherT) {
			edge other = (edge) otherT;
			return (other.node == this.node);
		}

	}
	
	public static void main(String[] args) throws IOException {
		shortestPath();
	}

	public static void shortestPath() throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V, E, start, end;
		String[] line = br.readLine().split(" ");
		V = Integer.parseInt(line[0]);
		E = Integer.parseInt(line[1]);
		start = Integer.parseInt(line[2]) - 1;
		end = Integer.parseInt(line[3]) - 1;
		

		ArrayList<edge>[] adj = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<edge>();
		}

		for (int i = 0; i < E; i++) {
			line = br.readLine().split(" ");
			adj[Integer.parseInt(line[0]) - 1].add(new edge(Integer.parseInt(line[1]) - 1, Double.parseDouble(line[2])));
		}
		
		double[] dist = new double[V];
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[start] = 0;
		int[] prev = new int[V];
		Arrays.fill(prev, -1);

		BinomialHeap<edge> pq = new BinomialHeap<edge>();

		for (int i = 0; i < V; i++) {
			pq.insert(new edge(i, dist[i]));
		}
		
		while (pq.size() != 1) {
			edge min = pq.extractMin();
			double curDist = min.weight;
			int node = min.node;

			for (edge neighbor : adj[node]) {
				if (curDist + neighbor.weight < dist[neighbor.node]) {
					dist[neighbor.node] = curDist + neighbor.weight;
					System.out.println(node);
					//prev[neighbor.node] = node;
					edge newEdge = min;
					newEdge.weight = curDist + neighbor.weight;
					pq.decreaseKey(pq.find(neighbor), newEdge);
				}
			}
			
		}
		
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		int cur = end;
		while(prev[cur] != -1) {
			pathList.add(0, prev[cur]);
		}
		
		int[] path = pathList.stream().mapToInt(i -> i).toArray();
		
		System.out.println(dist[end]);

		br.close();

	}

}
