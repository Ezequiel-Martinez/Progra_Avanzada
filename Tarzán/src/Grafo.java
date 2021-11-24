import java.util.LinkedList;
import java.util.List;

public class Grafo {
	public List<Nodo>[] grafo;
	
	public Grafo(int cantNodos) {
		grafo = new List[cantNodos];
		
		for (int i = 0 ; i < cantNodos; i++) {
			grafo[i] = new LinkedList<Nodo>();
		}
	}
	
	public void setEdge(int from, int to, int cost) {
		for (Nodo current : grafo[from]) {
			if (current.number == to) {
				current.cost = cost;
			}
		}
		
		grafo[from].add(new Nodo(to, cost));
	}
	
	public void setUndirectedEdge(int from, int to, int cost) {
		setEdge(from, to, cost);
		setEdge(to, from, cost);
	}
	
	public int size() {
		return grafo.length;
	}
	
}
