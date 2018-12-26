package net.skhu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Customer;
import net.skhu.domain.Employee;
import net.skhu.domain.Order;
import net.skhu.domain.OrderDetail;
import net.skhu.domain.Product;
import net.skhu.repository.CustomerRepository;
import net.skhu.repository.EmployeeRepository;
import net.skhu.repository.OrderRepository;
import net.skhu.repository.ProductRepository;

@RestController
@RequestMapping("api")
public class APIController {
	@Autowired CustomerRepository customerRepository;
	@Autowired EmployeeRepository employeeRepository;
	@Autowired OrderRepository orderRepository;
	@Autowired ProductRepository productRepository;
	
	@RequestMapping("employees")
	public List<Employee> employees() {
		return employeeRepository.findAll();
	}
	
	@RequestMapping("order/{id}/products")
	public List<Product> detailss(@PathVariable("id") int id) {
		Order orders = orderRepository.findById(id).get();
		List<Product> products = new ArrayList<Product>();
		for(OrderDetail d : orders.getDetails())
			products.add(d.getProduct());
		return products;
	}
	
	@RequestMapping("customers")
	public List<Customer> customers() {
		return customerRepository.findAll();
	}
	
	@RequestMapping("products")
	public List<Product> products() {
		return productRepository.findAll();
	}
	
	@RequestMapping("customer/{id}/orderDate")
	public List<Date> dates(@PathVariable("id") int id) {
		Customer customer = customerRepository.findById(id).get();
		List<Date> date = new ArrayList<Date>();
		for(Order o : customer.getOrders())
			date.add(o.getDate());
		return date;
	}
	
	@RequestMapping("customer/{id}/products")
	public List<Product> productss(@PathVariable("id") int id) {
		Customer customer = customerRepository.findById(id).get();
		//List<Order> orders = customer.getOrders();
		List<Product> products = new ArrayList<Product>();
		for(Order o : customer.getOrders()) 
			for(OrderDetail d : o.getDetails())
				products.add(d.getProduct());
		return products;
	}
}
