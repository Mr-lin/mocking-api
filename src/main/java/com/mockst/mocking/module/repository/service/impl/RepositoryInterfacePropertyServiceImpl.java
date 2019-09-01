package com.mockst.mocking.module.repository.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.esnotary.framework.service.impl.BaseServiceImpl;
import com.mockst.mocking.constant.Constant;
import com.mockst.mocking.model.repository.InterfacePropertyDTO;
import com.mockst.mocking.model.repository.OutInterfaceDTO;
import com.mockst.mocking.module.repository.dao.RepositoryInterfacePropertyDao;
import com.mockst.mocking.module.repository.entity.RepositoryInterfaceEntity;
import com.mockst.mocking.module.repository.entity.RepositoryInterfacePropertyEntity;
import com.mockst.mocking.module.repository.service.RepositoryInterfacePropertyService;
import com.mockst.mocking.module.repository.service.RepositoryInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
//Import Package End
/**
 * repository接口参数
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Service("repositoryInterfacePropertyService")
public class RepositoryInterfacePropertyServiceImpl extends BaseServiceImpl<RepositoryInterfacePropertyEntity> implements RepositoryInterfacePropertyService {
	@Autowired
	private RepositoryInterfacePropertyDao repositoryInterfacePropertyDao;

	//Custom Generate Code Start

	@Autowired
	private RepositoryInterfaceService repositoryInterfaceService;

	@Override
	@Transactional
	public void updateProperty(String interfaceId, List<RepositoryInterfacePropertyEntity> properties) {
		//删除旧的
		Example example = new Example(RepositoryInterfacePropertyEntity.class);
		example.createCriteria()
				.andEqualTo("interfaceId",interfaceId)
				.andEqualTo("isDelete", Constant.IS_NOT_DELETE);
		RepositoryInterfacePropertyEntity query = new RepositoryInterfacePropertyEntity();
		query.setIsDelete(Constant.IS_DELETE);
		query.setDeleteTime(new Date());
		updateByExampleSelective(query,example);
		if(!properties.isEmpty()){
			for (RepositoryInterfacePropertyEntity property:properties){
				update(property);
			}
		}
	}

	@Override
	public List<InterfacePropertyDTO> findProperiesByInterfaceId(String interfaceId) {
		return repositoryInterfacePropertyDao.findProperiesByInterfaceId(interfaceId);
	}

	@Override
	public OutInterfaceDTO findByInterfaceId(String interfaceId) {
		RepositoryInterfaceEntity repositoryInterface = repositoryInterfaceService.selectByKey(interfaceId);
		OutInterfaceDTO dto = new OutInterfaceDTO();
		dto.setInterfaceName(repositoryInterface.getInterfaceName());
		dto.setUrl(repositoryInterface.getUrl());
		dto.setDescription(repositoryInterface.getDescription());
		//todo 构建模拟数
//		String json ="{ \"name\": \"zhangsan\", \"age\": 18 ,\"code\":\"100001\"}";
//		JSONObject jsonObject = null;
//		try {
//			jsonObject = JSONObject.parseObject(json);
//		}catch (Exception e){
//		}
		String responseExample = JSONObject.toJSONString(new JSONObject(),true);
		dto.setResponseExample(responseExample);

		List<InterfacePropertyDTO> list = findProperiesByInterfaceId(interfaceId);
		List<InterfacePropertyDTO> request = list.stream().filter(s->"request".equals(s.getScope())).collect(Collectors.toList());
		List<InterfacePropertyDTO> response = list.stream().filter(s->"response".equals(s.getScope())).collect(Collectors.toList());
		List<InterfacePropertyDTO> requestlist = new ArrayList<>();
		request.stream().filter(s->"".equals(s.getParentId())).forEach(s->{
			s.setDepth(0);
			buildList(s,request,requestlist);
		});
		List<InterfacePropertyDTO> responselist = new ArrayList<>();
		response.stream().filter(s->"".equals(s.getParentId())).forEach(s->{
			s.setDepth(0);
			buildList(s,response,responselist);
		});
		dto.setRequestProperties(requestlist);
		dto.setResponseProperties(responselist);
		return dto;
	}

	private void buildList(InterfacePropertyDTO p,List<InterfacePropertyDTO> tag,List<InterfacePropertyDTO> newTag){
		List<InterfacePropertyDTO> list =
				tag.stream().filter(s->p.getId().equals(s.getParentId())).collect(Collectors.toList());
		newTag.add(p);
		for (InterfacePropertyDTO pp:list){
			pp.setDepth(p.getDepth()+1);
			buildList(pp,tag,newTag);
		}
	}

	//Custom Generate Code End
}
