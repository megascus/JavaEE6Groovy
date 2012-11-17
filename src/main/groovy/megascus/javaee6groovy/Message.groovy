/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megascus.javaee6groovy

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import groovy.transform.Canonical;
import groovy.transform.AutoExternalize;
import groovy.transform.CompileStatic;

/**
 *
 * @author megascus
 */
@Entity
@Canonical
@AutoExternalize
@CompileStatic
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String message;
}

