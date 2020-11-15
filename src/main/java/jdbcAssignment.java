import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class jdbcAssignment {
    private static SessionFactory factory;
    public static void main(String[] args) {
        System.out.println("Enter customer ID");
        Scanner s = new Scanner(System.in);
        int customerID =  Integer.parseInt(args[0]);
        System.out.println("Enter Customer's First Name: ");
//        String firstName = args[1];
        System.out.println("Enter Customer last name: ");
//        String lastName = args[2];
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        jdbcAssignment firstTry = new jdbcAssignment();
        firstTry.addToCart(customerID, customerID, customerID);

    }
    public void addCustomer(int id, String fname, String lname){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           Customer customer1 = new Customer(id,fname,lname);
           session.save(customer1);
           tx.commit();
        }catch(HibernateException e){
            if(tx!=null)tx.rollback();
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
    }
    public void addProduct(int id, String pType, String pName){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Product product1 = new Product(id,pType,pName);
            session.save(product1);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)tx.rollback();
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
    }
    public void deleteProduct(Integer productID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Product product = (Product)session.get(Product.class, productID);
            session.delete(product);
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void addToCart(int cartID, int custID, int prodID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //query product table to make sure prodiD EXISTS, throw err if it doesnt
            ShoppingCart cart = new ShoppingCart(cartID, custID, prodID);
            session.save(cart);
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //to retrieve all products in cart for custmer id
    //query database for all entries where cart id = x & customer id = y
    //get all product ids (z1, z2, ...)
    //query product table for names of products z1, z2, ...
}
