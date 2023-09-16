package com.knubisoft.application.about;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;

    @Override
    public List<About> findAll() {
        return aboutRepository.findAll();
    }
}
