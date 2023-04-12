package it.prova.gestionesmartphoneapp.test;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;

public class TestSmartphoneApp {

	public static void main(String[] args) {
		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

		try {
			
			//testInserimentoNuovoSmartphone(smartphoneServiceInstance);
			//testInserimentoNuovaApp(appServiceInstance);
			//testAggiornaVersioneOS(smartphoneServiceInstance);
			//testAggiornaVersioneApp(appServiceInstance);
			testInstallaAppEsistenti(smartphoneServiceInstance, appServiceInstance);
			//smartphoneServiceInstance.disinstallaApp(1L, 1L);
			smartphoneServiceInstance.rimuoviMaPrimaDisinstallaApp(2L);
			
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

		Smartphone smartphoneInstance = new Smartphone("nokia", "32", 20, 3);
		smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);
//		if (smartphoneInstance.getId() == null)
//			throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

		System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
	}
	
	private static void testAggiornaVersioneOS(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testAggiornaVersioneOS inizio.............");
		
		Smartphone smartphoneInstance = smartphoneServiceInstance.listAll().get(0);
		Integer version = 99;
		smartphoneServiceInstance.aggiornamentoVersioneOsSmartphone(smartphoneInstance,version);
//		if (smartphoneInstance.getId() == null)
//			throw new RuntimeException("testAggiornaVersioneOS fallito ");

		System.out.println(".......testAggiornaVersioneOS fine: PASSED.............");
	}
	
	
	private static void testInstallaAppEsistenti(SmartphoneService smartphoneServiceInstance, AppService appServiceInstance)
			throws Exception {
		// fare su due elementi nuovi e che in teoria poi togli...
		System.out.println(".......testInstallaAppEsistenti inizio.............");

		// carico uno smartphone
		if (smartphoneServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testDeleteAtleta fallito: non ci sono smartphones da caricare. ");
		Smartphone smartphoneInstance = smartphoneServiceInstance.listAll().get(1);

		// inserisco un app
		if (appServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testDeleteAtleta fallito: non ci sono app da caricare. ");
		App appInstance = appServiceInstance.listAll().get(1);

		// collego
		smartphoneServiceInstance.installaApp(smartphoneInstance, appInstance);

//		// ricarico eager per forzare il test
//		Brano branoReloaded = branoServiceInstance.caricaSingoloElementoEagerGeneri(branoInstance.getId());
//		if (branoReloaded.getGeneri().isEmpty())
//			throw new RuntimeException("testCollegaGenereABrano fallito: genere non collegato ");

		System.out.println(".......testCollegaGenereABrano fine: PASSED.............");
	}
	
	
	
	private static void testInserimentoNuovaApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovaApp inizio.............");

		App appInstance = new App("maps", 5);
		appServiceInstance.inserisciNuovo(appInstance);
//		if (smartphoneInstance.getId() == null)
//			throw new RuntimeException("testInserimentoNuovaApp fallito ");

		System.out.println(".......testInserimentoNuovaApp fine: PASSED.............");
	}
	
	

	private static void testAggiornaVersioneApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testAggiornaVersioneApp inizio.............");
		
		App appInstance = appServiceInstance.listAll().get(0);
		Integer version = 99;
		appServiceInstance.aggiornamentoVersioneEDataUpdate(appInstance,version);
//		if (smartphoneInstance.getId() == null)
//			throw new RuntimeException("testAggiornaVersioneApp fallito ");

		System.out.println(".......testAggiornaVersioneApp fine: PASSED.............");
	}
	
	
}
