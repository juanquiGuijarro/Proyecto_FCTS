package Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import Vista.Alumnos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class TestConexion {
	private String bd;
	private String url= "";
	private String usr= "";
	private String pwd= "";
	private static Connection conexion;
	

	public TestConexion()  {
		
		Properties propiedades = new Properties();
		InputStream entrada = null; 
		try {
			File miFichero = new File("src/Conexion/ConexionBBDD.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				//cargamos el archivo
				propiedades.load(entrada);
				//obrenemos las propiedades
				url = propiedades.getProperty("url");
				usr = propiedades.getProperty("usr");
				pwd = propiedades.getProperty("pwd");
				System.out.println(propiedades.getProperty("url"));
				System.out.println(propiedades.getProperty("usr"));
				System.out.println(propiedades.getProperty("pwd"));
			}
			else
				System.out.println("Fichero no existe");
		
			}catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (entrada != null) {
					try {
						entrada.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}	
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
				//conexion.close();
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}

	public void InsertarAlumno(String DNI, String Nombre1, String Apellido1, String Email,String tlfno) throws SQLException{
		Statement stmt = conexion.createStatement();
		System.out.println("INSERT INTO PRUEBA.ALUMNOS VALUES ("+DNI+","+Nombre1+","+Apellido1+","+Email+","+tlfno+")");
		int num1= stmt.executeUpdate("INSERT INTO PRUEBA.ALUMNOS VALUES ('"+DNI+"','"+Nombre1+"','"+Apellido1+"','"+Email+"','"+tlfno+"')");
		System.out.println("dato insertado");
	}
	
	public void InsertarEmpresa(String numConvenio, String CIF, String Representante, String NIFRP, String NombreEMP, String Pais, String Ciudad, String Provincia, String Direccion, int CP, String TFNO, String Fax) throws SQLException{
		Statement stmt = conexion.createStatement();
		System.out.println("INSERT INTO PRUEBA.EMPRESA VALUES ("+numConvenio+","+CIF+","+Representante+","+NIFRP+","+NombreEMP+","+Pais+","+Ciudad+","+Provincia+","+Direccion+","+CP+","+TFNO+","+Fax+")");
		int num2= stmt.executeUpdate("INSERT INTO PRUEBA.EMPRESA VALUES ('"+numConvenio+"','"+CIF+"','"+Representante+"','"+NIFRP+"','"+NombreEMP+"','"+Pais+"','"+Ciudad+"','"+Provincia+"','"+Direccion+"','"+CP+"','"+TFNO+"','"+Fax+"')");
		System.out.println("dato insertado");
	}
	
	public void InsertarTutorCentro(String dni1, String nombre2, String apellido2, String email2) throws SQLException{
		Statement stmt = conexion.createStatement();
		System.out.println("INSERT INTO PRUEBA.TUTORESCENTRO VALUES ("+dni1+","+nombre2+","+apellido2+","+email2+")");
		int num3= stmt.executeUpdate("INSERT INTO PRUEBA.TUTORESCENTRO VALUES ('"+dni1+"','"+nombre2+"','"+apellido2+"','"+email2+"')");
		System.out.println("dato insertado");
	}
	
	public void InsertarTutorEmpresa(String dni3, String nombre3, String apellido3, String email3, String tfno3) throws SQLException{
		Statement stmt = conexion.createStatement();
		System.out.println("INSERT INTO PRUEBA.TUTORESEMPRESA VALUES ("+dni3+","+nombre3+","+apellido3+","+email3+","+tfno3+")");
		int num4= stmt.executeUpdate("INSERT INTO PRUEBA.TUTORESEMPRESA VALUES ('"+dni3+"','"+nombre3+"','"+apellido3+"','"+email3+"','"+tfno3+"')");
		System.out.println("dato insertado");
	}
	/*public static int borrarAramario(int numero) throws SQLException{
		Statement stmt = conexion.createStatement();
		int num1= stmt.executeUpdate("DELETE FROM PRUEBA.ARMARIO WHRERW NUM_ARMARIO='numero'");
		System.out.println("dato borrado");
		return num1; */

	public ObservableList<String> ConsultarAlumnos() {
		
		ObservableList<String> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM PRUEBA.ALUMNOS" );
			while(rset.next()) {
				aux.add(rset.getString(1));
				aux.add(rset.getString(2));
				aux.add(rset.getString(3));
				aux.add(rset.getString(4));
				aux.add(rset.getString(5));
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		System.out.println(aux);
		return aux;
		
		
	}

	
	/*public ObservableList<Alumnos> consultarAlumno() {
		ObservableList<Alumnos> aux = FXCollections.observableArrayList();
		try {
			Statement stmt = conexion.createStatement();
			String query = "SELECT * FROM PRUEBA.ALUMNOS";
			System.out.println(query);
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				String DNIA = rset.getString(1);
				String NOMBRE = rset.getString(2);
				String APELLIDOS = rset.getString(3);
				String EMAIL = rset.getString(4);
				String TELEFONO = rset.getString(5);
				Alumnos auxAlumnos = new Alumnos(DNIA,NOMBRE,APELLIDOS,EMAIL,TELEFONO);
				aux.addAll(auxAlumnos);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return aux;
	}*/
	}
	
