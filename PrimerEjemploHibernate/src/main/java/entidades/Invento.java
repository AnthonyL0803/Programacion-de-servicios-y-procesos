package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "inventos")
public class Invento {
	
	@Id
	private String invento = "";
	@Column
	private String inventor = "";
	private int fecha = 0;
	
	public String getInvento() {
		return invento;
	}
	public void setInvento(String invento) {
		this.invento = invento;
	}
	public String getInventor() {
		return inventor;
	}
	public void setInventor(String inventor) {
		this.inventor = inventor;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Invento [invento=" + invento + ", inventor=" + inventor + ", fecha=" + fecha + "]";
	}
	
}
