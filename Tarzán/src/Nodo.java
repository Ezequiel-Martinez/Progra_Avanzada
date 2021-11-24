
public class Nodo {
	public int number;
	public int cost;
	
	public Nodo(int number, int cost) {
		this.number = number;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Nodo [number=" + number + ", cost=" + cost + "]";
	};
	
	
}
