package me.demo.service;

import me.demo.DAO.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentServiceRepository extends JpaRepository<StudentDAO, Integer> {
}
