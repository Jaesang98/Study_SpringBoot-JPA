package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Service : 비즈니스 로직을 담는 클래스
 */


@Service
@RequiredArgsConstructor
public class BasicService {

    private final BasicRepository basicRepository;

    public List<BasicEntity> Service(BasicEntity data) {
        return basicRepository.findAll();
    }
}
