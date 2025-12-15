package com.buscuitShop.biscuit_service.service;

import com.buscuitShop.biscuit_service.entity.Biscuit;
import com.buscuitShop.biscuit_service.exception.BiscuitNotFound;
import com.buscuitShop.biscuit_service.repository.BiscuitRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BiscuitServiceImpl implements BiscuitService{

    @Autowired
    BiscuitRepo repo;

    @Override
    public Page<Biscuit> getAllBiscuit(int pageNo
                                      ,int pageSize
                                      ,String sortBy
                                      ,String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("DESC")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        return repo.findAll(pageRequest);
    }
    @Override
    public Biscuit getBiscuitById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->
                        new BiscuitNotFound("Biscuit Not Found with this Id: "+id));
    }
    @Override
    public void deleteBiscuitById(Long id) {
        repo.deleteById(id);
    }
    @Override
    public Biscuit addBiscuits(Biscuit biscuit) {
        return repo.save(biscuit);
    }
    @Transactional
    @Override
    public Biscuit updateBiscuit(Long id, Biscuit biscuit) {
        Biscuit getBiscuit=repo.findById(id)
                .orElseThrow(()->
                        new BiscuitNotFound("Biscuit Not Found With This Id: "+id));
        getBiscuit.setBiscuitName(biscuit.getBiscuitName());
        getBiscuit.setBiscuitType(biscuit.getBiscuitType());
        getBiscuit.setRate(biscuit.getRate());
        getBiscuit.setStock(biscuit.getStock());

        return repo.save(getBiscuit);
    }
    @Override
    public Biscuit getBiscuitByName(String name) {
        return repo.findByBiscuitName(name)
                .orElseThrow(()->new RuntimeException("Biscuit Not Found.."));
    }
    @Override
    @Transactional
    public Biscuit reduceBiscuitStock(Long biscuitId, Long quantity) {

        Biscuit biscuit=repo.findById(biscuitId)
                .orElseThrow(()-> new BiscuitNotFound("Not Found.."));

        if(biscuit.getStock() < quantity){
            throw new BiscuitNotFound("Insufficient Stock..");
        }
        biscuit.setStock(biscuit.getStock()-quantity);

        return repo.save(biscuit);
    }
}
