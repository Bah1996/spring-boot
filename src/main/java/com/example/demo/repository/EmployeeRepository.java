package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.name =:name and e.lastName=:lastName")
    List<Employee>findAll(@Param("name")String name,
                          @Param("lastName")String lastName);
    List<Employee>findAllByNameAndLastName(String name, String lastName);

    @Query(value = "select * from employee e where e.name=:name", nativeQuery = true)//nativeQuery malumot olish
    List<Employee>getAll(@Param("name")String name);

   List<Employee>findAllByNameStartingWith(String name);
   List<Employee>findAllByNameEndingWith(String name);

    @Query("select e from Employee e where e.name like  :name")
    List<Employee>findAllByNameLikeJPQL(@Param("name") String name);

    @Query(value = "select * from Employee e where e.name like :name",nativeQuery = true)
    List<Employee>findAllByNameLikeNative(@Param("name") String name);
}
