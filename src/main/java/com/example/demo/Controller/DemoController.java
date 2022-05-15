package com.example.demo.Controller;

import com.example.demo.Dtos.DemoDtos;
import com.example.demo.Entity.DemoEntity;
import com.example.demo.Service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Demo/")
public class DemoController {
    @Autowired
    public DemoService demoService;

    @GetMapping("getDemoTuplas")
    ResponseEntity getTuplas(){
        List toret = demoService.findAll();
        if (toret.size() !=0)
            return new ResponseEntity(toret, HttpStatus.OK);
        else
            return new ResponseEntity("No hay tuplas en la base de datos", HttpStatus.NOT_FOUND);


    }
    @PostMapping("setDemo/Tuplas")
    ResponseEntity createTuplas(@RequestBody DemoEntity demo){
        if(demoService.save(demo).isPresent()){
            DemoDtos dtos = new DemoDtos(demo.getId(), demo.getNombre());
            return new ResponseEntity(dtos, HttpStatus.OK);
        }else{
            return new ResponseEntity("Error", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("deleteTupla/Id/{id}")
    ResponseEntity deleteTupla(@PathVariable("id")Integer id) throws Exception{
        if(demoService.deleteById(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
