/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo A.
 */
@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer>{
    
}
