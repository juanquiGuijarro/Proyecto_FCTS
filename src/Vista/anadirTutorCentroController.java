package Vista;

import java.awt.TextField;
import java.sql.SQLException;

import Conexion.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class anadirTutorCentroController {
	private Stage ventana;

	@FXML
    public TextField dni;
	@FXML
    public TextField nombre;
	@FXML
    public TextField apellidos;
	@FXML
    public TextField email;
	@FXML
    public Button anadir;

	
	public void InsertadoTutorC(ActionEvent event) throws SQLException{
		TestConexion conexionbbdd = new TestConexion();
		String dni1= dni.getText();
		String nombre2= nombre.getText();
		String apellido2= apellidos.getText();
		String email2= email.getText();
	}

	
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void closeWindow(){
		this.ventana.close();
	}
}
