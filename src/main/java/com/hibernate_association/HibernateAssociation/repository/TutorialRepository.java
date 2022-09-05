package com.hibernate_association.HibernateAssociation.repository;

import com.hibernate_association.HibernateAssociation.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
