package zacc.popo.ltd.zaccount;

public class BankServicesHObj {
   private int resourceIds;
   private String name;

    public BankServicesHObj(int resourceIds, String name) {
        this.resourceIds = resourceIds;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getResourceIds() {
        return resourceIds;
    }
}
