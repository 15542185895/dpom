package com.huagu.vcoin.main.dao;

// default package

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huagu.vcoin.main.dao.comm.HibernateDaoSupport;
import com.huagu.vcoin.main.model.Fbalanceearning;

/**
 * A data access object (DAO) providing persistence and search support for
 * Fbalanceearning entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .Fbalanceearning
 * @author MyEclipse Persistence Tools
 */
@Repository
public class FbalanceearningDAO extends HibernateDaoSupport {
    private static final Logger log = LoggerFactory.getLogger(FbalanceearningDAO.class);
    // property constants
    public static final String FQTY = "fqty";
    public static final String FSTATUS = "fstatus";

    public void save(Fbalanceearning transientInstance) {
        log.debug("saving Fbalanceearning instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Fbalanceearning persistentInstance) {
        log.debug("deleting Fbalanceearning instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Fbalanceearning findById(java.lang.Integer id) {
        log.debug("getting Fbalanceearning instance with id: " + id);
        try {
            Fbalanceearning instance = (Fbalanceearning) getSession().get("com.huagu.vcoin.main.model.Fbalanceearning",
                    id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Fbalanceearning> findByExample(Fbalanceearning instance) {
        log.debug("finding Fbalanceearning instance by example");
        try {
            List<Fbalanceearning> results = getSession().createCriteria("com.huagu.vcoin.main.model.Fbalanceearning")
                    .add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Fbalanceearning instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from Fbalanceearning as model where model." + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Fbalanceearning> findByFqty(Object fqty) {
        return findByProperty(FQTY, fqty);
    }

    public List<Fbalanceearning> findByFstatus(Object fstatus) {
        return findByProperty(FSTATUS, fstatus);
    }

    public List findAll() {
        log.debug("finding all Fbalanceearning instances");
        try {
            String queryString = "from Fbalanceearning";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Fbalanceearning merge(Fbalanceearning detachedInstance) {
        log.debug("merging Fbalanceearning instance");
        try {
            Fbalanceearning result = (Fbalanceearning) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Fbalanceearning instance) {
        log.debug("attaching dirty Fbalanceearning instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Fbalanceearning instance) {
        log.debug("attaching clean Fbalanceearning instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public List<Fbalanceearning> list(int firstResult, int maxResults, String filter, boolean isFY) {
        List<Fbalanceearning> list = null;
        log.debug("finding Fbalanceearning instance with filter");
        try {
            String queryString = "from Fbalanceearning " + filter;
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setCacheable(true);
            if (isFY) {
                queryObject.setFirstResult(firstResult);
                queryObject.setMaxResults(maxResults);
            }
            list = queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by Fbalanceearning name failed", re);
            throw re;
        }
        return list;
    }
}