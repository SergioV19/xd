package model;

import view.IoManager;

public class Matriz {

	final static int FIL = 3;
	final static int COL = 3;

	private IoManager io;
	int matriz[][];
	int mat1[][];
	int mat2[][];
	private int resultSuma[][];
	private int resultadoMultiplicacion[][];
	private int sumando[];

	private int sumando1[];
	private int resultado[];
	private int sobrante[];
	double transpuesta[][] = null;

	public int[][] getResultSuma() {
		return resultSuma;
	}

	public void setResultSuma(int[][] resultSuma) {
		this.resultSuma = resultSuma;
	}

	public double[][] getTranspuesta() {
		return transpuesta;
	}

	public void setTranspuesta(double[][] transpuesta) {
		this.transpuesta = transpuesta;
	}

	public Matriz() {

		mat1 = new int[FIL][COL];
		mat2 = new int[FIL][COL];

		io = new IoManager();
		matriz = new int[FIL][COL];
//		sumando = new int[];
//		sumando1 = new int[5];
//		resultado = new int[7];
//		sobrante = new int[7];

	}

	public int[] getSumando() {
		return sumando;
	}

	public void setSumando(int[] sumando) {
		this.sumando = sumando;
	}

	public int[] getSumando1() {
		return sumando1;
	}

	public int[] getSobrante() {
		return sobrante;
	}

	public void setSobrante(int[] sobrante) {
		this.sobrante = sobrante;
	}

	public void setSumando1(int[] sumando1) {
		this.sumando1 = sumando1;
	}

	public int[] getResultado() {
		return resultado;
	}

	public void setResultado(int[] resultado) {
		this.resultado = resultado;
	}

	public int[][] getResultadoMultiplicacion() {
		return resultadoMultiplicacion;
	}

