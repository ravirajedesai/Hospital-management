package com.college_student.company_selection.repo;

import com.college_student.company_selection.entity.CompanySelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<CompanySelection,Long> {
}
