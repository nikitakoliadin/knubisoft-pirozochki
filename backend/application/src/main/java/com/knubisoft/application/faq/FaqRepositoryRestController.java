package com.knubisoft.application.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class FaqRepositoryRestController {

    private final DefaultFaqService defaultFaqService;

    @Autowired
    public FaqRepositoryRestController(DefaultFaqService defaultFaqService) {
        this.defaultFaqService = defaultFaqService;
    }

    @GetMapping("/faq")
    public @ResponseBody List<Faq> faqList() {
        return defaultFaqService.getFaq();
    }
}
