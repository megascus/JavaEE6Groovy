/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megascus.javaee6groovy

import javax.ejb.Local

/**
 *
 * @author megascus
 */
@Local
interface IMessageFacade {
    void create(Message entity)
    void edit(Message entity) 
    void remove(Message entity)
    Message find(Object id) 
    List<Message> findAll() 
    List<Message> findRange(int[] range)
    int count()
}

