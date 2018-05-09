package yamanda.service;

import yamanda.common.utils.Page;
import yamanda.pojo.Customer;
import yamanda.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPage(QueryVo qv);
	public Customer selectById(Integer id);
	 //修改客户
    public void update(Customer customer);
    
  //通过id删除客户
    public void deleteById(Integer id);
}
