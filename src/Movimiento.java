import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Movimiento {
	private LocalDateTime fecha;
	private String detalle;
	private int movimiento;
	private Cliente cliente;
	public Movimiento(LocalDateTime fecha, String detalle, int movimiento, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.detalle = detalle;
		this.movimiento = movimiento;
		this.cliente = cliente;
	}
	public Movimiento () {}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Movimiento [fecha=" + fecha + ", detalle=" + detalle + ", movimiento=" + movimiento + ", cliente="
				+ cliente + "]";
	}
	
	public void opciones() {
		int opcion = 0;
		
		opcion = JOptionPane.showOptionDialog(null, "Seleccione el movimiento que desea realizar:", null,0,0, null, OpcionesCliente.values(), OpcionesCliente.values());
		
		
		
	
		
	}
	
}
