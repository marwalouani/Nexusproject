

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.User;
import service.userService;




@ManagedBean
@SessionScoped
public class LoginBean  implements Serializable {
	private String login; private String password; private User employe; private Boolean
	loggedIn;
	@EJB
	userService userservice;
	public String doLogin() {
	String navigateTo = "null";
	employe = userservice.getEmployeByEmailAndPassword(login, password);
	// (employe != null && employe. == Role.ADMINISTRATEUR)
	if (employe != null) {
		System.out.println("mawjouuuuuud");
	navigateTo = "/hi?faces-redirect=true"; loggedIn = true; }
	else {
		System.out.println("mouuch mawjouuuuuud");

	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
	}
	return navigateTo; 
	}
	public String doLogout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login?faces-redirect=true"; }
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getEmploye() {
		return employe;
	}
	public void setEmploye(User employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
}
