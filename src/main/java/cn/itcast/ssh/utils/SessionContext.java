package cn.itcast.ssh.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.itcast.ssh.domain.Employee;

public class SessionContext {

	public static final String GLOBLE_USER_SESSION = "globle_user";

	public static void setUser(Employee user) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (user != null) {
			// user不为空时，设置session
			session.setAttribute(GLOBLE_USER_SESSION, user);
		} else {
			// user为空时，清空session
			session.removeAttribute(GLOBLE_USER_SESSION);
		}
	}

	public static Employee get() {
		// 获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		return (Employee) session.getAttribute(GLOBLE_USER_SESSION);
	}


}
