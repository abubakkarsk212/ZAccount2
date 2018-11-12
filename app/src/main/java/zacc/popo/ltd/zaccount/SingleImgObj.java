package zacc.popo.ltd.zaccount;

public class SingleImgObj {
    private String picsUrl;
    private String imgNo;
    public SingleImgObj(){
    }public SingleImgObj(String picsUrl, String imgNo) {
        this.picsUrl = picsUrl;
        this.imgNo = imgNo; }
    public String getImgNo() {
        return imgNo;
    }public String getPicsUrl() {
        return picsUrl;
    }
}
