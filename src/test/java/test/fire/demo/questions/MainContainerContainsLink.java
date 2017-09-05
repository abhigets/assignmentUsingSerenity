package test.fire.demo.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.thucydides.core.annotations.Step;
import test.fire.demo.ui.MainContainer;

public class MainContainerContainsLink implements Question<Boolean> {
    String linkText;

    public MainContainerContainsLink(String linkText) {
        this.linkText = linkText;
    }

    @Override
    @Step("contains link #linkText")
    public Boolean answeredBy(Actor actor) {
        return Presence.of(MainContainer.getHyperlinkLocator(linkText)).viewedBy(actor).asBoolean();
    }
}
