package admin.model;

public class Admin {
	private int adminId;
	private String adminName;
	private int adminAge;
	private String adminAddress;
	private int adminTel;
	
	public Admin(int adminId, String adminName, int adminAge, String adminAddress, int adminTel) {
		super();
		this.setAdminId(adminId);
		this.setAdminName(adminName);
		this.setAdminAge(adminAge);
		this.setAdminAddress(adminAddress);
		this.setAdminTel(adminTel);
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public int getAdminTel() {
		return adminTel;
	}

	public void setAdminTel(int adminTel) {
		this.adminTel = adminTel;
	}
	
	
}
