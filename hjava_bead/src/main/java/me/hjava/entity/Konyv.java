package me.hjava.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="konyvtar")
public class Konyv implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="k_id")
    private int k_id;  
	@Column(name="cim")
    private String cim;
	@Column(name="iro")	
	private String iro;
	@Column (name="vasarlas_datuma")
	private String vasarlas_datuma;
	
	 
		public String getVasarlas_datuma() {
		return vasarlas_datuma;
	}
	
	public int getK_id() {
		return k_id;
	}
	public void setK_id(int k_id) {
		this.k_id = k_id;
	}
	public String getCim() {
		return cim;
	}
	public void setCim(String cim) {
		this.cim = cim;
	}

	public String getIro() {
		return iro;
	}

	public void setIro(String iro) {
		this.iro = iro;
	}
	
} 