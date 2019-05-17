package Vista;

import java.awt.TextField;
import java.sql.SQLException;

import Conexion.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AnadirTutorEmpresaController {
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
	public TextField tfno;
	@FXML
    public Button anadir;

	
	public void InsertadoTutorE(ActionEvent event) throws SQLException{
		TestConexion conexionbbdd = new TestConexion();
		String dni3= dni.getText();
		String nombre3= nombre.getText();
		String apellido3= apellidos.getText();
		String email3= email.getText();
		String tfno3= tfno.getText();
	}
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void closeWindow(){
		this.ventana.close();
	}
}
