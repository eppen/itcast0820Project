package cn.itcast.ssh.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.ValueContext;

/**
 * 请假单管理
 */
@SuppressWarnings("serial")
@Scope("prototype")
public class LeaveBillAction extends WfBaseAction implements ModelDriven<LeaveBill> {

	private LeaveBill leaveBill = new LeaveBill();

	@Override
	public LeaveBill getModel() {
		return leaveBill;
	}

	@Autowired
	private ILeaveBillService leaveBillService;


	/**
	 * 请假管理首页显示
	 *
	 * @return
	 */
	public String home() {
		//1：查询所有的请假信息（对应a_leavebill），返回List<LeaveBill>
		List<LeaveBill> list = leaveBillService.findLeaveBillList();
		//放置到上下文对象中
		ValueContext.putValueContext("list", list);
		return "home";
	}

	/**
	 * 添加请假申请
	 *
	 * @return
	 */
	@Override
	public String input() {
		//1：获取请假单ID
		Long id = leaveBill.getId();
		//修改
		if (id != null) {
			//2：使用请假单ID，查询请假单信息，
			LeaveBill bill = leaveBillService.findLeaveBillById(id);
			//3：将请假单信息放置到栈顶，页面使用struts2的标签，支持表单回显
			ValueContext.putValueStack(bill);
		}
		//新增
		return "input";
	}

	/**
	 * 保存/更新，请假申请
	 */
	public String save() {
		//执行保存
		leaveBillService.saveLeaveBill(leaveBill);
		return "save";
	}

	/**
	 * 删除，请假申请
	 */
	public String delete() {
		//1：获取请假单ID
		Long id = leaveBill.getId();
		//执行删除
		leaveBillService.deleteLeaveBillById(id);
		return "save";
	}

}
