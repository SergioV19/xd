package controller;

import model.Matriz;
import view.IoManager;

public class Control {

	private IoManager io;
	private int variableGlobalXd;
	private Matriz matriz;
	
	
	public Control() {
		
		io = new IoManager();
		init();
	}

	public void init() {
		
		Matriz mat = new Matriz();
		int [][] matriz = {{2,7,6},{9,5,1},{4,3,8}};
		mat.setMatriz(matriz);
		
		int [][] mat1 = {{3,4},{-1,2},{2,1}};
		mat.setMat(mat1);
		int [][] mat2 = {{1,3},{-1,-1}};
		mat.setMat2(mat2);
		
		
		int sumando[] = {1,0,1,1,0};
		mat.setSumando(sumando);
		int sumando1 [] = {1,0,0,1,1};
		mat.setSumando1(sumando1);
		
		mat.setMultipl();
		io.showMessageGUI(mat.imprimirResultadoMultiplicacion(mat.getResultadoMultiplicacion()));
//		io.showMessageGUI(mat.imprimirSumMatrices());
//		io.showMessageGUI(mat.getMatrizString());
//		io.showMessageGUI(""+mat.diagonalSegundaria());
//		io.showMessageGUI(""+mat.imprimirTranspuesta());
//		io.showMessageGUI(mat.sumDeMatriz());
//		io.showMessageGUI(mat.imprimirSuma());
//		io.showMessageGUI(mat.setMatrizString());
//		io.showMessageGUI("matriz es magica ;"+mat.matrizMagica());
	}	
}
