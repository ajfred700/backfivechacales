package com.bezkoder.springjwt.controllers;
import com.bezkoder.springjwt.models.Board;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.BoardRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Gustavo A.
 */


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    BoardRepository boardRepository;
    
    @PostMapping()
    public ResponseEntity<MessageResponse> post(@Valid @RequestBody Board board) {
        String message = "";
        try {
            boardRepository.save(board);

          message = "Saved";
          return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
          message = "Error";
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }
    @GetMapping()
    public ResponseEntity<List<Board>> get() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(boardRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Board> getById(@PathVariable Integer id) {
        try {   
            return ResponseEntity.status(HttpStatus.OK).body(boardRepository.findById(id).get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        try {
            Board board = boardRepository.findById(id).get();
            boardRepository.delete(board);
            return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
