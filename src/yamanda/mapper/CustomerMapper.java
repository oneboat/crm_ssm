package yamanda.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yamanda.pojo.Customer;
import yamanda.pojo.CustomerExample;
import yamanda.pojo.QueryVo;

public interface CustomerMapper {
	//通过条件查询获取用户列表
    public List<Customer> selectPage(QueryVo qv);
    
    //查询总的记录数
    public Integer countByQueryVo(QueryVo qv);
   
    
    //通过id查询客户
    public Customer selectById(Integer id);
    //修改客户
    public void update(Customer customer);
    
    //通过id删除客户
    public void deleteById(Integer id);
}