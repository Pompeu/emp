/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model.DAO;

/**
 *
 * @author pompeu
 */
class JPAExeption extends RuntimeException {

    public JPAExeption(Exception e) {
        super(e);
    }

}
