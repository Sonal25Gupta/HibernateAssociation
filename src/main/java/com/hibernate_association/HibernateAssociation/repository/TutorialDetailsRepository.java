package com.hibernate_association.HibernateAssociation.repository;

import com.hibernate_association.HibernateAssociation.model.TutorialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {

}
