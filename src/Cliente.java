import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cliente extends Usuario{
	private String tipo;
	private Cuenta cuenta;
	private LinkedList<Cuenta> cuentas = new LinkedList<Cuenta> ();
	public Cliente(String nombre, String dni, String contrasena, String tipo,Cuenta cuenta) {
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
	
	public LinkedList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(LinkedList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	@Override
	public String toString() {
		return "Cliente:" + getNombre()+ "\n";
	}
	
	public void Menu() {
		Movimiento movin = new Movimiento(); 
		int opcion=0;
	do {
		opcion=JOptionPane.showOptionDialog(null,this.getNombre()+" que accio realizar el dia de hoy:","Menu",JOptionPane.DEFAULT_OPTION, 0
				, new ImageIcon(Main.class.getResource("/img/messias.png")),OpcionesCliente.values(), OpcionesCliente.values());

		switch (opcion) {
		case 0:
			this.Transferir();
			
			break;

		case 1:
			this.Depositar(0,this.getCuenta());
			break;
		case 2:
			this.Retirar(0);
			break;
		}
	}while(opcion!=3);
		
	}
	
	
	public void Registro() {
		do {
		setNombre(JOptionPane.showInputDialog("Ingrese su nuevo nombre"));
		setContrasena(JOptionPane.showInputDialog("Ingrese su nueva contraseña"));
		}while(getNombre().isEmpty() || getContrasena().isEmpty());
		getCuenta().Ingreso();
		JOptionPane.showMessageDialog(null, "Felicidades " +this.getNombre()+ " haz abierto una cuenta en el banco Messias!");
		
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
	
	public void Transferir() {
		
		
		int nro=0;
		double monto;
		
		
	do {
		nro=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta al que quiere transferir:"));
		monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese  el monto que quiere transferir:"));	
	}while(nro==0);
	
	for (Cliente cliente : Usuario.getUsuarios()) {
		if (cliente.getCuenta().getNroCuenta()==nro) {
            this.getCuenta().setSaldo(this.getCuenta().getSaldo() - monto);

			
			if (this.getCuenta().getSaldo()<=0) {
				JOptionPane.showMessageDialog(null, "No tiene dinero en su cuenta para realizar la transferencia");
			} else {
	            JOptionPane.showMessageDialog(null, "Transaccion exitosa!!");
				JOptionPane.showMessageDialog(null, "Transferencia con exito!!\n" + "Sea Descontado de su saldo: $"+ monto+ "\nSaldo Actual: $"+ this.getCuenta().getSaldo());
				Movimiento Movimientonuevo = new Movimiento( LocalDateTime.now(),  "Transferencia realizada a " + nro,  (int) monto,
						this  );
				this.getCuenta().getMovimientos().add(Movimientonuevo);
				return;
			}
			
			
			
			
			
			
		}
		JOptionPane.showMessageDialog(null,"El Alias del al que quieres transferir no existe!");
		return;
		}

	
	
	
	
	
	}
	
	public void Depositar ( double monto, Cuenta cuenta) {
		
			 monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que desea depositar"));
			 
	            cuenta.setSaldo(cuenta.getSaldo() + monto);
	            Movimiento Movimientonuevo = new Movimiento( LocalDateTime.now()," Deposito", (int) monto,
		                this  );
			this.cuenta.getMovimientos().add(Movimientonuevo);
			JOptionPane.showMessageDialog(null, "Deposito con exito!!\n" + "Sea Agregado a su saldo: $"+ monto+ "\nSaldo Actual: $"+ cuenta.getSaldo());
			return;
	}
	
	public void Retirar(double monto) {
		 monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que desea depositar"));
		 if(this.getCuenta().getSaldo()<monto) {
			 JOptionPane.showMessageDialog(null,"El dinero en cuenta es insuficiente!!");
		 }else {
         cuenta.setSaldo(cuenta.getSaldo() - monto);
         Movimiento Movimientonuevo = new Movimiento( LocalDateTime.now()," Retiro", (int) monto,
	                this  );
		this.cuenta.getMovimientos().add(Movimientonuevo);
		JOptionPane.showMessageDialog(null, "Retiro con exito!!\n" + "Sea Descontado de su saldo: $"+ monto+ "\nSaldo Actual: $"+ cuenta.getSaldo());
		return;
		 }
	} 

	public void Consulta() {
		JOptionPane.showMessageDialog(null, "Cliente: "+this.getNombre() +"\n"+"Nro de cuenta: "+this.getCuenta().getNroCuenta()+
				"\n"+"Saldo: $" +this.getCuenta().getSaldo());
	}
	
	public void Historial() {
		for (Cliente cliente : Usuario.getUsuarios()) {
			if (cliente.getNombre().equals(this.getNombre())) {
				
				JOptionPane.showMessageDialog(null,cliente.getCuenta().getMovimientos());
			}
		}

	}
	public void Modificar() {
		String nom;
		String con;
		int nro;
		int opcion=0;
		String[] menu= {"Nombre","Contraseña","Nro Cuenta","Salir"};
		do {
		opcion=JOptionPane.showOptionDialog(null,this.getNombre()+" que desea realizar el dia de hoy:","Menu",JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/messias.png")),menu, menu[0]);

		switch (opcion) {
		case 0:
			nom=Caracteres("Ingrese su nuevo nombre:");
			this.setNombre(nom);
			break;

		case 1:
			con=Caracteres("Ingrese su nueva contraseña:");
			this.setContrasena(con);
			break;
		case 2: 
			nro=Numeros("Ingrese su nuevo numero de cuenta:");
			this.cuenta.setNroCuenta(nro);
		}
		}while(opcion!=3);
		
	}
}
