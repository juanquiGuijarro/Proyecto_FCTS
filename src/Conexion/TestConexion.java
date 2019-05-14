package Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class TestConexion {
	private String bd;
	private String url= "";
	private String usr = "";
	private String pwd = "";
	private static Connection conexion;
	

	public TestConexion()  {
		
		Properties propiedades = new Properties();
		InputStream entrada = null; 
		try {
			File miFichero = new File("src/configuracionBBDD.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				//cargamos el archivo
				propiedades.load(entrada);
				//obrenemos las propiedades
				System.out.println(propiedades.getProperty("basedatos"));
				System.out.println(propiedades.getProperty("usuario"));
				System.out.println(propiedades.getProperty("clave"));
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
	}
		
		
		/*try {
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
		
	}*/
	public static int InsertarAramario(int numero, String letra) throws SQLException{
		Statement stmt = conexion.createStatement();
		int num1= stmt.executeUpdate("INSERT INTO PRUEBA.ARMARIO VALUES ("+numero+",'"+letra+"')");
		System.out.println("dato insertado");
		return num1; 
	}
	public static int borrarAramario(int numero) throws SQLException{
		Statement stmt = conexion.createStatement();
		int num1= stmt.executeUpdate("DELETE FROM PRUEBA.ARMARIO WHRERW NUM_ARMARIO='numero'");
		System.out.println("dato borrado");
		return num1; 
	}
	public static int modificarAramario() throws SQLException{
		Scanner sc = new  Scanner(System.in);
	
		System.out.println("Introduce un numero del armario:");
		int num=sc.nextInt();
		System.out.println("introduce el tamaño:");
		String letra= sc.next();
		Statement stmt = conexion.createStatement();
		int num1= stmt.executeUpdate("UPDATE TABLE PRUEBA.ARMARIO SET TIPO='letra'");
		System.out.println("Dato Actualizado");
		return num1; 
	}
}
