package com.example.spring_base.Annotation_MVC.repository;

import com.example.spring_base.Annotation_MVC.entitiy.Ex_Entity_List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ex_List_Repository extends JpaRepository<Ex_Entity_List, Long> {
}
