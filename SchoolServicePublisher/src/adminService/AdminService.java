package adminService;

import java.util.List;

import admin.model.Admin;

public interface AdminService {
	public  int  addAdmins(String adminName, int adminAge, String adminAddress, int adminTel);
	public   int  updateAdmins(String adminName, int adminAge, String adminAddress, int adminTel);
	public   int removeAdmins(String adminName);
	public   int searchAdmins(String adminName);
	public   List<Admin> listAdmins();
}

