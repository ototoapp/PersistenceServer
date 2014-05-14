package pt.ototo.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import pt.ototo.dao.SuggestedRouteDao;
import pt.ototo.domain.SuggestedRoute;

public class App {
	
	
	
	public static void main(String[] args) {
		
		Log log = LogFactory.getLog(App.class);
		
		short RouteId = 3;
		String RRID = "930";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath*:app-context.xml");
		System.out.println(ctx.toString());
		ctx.refresh();
		
		SuggestedRouteDao suggestedRouteDao = ctx.getBean("suggestedRouteDao", SuggestedRouteDao.class);		
		
		List<SuggestedRoute> suggestedRoutes;
		suggestedRoutes=suggestedRouteDao.findByRRID(RRID);
		System.out.println("deleted"+suggestedRouteDao.delete(RRID));
		
		List<SuggestedRoute> selectedRoutes = new ArrayList<SuggestedRoute>();
		
		if(suggestedRoutes.size()>0){
			System.out.println("Size of suggestedRoutes is :"+suggestedRoutes.size());					
		}

		//get SelectRoute
		
		for (Iterator iterator = suggestedRoutes.iterator(); iterator.hasNext();)
		{
			    SuggestedRoute sr = (SuggestedRoute) iterator.next(); 
			    System.out.println("SuggestedRoute : Id "+sr.getId());
                if(sr.getRouteId().equals(RouteId)){
                	selectedRoutes.add(sr);
                	System.out.println("found selected route : Id "+sr.getId());
                 	
                }
        }
		
		System.out.println("Result is: "+suggestedRouteDao.delete(RRID));
		
/*		
		try {
			
			suggestedRoutes=SuggestedRoute.listSuggestedRoutesAccordingToRRID(RRID);			
						
			
			//check if not empty
			if(suggestedRoutes.size()>0){
				
				System.out.println("Size of suggestedRoutes is :"+suggestedRoutes.size());
				selectedRoutes=SuggestedRoute.getSelectedRoute(suggestedRoutes,RouteId);
			}
			//1.add persistence suggestedRoutes to PostgreSQL
			//2.add persistence selectedRoutes to PostgreSQL 
			//3.open comment from delete			
			//SuggestedRoute.deleteFromSuggestedRoutesAccordingToRRID(RRID);
			
			
//			for (Iterator iterator = suggestedRoutes.iterator(); iterator.hasNext();)
//			{
//				    SuggestedRoute sr = (SuggestedRoute) iterator.next(); 
//				    System.out.println("SuggestedRoute : Id "+sr.getId());
//	                if(sr.getRouteId().equals(RouteId)){
//	                	selectedRoutes.add(sr);
//	                	System.out.println("found selected route : Id "+sr.getId());
//	                 	
//	                }
//	        }
			
			SuggestedRoute.persistToPostgres(selectedRoutes);
		
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		System.out.println("Done");
	}
}
