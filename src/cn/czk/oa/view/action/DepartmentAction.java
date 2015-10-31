package cn.czk.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Department;
import cn.czk.oa.util.DepartmentUtil;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	private static final long serialVersionUID = 1L;
	private Long parentId;

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	public String addUI() {
		//1. 获取最顶级的部门
		List<Department> departmentList = departmentService.getTopList();
		//2. 获取所有部门的子部门等，并以树状的结构保存到list集合中
		departmentList = DepartmentUtil.getAllDepartments(departmentList);
		//3. 保存到已经处理过的list集合
		ActionContext.getContext().put("departmentList", departmentList);
		//4. 获取所属的上级部门对象，用于页面在新建部门的时候，可以自动选中上级部门。
		Department parent = departmentService.getById(parentId);
		ActionContext.getContext().put("parent", parent);
		return "addUI";
	}

	/**
	 * 添加部门
	 * 
	 * @return
	 */
	public String add() {
		// 获取要添加的部门所属于哪个上级部门。
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}

	/**
	 * 更新页面
	 * 
	 * @return
	 */
	public String updateUI() {
		//1. 获取最顶级的部门
		List<Department> departmentList = departmentService.getTopList();
		//2. 获取所有部门的子部门等，并以树状的结构保存到list集合中
		departmentList = DepartmentUtil.getAllDepartments(departmentList);
		//3. 保存到已经处理过的list集合
		ActionContext.getContext().put("departmentList", departmentList);
		//4. 获取当前要修改的对象
		model = departmentService.getById(model.getId());
		//5. 保存对象
		ActionContext.getContext().put("model", model);
		//获取当前对象父级id
		if(model.getParent()!=null){
			parentId = model.getParent().getId();
		}
		ActionContext.getContext().put("parentId", parentId);
		return "updateUI";
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	public String update() {
		// 1. 获取需要更新的对象
		Department department = departmentService.getById(model.getId());
		// 2. 获取用户选择的上级对象
		Department parent = departmentService.getById(parentId);
		// 3. 设置更新对象的值
		department.setParent(parent);
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		// 4. 执行更新
		departmentService.update(department);
//		Department parent = departmentService.getById(parentId);
//		model.setParent(parent);
//		departmentService.update(model);
		// 5. 因为更新完后，要跳转到上级id为parentId的列表页面，所以通过Action转发的时候，带着parentId参数到list方法。
		ActionContext.getContext().put("parentId", parentId);
		return "toList";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		departmentService.delete(model.getId());
		return "toList";
	}

	/**
	 * 获取顶级的部门列表
	 * 
	 * @return
	 */
	public String list() {
		List<Department> departmentList = null;
		// 1. 判断上级id是否为null，如果为null，那么就查询出顶级部门；如果不是，那么就查询出相应的上级Id等于parentId的下级部门
		if (parentId == null) {
			departmentList = departmentService.getTopList();// 查询出顶级部门
		} else {
			// 查询出相应的上级Id等于parentId的下级部门
			departmentList = departmentService.getChildren(parentId);
			// 根据传进来的parentId来查询对应的上级部门对象
			Department parent = departmentService.getById(parentId);
			// 保存上级部门对象，作用：提供给页面用来获取parentId
			ActionContext.getContext().put("parent", parent);
		}
		// 2. 保存下级部门列表
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/* get() set() */
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
