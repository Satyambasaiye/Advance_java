package dao;
import static utils.HibernateUtils.*;


import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Employee;


public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String insertEmployee(Employee employee) {
		String msg="failed to insert";
		Session session=getFactory().openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.save(employee);
			tx.commit();
			
		}
		
		
		
	}

}
