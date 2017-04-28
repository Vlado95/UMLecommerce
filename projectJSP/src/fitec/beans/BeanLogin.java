package fitec.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fitec.dba.factory.HbnFactory;
import fitec.dba.metier.User;

@ManagedBean
@SessionScoped
public class BeanLogin implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	public BeanLogin() {
	}

	private String pwd;
	private String msg;
	private String email;
	private User user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// validate login
	public String connexion() {
  String page = "";
		//try {
			HbnFactory hbnFactory = new HbnFactory();
			User userLog = hbnFactory.authenticate(email, pwd);
			
			if (userLog != null) {
			setUser(userLog);
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("user", user);
			return "admin";
			 } else {
			 FacesContext.getCurrentInstance().addMessage(
			 null,
			 new FacesMessage(FacesMessage.SEVERITY_WARN,
			 "Incorrect Username and Passowrd",
			 "Please enter correct username and Password"));
			 return "login";
			 }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.err.println("erruer login: "+e.getLocalizedMessage());
//		}
	}

	// logout event, invalidate session
	// public String logout() {
	// HttpSession session = SessionUtils.getSession();
	// session.invalidate();
	// return "login";
	// }
}