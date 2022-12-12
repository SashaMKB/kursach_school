package com.reboticaSchool.School.Manager.repo;

import com.reboticaSchool.School.Manager.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
