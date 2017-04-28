package fitec.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="auteurResponse")
@SessionScoped
public class BeanAuteurResponse implements Serializable{
	
	private static final long serialVersionUID = -6557080130070737369L;
	
	private String expression ;
	
	public String getExpression() {
		return expression;
	}
	
	private String msg ;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public BeanAuteurResponse(){		
	}
	
	public BeanAuteurResponse(String expression, String msg) {
		this.expression = expression;
		this.msg = msg;
	}

	public String result() {
		System.out.println("Enter Auteur Response ...");
		if ( expression != null && ! expression.equals("")){
			msg="Good!";
			return "success?redirect=true";
		}else{
			msg = "error.jsp?faces-redirect=true";
			return "failure";
		}
	}
}
