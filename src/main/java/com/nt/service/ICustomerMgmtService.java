package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {
	
	public String deleteCustomersByIds(List<Integer> ids);
	public Customer getCustomerById(int id);
	public List<Customer> showCustomersByExampleData(Customer cust, boolean ascOrder, String ...properties);
	public String groupCustomerRegistrations(List<Customer> list);

}
