package Vista;

import java.sql.SQLException;

import Conexion.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class anadirEmpresaController {
	private Stage ventana;
	
	@FXML
	Button anadir;
	@FXML
	public TextField numconvenio;
	@FXML
	public TextField CIF;
	@FXML
	public TextField Representante;
	@FXML
	public TextField NIFRP;
	@FXML
	public TextField NombreEMP;
	@FXML
	public TextField Pais;
	@FXML
	public TextField Ciudad;
	@FXML
	public TextField Provincia;
	@FXML
	public TextField Direccion;
	@FXML
	public TextField CP;
	@FXML
	public TextField TFNO;
	@FXML
	public TextField Fax;
	
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	public void InsertadoEmpresa(ActionEvent event) throws SQLException {
		// TODO Auto-generated method stub
		TestConexion conexionbbdd = new TestConexion();
		String numConvenio=numconvenio.getText();
		String CIF1=CIF.getText();
		String Representante1=Representante.getText();
		String NIFRP1=NIFRP.getText();
		String NombreEMP1=NombreEMP.getText();
		String Pais1=Pais.getText();
		String Ciudad1=Ciudad.getText();
		String Provincia1=Provincia.getText();
		String Direccion1=Direccion.getText();
		int CP1=CP.getLength();
		String TFNO1=TFNO.getText();
		String Fax1=Fax.getText();
		
		conexionbbdd.InsertarEmpresa(numConvenio,CIF1,Representante1,NIFRP1,NombreEMP1,Pais1,Ciudad1,Provincia1,Direccion1,CP1,TFNO1,Fax1);
		
	}
	public void closeWindow(){
		this.ventana.close();
	}

}
