package com.buscuitShop.biscuit_service.service;

import com.buscuitShop.biscuit_service.entity.Biscuit;
import org.springframework.data.domain.Page;

public interface BiscuitService {
    Page<Biscuit> getAllBiscuit(int pageNo,
                                int pageSize,
                                String sortBy,
                                String sortDir);

    Biscuit getBiscuitById(Long id);
    void deleteBiscuitById(Long id);
    Biscuit addBiscuits(Biscuit biscuit);

    Biscuit updateBiscuit(Long id,Biscuit biscuit);

    Biscuit getBiscuitByName(String name);
    Biscuit reduceBiscuitStock(Long biscuitId,Long quantity);
}
