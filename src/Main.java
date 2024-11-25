import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		Cliente nico=new Cliente("Nico", "1245543", "123", "Normal", new Cuenta(1234, 10000));
		Cliente maxi= new Cliente("Maxi", "1245543", "123", "Normal", new Cuenta(12345, 10000));
		Cliente luca= new Cliente("Luca", "1245543", "123", "Normal", new Cuenta(12345, 20000));
		
		String[] opciones= {
				"Registro","Login","Salir"
		};
		String[] menucliente={
				"Acciones","Movimientos","Salir"
		};
		int selec2=0;
		int selec=0;
		do {
			selec=JOptionPane.showOptionDialog(null,"Bienvenido al Banco MESSIAS:","Inicio", 0,0, null,opciones, opciones[0]);
		switch (selec) {
		case 0:
			nico.Registro();
			break;
		case 1:
			nico.Login("","");
			do {
				selec2=JOptionPane.showOptionDialog(null,"Bienvenido Usuario que desea realizar el dia de hoy:","Menu", 0,0, null,menucliente, menucliente[0]);
				switch (selec2) {
				case 0:
					nico.Menu();
					nico.Transferir("", selec,nico.getCuenta() , luca.getCuenta());
					nico.Depositar(0,nico.getCuenta());
					break;

				default:
					break;
				}
			} while (selec2!=2);
			break;
		case 2:
			break;
		}
	}while(selec!=2);
}
}