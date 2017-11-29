
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fin.business.models.Employee;
import com.fin.business.service.EmployeeService;
import com.fin.dataSource.dao.EmployeeDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
@TransactionConfiguration
@Transactional
public class EmployeeTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	EmployeeDAO emplD;
	
	@Test
	public void test() {
		Employee emp = new Employee();
		emp.setEmployeeName("Man2");
		emp.setEmployeePNC(1234567890201l);
		emp.setUsername("manager2");
		emp.setPassword("manager");
		emp.setRole("ROLE_USER");
		emplD.add(emp);
		System.out.println(emplD.getEmployeeByPNC(1234567890200l).getEmployeeName());
		
	}

}
