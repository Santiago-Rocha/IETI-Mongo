package edu.eci.ieti.tablero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;


import java.io.IOException;

@RequestMapping("img")
@RestController
public class RESTController {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @RequestMapping("/files/{filename}")
    public ResponseEntity<InputStreamResource> getFileByName(@PathVariable String filename) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query().addCriteria(Criteria.where("filename").is(filename)));
        if(file ==  null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else{
            GridFsResource resource = gridFsTemplate.getResource(file.getFilename());
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(resource.getContentType()))
                    .body(new InputStreamResource(resource.getInputStream()));
        }

    }
    
}
