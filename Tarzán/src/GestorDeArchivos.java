import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestorDeArchivos {
	
	@SuppressWarnings("resource")
	public static Grafo leer(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner lector = new Scanner(file);
		
		int cantLineas = 0;
		
		while (lector.hasNextLine()) {
			lector.nextLine();
			cantLineas++;
		}
		
		lector = new Scanner(file);
		
		Grafo grafo = new Grafo(cantLineas);
		
		while (lector.hasNextInt()) {
			int x = lector.nextInt();
			int y = lector.nextInt();
//			
//			System.out.println(x);
//			System.out.println(y);
					
			Coordenada coordenada = new Coordenada(x, y);
			Arboles.addCoordenada(coordenada);
		}
		
		for (int i = 0; i < Arboles.coordenadas.size(); i++) {
			for (int j = 0; j < Arboles.coordenadas.size(); j++) {
				if (i != j) {
					double distanciaEntreArboles = Coordenada.distancia(Arboles.coordenadas.get(i), Arboles.coordenadas.get(j));
					if (distanciaEntreArboles <= 50) {
						grafo.setUndirectedEdge(i, j, 1);
					}
				}
			}
		}
		
		
		lector.close();
		
		return grafo;
		
	}
}
