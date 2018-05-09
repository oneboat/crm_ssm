package yamanda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 客户管理
 * @author ymdhi
 *
 */

import yamanda.common.utils.Page;
import yamanda.mapper.CustomerMapper;
import yamanda.pojo.Customer;
import yamanda.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	//通过条件查询分页对象
	public Page<Customer> selectPage(QueryVo qv){
		
		Page<Customer> page = new Page<Customer>();
		page.setPage(qv.getPage());   //默认当前页为1
		
		qv.setSize(3);  //默认页面数量为10
		page.setSize(10);
		
		if(null!=qv){
			if(null!=qv.getPage()){
				page.setPage(qv.getPage());
				qv.setStart((qv.getPage()-1)*page.getSize());
			}
			if(null!=qv.getCustName()&&!"".equals(qv.getCustName().trim())){
				qv.setCustName(qv.getCustName().trim());
			}
			if(null!=qv.getCustSource()&&!"".equals(qv.getCustSource().trim())){
				qv.setCustSource(qv.getCustSource().trim());
			}
			if(null!=qv.getCustIndustry()&&!"".equals(qv.getCustIndustry().trim())){
				qv.setCustIndustry(qv.getCustIndustry().trim());
			}
			if(null!=qv.getCustLevel()&&!"".equals(qv.getCustLevel().trim())){
				qv.setCustLevel(qv.getCustLevel().trim());
			}
			
		}
		
		
		List<Customer> customerList = customerMapper.selectPage(qv);
		page.setRows(customerList);
		page.setTotal(customerMapper.countByQueryVo(qv));   //设置总的记录数
		
		
		
		return page;
	}
	//通过id查询客户信息
	public Customer selectById(Integer id){
		return customerMapper.selectById(id);
	}
	
	public void update(Customer customer) {
		customerMapper.update(customer);
		
	}
	@Override
	public void deleteById(Integer id) {
		customerMapper.deleteById(id);
		
	}
}
