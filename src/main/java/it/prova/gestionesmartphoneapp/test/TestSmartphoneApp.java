package it.prova.gestionesmartphoneapp.test;

import java.time.LocalDate;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;

public class TestSmartphoneApp {

	public static void main(String[] args) {
		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

		try {
			
			testInserimentoNuovoSmartphone(smartphoneServiceInstance);
			
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}
	
///////////// METODI INTERMEDI ////////////////////////////////////////////////////////////////////////////////////////////////

	private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

		Smartphone smartphoneInstance = new Smartphone("samsung", "g8", 180, 12);
		smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);
//		if (smartphoneInstance.getId() == null)
//			throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

		System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
	}
	
	
}
