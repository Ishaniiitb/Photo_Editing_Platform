package com.iiitb.imageEffectApplication.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//Interface to declare functions to fetch rows based on a particular filter condition from the JDBC h2 database
public interface LogModelRepository extends JpaRepository<LogModel, Long> {
    public List<LogModel> getLogModelByEffectName(String effect);



}
