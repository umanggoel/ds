import models.Branch;
import models.FlipKar;
import models.Vehicle;
import models.VehicleType;
import service.BookingService;
import service.FlipKarManager;

public class MainApp {

	public static void main(String[] args) {
		FlipKar k = new FlipKar();
		Branch b = new Branch();
		b.setName("Delhi");
		b.setBranchId(1);
		
		Vehicle v = new Vehicle();
		v.setType(VehicleType.SUV);
		v.buildVehicle(10, 12, 45);
		
		Vehicle v1 = new Vehicle();
		v1.setType(VehicleType.BIKE);
		v1.buildVehicle(10, 12, 5);
		
		FlipKarManager m = new FlipKarManager();
		m.addBranch(k, b);
		m.addVehicle(k, 1, v);
		m.addVehicle(k, 1, v1);

		b = new Branch();
		b.setName("Bangalore");
		b.setBranchId(2);
		
		v = new Vehicle();
		v.setType(VehicleType.SUV);
		v.buildVehicle(10, 12, 5);
		
		v1 = new Vehicle();
		v1.setType(VehicleType.BIKE);
		v1.buildVehicle(10, 12, 2);
		
		m.addBranch(k, b);
		m.addVehicle(k, 2, v);
		m.addVehicle(k, 2, v1);
		
		BookingService s = new BookingService();
		s.printAvailability(k, 10, 12);
		s.bookVehicle(k, VehicleType.SUV, 11, 12);
	}
}
