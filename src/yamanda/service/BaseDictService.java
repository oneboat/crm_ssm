package yamanda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import yamanda.pojo.BaseDict;
import yamanda.pojo.Customer;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictListByCode(String code);
}
