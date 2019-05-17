package application;
	
import java.io.IOException;

import Vista.AnadirTutorEmpresaController;
import Vista.VentanaPrincipalController;
import Vista.anadirAlumnoController;
import Vista.anadirEmpresaController;
import Vista.anadirTutorCentroController;
import Vista.modificarDatosController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	private static Stage stagePrincipal;
    private AnchorPane rootPane;
	
	@Override
	 public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
	 public void mostrarVentanaPrincipal() {
		 try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/VentanaPrincipal.fxml"));
	            rootPane=(AnchorPane) loader.load();
	            Scene scene = new Scene(rootPane);
	            stagePrincipal.setTitle("Ventana Principal");
	            stagePrincipal.setScene(scene);
	            /*
	             * Añadidos las llamadas del main al Controlador y del controlador al main ***/
	            VentanaPrincipalController controller = loader.getController();
	            controller.setProgramaPrincipal(this);

	            stagePrincipal.show();
	        } catch (IOException e) {
	            //tratar la excepción.
	        	System.out.println("no se visualiza la pantalla");
	        	System.out.println(e.getMessage());
	        }
	   }
	 /* Este método es llamado cuando se presiona el botón de la ventana principal
	     * Lo llama el controlador de la vista principal
	     */
		public void mostrarAnadirAlumno() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/anadirAlumno.fxml"));
	            AnchorPane anadirAlumno = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Añadir Alumno");
	            /* Le decimos a la ventana quién es la ventana original */
	            Scene scene = new Scene(anadirAlumno);
	            anadirAlumnoController controller2 = loader.getController();
	            ventana.setScene(scene);
	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        	System.out.println("no se visualiza la pantalla");
	        	System.out.println(e.getMessage());
	        }
			
		}
		
		public void mostrarAnadirEmpresa() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/anadirEmpresa.fxml"));
	            AnchorPane anadirEmpresa = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Añadir Empresa");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(anadirEmpresa);
	            ventana.setScene(scene);

	            anadirEmpresaController controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        	System.out.println("no se visualiza la pantalla");
	        }
			
		}

		public void mostrarAnadirTutorEmpresa() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/anadirTutor_Empresa.fxml"));
	            AnchorPane anadirEmpresa = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Añadir Tutor Empresa");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(anadirEmpresa);
	            ventana.setScene(scene);

	            AnadirTutorEmpresaController controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        	System.out.println("no se visualiza la pantalla");
	        	System.out.println(e.getMessage());
	        	
	        }
			
		}
		
		public void mostrarAnadirTutorCentro() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/anadirTutor_Centro.fxml"));
	            AnchorPane anadirEmpresa = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Añadir Tutor Centro");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(anadirEmpresa);
	            ventana.setScene(scene);

	            anadirTutorCentroController controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        	System.out.println("no se visualiza la pantalla");
	        	System.out.println(e.getMessage());
	        	
	        }
			
		}
		
		public void mostrarVentanaModificar() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/modificar_datos.fxml"));
	            AnchorPane anadirEmpresa = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Modificar Datos");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(anadirEmpresa);
	            ventana.setScene(scene);

	            modificarDatosController controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        	System.out.println("no se visualiza la pantalla");
	        	System.out.println(e.getMessage());
	        	
	        }
			
		}
}

