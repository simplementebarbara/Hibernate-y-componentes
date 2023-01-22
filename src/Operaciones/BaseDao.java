/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 34686
 */
public class BaseDao<T> implements Dao<T> {

    protected final Session session;
    private static Transaction transaction;

    public BaseDao(Session session) {
        this.session = session;
    }

    @Override
    public T get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(T t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(T t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(T t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    protected void commit() {
        if (session.getTransaction() == null) {
            transaction = session.beginTransaction();

        } else {
            transaction = session.getTransaction();
            transaction.begin();
        }
        transaction.commit();
    }

}
