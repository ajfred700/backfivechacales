/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bezkoder.springjwt.service;
import com.bezkoder.springjwt.models.Archivo;
import com.bezkoder.springjwt.repository.ArchivoRepository;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Gustavo A.
 */

@Service
public class FileStorageService {
  @Autowired
  private ArchivoRepository fileDBRepository;

  public Archivo store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Archivo FileDB = new Archivo(fileName, file.getContentType(), file.getBytes());

    return fileDBRepository.save(FileDB);
  }

  public Archivo getFile(Integer id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<Archivo> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
