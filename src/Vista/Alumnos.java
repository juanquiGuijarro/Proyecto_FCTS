package Vista;

public class Alumnos {

	String DNI;
	String Nombre;
	String Apellidos;
	String Email;
	String Telefono;
	public Alumnos(String dNI, String nombre, String apellidos, String email, String telefono) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;
		Email = email;
		Telefono = telefono;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	
}
