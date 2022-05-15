package com.example.demo.Service;

import com.example.demo.Dtos.DemoDtos;
import com.example.demo.Entity.DemoEntity;
import com.example.demo.Repositorio.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DemoService {
    @Autowired
    private DemoRepository demoRep;

    public List findAll(){
        List<DemoDtos> toret = new ArrayList<>();
        List<DemoEntity> demoList = demoRep.findTuples();
        Iterator<DemoEntity> ListIt = demoList.iterator();

        while (ListIt.hasNext()){
            DemoEntity ent = ListIt.next();
            DemoDtos aux = new DemoDtos(ent.getId(), ent.getNombre());
            toret.add(aux);
        }
        return toret;


    }
    public Optional save(DemoEntity demo){
        DemoDtos dto = new DemoDtos(demo.getId(), demo.getNombre());
        demoRep.save(new DemoEntity(null, demo.getNombre()));
        return Optional.of(dto);
    }

    public boolean deleteById(Integer id){
        boolean toret = false;
        if(!findTuplaById(id).isEmpty()){
            demoRep.deleteById(id);
            toret = true;

        }
        return  toret;
    }

    private List findTuplaById(Integer id) {
        List<DemoDtos> toret = new ArrayList<>();
        List<DemoEntity> demoList = demoRep.findTuplaById(id);
        Iterator<DemoEntity> ListIt = demoList.iterator();

        while (ListIt.hasNext()){
            DemoEntity ent = ListIt.next();
            DemoDtos aux = new DemoDtos(ent.getId(), ent.getNombre());
            toret.add(aux);
        }
        return toret;

    }

}
