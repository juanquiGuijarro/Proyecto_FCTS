package Vista;

import Conexion.TestConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class modificarDatosController {

	private Stage ventana;
	
	@FXML
	public TextField DNI;
	@FXML
	public TextField Nombre;
	@FXML
	public TextField Apellidos;
	@FXML
	public TextField Email;
	@FXML
	public TextField Telefono;
	
	@FXML
	public Button modificar;
	@FXML
	public Button VERTABLA;
	
	ObservableList<String> AlumnosList = FXCollections.observableArrayList("");
	
	TestConexion conexionbbdd;
	@FXML
	public TableView <Alumnos> tabla;
	
	@FXML
	public TableColumn <Alumnos,String> colDNI;
	
	@FXML
	public TableColumn <Alumnos,String> colNombre;
	
	@FXML
	public TableColumn <Alumnos,String> colApellidos;
	
	@FXML
	public TableColumn <Alumnos,String> colEmail;
	
	@FXML
	public TableColumn <Alumnos,String> colTelefono;

	private final ObservableList<Alumnos> data =FXCollections.observableArrayList(new Alumnos ("","","","",""));
	
	@FXML
	public void initalize(ActionEvent event) {
		conexionbbdd= new TestConexion();
		
		AlumnosList =conexionbbdd.ConsultarAlumnos();
		
		tabla.setItems(data);
		
		colDNI.setCellValueFactory(new PropertyValueFactory<Alumnos,String>("DNI Alumno"));
		colNombre.setCellValueFactory(new PropertyValueFactory<Alumnos,String>("Nombre Alumno"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Alumnos,String>("Apellidos Alumno"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Alumnos,String>("Email Alumno"));
		colTelefono.setCellValueFactory(new PropertyValueFactory<Alumnos,String>("Telefono Alumno"));
		AlumnosList = FXCollections.observableArrayList();
	}
	/*@FXML
	public void ActualizaTabla(){
		
		// SE ha seleccionado un nuevo departamento
		// Tengo que lanzar la consulta a la tabla EMPLE
		
		String aux = VERTABLA.getSelectionModel().getSelectedItem();
		
		System.out.println("se ha seleccionado  " + aux);
		
		Tabla.setItems(conexionbbdd.ConsultaEmpleados(aux));}*/
	public void setStagePrincipal(Stage ventana) {
		// TODO Apéndice de método generado automáticamente
		this.ventana = ventana;
	}

	public void closeWindow(){
		this.ventana.close();
	}
}
