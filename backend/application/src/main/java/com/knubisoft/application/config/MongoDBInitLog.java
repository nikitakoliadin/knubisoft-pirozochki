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
import com.knubisoft.application.welcome_text.WelcomeText;
import com.knubisoft.application.welcome_text.WelcomeTextRepository;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Example;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@ChangeLog
public class MongoDBInitLog {

    private static final int AGE_22 = 22;
    private static final int AGE_25 = 25;
    private static final int ID_3 = 3;
    private static final long ID_LONG_3 = 3L;
    private static final long ID_LONG_4 = 4L;
    private static final String LOGO_BASE_64 = encodeImageToBase64("/logo.svg");
    private static final String IMG_BASE_64 = encodeImageToBase64("/img.svg");
    private static final String NIKITA = "Nikita";
    private static final String VLADYSLAV = "Vladyslav";
    private static final String VADIM = "Vadim";

    @ChangeSet(order = "001", id = "seedDatabase", author = "Vladyslav Kolesnyk")
    public void seedDatabase(final DeveloperRepository developerRepository) {
        if (developerRepository.count(Example.of(new Developer())) == 0) {
            List<Developer> developers = new ArrayList<>();
            developers.add(new Developer(1, VLADYSLAV, AGE_22));
            developers.add(new Developer(2, NIKITA, AGE_22));
            developers.add(new Developer(ID_3, VADIM, AGE_25));
            developerRepository.insert(developers);
        }
    }

    @ChangeSet(order = "002", id = "seedWelcomeText", author = "Vladyslav Kolesnyk")
    public void seedWelcomeText(final WelcomeTextRepository welcomeTextRepository) {
        if (welcomeTextRepository.count(Example.of(new WelcomeText())) == 0) {
            List<WelcomeText> welcomeTextList = new ArrayList<>();
            welcomeTextList.add(new WelcomeText(1L, "Step into the world of Futurama, where the future is"
                    + " wilder than you could have ever imagined! Join Fry, Leela, and Bender on their absurd"
                    + " adventures around the universe."));
            welcomeTextList.add(new WelcomeText(2L, "This fan site celebrates the hilarity, complexity,"
                    + " and genius of Futurama. Discover episode guides, character profiles, and exclusive content. "
                    + "It’s everything you need to fuel your love for this animated classic."));
            welcomeTextList.add(new WelcomeText(ID_LONG_3, "So buckle up, because it’s time to blast off into the"
                    + " bizarre and hilarious universe of Futurama! You won’t believe what lies ahead on this totally "
                    + "tubular trip through the year 3000 and beyond."));
            welcomeTextRepository.insert(welcomeTextList);
        }
    }

    @SneakyThrows
    @ChangeSet(order = "003", id = "seedAbout", author = "Vadym Kostenko")
    public void seedAbout(final AboutRepository aboutRepository) {
        if (aboutRepository.count(Example.of(new About())) == 0) {
            List<About> abouts = new ArrayList<>();
            abouts.add(new About(1L, VADIM, "Kostenko", "27 September",
                    "v.kostenko@knubisoft.com", "+380663396268", encodeImageToBase64("/vadym.jpeg")));
            abouts.add(new About(2L, VLADYSLAV, "Kolesnyk", "20 February'",
                    "v.kolesnyk@knubisoft.com", "+380635922372", encodeImageToBase64("/vlad.jpeg")));
            abouts.add(new About(ID_LONG_3, NIKITA, "Shumsky", "9 January",
                    "n.shumsky@knubisoft.com", "+380633036736", encodeImageToBase64("/nikita.jpeg")));
            abouts.add(new About(ID_LONG_4, NIKITA, "Koliadin", "11 January",
                    "n.koliadin@knubisoft.com", "+380951114332", encodeImageToBase64("/mentor.png")));
            aboutRepository.insert(abouts);
        }
    }

    @ChangeSet(order = "004", id = "seedFaq", author = "Nikita Shumsky")
    public void seedFaq(final FaqRepository faqRepository) {
        if (faqRepository.count(Example.of(new Faq())) == 0) {
            List<Faq> faqList = new ArrayList<>();
            faqList.add(new Faq(1L, "What year does Futurama take place?",
                    "Futurama primarily takes place in the year 3000, but expect lots of time-travel shenanigans!"));
            faqList.add(new Faq(2L, "Who created Futurama?",
                    "Futurama was created by Matt Groening, the mastermind behind The Simpsons."));
            faqList.add(new Faq(ID_LONG_3, "Is the Hypnotoad real?",
                    "No, the Hypnotoad is a fictional character from the show—but do not underestimate its power!"));
            faqRepository.insert(faqList);
        }
    }

    @SneakyThrows
    @ChangeSet(order = "005", id = "seedCard", author = "Nikita Shumsky")
    public void seedCard(final CardRepository cardRepository) {
        if (cardRepository.count(Example.of(new Card())) == 0) {
            List<Card> cardList = new ArrayList<>();
            cardList.add(new Card(1L, "Phillip J. Fly",
                    "Futurama is the space-faring comedy I didn’t know I needed in my life!", IMG_BASE_64));
            cardList.add(new Card(2L, "Turanga Leela",
                    "I laugh, I cry, I kick alien butt—Futurama has it all!", LOGO_BASE_64));
            cardList.add(new Card(ID_LONG_3, "Phillip J. Flys",
                    "Futurama is the space-faring comedy I didn’t know I needed in my life!", IMG_BASE_64));
            cardList.add(new Card(ID_LONG_4, "Turanga Leelaq",
                    "I laugh, I cry, I kick alien butt—Futurama has it all!", LOGO_BASE_64));
            cardRepository.insert(cardList);
        }
    }

    @SneakyThrows
    private static String encodeImageToBase64(final String imagePath) {
        String imagesResourcePath = new ClassPathResource("images").getFile().getAbsolutePath();
        byte[] imageBytes = Files.readAllBytes(new File(imagesResourcePath + imagePath).toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
