import java.io.FileNotFoundException;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = GestorDeArchivos.leer("./Entrada/00.in");
		
		for (int i = 0; i < grafo.size(); i++ ) {
			System.out.println(grafo.grafo[i]);
		}
		
		boolean visited[] = new boolean[grafo.size()];
		int distancias[] = new int[grafo.size()];
		int previous[] = new int[grafo.size()];
		int cantVisitados = 0;
		
		for (int i = 0 ; i < grafo.size(); i++) {
			visited[i] = false;
			distancias[i] = Integer.MAX_VALUE;
			previous[i] = -1;
		}
		
		int actual = 0;
		distancias[actual] = 0;
		
		while (cantVisitados != visited.length) {
			visited[actual] = true;
			int min = 999999;
			cantVisitados++;
			
			for (Nodo current : grafo.grafo[actual]) {
				if (current.cost + distancias[actual] < distancias[current.number]) {
					distancias[current.number] = current.cost + distancias[actual];
					previous[current.number] = actual;
				}
			}
			
			for (int i = 0; i < distancias.length; i++) {
				if (distancias[i] < min && visited[i] == false) {
					min = distancias[i];
					actual = i;
				}
			}
			
		}
		
		for (int i = 0; i < distancias.length; i++) {
			System.out.print(distancias[i] + " | ");
		}
		
		System.out.println();
		
		for (int i = 0; i < previous.length; i++) {
			System.out.print(previous[i] + " | ");
		}
		
		actual = grafo.size() - 1;
		System.out.println();
		System.out.println(Arboles.coordenadas.get(actual));
		
		while (actual > 0) {
			System.out.println(Arboles.coordenadas.get(previous[actual]));
			actual = previous[actual];
		}
		
		

	}

}
