
public class Coordenada {
	
	public int x;
	public int y;
	
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}
	
	public static double distancia(Coordenada a1, Coordenada a2) {
		return Math.sqrt(( (a2.x - a1.x) * (a2.x - a1.x) ) + ( (a2.y - a1.y) * (a2.y - a1.y) ));
	}
}
