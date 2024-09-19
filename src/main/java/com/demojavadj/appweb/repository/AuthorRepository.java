package com.demojavadj.appweb.repository;

import com.demojavadj.appweb.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
