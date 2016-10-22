package br.com.apsbiometria;

import javax.swing.JOptionPane;

public class Biometria {

	private static long f[][] = new long[4 - 1][4 - 1];
	private static long gCr[][] = new long[4 - 1][4 - 1];
	private static long gCv[][] = new long[4 - 1][4 - 1];
	private static double m[][] = new double[3][3];
	private static int x;
	private static int y;
	private static int s;
	private static int t;

	public static void main(String[] args) {

		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				f[i][j] = Long.parseLong(JOptionPane.showInputDialog("Escreva um número"));
			}
		}
		
		for (x = 0; x <= 2; x++) {
			for (y = 0; y <= 2; y++) {
				m[x][y] = 1.0 / 9.0;
			}
		}

		for (x = 1; x <= 3 - 2; x++) {
			for (y = 1; y <= 3 - 2; y++) {
				gCr[x][y] = 0;
				gCv[x][y] = 0;

				for (s = -1; s <= 1; s++) {
					for (t = -1; t <= 1; t++) {
						gCr[x][y] = (long) (gCr[x][y] + m[s + 1][t + 1] * f[x + s][y + t]);
						gCv[x][y] = (long) (gCv[x][y] + m[s + 1][t + 1] * f[x - s][y - t]);
						System.out.println(gCv[x][y]);
					}
				}
			}
		}
	}
}
