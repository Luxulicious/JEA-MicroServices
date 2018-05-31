/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Ticket;
import domain.User;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tomt
 */
@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        List<User> users = em.createNamedQuery("User.getAll").getResultList();
        return users;
    }

    public void save(User user) {
        em.persist(user);
    }

    public void update(User user) {
        em.merge(user);
    }

    public User find(String email) {
        Query query = em.createNamedQuery("User.find");
        return (User) query.setParameter("email", email).getSingleResult();
    }

    public void sendEmail(String email, String name, Ticket ticket) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("ctestemail999@gmail.com", "Testmail");
                        }
                    });
            
            StringBuilder seatNumbers = new StringBuilder();
            for(int i = 0; i < ticket.getSeatNumbers().size(); i++){
                seatNumbers.append(ticket.getSeatNumbers().get(i));
            }
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ctestemail999@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ctestemail999@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Beste " + name + ","
                    + "\n\n U heeft gereserveerd voor " + ticket.getMovieTitle() + " op stoelnummers " + seatNumbers.toString() + ". De film begint om " + ticket.getStartTime().toString()
                    + " en is afgelopen om " + ticket.getEndTime().toString() + ".");
            
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
