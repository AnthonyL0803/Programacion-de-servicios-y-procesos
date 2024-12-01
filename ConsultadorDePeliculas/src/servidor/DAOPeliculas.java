package servidor;

import java.sql.*;

public class DAOPeliculas {
	private String url;
	private String proyectPath;

	public DAOPeliculas() {
		this.proyectPath = System.getProperty("user.dir");
		this.url = ("jdbc:h2:file:" + this.proyectPath + "\\ConsultadorDePeliculas\\src\\Paises.db");
	}

	public void crearTablaPeliculas() throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		String dropTable = "DROP TABLE IF EXISTS TABLAALUMNOS";
		try (PreparedStatement eliminarSentencia = conexion.prepareStatement(dropTable)) {
			eliminarSentencia.execute();
		}
		PreparedStatement sentencia = conexion.prepareStatement("CREATE TABLE IF NOT EXISTS TABLAPELICULAS (ID INT PRIMARY KEY, TITULO VARCHAR(50), DIRECTOR VARCHAR(30), PRECIO DOUBLE)");
		sentencia.execute();
	}

	public boolean existePelicula(Pelicula a) throws SQLException {
	    Connection conexion = DriverManager.getConnection(this.url);
	    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE ID = ?");
	    sentencia.setInt(1, a.getId());
	    ResultSet result = sentencia.executeQuery();
	    boolean existe = result.next();
	    conexion.close();
	    return existe;
	}

	public synchronized void insertarPelicula(Pelicula a) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		if (!existePelicula(a)) {
			PreparedStatement sentencia = conexion
					.prepareStatement("INSERT INTO TABLAPELICULAS (ID, TITULO, DIRECTOR, PRECIO) VALUES(?, ?, ?, ?)");
			sentencia.setInt(1, a.getId());
			sentencia.setString(2, a.getTitulo()); // TITULO
			sentencia.setString(3, a.getDirector()); // DIRECTOR
			sentencia.setDouble(4, a.getPrecio()); // PRECIO
			sentencia.execute();
			conexion.close();
		} else {
	        System.out.println("Ya existe una película con ese ID.");
		}
	}

	public void mostrarTabla() throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("ID") + " - " + rs.getString("TITULO") + " - " + rs.getString("DIRECTOR")
					+ " - " + rs.getDouble("PRECIO"));
		}
	}

	public String consultarPeliculaID(int id) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE ID = ?");
		sentencia.setInt(1, id);
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película con ese id " + id);
		}
		conexion.close();
		System.out.println(output);
		return output;
	}

	public String consultarPeliculaTitulo(String titulo) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE TITULO = ?");
		sentencia.setString(1, titulo);
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
			output += "_";
		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película con ese id " + titulo);
		}
		conexion.close();
		return output;
	}

	public String consultarPeliculaDirector(String director) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE DIRECTOR = ?");
		sentencia.setString(1, director);
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
			output += "_";

		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película con ese id " + director);
		}
		conexion.close();
		return output;
	}
	public void limpiarTabla() throws SQLException {
	    Connection conexion = DriverManager.getConnection(this.url);
	    PreparedStatement stmt = conexion.prepareStatement("DELETE FROM TABLAPELICULAS");
	    stmt.executeUpdate();
	    conexion.close();
	}
}
