package yamanda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yamanda.mapper.BaseDictMapper;
import yamanda.mapper.CustomerMapper;
import yamanda.pojo.BaseDict;
import yamanda.pojo.Customer;
@Service

public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictMapper baseDictMapper;

	
	public List<BaseDict> selectBaseDictListByCode(String code) {
		
		return baseDictMapper.selectBaseDictListByCode(code);
	}
	

}
