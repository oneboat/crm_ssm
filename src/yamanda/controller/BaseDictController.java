package yamanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yamanda.common.utils.Page;
import yamanda.pojo.BaseDict;
import yamanda.pojo.Customer;
import yamanda.pojo.QueryVo;
import yamanda.service.BaseDictService;
import yamanda.service.BaseDictServiceImpl;
import yamanda.service.CustomerService;

/**
 * 客户管理
 * @author ymdhi
 *
 */
@Controller
public class BaseDictController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	
	@Value("${fromTypeCode}")      //用配置文件注入属性的方式解决硬编码问题
	//配置文件注入在springmvc.xml中
	private String fromTypeCode;
	
	
	@RequestMapping("/customer/list.action")
	public String list(QueryVo qv,Model model){
		
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType", levelType);
		
		model.addAttribute("fromType", fromType);    //客户信息来源
		
		Page<Customer> page = customerService.selectPage(qv);
		
		
		//回显，无法使用值栈，只能用model一个一个往回设置显示
		/*private String custName;   //客户名称
		private String custSource;   //客户来源
		private String custIndustry;  //客户行业
		private String custLevel;  //客户级别
*/		
		
		model.addAttribute("custName", qv.getCustName());
		model.addAttribute("custSource", qv.getCustSource());
		model.addAttribute("custIndustry", qv.getCustIndustry());
		model.addAttribute("custLevel", qv.getCustLevel());
		
		
		model.addAttribute("page", page);
		return "customer";
		
		
		
	}
	
	//弹出修改页面
	@RequestMapping("customer/edit.action")
	public @ResponseBody Customer toEditPage(Integer id){     //ajax返回值为void
		return customerService.selectById(id);
		
	}
	
	//保存修改
	@RequestMapping("customer/update.action")
	public @ResponseBody String update(Customer customer){
		
		customerService.update(customer);
		return "OK";      //回复“ok”，页面才会认识！！！！！！！function（data）中接收到的data是ok之后，才会继续向下执行
	}
	
	//删除客户
	@RequestMapping("customer/delete.action")
	public @ResponseBody String deleteById(Integer id){
		
		customerService.deleteById(id);
		return "OK";
	}
	
	
}
