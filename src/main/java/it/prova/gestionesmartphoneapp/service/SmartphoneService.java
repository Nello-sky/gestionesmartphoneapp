package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {

	 void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;
	
	 void aggiornamentoVersioneOsSmartphone (Smartphone smartphoneEsistente, Integer newVersion) throws Exception;
	
	  List<Smartphone> listAll() throws Exception;
	
	  public void installaApp(Smartphone smartphoneEsistente, App appEsistente) throws Exception;
	
	  public void disinstallaApp(Long idSmartphoneInput, Long idAppInput) throws Exception;
	
	  public void rimuoviMaPrimaDisinstallaApp(Long idSmartphoneInput) throws Exception;
	
	
	
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);
}
