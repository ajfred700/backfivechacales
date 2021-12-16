package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Board;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Gustavo A.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{
    
}
