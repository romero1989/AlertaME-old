package alertame.utils;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Romero Gomes
 */
public class Persistence {

    //Insert  
    public static void salvar(Object objeto) throws Exception {

        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();

                sess.save(objeto);
                tx.commit();
            } catch (RuntimeException e) {
                MailUtil.sendEmailError(e);
                if (tx != null) {
                    tx.rollback();
                }
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }

            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na inserção :" + he.getMessage());
            throw he;
        }
    }

    //getList  
    public static java.util.List Listar(String query) throws Exception {

        try {
            List objeto = null;
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

            try {
                tx = sess.beginTransaction();
                Query q1 = sess.createQuery(query);
                objeto = q1.list();
                tx.commit();
                return objeto;
            } catch (RuntimeException e) {
                if (tx != null) {
                    tx.rollback();
                }
                MailUtil.sendEmailError(e);
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }
            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na Recuperacao: " + he.getMessage());
            throw he;
        }
    }

    public static Object getAtributo(String SQLQuery) throws Exception {

        try {
            Object objeto = null;
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

            try {
                tx = sess.beginTransaction();
                Query q1 = sess.createSQLQuery(SQLQuery);
                objeto = q1.uniqueResult();
                tx.commit();
                return objeto;
            } catch (RuntimeException e) {
                MailUtil.sendEmailError(e);
                if (tx != null) {
                    tx.rollback();
                }
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }
            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na Recuperacao: " + he.getMessage());
            throw he;
        }
    }

    //Retrieve  
    public static Object carregar(Long pk, Class classe) throws Exception {

        try {
            Object objeto = null;
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {

                objeto = (Object) sess.load(classe, pk);
                sess.flush();
                Hibernate.initialize(objeto);
                return objeto;
            } catch (RuntimeException e) {
                MailUtil.sendEmailError(e);
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }

            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na Recuperacao: " + he.getMessage());
            throw he;
        }
    }

    //Retrieve  
    public static Object carregar(String nome, Class classe) throws Exception {
        try {
            Object objeto = null;
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();
                objeto = (Object) sess.load(nome, classe);
                return objeto;
            } catch (RuntimeException e) {
                MailUtil.sendEmailError(e);
                if (tx != null) {
                    tx.rollback();
                }
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }
            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na Recuperacao: " + he.getMessage());
            throw he;
        }
    }

    //Update  
    public static void atualizar(Object objeto) throws Exception {


        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();
                sess.update(objeto);
                tx.commit();
            } catch (RuntimeException e) {
                MailUtil.sendEmailError(e);
                if (tx != null) {
                    tx.rollback();
                }
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }
            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na Atualizacao: " + he.getMessage());
            throw he;
        }

    }

    public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
    //Delete  

    public static void excluir(Object objeto) throws Exception {

        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();
                sess.delete(objeto);
                tx.commit();
            } catch (RuntimeException e) {
                MailUtil.sendEmailError(e);
                if (tx != null) {
                    tx.rollback();
                }
                throw e; // or display error message
            } finally {
                if (sess.isOpen()) {
                    sess.connection().close();
                    sess.close();
                }
            }
        } catch (HibernateException he) {
            MailUtil.sendEmailError(he);
            System.out.println(
                    "Generic Persistence -> Erro na Exclusao: " + he.getMessage());
            throw he;
        }
    }

   
}
