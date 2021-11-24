import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Principal {

	public static void main(String[] args) {
		Grafo grafo = new Grafo(11);
		
		// DFS
		grafo.setUndirectedEdge(0, 1, 0);
		grafo.setUndirectedEdge(0, 8, 0);
		grafo.setUndirectedEdge(1, 2, 0);
		grafo.setUndirectedEdge(1, 5, 0);
		grafo.setUndirectedEdge(8, 4, 0);
		grafo.setUndirectedEdge(8, 9, 0);
		grafo.setUndirectedEdge(4, 5, 0);
		grafo.setUndirectedEdge(9, 10, 0);
		grafo.setUndirectedEdge(9, 5, 0);
		grafo.setUndirectedEdge(5, 6, 0);
		grafo.setUndirectedEdge(6, 7, 0);
		grafo.setUndirectedEdge(2, 3, 0);
		
		// DIJKSTRA
//		grafo.setEdge(0, 1, 50);
//		grafo.setEdge(0, 3, 10);
//		grafo.setEdge(0, 2, 45);
//		grafo.setEdge(1, 2, 10);
//		grafo.setEdge(1, 3, 15);
//		grafo.setEdge(2, 4, 30);
//		grafo.setEdge(3, 4, 15);
//		grafo.setEdge(3, 0, 10);
//		grafo.setEdge(4, 2, 35);
//		grafo.setEdge(4, 1, 20);
//		grafo.setEdge(5, 4, 3);
		
		// PRIM
//		grafo.setUndirectedEdge(0, 1, 28);
//		grafo.setUndirectedEdge(0, 5, 10);
//		grafo.setUndirectedEdge(1, 6, 14);
//		grafo.setUndirectedEdge(5, 4, 25);
//		grafo.setUndirectedEdge(6, 4, 24);
//		grafo.setUndirectedEdge(4, 3, 22);
//		grafo.setUndirectedEdge(6, 3, 18);
//		grafo.setUndirectedEdge(1, 2, 16);
//		grafo.setUndirectedEdge(2, 3, 12);
		
		// Grafo plano para colorear
//		grafo.setUndirectedEdge(0, 1, 1);
//		grafo.setUndirectedEdge(0, 2, 1);
//		grafo.setUndirectedEdge(1, 3, 1);
//		grafo.setUndirectedEdge(2, 3, 1);
//		grafo.setUndirectedEdge(3, 4, 1);
//		grafo.setUndirectedEdge(3, 5, 1);
//		grafo.setUndirectedEdge(4, 5, 1);
//		grafo.setUndirectedEdge(4, 6, 1);
//		grafo.setUndirectedEdge(5, 7, 1);
//		grafo.setUndirectedEdge(7, 8, 1);
//		grafo.setUndirectedEdge(6, 8, 1);
//		grafo.setUndirectedEdge(6, 7, 1);
		
//		algoritmoProbabilistico(grafo);
//		prim(grafo, 0);
//		dijkstra(grafo, 0);
//		DFS(grafo, 1);
		BFS(grafo, 0);

	}
	
	public static void DFS(Grafo grafo, int nodoInicial) {
		boolean visited[] = new boolean[grafo.getSize()];
		Stack<Integer> pila = new Stack<Integer>();
		
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		int actual = nodoInicial;
		pila.add(actual);
		visited[actual] = true;
		
		while (pila.isEmpty() == false) {
			actual = pila.pop();
			
			System.out.print(actual + " | ");
			
			for (Nodo current : grafo.grafo[actual]) {
				if (visited[current.number] == false) {
					visited[current.number] = true;
					pila.add(current.number);
				}
			}
		}
	}
	
	public static void BFS(Grafo grafo, int nodoInicial) {
		LinkedList<Integer> cola = new LinkedList<Integer>();
		boolean visited[] = new boolean[grafo.getSize()];
		int distancias[] = new int[grafo.getSize()];
		int cantVisitados = 0;
		
		for (int i = 0; i < grafo.getSize(); i++) {
			distancias[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		int actual = nodoInicial;
		visited[actual] = true;
		distancias[actual] = 0;
		cola.add(actual);
		
		while (cantVisitados != grafo.getSize()) {
			actual = cola.poll();
			cantVisitados++;
			System.out.print(actual + " --> ");
			
			for (Nodo current : grafo.grafo[actual]) {
				if (visited[current.number] == false) {
					visited[current.number] = true;
					cola.add(current.number);
				}
			}
		}
		
		
		
	}
	
	
	public static void dijkstra(Grafo grafo, int nodoInicial) {
		boolean[] visited = new boolean[grafo.getSize()];
		double[] resultados = new double[grafo.getSize()];
		int previous[] = new int[grafo.getSize()];
		int cantVisitados = 0;
		double min = 999999;
		
		for (int i = 0; i < grafo.getSize(); i++) {
			visited[i] = false;
			previous[i] = -1;
			resultados[i] = Integer.MAX_VALUE;
		}
		
		int actual = nodoInicial;
		resultados[actual] = 0;
		visited[actual] = true;
		cantVisitados++;
		
		while (cantVisitados != grafo.getSize()) {
			
			min = 999999;
			
			for (Nodo current : grafo.grafo[actual]) {
				if (current.cost + resultados[actual] < resultados[current.number]) {
					resultados[current.number] = current.cost + resultados[actual];
					previous[current.number] = actual;
				}
			}
			
			for (int i = 0; i < resultados.length; i++) {
				if (resultados[i] < min && visited[i] == false) {
					min = resultados[i];
					actual = i;
				}
			}
			
			cantVisitados++;
			visited[actual] = true;
			
		}
		
		for (int i = 0; i < resultados.length; i++) {
			System.out.println("Nodo " + i + ": " + resultados[i]);
		}
		
		for (int i = 0; i < previous.length; i++) {
			System.out.print(previous[i] + " | ");
		}
	}
	
	
	public static void prim(Grafo grafo, int nodoInicial) {
		boolean visited[] = new boolean[grafo.getSize()];
		int cantVisitados = 0;
		Nodo minimo = null;
		int from = -1;
		double min;
		double costoTotal = 0;
		
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		visited[nodoInicial] = true;
		cantVisitados++;
		
		
		while (cantVisitados != grafo.getSize()) {
			
			min = 999999;
			
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == true) {
					for (Nodo current : grafo.grafo[i]) {
						if (current.cost < min && visited[current.number] == false) {
							min = current.cost;
							minimo = current;
							from = i;
						}
					}
				}
			}
			
			visited[minimo.number] = true;
			cantVisitados++;
			costoTotal += minimo.cost;
			
			System.out.println(from + " --> " + minimo.number);
			
		}
		
		System.out.println("Costo total: " + costoTotal);
	}
	
	public static void algoritmoProbabilistico(Grafo grafo) {
		int nodos[] = new int[grafo.getSize()];
		int nodosColores[] = new int[grafo.getSize()];
		int colorInicial = 1;
		int color = colorInicial;
		int cantidadColoreados = 0;
		boolean coloreable;
		
		for (int i = 0; i < grafo.getSize(); i++) {
			nodos[i] = i;
			nodosColores[i] = -1;
		}
		
		shuffle(nodos);
		
		while (cantidadColoreados != grafo.getSize()) {
			for (int i = 0; i < nodos.length; i++) {
				int actual = nodos[i];
				coloreable = true;
				
				// El nodo actual no tiene que estar coloreado
				if (nodosColores[actual] == -1) {
					for (Nodo current : grafo.grafo[actual]) {
						if (nodosColores[current.number] == color) {
							coloreable = false;
						}
					}
					
					if (coloreable) {
						nodosColores[actual] = color;
						cantidadColoreados++;
					}
				}
			}
			
			color++;
		}
		
		for (int i = 0; i < nodosColores.length; i++) {
			System.out.println("Nodo " + (char) (i + 65) + "    color: " + nodosColores[i]);
		}
		
		System.out.println("Número cromático: " + (color - colorInicial));
		
	}
	
	public static void shuffle(int[] arr) {
		Random rnd = new Random();
		
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int aux = arr[i];
			arr[i] = arr[index];
			arr[index] = aux;
		}
	}

}
