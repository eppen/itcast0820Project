package cn.itcast.ssh.utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * 将传入的List集合或对象，
 * 	   压入到上下文对象中(eg，传一个List)，或压入栈顶(eg，表单回显)
 */
public class ValueContext {

	/**
	 * 放置在Root栈中
	 */
	public static void putValueContext(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	/**
	 * 压入栈顶
	 */
	public static void putValueStack(Object o) {
		ServletActionContext.getContext().getValueStack().push(o);
	}


}
