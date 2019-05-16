package Vista;

import java.sql.SQLException;

import Conexion.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class anadirAlumnoController {

		Stage ventana;
		@FXML
		Button anadir;
		@FXML
		public TextField DNIA;
		@FXML
		public TextField Nombre;
		@FXML
		public TextField Apellidos;
		@FXML
		public TextField email;
		@FXML
		public TextField telefono;

		public void InsertadoAlumno(ActionEvent event) throws SQLException {
			// TODO Auto-generated method stub
			TestConexion conexionbbdd = new TestConexion();
			String DNI=DNIA.getText();
			String Nombre1=Nombre.getText();
			String Apellido1=Apellidos.getText();
			String Email=email.getText();
			String tlfno=telefono.getText();
			
			System.out.println(DNI);
			System.out.println(Nombre1);
			System.out.println(Apellido1);
			System.out.println(Email);
			System.out.println(tlfno);
			conexionbbdd.InsertarAlumno(DNI,Nombre1,Apellido1,Email,tlfno);
			
		}

		public void setStagePrincipal(Stage ventana) {
			// TODO Auto-generated method stub
			this.ventana = ventana;
		}
		public void closeWindow(){
			this.ventana.close();
		}

	}
