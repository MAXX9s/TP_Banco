import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		Cliente nico=new Cliente("Nico", "1245543", "123", "Normal",new Cuenta(0,0));
		Cliente maxi= new Cliente("Maxi", "1245543", "123", "Normal",new Cuenta(2222, 0));
		Cliente luca= new Cliente("Luca", "1245543", "123", "Normal",new Cuenta(1122, 0));
		
		
		Movimiento movimiento = new Movimiento(LocalDateTime.now(), "Transferencia inicial", 1000, nico);

		Usuario.agregarCliente(maxi);
		Usuario.agregarCliente(nico);
		Usuario.agregarCliente(luca);
		Administrador gama=new Administrador("Gama","1223","1234",01,null,null);

		String[] opciones= {
				"Registro","Login","Salir"
		};
		String[] opcuentas= {
				"Crear cuenta","Abrir cuenta","Salir"
		};
		String[] menucliente={
				"Acciones","Movimientos","Ver saldo ","Modificar","Salir"
		};
		
		String[] menuadmin={
				"Clientes","Movimientos","Eliminar Movimiento","Salir"
		};
		String[] opcionesad= {
				"Login","Salir"
		};
		String[] tipousu= {
				"Usuario","Administrador","Salir "
		};
		int selec6=0;
		int selec5=0;
		int selec4=0;
		int selec3=0;
		int selec2=0;
		int selec=0;
		do{
			selec3=JOptionPane.showOptionDialog(null,"Bienvenido al Banco MESSIAS: \nCon que tipo de usuario va a ingresar:","Inicio",JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/messias.png")),tipousu, tipousu[0]);
			switch (selec3) {
			case 0:
				
			do {
				selec=JOptionPane.showOptionDialog(null,"Bienvenido al Banco MESSIAS:","Inicio", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/messias.png")),opciones, opciones[0]);
			switch (selec) {
			case 0:
				nico.Registro();
				break;
			case 1:
				nico.Login("","");

					do {
						selec2=JOptionPane.showOptionDialog(null,"Bienvenido "+nico.getNombre()+" que desea realizar el dia de hoy:","Menu",JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/messias.png")),menucliente, menucliente[0]);
						switch (selec2) {
						case 0:
							nico.Menu();
							
							break;
							
						case 1 :
							nico.Historial();
							break;
						case 2:
							nico.Consulta();
							break;
						case 3:
							nico.Modificar();
							break;
						}
					} while (selec2!=4);
					break;
				case 2:
					break;
				}
				
					break;
				
				}while(selec!=2);
			break;

			case 1:
				do {
					selec4=JOptionPane.showOptionDialog(null,"Bienvenido Administrador:","Inicio",JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/messias.png")),opcionesad, opcionesad[0]);
					switch (selec4) {

					case 0:
						gama.Login("","");
						do {
							selec5=JOptionPane.showOptionDialog(null,"Bienvenido "+gama.getNombre()+" que desea realizar el dia de hoy:","Menu",JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/messias.png")),menuadmin, menuadmin[0]);
							switch (selec5) {
							case 0:
								gama.verClientes();
								break;

							case 1:
								
								movimiento.AdHisto();
								break;
							case 2:
								movimiento.Remover();
								break;
					
							}
						} while (selec5!=3);
						break;
					}
				} while (selec4!=1);
				break;
			}
			
		}while(selec3!=2);
	}
}
