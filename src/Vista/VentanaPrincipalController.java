package Vista;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VentanaPrincipalController implements Initializable{
	
	private  Main ProgramaPrincipal;

    @FXML
    private Button anadirA;
    @FXML
    private Button anadirE;
    @FXML
    private Button anadirTP;
    @FXML
    private Button anadirTC;
   
    @FXML
    private Button modificar;
    


    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /* Cuando se pulsa el botón tendrá que abrir ventana nueva
     * para eso llama al método del main */
    
    @FXML
    private void anadirAlumno() {
    	this.ProgramaPrincipal.mostrarAnadirAlumno();
    }
    
    @FXML
    private void anadirEmpresa() {
    	this.ProgramaPrincipal.mostrarAnadirEmpresa();
    }
    
    @FXML
    private void anadirTutorPracticas() {
    	this.ProgramaPrincipal.mostrarAnadirTutorEmpresa();
    	
    }
    @FXML
    private void anadirTutorCentro() {
    	this.ProgramaPrincipal.mostrarAnadirTutorCentro();
    	
    }
    @FXML
    private void modificarDatos() {
    	this.ProgramaPrincipal.mostrarVentanaModificar();
    }
}