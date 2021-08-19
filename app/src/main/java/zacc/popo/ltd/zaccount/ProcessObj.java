package zacc.popo.ltd.zaccount;

public class ProcessObj {
    private String counter;
    private String steps;
    private String link;
    private String isButton;
    private String isPlayOrLink;
    private String webtitle;
    private String buttontext;


    public ProcessObj() {
    }

    public ProcessObj(String counter, String steps, String link, String isButton, String isPlayOrLink, String webtitle, String buttontext) {
        this.counter = counter;
        this.steps = steps;
        this.link = link;
        this.isButton = isButton;
        this.isPlayOrLink = isPlayOrLink;
        this.webtitle = webtitle;
        this.buttontext = buttontext;
    }

    public String getCounter() {
        return counter;
    }

    public String getLink() {
        return link;
    }

    public String getSteps() {
        return steps;
    }

    public String getIsButton() {
        return isButton;
    }

    public String getIsPlayOrLink() {
        return isPlayOrLink;
    }

    public String getWebtitle() {
        return webtitle;
    }

    public String getButtontext() {
        return buttontext;
    }
}
