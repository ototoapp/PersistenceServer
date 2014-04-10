package pt.ototo.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pt.ototo.dao.SugggestedRouteDao;
import pt.ototo.domain.SuggestedRoute;


@Repository("suggestedRouteDao")
@Transactional
public class SuggestedRouteDaoImpl implements SugggestedRouteDao {

	private Log log = LogFactory.getLog(SuggestedRouteDaoImpl.class);
	
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly=true)
	public List<SuggestedRoute> findByRRID(String RRID) {
		
		return sessionFactory.getCurrentSession().getNamedQuery("SuggestedRoute.findByRRID").setParameter("RRID", RRID).list();
		
		
	}

	@Override
	public int delete(String RRID) {
		
		return sessionFactory.getCurrentSession().getNamedQuery("SuggestedRoute.deleteByRRID").setParameter("RRID", RRID).executeUpdate();
	}

}
