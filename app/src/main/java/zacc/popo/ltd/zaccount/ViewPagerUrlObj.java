package zacc.popo.ltd.zaccount;

public class ViewPagerUrlObj {
    private String url;
    private String type;
    private String bankid;
    private String channelid;
    private String flag;


    public ViewPagerUrlObj() {
    }

    public ViewPagerUrlObj(String url, String type, String bankid, String channelid, String flag) {
        this.url = url;
        this.type = type;
        this.bankid = bankid;
        this.channelid = channelid;
        this.flag = flag;
    }

    public String getUrl() {
        return url;
    }

    public String getBankid() {
        return bankid;
    }

    public String getChannelid() {
        return channelid;
    }

    public String getType() {
        return type;
    }

    public String getFlag() {
        return flag;
    }
}



