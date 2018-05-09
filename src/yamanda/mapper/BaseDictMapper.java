package yamanda.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yamanda.pojo.BaseDict;
import yamanda.pojo.BaseDictExample;

public interface BaseDictMapper {
   //查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}