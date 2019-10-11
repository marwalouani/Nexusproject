package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.User;



/**
 * Session Bean implementation class userService
 */
@Stateless
@LocalBean
public class userService implements userServiceRemote, userServiceLocal {

    /**
     * Default constructor. 
     */
    public userService() {
        // TODO Auto-generated constructor stub
    
    }
    
    @PersistenceContext(unitName = "examen_blanc-ejb")
    EntityManager em;
    
    @Override
    public entities.User getEmployeByEmailAndPassword(String email, String password) {
    TypedQuery<User> query =
    em.createQuery("SELECT e FROM User e WHERE e.adressmail=:email AND e.password=:password ",
    User.class);
    query.setParameter("email", email);
    query.setParameter("password", password);
  
    User employe = null;
    try { employe = query.getSingleResult(); }
    catch (Exception e) { System.out.println("Erreur : " + e); }
    return employe;
    } 

    @Override
    public int addUser(User user) {
    System.out.println("In addUser : ");
    em.persist(user);
    System.out.println("Out of addUser" + user.getId());
    return user.getId();
    }
    @Override
    public void removeUser(int id) {
    System.out.println("In removeUser : ");
    em.remove(em.find(User.class, id));
    System.out.println("Out of removeUser : ");
    }
    @Override
    public void updateUser(User employe) {
    User emp = em.find(User.class, employe.getId());
    emp.setPrenom(employe.getPrenom()); emp.setNom(employe.getNom());
    emp.setAdressmail(employe.getAdressmail()); emp.setPassword(employe.getPassword());
    emp.setIsActif(employe.getIsActif()); emp.setRole(employe.getRole());
    }

    @Override
    public User findUserById(int id) {
    System.out.println("In findUserById : ");
    User user = em.find(User.class, id);
    System.out.println("Out of findUserById : ");
    return user;
    }

    @Override
    public List<User> findAllUsers() {
    System.out.println("In findAllUsers : ");
    List<User> users = em.createQuery("from User", User.class).getResultList();
    System.out.println("Out of findAllUsers : ");
    return users;
    }
 // EmployeService
    @Override
    public List<User> getAllEmployes() {
    List<User> emp = em.createQuery("Select e from User e",User.class).getResultList();
    return emp;
    }

}
