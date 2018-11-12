package zacc.popo.ltd.zaccount;

public class OfferProgressObj {
   private String photoUrl;
   private String pageNo;

    public OfferProgressObj() {
    }

    public OfferProgressObj(String photoUrl, String pageNo) {
        this.photoUrl = photoUrl;
        this.pageNo = pageNo;

    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPageNo() {
        return pageNo;
    }
}
