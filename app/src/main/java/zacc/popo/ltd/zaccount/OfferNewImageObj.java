package zacc.popo.ltd.zaccount;

public class OfferNewImageObj {
   private String photoUrl;
   private String imageNo;

    public OfferNewImageObj() {
    }

    public OfferNewImageObj(String photoUrl, String imageNo) {
        this.photoUrl = photoUrl;
        this.imageNo = imageNo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getImageNo() {
        return imageNo;
    }
}
