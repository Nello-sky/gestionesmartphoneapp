package it.prova.gestionesmartphoneapp.dao.smartphone;

import it.prova.gestionesmartphoneapp.dao.IBaseDAO;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneDAO extends IBaseDAO<Smartphone> {
	
	public void deleteAppJoin(Long idBranoInput, Long idAppInput) throws Exception;
	
	public void deleteSmartphoneAndUnlinkApp(Long idSmartphoneInput) throws Exception;
}
