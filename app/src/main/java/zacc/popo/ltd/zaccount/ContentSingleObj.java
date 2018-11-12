package zacc.popo.ltd.zaccount;

public class ContentSingleObj {
    private String topic;
    private String about;
    private String aboutDetails;
    private String feature;
    private String featureDetails;
    private String promotion;
    private String promotionDetails;
    private String extra;
    private String extraDetails;
    private String urlClick;
    private String buttonText;
    public ContentSingleObj(){ }
    public ContentSingleObj(String topic, String about, String aboutDetails, String feature, String featureDetails, String promotion, String promotionDetails, String extra, String extraDetails, String urlClick, String buttonText) {
        this.topic = topic;
        this.about = about;
        this.aboutDetails = aboutDetails;
        this.feature = feature;
        this.featureDetails = featureDetails;
        this.promotion = promotion;
        this.promotionDetails = promotionDetails;
        this.extra = extra;
        this.extraDetails = extraDetails;
        this.urlClick = urlClick;
        this.buttonText = buttonText; }
    public String getTopic() {
        return topic;
    }
    public String getAbout() {
        return about;
    }
    public String getAboutDetails() {
        return aboutDetails;
    }
    public String getFeature() {
        return feature;
    }
    public String getFeatureDetails() {
        return featureDetails;
    }
    public String getPromotion() {
        return promotion;
    }
    public String getPromotionDetails() {
        return promotionDetails;
    }
    public String getExtra() {
        return extra;
    }
    public String getExtraDetails() {
        return extraDetails;
    }
    public String getUrlClick() {
        return urlClick;
    }
    public String getButtonText() {
        return buttonText;
    }
}
