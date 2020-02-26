package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
