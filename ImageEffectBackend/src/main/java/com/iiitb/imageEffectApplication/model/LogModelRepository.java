package com.iiitb.imageEffectApplication.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogModelRepository extends JpaRepository<LogModel, Long> {
    public List<LogModel> getLogModelByEffectName(String effect);



}
