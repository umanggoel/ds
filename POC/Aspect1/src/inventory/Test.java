package inventory;

public class Test {

	public static void main(String[] args) {
		InventoryService is = (InventoryService)AuditProxy.newInstance(new DefaultInventoryServiceImpl());
		is.create(new Inventory());
	}
}
