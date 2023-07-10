package parentServiceImpl;

import java.util.List;

import parent.model.Parent;
import parentService.ParentService;
import parentStore.ParentStore;

public class ParentServiceImpl implements ParentService{

	@Override
	public synchronized int addParents(String parentName, int parentAge, String parentAddress, int parentTel) {
		// TODO Auto-generated method stub
		Parent newParent = new Parent(ParentStore.parentsList.size() + 1, parentName, parentAge, parentAddress, parentTel);
		ParentStore.parentsList.add(newParent);

	return 1;
	}

	@Override
	public int updateParents(String updatedParentName, int updatedParentAge, String updatedParentAddress, int UpdatedParentTel) {
		// TODO Auto-generated method stub
		
		Parent parentToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Parent tempParent : ParentStore.parentsList) {
			count++;
			if (tempParent.getParentName().equalsIgnoreCase(updatedParentName)) {

				parentToBeUpdated = tempParent;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			parentToBeUpdated.setParentName(updatedParentName);
			parentToBeUpdated.setParentAge(updatedParentAge);
			parentToBeUpdated.setParentAddress(updatedParentAddress);
			parentToBeUpdated.setParentTel(UpdatedParentTel);

			ParentStore.parentsList.set(count, parentToBeUpdated);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public synchronized int removeParents(String parentName) {
		// TODO Auto-generated method stub
		boolean invalid = true;
		int count = -1;
		for (Parent tempItem :ParentStore.parentsList) {
			count++;
			if (tempItem.getParentName().equalsIgnoreCase(parentName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ParentStore.parentsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchParents(String parentName) {
		boolean valid = false;
		
		for (Parent tempItem : ParentStore.parentsList) {
		
			if (tempItem.getParentName().equalsIgnoreCase(parentName)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Parent> listParents() {
		// TODO Auto-generated method stub
		return ParentStore.parentsList;
	}
	
}
