package parent.model;

public class Parent {
	private int parentId;
	private String parentName;
	private int parentAge;
	private String parentAddress;
	private int parentTel;
	
	public Parent(int parentId, String parentName, int parentAge, String parentAddress, int parentTel) {
		super();
		this.parentId = parentId;
		this.parentName = parentName;
		this.parentAge = parentAge;
		this.parentAddress = parentAddress;
		this.parentTel = parentTel;
	}
	
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentName() {
		return parentName;
	}
	
	public int getParentAge() {
		return parentAge;
	}
	public void setParentAge(int parentAge) {
		this.parentAge = parentAge;
	}
	public String getParentAddress() {
		return parentAddress;
	}
	public void setParentAddress(String parentAddress) {
		this.parentAddress = parentAddress;
	}
	public int getParentTel() {
		return parentTel;
	}
	public void setParentTel(int parentTel) {
		this.parentTel = parentTel;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
