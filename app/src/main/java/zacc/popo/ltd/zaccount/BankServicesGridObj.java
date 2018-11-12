package zacc.popo.ltd.zaccount;

public class BankServicesGridObj {
    private int resourceIds;
    private String name;

    public BankServicesGridObj(int resourceIds, String name) {
        this.resourceIds = resourceIds;
        this.name = name;
    }

    public int getResourceIds() {
        return resourceIds;
    }

    public String getName() {
        return name;
    }
}
