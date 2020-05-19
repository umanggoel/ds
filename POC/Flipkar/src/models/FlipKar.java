package models;

import java.util.HashMap;
import java.util.Map;

public class FlipKar {

	private Map<Integer,Branch> branches = new HashMap<>();
	
	public void addBranch(Branch b) {
		branches.put(b.getBranchId(), b);
	}
	
	public Branch getBranch(int id) {
		return branches.get(id);
	}

	public Map<Integer, Branch> getBranches() {
		return branches;
	}

	public void setBranches(Map<Integer, Branch> branches) {
		this.branches = branches;
	}
	
}
