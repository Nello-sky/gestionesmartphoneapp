package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;

public interface AppService {

	public void inserisciNuovo(App appInstance) throws Exception ;
	
	void aggiornamentoVersioneEDataUpdate (App appEsistente, Integer newVersion) throws Exception;
	
	List<App> listAll() throws Exception;
	
	
	void setAppDAO(AppDAO appDAO);
}
