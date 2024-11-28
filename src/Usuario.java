import java.util.LinkedList;

import javax.swing.JOptionPane;

public  class Usuario {
	private String nombre;
	private String dni;
	private String contrasena;
	private static LinkedList<Cliente> usuarios= new LinkedList<Cliente> ();
	
	public Usuario(String nombre, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.contrasena = contrasena;
	}
	public Usuario() {}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public static LinkedList<Cliente> getUsuarios() {
		return usuarios;
	}
	public static void setUsuarios(LinkedList<Cliente> usuarios) {
		Usuario.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", contrasena=" + contrasena + "]";
	}
	
	public void Login() {
	
		
		
		
	}
	public void Menu() {
		
		
		
		
	}
	public static void agregarCliente(Cliente cliente) {
        usuarios.add(cliente);
    }
	public int Numeros(String mensaje) {
		boolean flag ;
		String num ="" ;
		do {
			flag =true;
			num = JOptionPane.showInputDialog(mensaje);
			while (num.isEmpty()) {
				num = JOptionPane.showInputDialog(mensaje);
			}
			for (int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					flag = false;
					break;
				}
			}
		} while (!flag);
		
		return Integer.parseInt(num);
	}
	
	public String Caracteres(String mensaej) {
		String palabra = "";
		while (palabra.equals("")) {
			palabra = JOptionPane.showInputDialog(mensaej);
		}
		return palabra;
	}
	
}
