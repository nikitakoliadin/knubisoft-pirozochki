package com.knubisoft.application.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFaqService implements FaqService {

    private final FaqRepository faqRepository;

    @Autowired
    public DefaultFaqService(final FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @Override
    public List<Faq> getFaq() {
        return faqRepository.findAll();
    }
}
