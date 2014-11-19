/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model.DAO;

import java.util.List;

/**
 *
 * @author pompeu
 * @param <T>
 */
public interface ICRUD<T> {
    public long create(T obj);
    public long update(T obj);
    public boolean delete(T obj);
    public List<T> retriveAll(T obj);
    public T retrivebyId(long  id);
}
