package Vista;

import javafx.stage.Stage;

public class VentanaDosController {

	private Stage ventana;

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void closeWindow(){
		this.ventana.close();
	}

}
