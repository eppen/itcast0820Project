package cn.itcast.ssh.utils;

import org.apache.struts2.ServletActionContext;

import cn.itcast.ssh.domain.Employee;

public class SessionContext {

	public static final String GLOBLE_USER_SESSION = "globle_user";

	public static void setUser(Employee user) {
		if (user != null) {
			// user不为空时，设置session
			ServletActionContext.getRequest().getSession().setAttribute(GLOBLE_USER_SESSION, user);
		} else {
			// user为空时，清空session
			ServletActionContext.getRequest().getSession().removeAttribute(GLOBLE_USER_SESSION);
		}
	}

	public static Employee get() {
		// 获取session
		return (Employee) ServletActionContext.getRequest().getSession().getAttribute(GLOBLE_USER_SESSION);
	}


}
