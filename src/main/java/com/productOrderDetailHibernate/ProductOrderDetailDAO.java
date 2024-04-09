package com.productOrderDetailHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductOrderDetailDAO {

    private SessionFactory sessionFactory;

    public ProductOrderDetailDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(ProductOrderDetail productOrderDetail) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(productOrderDetail);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ProductOrderDetail productOrderDetail) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(productOrderDetail);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(ProductOrderDetail.CompositeDetail compositeDetail) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            ProductOrderDetail productOrderDetail = session.get(ProductOrderDetail.class, compositeDetail);
            if (productOrderDetail != null) {
                session.delete(productOrderDetail);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductOrderDetail get(ProductOrderDetail.CompositeDetail compositeDetail) {
        ProductOrderDetail productOrderDetail = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            productOrderDetail = session.get(ProductOrderDetail.class, compositeDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productOrderDetail;
    }
}
