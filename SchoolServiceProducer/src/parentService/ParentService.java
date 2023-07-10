package parentService;

import java.util.List;

import parent.model.Parent;

public interface ParentService {
	public  int  addParents(String parentName, int parentAge, String parentAddress, int parentTel);
	public   int  updateParents(String parentName, int parentAge, String parentAddress, int parentTel);
	public   int removeParents(String parentName);
	public   int searchParents(String parentName);
	public   List<Parent> listParents();
}
