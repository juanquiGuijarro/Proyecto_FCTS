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
		return num1; 
	}*/
	/*public static int modificarAramario() throws SQLException{
		Scanner sc = new  Scanner(System.in);
	
		System.out.println("Introduce un numero del armario:");
		int num=sc.nextInt();
		System.out.println("introduce el tamaño:");
		String letra= sc.next();
		Statement stmt = conexion.createStatement();
		int num1= stmt.executeUpdate("UPDATE TABLE PRUEBA.ARMARIO SET TIPO='letra'");
		System.out.println("Dato Actualizado");
		return num1; 
	}*/
}
