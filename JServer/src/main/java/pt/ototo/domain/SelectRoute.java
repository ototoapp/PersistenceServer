package pt.ototo.domain;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pt.ototo.util.HibernateUtilMSSQL;

@Entity
@Table(name = "SelectRoute",uniqueConstraints = {
		@UniqueConstraint(columnNames = "Id") })
public class SelectRoute {
	
	Long Id;
	String RRID;
	Short RouteId;
	Short StepId;
	Float OriginLatitude;
    Float OriginLongitude;
    Float DestinationLatitude;
    Float DestinationLongitude;
    Time StepDepartureTime;
    Time StepArivalTime;
    Short TravelMode;
    String TransitName;
    String TransitShortName;
    Integer StopId;
    Integer TripId;
    
    
    @Id
	@Column(name = "Id", unique = true, nullable = false)	
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


	public Float getOriginLatitude() {
		return OriginLatitude;
	}


	public void setOriginLatitude(Float originLatitude) {
		OriginLatitude = originLatitude;
	}


	public Float getOriginLongitude() {
		return OriginLongitude;
	}


	public void setOriginLongitude(Float originLongitude) {
		OriginLongitude = originLongitude;
	}


	public Float getDestinationLatitude() {
		return DestinationLatitude;
	}


	public void setDestinationLatitude(Float destinationLatitude) {
		DestinationLatitude = destinationLatitude;
	}


	public Float getDestinationLongitude() {
		return DestinationLongitude;
	}


	public void setDestinationLongitude(Float destinationLongitude) {
		DestinationLongitude = destinationLongitude;
	}


	public Time getStepDepartureTime() {
		return StepDepartureTime;
	}


	public void setStepDepartureTime(Time stepDepartureTime) {
		StepDepartureTime = stepDepartureTime;
	}


	public Time getStepArivalTime() {
		return StepArivalTime;
	}


	public void setStepArivalTime(Time stepArivalTime) {
		StepArivalTime = stepArivalTime;
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


	public Integer getStopId() {
		return StopId;
	}


	public void setStopId(Integer stopId) {
		StopId = stopId;
	}


	public Integer getTripId() {
		return TripId;
	}


	public void setTripId(Integer tripId) {
		TripId = tripId;
	}



}
