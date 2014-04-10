package pt.ototo.dao;

import pt.ototo.domain.SuggestedRoute;
import java.util.List;

public interface SugggestedRouteDao {
	
	// Find with details by RRID
	public List<SuggestedRoute> findByRRID(String  RRID);
	
//	// Find all 
//	public List<SuggestedRoute> findAll();
//	
//	// Find all with details
//	public List<SuggestedRoute> findAllWithDetail();
//	
//	// Insert or update 
//	public SuggestedRoute save(SuggestedRoute suggestedRoute);
//	
	// Delete 
    public int delete(String  RRID);
    

}
