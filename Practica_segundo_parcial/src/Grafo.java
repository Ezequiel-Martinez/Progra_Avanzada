import java.util.LinkedList;
import java.util.List;

public class Grafo {
	
	public List<Nodo>[] grafo;
	
	@SuppressWarnings("unchecked")
	public Grafo(int cantNodos) {
		grafo = new List[cantNodos];
		
		for (int i = 0; i < cantNodos; i++) {
			grafo[i] = new LinkedList<Nodo>();
		}
	}
	
	public void setEdge(int from, int to, double cost) {
		for (Nodo current : grafo[from]) {
			if (current.number == to) {
				current.cost = cost;
				return;
			}
		}
		
		grafo[from].add(new Nodo(to, cost));
	}
	
	public void setUndirectedEdge(int from, int to, double cost) {
		setEdge(from, to, cost);
		setEdge(to, from, cost);
	}
	
	public int getSize() {
		return grafo.length;
	}
}
