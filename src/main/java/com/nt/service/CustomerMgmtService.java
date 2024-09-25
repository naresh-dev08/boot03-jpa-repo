package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Service("custService")
public class CustomerMgmtService implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;
	
	
	@Override
	public String deleteCustomersByIds(List<Integer> ids) {
		List<Customer> list = custRepo.findAllById(ids);
		if (list.size() != 0) {
			custRepo.deleteAllByIdInBatch(ids);
			return list.size()+" No of records are deleted";
		} else
		return "No records are found for deletion";
	}


	@Override
	public Customer getCustomerById(int id) {
		// Customer cust = custRepo.getById(id);        //Deprecated
		// Customer custObj = custRepo.getOne(id);  //Deprecated
		
		 Customer customer = custRepo.getReferenceById(id);
		return customer;
	}


	@Override
	public List<Customer> showCustomersByExampleData(Customer cust, boolean ascOrder, String... properties) {
		//prepare Example obj having customer obj
		Example<Customer> example = Example.of(cust);
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC ,properties);
		List<Customer> list = custRepo.findAll(example, sort);
		return list;
	}


	@Override
	public String groupCustomerRegistrations(List<Customer> list) {
		custRepo.saveAllAndFlush(list);
		return list.size()+" No. of records are saved";
	}

}
