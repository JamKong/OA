package cn.czk.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7616787615722617988L;
	public String index(){
		return "index";
	}
	public String top(){
		return "top";
	}
	public String left(){
		return "left";
	}
	public String right(){
		return "right";
	}
	public String bottom(){
		return "bottom";
	}
}
