/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model.DAO;


import emp.model.Cliente;
import emp.model.JPAutil.ConnectionFactoryJPA;
import java.util.List;

/**
 *
 * @author pompeu
 */
public class ClienteDao implements ICRUD<Cliente> {

    public ClienteDao() {
        ConnectionFactoryJPA.getEntityManager().getTransaction().begin();
    }

    @Override
    public long create(Cliente obj) {
        try{
        ConnectionFactoryJPA.getEntityManager().persist(obj);
        ConnectionFactoryJPA.getEntityManager().getTransaction().commit();
        }catch(Exception e){
            throw new JPAExeption(e);
        }finally{
            ConnectionFactoryJPA.getEntityManager().close();
        }
        return -1;
    }

    @Override
    public long update(Cliente obj) {
        return -1;
    }

    @Override
    public boolean delete(Cliente obj) {
        return false;
    }

    @Override
    public List<Cliente> retriveAll(Cliente obj) {
        List<Cliente> clientes = null;
        return clientes;
    }

    @Override
    public Object retrivebyId(long id) {
        Cliente cliente = null;
        return cliente;
    }

}
