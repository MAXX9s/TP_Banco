import javax.swing.JOptionPane;

public class Administrador extends Usuario {
	private int Nroadmin;
	private Movimiento movimiento;
	private Cliente cliente;
	public Administrador(String nombre, String dni, String contrasena, int nroadmin, Movimiento movimieno , Cliente cliente) {
		super(nombre, dni, contrasena);
		Nroadmin = nroadmin;
		this.movimiento = movimieno;
		this.cliente=cliente;
	}
	public Administrador() {}
	public int getNroadmin() {
		return Nroadmin;
	}
	public void setNroadmin(int nroadmin) {
		Nroadmin = nroadmin;
	}
	public Movimiento getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void Registro() {
		do {
		setNombre(JOptionPane.showInputDialog("Ingrese su nuevo nombre"));
		setContrasena(JOptionPane.showInputDialog("Ingrese su nueva contraseña"));
		}while(getNombre().isEmpty() || getContrasena().isEmpty());
		JOptionPane.showMessageDialog(null, "Felicidades maquina te registraste!!");
		
	}
	
	public void Login(String nom , String con) {
	
		do {
			do {
			nom=Caracteres("Ingrese su nombre");
			if (!nom.equals(getNombre())) {
				JOptionPane.showMessageDialog(null,"El nombre no corresponde a un usuario registrado");
			}
			}while(!nom.equals(getNombre()));
			do {
				con=Caracteres("Ingrese la contraseña");
				if (!con.equals(getContrasena())) {
					JOptionPane.showMessageDialog(null,"La Contraseña es incorrecta");

				} 
			} while (!con.equals(getContrasena()));
		} while (!nom.equals(getNombre()) && !con.equals(getContrasena()));
		
	}
	
	public void verClientes() {
		JOptionPane.showMessageDialog(null, "Registro Clientes:\n"+ Usuario.getUsuarios());
	}
}