	public void setResultadoMultiplicacion(int[][] resultadoMultiplicacion) {
		this.resultadoMultiplicacion = resultadoMultiplicacion;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int[][] getMat() {
		return mat1;
	}

	public void setMat(int[][] mat) {
		this.mat1 = mat;
	}

	public int[][] getMat2() {
		return mat2;
	}

	public void setMat2(int[][] mat2) {
		this.mat2 = mat2;
	}

	public String setMatrizString() {
		String matri = "";
		for (int i = 0; i < FIL; i++) {
			for (int j = 0; j < COL; j++) {
				matri += "[" + getMatriz()[i][j] + "]";
			}
			matri += "\n";
		}
		return matri;
	}

	public boolean matrizMagica() {
		int auxfilas = 0;
		int auxColumnas = 0;
		int auxDiagonal = 0;
		boolean magic = true;

		do {
			int cont = 0;

			for (int i = 0; i < FIL; i++) {
				auxfilas = 0;

				for (int j = 0; j < COL; j++) {
					auxfilas += getMatriz()[i][j];
				}
				if (auxfilas != 15)
					magic = false;
			}
			for (int i = 0; i < COL; i++) {
				auxColumnas = 0;

				for (int j = 0; j < FIL; j++) {
					auxColumnas += getMatriz()[i][j];
				}
				if (auxColumnas != 15)
					magic = false;
			}
			for (int i = 0; i < COL; i++) {
				auxDiagonal = 0;
				cont = 0;
				for (int j = 0; j < FIL; j++) {
					auxDiagonal += getMatriz()[cont][j];
					cont = cont + 1;
				}
				if (auxDiagonal != 15)
					magic = false;
			}

			return magic;
		} while (1 < COL);

	}

	public void sumaBinarios() {
		int acarreo = 0;
		int suma = 0;
		this.resultado = new int[sumando1.length];
		for (int i = sumando1.length - 1; i > 0; i--) {
			suma = sumando[i + 1] + sumando1[i];
			if (suma == 2) {
				resultado[i + 1] = 0;
				acarreo = 1;
			}
			if (suma == 0) {
				resultado[i + 1] = 0;
			} else if (suma == 1) {
				resultado[i + 1] = 1;
			}
			System.out.println(resultado[i]);
			if (acarreo == 1) {
				if (sumando1[i - 1] + 1 == 2) {
					sumando1[i - 1] = 0;
					acarreo = 1;
				} else {
					sumando1[i - 1] = 1;
					acarreo = 0;
				}

			}
		}
	}

	private void setResult() {
		resultado = calculateBinAdd(sumando, sumando1);
	}

	private int[] calculateBinAdd(int[] numbers1, int[] numbers2) {
		int dim = 0;
		if (numbers1.length >= numbers2.length)
			dim = numbers1.length + 1;
		else
			dim = numbers2.length + 1;
		int[] result = new int[dim];
		int acarreo = 0;
		for (int i = numbers2.length - 1; i >= 0; i--) {
			int temp = (numbers1[i] + numbers2[i]);
			System.out.println(acarreo + ";" + numbers1[i] + "+" + numbers2[i] + "=" + temp + ":" + i);
			switch (temp) {
			case 2:
				if (acarreo == 1)
					result[i + 1] = 1;
				else {
					result[i + 1] = 0;
					acarreo = 1;
				}
				break;
			case 1:
				if (acarreo == 1) {
					result[i + 1] = 0;
					acarreo = 1;
				} else {
					result[i + 1] = 1;
				}
				break;
			case 0:
				result[i + 1] = acarreo;
				acarreo = 0;
				break;

			default:
				break;
			}
		}
		result[0] = acarreo;
		return result;
	}

	public String imprimirSuma() {
		setResult();
		String result = "";
		for (int i = 0; i < resultado.length; i++) {
			result += "\n" + resultado[i];
		}
		return result;
	}

	public String sumDeMatriz() {
		String result = "";
		int suma = 0;
		for (int i = 0; i < (FIL); i++) {
			for (int j = 0; j < COL; j++) {
				suma += getMatriz()[i][j];
				result = "" + suma;
			}
		}
		return result;
	}

	public String imprimirTranspuesta() {
		String matri = "";
		for (int i = 0; i < FIL; i++) {
			for (int j = 0; j < COL; j++) {
				matri += "[" + getMatriz()[j][i] + "]";
			}
			matri += "\n";
		}
		return matri;
	}

	public int diagonalSegundaria() {
		int auxDiag = 0;
		int cont = 0;
		for (int i = (FIL - 1); i >= 0; i--) {

			auxDiag += getMatriz()[i][cont];
			cont = cont++;

		}
		return auxDiag;
	}

	public int[][] sumaDeMatrices() {

		for (int i = 0; i < FIL; i++) {
			for (int j = 0; j < COL; j++) {

				resultSuma[i][j] = (getMat()[i][j] + getMat2()[i][j]);
				setResultSuma(resultSuma);

			}
		}
		return resultSuma;

	}

	public String imprimirSumMatrices() {

		String resultadoSuma = "";
		for (int i = 0; i < FIL; i++) {
			for (int j = 0; j < COL; j++) {
				resultadoSuma += "[" + getResultSuma()[i][j] + "]";
			}
			resultadoSuma += "\n";
		}
		return resultadoSuma;
	}

	public int[][] multiplicacionMatrices(int[][] matA, int[][] matB) {
		int n = matA[0].length;
		int n2 = matB.length;
		int[][] total = new int[matA.length][matB[0].length];
		if (n == n2)
			for (int i = 0; i<total.length; i++)
				for (int j = 0; j<total[0].length; j++) 
					for (int k = 0; k<n; k++)
						total [i][j] += (matA[i][k]* matB[k][j]);
		return total;
	}
	
	public void setMultipl() {
		this.resultadoMultiplicacion = multiplicacionMatrices(mat1, mat2);
	}

//	private int[][] multiplicateMatrices(int[][] matrix1, int[][] matrix2) {
//		int[][] result = null;
//		if (matrix1.length == matrix2[0].length && matrix2.length == matrix1[0].length) {
//			result = new int[matrix1.length][matrix2[0].length];
//			for (int i = 0; i < matrix1.length; i++) {
//				for (int j = 0; j < matrix2[0].length; j++) {
//
//				}
//			}
//		}
//		return result;
//	}

//	public String imprimirResultadoMultiplicacion() {
//
//		int aux = 0;
//		int aux2 = 0;
//		int cont = 0;
//
//		do {
//			
//			cont ++;
//			for (int i = 0; i < FIL; i++) {
//				for (int j = 0; j < COL; j++) {
//
//					aux = (getMat()[cont][j] * getMat2()[j][i]);
//
//					aux2 = aux+aux2;
//					resultadoMultiplicacion[i][j] = aux2;
//					setResultadoMultiplicacion(resultadoMultiplicacion);
//				}
//				
//			}
//		} while (cont < COL);
//		
//	}

	public String imprimirResultadoMultiplicacion(int[][] matriz) {
		String mostrar = "";
		for (int[] a : matriz) {
			for (int i : a) {
				mostrar += "|" + i + "|";
			}
			mostrar += "\n";
		}
		return mostrar;
	}

}
