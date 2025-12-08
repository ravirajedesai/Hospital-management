package com.jpa_orm.jpa_orm;

import com.jpa_orm.jpa_orm.entity.Address;
import com.jpa_orm.jpa_orm.entity.Laptop;
import com.jpa_orm.jpa_orm.entity.Student;
import com.jpa_orm.jpa_orm.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class JpaOrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOrmApplication.class, args);

        @Autowired
        StudentRepo repo;


        Student s=new Student();
        s.setStudentId(1);
        s.setStudentName("raj");
        s.setAbout("owner");
        s.getLaptop();

        Laptop l=new Laptop();
        l.setLaptopId(100);
        l.setBrand("HP");
        l.setModelNumber("elitebook");

        s.getStudentId();

        Address a=new Address();
        a.setAddressId(1);
        a.setStreet("ABC");
        a.setCity("pune");
        a.setCountry("IND");
        a.setStudent(s);

        Address b=new Address();
        b.setAddressId(2);
        b.setStreet("baner");
        b.setCity("pune");
        b.setCountry("IND");
        b.setStudent(s);

        List<Address> addressList=new ArrayList<>();
        addressList.add(a);
        addressList.add(b);

        s.setAddressList(addressList);

	}

}
