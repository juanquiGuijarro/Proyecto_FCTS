package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;

public class VentanaPrincipalController implements Initializable{
	
	private  Main ProgramaPrincipal;

    @FXML
    private MenuButton anadir;
    private MenuButton Modificar;
    


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
    private void anadirEmpresa() {
       	this.ProgramaPrincipal.mostrarAnadirEmpresa();
}
    private void anadirAlumno() {
    	this.ProgramaPrincipal.mostrarAnadirAlumno();
    }
}