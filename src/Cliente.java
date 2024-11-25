import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cliente extends Usuario{
	private String tipo;
	private Cuenta cuenta;
	public Cliente(String nombre, String dni, String contrasena, String tipo, Cuenta cuenta) {
		super(nombre, dni, contrasena);
		this.tipo = tipo;
		this.cuenta = cuenta;
	}
	public Cliente() {}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	@Override
	public String toString() {
		return "Cliente [tipo=" + tipo + ", cuenta=" + cuenta + "]";
	}
	@Override
	public void Menu() {
		Movimiento movin = new Movimiento(); 
		int opcion=0;
	
		opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", null, 0, 0, null, OpcionesCliente.values(), OpcionesCliente.values());
		
		
	}
	
	public void Registro() {
		do {
		setNombre(JOptionPane.showInputDialog("Ingrese su nuevo nombre"));
		setContrasena(JOptionPane.showInputDialog("Ingrese su nueva contraseña"));
		}while(getNombre().isEmpty() || getContrasena().isEmpty());
		JOptionPane.showMessageDialog(null, "Felicidades maquina te registraste!!");
		
	}
	
	
	
	public void Login(String nom , String cont) {
		do {
			nom=JOptionPane.showInputDialog("Ingrese su nombre");
			cont=JOptionPane.showInputDialog("Ingrese su contraseña");
			
		}while(!getNombre().equals(nom) && !getContrasena().equals(cont));
		
		
	}
	public void Transferir(String nom ,double monto,Cuenta cuenta1 , Cuenta cuenta2 ) {
		
	
		
		
	do {
		nom=JOptionPane.showInputDialog("Ingrese el Alias al que quiere transferir:");
		monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese  el monto que quiere transferir:"));	
	}while(nom.isEmpty());
	
	for (Cliente cliente : Usuario.getUsuarios()) {
		if (cliente.getNombre().equals(nom)) {
			cliente.getCuenta().getMovimientos().add(null);
			
			if (cuenta.getSaldo()<=0) {
				JOptionPane.showMessageDialog(null, "No tiene dinero en su cuenta para realizar la transferencia");
			} else {
	            cuenta1.setSaldo(cuenta1.getSaldo() - monto);
	            JOptionPane.showMessageDialog(null, "Transaccion exitosa!!");

				JOptionPane.showMessageDialog(null,"Saldo: $"+ cuenta1.getSaldo());
				return;
			}
			
			
			
			
			
			 
			//	cliente.getCuenta() - > receptor de dinero, sumar el monto a este cliente
			//this.getcuenta este es el cliente que realiza la transferencia, entonces le sumo.
			 // te saca de la funciòn transferir cuando pude realizarlo. 
		 
		}
		}
	JOptionPane.showMessageDialog(null,"El Alias del al que quieres transferir no existe!");
	
	//Los errores van aca. 
	
	
	
	
	}
	
	public void Depositar ( double monto, Cuenta cuenta) {
		
			 monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que desea depositar"));
	            cuenta.setSaldo(cuenta.getSaldo() + monto);
			JOptionPane.showMessageDialog(null, "Deposito con exito!!\n" + "Sea Agregado a su saldo: $"+ monto+ "\nSaldo Actual: $"+ cuenta.getSaldo());
		
	}
	
	
	
}
