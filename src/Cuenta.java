import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cuenta {
	private int nroCuenta;
	private double saldo;
	private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento> ();
	public Cuenta(int nroCuenta, double saldo) {
		super();
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
		
	}
	public Cuenta() {}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(LinkedList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	@Override
	public String toString() {
		return "Cuenta: nroCuenta=" + nroCuenta + ", saldo=" + saldo + "\n";
	}
	
	public void Ingreso() {
		nroCuenta = (int) (Math.random() * 9000) + 1000;
		saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese su saldo"));
		JOptionPane.showMessageDialog(null, nroCuenta);
		
	}
	
		
	
	
}
