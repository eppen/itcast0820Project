package cn.itcast.ssh.utils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.itcast.ssh.domain.Employee;

/**
 * 登录验证拦截器：
 *    主要处理当前用户正常登录，若存在session，可以访问对应的URL；若session不存在，跳转到登录页面
 */
@SuppressWarnings("serial")
public class LoginInteceptor implements Interceptor {

	@Override
	public void init() {
		System.out.println("登录验证拦截器初始化成功！");
	}

	@Override
	public void destroy() {
		System.out.println("登录验证拦截器销毁！");
	}

	/**
	 * 每次访问Action类之前，先执行intercept方法
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取当前访问Action的URL
		String actionName = invocation.getProxy().getActionName();
		// 如果当前访问Action的URL是"loginAction_login"表示此时还没有Sesion，需要放行
		if (!"loginAction_login".equals(actionName)) {
			// 从Session中获取当前用户对象
			Employee employee = SessionContext.get();
			// 如果Session不存在，跳转到登录页面
			if (employee == null) {
				return "login";
			}
		}

		//放行，访问Action类中方法
		return invocation.invoke();
	}

}
