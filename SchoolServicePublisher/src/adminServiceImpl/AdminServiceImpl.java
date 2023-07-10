package adminServiceImpl;

import java.util.List;

import admin.model.Admin;
import adminService.AdminService;
import adminStore.AdminStore;


public class AdminServiceImpl implements AdminService{
	@Override
	public synchronized int addAdmins(String adminName, int adminAge, String adminAddress, int adminTel) {
		// TODO Auto-generated method stub
		Admin newParent = new Admin(AdminStore.adminsList.size() + 1, adminName, adminAge, adminAddress, adminTel);
		AdminStore.adminsList.add(newParent);

	return 1;
	}

	@Override
	public int updateAdmins(String updatedAdminName, int updatedAdminAge, String updatedAdminAddress, int UpdatedAdminTel) {
		// TODO Auto-generated method stub
		
		Admin adminToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Admin tempAdmin : AdminStore.adminsList) {
			count++;
			if (tempAdmin.getAdminName().equalsIgnoreCase(updatedAdminName)) {

				adminToBeUpdated = tempAdmin;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			adminToBeUpdated.setAdminName(updatedAdminName);
			adminToBeUpdated.setAdminAge(updatedAdminAge);
			adminToBeUpdated.setAdminAddress(updatedAdminAddress);
			adminToBeUpdated.setAdminTel(UpdatedAdminTel);

			AdminStore.adminsList.set(count, adminToBeUpdated);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public synchronized int removeAdmins(String adminName) {
		// TODO Auto-generated method stub
		boolean invalid = true;
		int count = -1;
		for (Admin tempItem :AdminStore.adminsList) {
			count++;
			if (tempItem.getAdminName().equalsIgnoreCase(adminName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			AdminStore.adminsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchAdmins(String adminName) {
		boolean valid = false;
		
		for (Admin tempItem : AdminStore.adminsList) {
		
			if (tempItem.getAdminName().equalsIgnoreCase(adminName)) {

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
	public List<Admin> listAdmins() {
		// TODO Auto-generated method stub
		return AdminStore.adminsList;
	}
}
