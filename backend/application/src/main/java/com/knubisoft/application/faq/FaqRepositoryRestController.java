package com.knubisoft.application.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FaqRepositoryRestController {

    private final DefaultFaqService defaultFaqService;

    @Autowired
    public FaqRepositoryRestController(final DefaultFaqService defaultFaqService) {
        this.defaultFaqService = defaultFaqService;
    }

    @GetMapping("/faq")
    public @ResponseBody List<Faq> faqList() {
        return defaultFaqService.getFaq();
    }
}
