package operators;

public class Pinball {
	private int height, points;
	
	public void launchBall() {
		/*
		 * Comienza el juego con 3 puntos.
		 */
		points = 3;
		
		/*
		 * La bola va bajando poco a poco, siguiendo diferentes criterios de puntuación
		 * en cada altura.
		 */
		height = 3;
		System.out.println("¡La bola está en la zona alta del pinball!");
		heightThreePoints();
		System.out.println("");
		
		height = 2;
		System.out.println("¡La bola está en la zona media del pinball!");
		heightTwoPoints();
		System.out.println("");
		
		height = 1;
		System.out.println("¡La bola está en la zona baja del pinball!");
		heightOnePoints();
		System.out.println("");
		
		System.out.println("¡La partida ha terminado!");
	}
	
	public void heightThreePoints() {
		/*
		 * Escoge un número entre 1 y 3.
		 */
		int option = (int)(Math.random()*3 + 1);
		
		switch (option) {
			case 1:
				/*
				 * Si sale 1, suma 1 punto.
				 */
				points++;
				System.out.println("Rebote simple, +1 punto: " + points + " puntos en total.");
			case 2:
				/*
				 * Si sale 2, suma de 1 a 5 puntos.
				 */
				int rebotes = (int)(Math.random()*5 + 1);
				points += rebotes;
				System.out.println("Rebotes múltiples, +" + rebotes + " puntos: " + points + " puntos en total.");
			case 3:
				/*
				 * Si sale 3, multiplica los puntos por 1.5.
				 */
				points = (int) (points * 1.5);
				System.out.println("¡Tiro a la diana!, +50% puntos: " + points + " puntos en total.");
		}
	}
	
	public void heightTwoPoints() {
		int option = 1;
		
		/*
		 * Se obtienen de 2 a 4 puntos. La bola tiene una probabilidad de 20%
		 * de caer al siguiente nivel, y 80% de seguir rebotando y sumando puntos.
		 * Llegar a 30 puntos fuerza a la bola a bajar.
		 */
		do {
			int extra = (int)(Math.random()*3 + 2);
			System.out.println("La bola continúa rebotando en la zona media, +" + extra + " puntos: " + points + " puntos en total.");
			option = (int)(Math.random()*5);
		} while (option != 0 || points >= 30);
	}
	
	public void heightOnePoints() {
		/*
		 * Según los puntos con los que se lleguen al nivel más bajo, ocurren cosas distintas.
		 */
		if (points <= 8) {
			/*
			 * Si se llega con 8 puntos o menos, se intentan sumar un punto 20-puntos veces,
			 * con un 33% de probabilidad cada vez.
			 */
			for (int x=20; x > points; x--) {
				int option = (int)(Math.random()*3);
				if (option == 0)
					points++;
			}
			System.out.println("Ráfaga de rebotes: " + points + " puntos en total.");
		} else if (points <= 25) {
			/*
			 * Si se llega con 9-25 puntos, se restan 3 puntos y luego se multiplican por 1.2.
			 */
			points = (int)((points - 3) * 1.2);
			System.out.println("Pozo gravitatorio: " + points + " puntos en total.");
		} else {
			/*
			 * Si se llega con más de 25 puntos, los puntos se multiplican por 2.
			 */
			points = points * 2;
			System.out.println("JACKPOT!!!, x2 puntos: " + points + " puntos en total.");
		}
	}
}
