package cn.com.vcloud.test.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.vcloud.core.service.AbstractService;
import cn.com.vcloud.test.model.entity.SysTest;
import cn.com.vcloud.test.service.TestService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl extends AbstractService<SysTest> implements TestService{
	

}
