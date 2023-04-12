package it.prova.gestionesmartphoneapp.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "smartphone")
public class Smartphone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "versione")
	private Integer versione;
	
	// campi per le time info del record
	@CreationTimestamp
	@Column(name = "createdatetime")
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	@Column(name = "updatedatetime")
	private LocalDateTime updateDateTime;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "smartphone_app", joinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "app_id", referencedColumnName = "ID"))
	private Set<App> apps = new HashSet<App>();

	public Smartphone() {
	}
	

	public Smartphone( String marca, String modello, Integer prezzo, Integer versione) {
		super();
		
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.versione = versione;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getVersione() {
		return versione;
	}

	public void setVersione(Integer versione) {
		this.versione = versione;
	}

	public Set<App> getApps() {
		return apps;
	}

	public void setApps(Set<App> apps) {
		this.apps = apps;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo
				+ ", versione=" + versione + "]";
	}


	
//	// metodi per set
//	public void addToApps(App appInstance) {
//		this.generi.add(appInstance);
//		genereInstance.getBrani().add(this);
//	}
//
//	public void removeFromApps(Genere genereInstance) {
//		this.generi.remove(genereInstance);
//		genereInstance.getBrani().remove(this);
//	}
	
	
	
}

