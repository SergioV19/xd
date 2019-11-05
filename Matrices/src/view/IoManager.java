package view;

import javax.swing.JOptionPane;

public class IoManager {

	public void showMessageGUI(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public short readShortGUI(String message) {
		return Short.parseShort(JOptionPane.showInputDialog(message));
	}
	
	public int readIntGUI(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}
	
	public long readLongGUI(String message) {
		return Long.parseLong(JOptionPane.showInputDialog(message));
	}
	
	public double readDoubleGUI(String message) {
		return Double.parseDouble(JOptionPane.showInputDialog(message));
	}
	
	public char readCharGUI(String message) {
		return JOptionPane.showInputDialog(message).charAt(0);
	}
	
	public String readStringGUI(String message) {
		return JOptionPane.showInputDialog(message);
	}
}
