package pt.ototo.domain;



import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

import pt.ototo.util.HibernateUtilMSSQL;
import pt.ototo.util.HibernateUtilPostgresSQL;

 
@Table(name = "SuggestedRoute", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Id") })

@NamedQueries({
	@NamedQuery(name="SuggestedRoute.findByRRID", 
			    query="from SuggestedRoute sg where sg.RRID = :RRID"),
    @NamedQuery(name="SuggestedRoute.deleteByRRID", 
			    query="delete from SuggestedRoute sg where sg.RRID = :RRID"),	
})

@Entity
public class SuggestedRoute implements Serializable {
	
	
	private Long Id;
	public String getStepDepartureTime() {
		return StepDepartureTime;
	}
	public void setStepDepartureTime(String stepDepartureTime) {
		StepDepartureTime = stepDepartureTime;
	}
	public String getStepArivalTime() {
		return StepArivalTime;
	}
	public void setStepArivalTime(String stepArivalTime) {
		StepArivalTime = stepArivalTime;
	}

	private String  RRID;
	private Short RouteId;
	private Short  StepId;
	private float  OriginLatitude;
	private float  OriginLongitude;
	private float DestinationLatitude;
	private float DestinationLongitude;
	//private Time StepDepartureTime;
	//private Time StepArivalTime;
	private String StepDepartureTime;
	private String StepArivalTime;
	private Short TravelMode;
	private String TransitName;
	private String TransitShortName;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getRRID() {
		return RRID;
	}
	public void setRRID(String rRID) {
		RRID = rRID;
	}
	public Short getRouteId() {
		return RouteId;
	}
	public void setRouteId(Short routeId) {
		RouteId = routeId;
	}
	public Short getStepId() {
		return StepId;
	}
	public void setStepId(Short stepId) {
		StepId = stepId;
	}
	public float getOriginLatitude() {
		return OriginLatitude;
	}
	public void setOriginLatitude(float originLatitude) {
		OriginLatitude = originLatitude;
	}
	public float getOriginLongitude() {
		return OriginLongitude;
	}
	public void setOriginLongitude(float originLongitude) {
		OriginLongitude = originLongitude;
	}
	public float getDestinationLatitude() {
		return DestinationLatitude;
	}
	public void setDestinationLatitude(float destinationLatitude) {
		DestinationLatitude = destinationLatitude;
	}
	public float getDestinationLongitude() {
		return DestinationLongitude;
	}
	public void setDestinationLongitude(float destinationLongitude) {
		DestinationLongitude = destinationLongitude;
	}

	public Short getTravelMode() {
		return TravelMode;
	}
	public void setTravelMode(Short travelMode) {
		TravelMode = travelMode;
	}
	public String getTransitName() {
		return TransitName;
	}
	public void setTransitName(String transitName) {
		TransitName = transitName;
	}
	public String getTransitShortName() {
		return TransitShortName;
	}
	public void setTransitShortName(String transitShortName) {
		TransitShortName = transitShortName;
	}

	
	public static List<SuggestedRoute> listSuggestedRoutesAccordingToRRID(String RRID) throws Throwable{
		
		Session session = HibernateUtilMSSQL.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		List<SuggestedRoute> suggestedRoutes;
		
		try{
			
			Query query = session.createQuery("From SuggestedRoute where RRID = :code");
			query.setParameter("code", RRID);
			suggestedRoutes = query.list();
        	session.getTransaction().commit();
		
		 
		}catch (Throwable t) {
			  transaction.rollback();
			  throw t;
		}
		 session.close();
		 return suggestedRoutes;
		 
	}
	
	public static List<SuggestedRoute> getSelectedRoute(List<SuggestedRoute> suggestedRoutes,short RouteId) throws Throwable{			
		
		List<SuggestedRoute> selectedRoutes = new ArrayList<SuggestedRoute>();		
	
//		for (Iterator<SuggestedRoute> iterator = suggestedRoutes.iterator(); iterator.hasNext();)
//		{
//			    SuggestedRoute sr = (SuggestedRoute) iterator.next(); 
//                if(sr.getRouteId().equals(RouteId)){
//                	selectedRoutes.add(sr);
//                 	System.out.println("found selected route : Id "+sr.getId());                 	
//                }
//        } 

		for (Iterator iterator = suggestedRoutes.iterator(); iterator.hasNext();)
		{
			    SuggestedRoute sr = (SuggestedRoute) iterator.next(); 
			    System.out.println("SuggestedRoute : Id "+sr.getId());
                if(sr.getRouteId().equals(RouteId)){
                	selectedRoutes.add(sr);
                	System.out.println("found selected route : Id "+sr.getId());
                 	
                }
        }
		 return selectedRoutes;
		 
	}
	
	
	
	public static void deleteFromSuggestedRoutesAccordingToRRID(String RRID) throws Throwable{
		
		Session session = HibernateUtilMSSQL.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try{
		Query query = session.createQuery("delete from SuggestedRoute where RRID = :code");
		query.setParameter("code", RRID);
		int result = query.executeUpdate();
		System.out.println("result: "+result);		 
     	 session.getTransaction().commit();
		}catch (Throwable t) {
			  transaction.rollback();
			  throw t;
		}
		 session.close();
	}
	
	public static void persistToPostgres(List<SuggestedRoute> suggestedRoutes) throws Throwable{
		
		Session session = HibernateUtilPostgresSQL.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		//SelectRoute selectRoute = (SelectRoute)suggestedRoutes.get(0);
		
		try{	
			
	  	 for (SuggestedRoute suggestedRoute:suggestedRoutes){
		 session.save(suggestedRoute);
	  	 }
     	 session.getTransaction().commit();
     	 
		}catch (Throwable t) {
			  transaction.rollback();
			  throw t;
		}
		 session.close();
	}
	
}
