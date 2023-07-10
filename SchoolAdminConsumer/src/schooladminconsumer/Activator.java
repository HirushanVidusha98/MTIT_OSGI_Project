package schooladminconsumer;

import adminService.AdminService;
import adminService.NoticeService;
import adminServiceImpl.AdminServiceImpl;
import adminServiceImpl.NoticeServiceImpl;

import admin.model.*;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	ServiceReference AdminServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============School Admin consumer started.============");
		AdminServiceReference = context.getServiceReference(AdminService.class.getName());
		@SuppressWarnings("unchecked")
		AdminService adminService = (AdminService) context.getService(AdminServiceReference);
		
		do {
			int selection = 7;
			do {
			System.out.println("----------------------------Welcome to School-------------------------------");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Register Employees to the system ");
			System.out.println("2.Display Employees");
			System.out.println("3.Search Employee");
			System.out.println("4.Edit an exsisiting Employee");
			System.out.println("5.Delete exsisiting Employee");
			System.out.println("6.Navaigate to the notice page");
			System.out.println("7.Exit");
			
			System.out.println("Enter your selection...");
			 selection = input.nextInt();
			
			 input.nextLine();
			 if(selection == 7) {
				 exit = true;
			 }
			 if(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6 && selection !=7) {
				 System.out.println("Please enter a valid selection");
			 }
			}while(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6 && selection !=7);
			
			 String  backToHome = null;
			 if (selection == 1) {//Handles the adding process of new items to the list
					do {
					System.out.println("Employee Name");
					String adminName = input.nextLine();

					System.out.println("Admin Age");
					int adminAge = input.nextInt();

					System.out.println("Address");
					String adminAddress = input.next();
					
					System.out.println("Telephone number");
					int adminTel = input.nextInt();
					
					input.nextLine();
					//AdminService adminService = new AdminServiceImpl();
					int result = adminService.addAdmins(adminName, adminAge, adminAddress, adminTel);//Consumes the ManagerService addItems()
					 String msg = (result ==1) ? "Employee added!" :"please enter name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
					
				}else if(selection == 2) {
					do {
					//AdminService adminService = new AdminServiceImpl();
						List<Admin>adminsList = adminService.listAdmins();
						System.out.println("............List of Employees...............");
						System.out.println("-------------------------------------------------------------------------------------------------");
						for(Admin tempAdmin: adminsList) {
						System.out.println(tempAdmin.getAdminId()+"  " + tempAdmin.getAdminName()+"  "+tempAdmin.getAdminAge()+"  "+tempAdmin.getAdminAddress()+"  "+tempAdmin.getAdminTel());
						}
						
							System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							backToHome=input.nextLine();
							
					}while(!(backToHome.equals("0")));
		
				}
				
				else if(selection == 3) {//Handles the searching process of an existing item in the list
					do {
					
					System.out.println("Enter the Employee name");
					

					String adminName = input.nextLine();
					//AdminService adminService = new AdminServiceImpl();
					int result =adminService.searchAdmins(adminName);//Consumes the ManagerService searchItems()
					 String msg = (result ==1) ? "Employee found!" :"Employee not found!";
					   System.out.println(msg);
					
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));
				
				}else if (selection == 4) {//Handles the updating process of an item in the list
					do {
						System.out.println("Employee Name");
						String updatedAdminName = input.nextLine();

						System.out.println("Employee Age");
						int updatedAdminAge = input.nextInt();

						System.out.println("Employee Address");
						String updatedAdminAddress = input.next();
						
						System.out.println("Employee Telephone Number");
						int updatedAdminTel = input.nextInt();
						input.nextLine();
						
						//AdminService adminService = new AdminServiceImpl();
					int result =adminService.updateAdmins(updatedAdminName,updatedAdminAge,updatedAdminAddress, updatedAdminTel);
					  String msg = (result ==1) ? "updated the Employee!" :"please enter a name";
					   System.out.println(msg);
		           System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
					
				}else if (selection == 5) {//Handles the removing process of an existing item in the list 
					do {
					System.out.println("Enter the Employee name");

					String itemName = input.nextLine();
					//AdminService adminService = new AdminServiceImpl();
					int result =adminService.removeAdmins(itemName);//Consumes the ManagerService removeItems()
					   String msg = (result ==1) ? "Successfully Removed the Employee!" :"please enter a valid name";
					   System.out.println(msg);
		              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));

				}else if(selection == 6) {
					do {
						boolean exitt = false;
						do {
							int selectionn = 3;
							do {
							System.out.println("----------------------------Welcome to Notice-------------------------------");
						
							System.out.println("Please Select an option to continue.....");
							System.out.println("Options");
							System.out.println("1.Add notice ");
							System.out.println("2.Display notices ");
							System.out.println("3.Update notices ");
							System.out.println("4.Exit");
							
							System.out.println("Enter your selection...");
							 selection = input.nextInt();
							
							 input.nextLine();
							 if(selection == 4) {
								 exitt = true;
							 }
							 if(selectionn !=1 && selectionn !=2 && selectionn !=3 && selectionn !=4) {
								 System.out.println("Please enter a valid selection");
							 }
							}while(selectionn !=1 && selectionn !=2 && selectionn !=3 && selectionn !=4);
							
							 String  backToHomee = null;
							 if (selection == 1) {//Handles the adding process of new items to the list
									do {
									System.out.println("Notice Name");
									String noticeName = input.next();

									System.out.println("Notice Body");
									String noticeBody = input.nextLine();

				
									
									input.nextLine();
									NoticeService noticeService = new NoticeServiceImpl();
									int result = noticeService.addNotice(noticeName, noticeBody);
									 String msg = (result ==1) ? "Notice added!" :"please enter header";
									   System.out.println(msg);
									System.out.println("Press 0 to navigate back to home or press any other key to continue....");
									
									backToHomee=input.nextLine();
									
									}while(!(backToHomee.equals("0")));
									
								}
							 
							 
							 
							 else if(selection == 2) {
									do {
										NoticeService noticeService = new NoticeServiceImpl();
										List<Notice>noticesList = noticeService.listNotices();
										System.out.println("............List of Notices...............");
										System.out.println("-------------------------------------------------------------------------------------------------");
										for(Notice not: noticesList) {
										System.out.println(not.getNoticeId() +"  " + not.getNoticeName()+"  " +not.getNoticeBody()+"");
										}
										
											System.out.println("Press 0 to navigate back to home or press any other key to continue....");
											backToHome=input.nextLine();
											
									}while(!(backToHome.equals("0")));
						
								}
							 
							 
							 else if (selection == 3) {
									do {
										System.out.println("Notice Name");
										String noticeName = input.next();

										System.out.println("Notice Body");
										String noticeBody = input.nextLine();

										input.nextLine();
										
										NoticeService noticeService = new NoticeServiceImpl();
									int result =noticeService.updateNotice(noticeName, noticeBody);
									  String msgg = (result ==1) ? "updated the Manager!" :"please enter a name";
									   System.out.println(msgg);
						           System.out.println("Press 0 to navigate back to home or press any other key to continue....");
									
									backToHomee=input.nextLine();
									
									}while(!(backToHomee.equals("0")));
									
								}
							 
							 
							 
							 
							 
							 
							 
							 else if(selectionn == 4) {
									return;
								}
						}while(!exitt);
					}while(!(backToHome.equals("0")));
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				else if(selection == 7) {
						return;
					}
				}while(!exit);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("******************Admin concumer consumer stopped.***************");
		context.ungetService(AdminServiceReference);
	}

}
