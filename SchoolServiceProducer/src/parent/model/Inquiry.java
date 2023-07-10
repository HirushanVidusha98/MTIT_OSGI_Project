package parent.model;

public class Inquiry {
  private int inqId;
  private String name;
  private String inqBody;

  public int getInqId() {
	return inqId;
}
public Inquiry(int inqId, String name, String inqBody) {
	this.inqId = inqId;
	this.inqBody = inqBody;
}

public void setInqId(int inqId) {
	this.inqId = inqId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getInqBody() {
	return inqBody;
}
public void setInqBody(String inqBody) {
	this.inqBody = inqBody;
}
}
