package com.mockst.mocking;

import com.alibaba.fastjson.JSONObject;
import com.mockst.mocking.model.repository.InterfacePropertyDTO;
import com.mockst.mocking.module.repository.entity.RepositoryInterfacePropertyEntity;
import com.mockst.mocking.module.repository.service.RepositoryInterfacePropertyService;
import com.mockst.mocking.module.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockingApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private RepositoryInterfacePropertyService repositoryInterfacePropertyService;

	@Test
	public void prettyJson(){
		List<InterfacePropertyDTO> propertyDTOList = repositoryInterfacePropertyService.findProperiesByInterfaceId("283");

		List<InterfacePropertyDTO> request = propertyDTOList.stream().filter(s->"request".equals(s.getScope())).collect(Collectors.toList());
		List<InterfacePropertyDTO> response = propertyDTOList.stream().filter(s->"response".equals(s.getScope())).collect(Collectors.toList());

		List<InterfacePropertyDTO> requestlist = new ArrayList<>();
		request.stream().filter(s->"".equals(s.getParentId())).forEach(s->{
			s.setDepth(0);
			buildList(s,request,requestlist);
		});
		for(int i=0;i<requestlist.size();i++){
			InterfacePropertyDTO ip = requestlist.get(i);
			RepositoryInterfacePropertyEntity propertyEntity = new RepositoryInterfacePropertyEntity();
			propertyEntity.setId(ip.getId());
			propertyEntity.setSort(i+1);
			repositoryInterfacePropertyService.updateSelective(propertyEntity);
		}
		List<InterfacePropertyDTO> responselist = new ArrayList<>();
		response.stream().filter(s->"".equals(s.getParentId())).forEach(s->{
			s.setDepth(0);
			buildList(s,response,responselist);
		});
		for(int i=0;i<responselist.size();i++){
			InterfacePropertyDTO ip = responselist.get(i);
			RepositoryInterfacePropertyEntity propertyEntity = new RepositoryInterfacePropertyEntity();
			propertyEntity.setId(ip.getId());
			propertyEntity.setSort(i+1);
			repositoryInterfacePropertyService.updateSelective(propertyEntity);
		}
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
}
