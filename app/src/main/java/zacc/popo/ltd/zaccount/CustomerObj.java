package zacc.popo.ltd.zaccount;

public class CustomerObj {
    private int resourceIds;
    private String name;

    public CustomerObj(int resourceIds, String name) {
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
