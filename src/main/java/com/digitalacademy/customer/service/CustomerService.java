package com.digitalacademy.customer.service;

import com.digitalacademy.customer.model.Customer;
import com.digitalacademy.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    //------------ create--------
/*
    private final List<Customer> getCustomerDemo(){
        List<Customer> customersList = new ArrayList<>();

        Customer customer1 = new Customer("non", "lastname", "non@gmail.com", "084725454", 12);
        Customer customer2 = new Customer("non1", "lastname", "non@gmail.com", "084725454", 12);

        customersList.add(customer1);
        customersList.add(customer2);

        return customersList;
    }

    public List<Customer> getCustomerList(){
        return getCustomerDemo();
    }
*/
//------------update----------//

    public Customer getCustomer(Long id){
        //return getCustomerDemo().get(id);
        return customerRepository.findAllById(id);
    }

    public List<Customer> getCustomerName(String name){
        return customerRepository.findByFirstName(name);
    }


    public Customer createCustomer(Customer body) {
        return customerRepository.save(body) ;
    }

    public Customer updateCustomer(Long id,Customer customerReq){
        return customerRepository.findAllById(id) != null ?
                customerRepository.save(customerReq) : null;
    }

    public boolean deleteById(Long id){
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
