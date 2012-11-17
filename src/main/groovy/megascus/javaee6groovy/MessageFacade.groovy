/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megascus.javaee6groovy

import javax.ejb.Stateless
import javax.ejb.Local
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaQuery
import groovy.transform.CompileStatic

@Stateless
public class MessageFacade implements IMessageFacade {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void create(Message entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Message entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Message entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Message find(Object id) {
        return getEntityManager().find(Message.class, id);
    }

    public List<Message> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Message.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<Message> findRange(int[] range) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //def cq = entityManager.criteriaBuilder.createQuery();
        cq.select(cq.from(Message.class));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Message> rt = cq.from(Message.class);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}