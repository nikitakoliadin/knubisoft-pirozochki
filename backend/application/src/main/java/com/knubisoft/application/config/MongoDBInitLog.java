package com.knubisoft.application.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.knubisoft.application.model.Developer;
import com.knubisoft.application.repository.DeveloperRepository;
import com.knubisoft.application.welcomeText.WelcomeText;
import com.knubisoft.application.welcomeText.WelcomeTextRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class MongoDBInitLog {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Vladyslav Kolesnyk")
    public void seedDatabase(DeveloperRepository developerRepository) {
        if (developerRepository.count() == 0) {
            List<Developer> developers = new ArrayList<>();
            developers.add(new Developer(1, "Vlad", 22));
            developers.add(new Developer(2, "Nikita", 22));
            developers.add(new Developer(3, "Vadim", 25));
            developerRepository.insert(developers);
        }
    }

    @ChangeSet(order = "002", id = "seedWelcomeText", author = "Vladyslav Kolesnyk")
    public void seedWelcomeText(WelcomeTextRepository welcomeTextRepository) {
        if (welcomeTextRepository.count() == 0) {
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
}
