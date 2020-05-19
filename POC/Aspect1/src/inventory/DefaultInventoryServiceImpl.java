package inventory;

import java.util.ArrayList;
import java.util.List;

public class DefaultInventoryServiceImpl implements InventoryService{
    
    @Override
    public Inventory create(Inventory inventory) {
        inventory.setId(1L);
        return inventory; 
    }

    @Override
    public List<Inventory> list(){
        return new ArrayList<Inventory>();
    }

    @Override
    public Inventory update(Inventory inventory) {
        return inventory;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }

	@Override
	public Inventory findByVin(String vin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory compositeUpdateService(String vin, String newMake) {
		// TODO Auto-generated method stub
		return null;
	}
}