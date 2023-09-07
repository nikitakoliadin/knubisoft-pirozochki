package com.knubisoft.application.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.knubisoft.application.about.About;
import com.knubisoft.application.about.AboutRepository;
import com.knubisoft.application.card.Card;
import com.knubisoft.application.card.CardRepository;
import com.knubisoft.application.faq.Faq;
import com.knubisoft.application.faq.FaqRepository;
import com.knubisoft.application.model.Developer;
import com.knubisoft.application.repository.DeveloperRepository;
import com.knubisoft.application.welcomeText.WelcomeText;
import com.knubisoft.application.welcomeText.WelcomeTextRepository;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@ChangeLog
public class MongoDBInitLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "Vladyslav Kolesnyk")
    public void seedDatabase(DeveloperRepository developerRepository) {
        if (developerRepository.count(Example.of(new Developer())) == 0) {
            List<Developer> developers = new ArrayList<>();
            developers.add(new Developer(1, "Vlad", 22));
            developers.add(new Developer(2, "Nikita", 22));
            developers.add(new Developer(3, "Vadim", 25));
            developerRepository.insert(developers);
        }
    }

    @ChangeSet(order = "002", id = "seedWelcomeText", author = "Vladyslav Kolesnyk")
    public void seedWelcomeText(WelcomeTextRepository welcomeTextRepository) {
        if (welcomeTextRepository.count(Example.of(new WelcomeText())) == 0) {
            List<WelcomeText> welcomeTextList = new ArrayList<>();
            welcomeTextList.add(new WelcomeText(1L, "Step into the world of Futurama, where the future is" +
                    " wilder than you could have ever imagined! Join Fry, Leela, and Bender on their absurd" +
                    " adventures around the universe."));
            welcomeTextList.add(new WelcomeText(2L, "This fan site celebrates the hilarity, complexity," +
                    " and genius of Futurama. Discover episode guides, character profiles, and exclusive content. " +
                    "It’s everything you need to fuel your love for this animated classic."));
            welcomeTextList.add(new WelcomeText(3L, "So buckle up, because it’s time to blast off into the" +
                    " bizarre and hilarious universe of Futurama! You won’t believe what lies ahead on this totally " +
                    "tubular trip through the year 3000 and beyond."));
            welcomeTextRepository.insert(welcomeTextList);
        }
    }

    @SneakyThrows
    @ChangeSet(order = "003", id = "seedAbout", author = "Vadym Kostenko")
    public void seedAbout(final AboutRepository aboutRepository) {
        if (aboutRepository.count(Example.of(new About())) == 0) {
            List<About> abouts = new ArrayList<>();
            abouts.add(new About(1L, "Vadym", "Kostenko", "27 September",
                    "v.kostenko@knubisoft.com", "+380663396268", encodeImageToBase64("/vadym.jpeg")));
            abouts.add(new About(2L, "Vladyslav", "Kolesnyk", "20 February'",
                    "v.kolesnyk@knubisoft.com", "+380635922372", encodeImageToBase64("/vlad.jpeg")));
            abouts.add(new About(3L, "Nikita", "Shumsky", "9 January",
                    "n.shumsky@knubisoft.com", "+380633036736", encodeImageToBase64("/nikita.jpeg")));
            abouts.add(new About(4L, "Nikita", "Koliadin", "11 January",
                    "n.koliadin@knubisoft.com", "+380951114332", encodeImageToBase64("/mentor.png")));
            aboutRepository.insert(abouts);
        }
    }

    @ChangeSet(order = "004", id = "seedFaq", author = "Nikita Shumsky")
    public void seedFaq(FaqRepository faqRepository) {
        if (faqRepository.count(Example.of(new Faq())) == 0) {
            List<Faq> faqList = new ArrayList<>();
            faqList.add(new Faq(1L, "What year does Futurama take place?",
                    "Futurama primarily takes place in the year 3000, but expect lots of time-travel shenanigans!"));
            faqList.add(new Faq(2L, "Who created Futurama?",
                    "Futurama was created by Matt Groening, the mastermind behind The Simpsons."));
            faqList.add(new Faq(3L, "Is the Hypnotoad real?",
                    "No, the Hypnotoad is a fictional character from the show—but do not underestimate its power!"));
            faqRepository.insert(faqList);
        }
    }

    @SneakyThrows
    @ChangeSet(order = "005", id = "seedCard", author = "Nikita Shumsky")
    public void seedCard(CardRepository cardRepository) {
        if (cardRepository.count(Example.of(new Card())) == 0) {
            List<Card> cardList = new ArrayList<>();
            String logoBase64 = encodeImageToBase64("/logo.svg");
            String imgBase64 = encodeImageToBase64("/img.svg");
            cardList.add(new Card(1L, "Phillip J. Fly",
                    "Futurama is the space-faring comedy I didn’t know I needed in my life!", imgBase64));
            cardList.add(new Card(2L, "Turanga Leela",
                    "I laugh, I cry, I kick alien butt—Futurama has it all!", logoBase64));
            cardList.add(new Card(3L, "Phillip J. Flys",
                    "Futurama is the space-faring comedy I didn’t know I needed in my life!", imgBase64));
            cardList.add(new Card(4L, "Turanga Leelaq",
                    "I laugh, I cry, I kick alien butt—Futurama has it all!", logoBase64));
            cardRepository.insert(cardList);
        }
    }

    private String encodeImageToBase64(final String imagePath) throws IOException {
        String imagesResourcePath = new ClassPathResource("images").getFile().getAbsolutePath();
        byte[] imageBytes = Files.readAllBytes(new File(imagesResourcePath + imagePath).toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
