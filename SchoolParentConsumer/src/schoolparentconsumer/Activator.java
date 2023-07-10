package schoolparentconsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import parentStore.InquiryStore;
import parent.model.Inquiry;
import parent.model.Parent;
import parentService.InquiryService;
import parentService.ParentService;
import parentServiceImpl.InquiryServiceImpl;
import parentServiceImpl.ParentServiceImpl;
import parentStore.ParentStore;

public class Activator implements BundleActivator {

	ServiceReference ParentServiceReference;
	Scanner input = new Scanner(System.in);

	boolean exit = false;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============School Parent consumer started.============");
		ParentServiceReference = context.getServiceReference(ParentService.class.getName());
		@SuppressWarnings("unchecked")
		ParentService parentService = (ParentService) context.getService(ParentServiceReference);
		
		do {
			int selection = 7;
			do {
			System.out.println("----------------------------Welcome to School-------------------------------");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Register to the system ");
			System.out.println("2..Display Parents ");
			System.out.println("3.Search Parent ");
			System.out.println("4.Edit an exsisiting Parent");
			System.out.println("5.Delete exsisiting Prent");
			System.out.println("6.Add Inquiry");
			System.out.println("7.Exit");
		
			
			System.out.println("Enter your selection...");
			 selection = input.nextInt();
			
			 input.nextLine();
			 if(selection == 6) {
				 exit = true;
			 }
			 if(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6 && selection !=7) {
				 System.out.println("Please enter a valid selection");
			 }
			}while(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6 && selection !=7);
			
			 String  backToHome = null;
				if (selection == 1) {//Handles the adding process of new items to the list
					do {
					System.out.println("Parent Name");
					String parentName = input.nextLine();

					System.out.println("Parent Age");
					int parentAge = input.nextInt();

					System.out.println("Address");
					String parentAddress = input.next();
					
					System.out.println("Telephone number");
					int parentTel = input.nextInt();
					
					input.nextLine();
					ParentService ParentService = new ParentServiceImpl();
					int result = ParentService.addParents(parentName, parentAge, parentAddress, parentTel);//Consumes the ManagerService addItems()
					 String msg = (result ==1) ? "Parent added!" :"please enter name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
					
				}else if(selection == 2) {
					do {
					//AdminService adminService = new AdminServiceImpl();
						List<Parent>parentsList = parentService.listParents();
						System.out.println("............List of Parents...............");
						System.out.println("-------------------------------------------------------------------------------------------------S");
						for(Parent tempAdmin: parentsList) {
						System.out.println(tempAdmin.getParentId()+"  " + tempAdmin.getParentName()+"  "+tempAdmin.getParentAge()+"  "+tempAdmin.getParentAddress()+"  "+tempAdmin.getParentTel());
						}
						
							System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							backToHome=input.nextLine();
							
					}while(!(backToHome.equals("0")));
		
				}
				
				else if(selection == 3) {//Handles the searching process of an existing item in the list
					do {
					
					System.out.println("Enter the Parent name");
					

					String parentName = input.nextLine();
					//AdminService adminService = new AdminServiceImpl();
					int result =parentService.searchParents(parentName);//Consumes the ManagerService searchItems()
					 String msg = (result ==1) ? "Parent found!" :"Parent not found!";
					   System.out.println(msg);
					
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));
				
				}else if (selection == 4) {//Handles the updating process of an item in the list
					do {
						System.out.println("Parent Name");
						String updatedParentName = input.nextLine();

						System.out.println("Parent Age");
						int updatedParentAge = input.nextInt();

						System.out.println("Parent Address");
						String updatedParentAddress = input.next();
						
						System.out.println("Parent Telephone Number");
						int updatedParentTel = input.nextInt();
						input.nextLine();
						
						//AdminService adminService = new AdminServiceImpl();
					int result =parentService.updateParents(updatedParentName,updatedParentAge,updatedParentAddress, updatedParentTel);
					  String msg = (result ==1) ? "updated the Parent!" :"please enter a name";
					   System.out.println(msg);
		           System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
					
				}else if (selection == 5) {//Handles the removing process of an existing item in the list 
					do {
					System.out.println("Enter the Parent name");

					String itemName = input.nextLine();
					int result =parentService.removeParents(itemName);
					   String msg = (result ==1) ? "Successfully Removed the item!" :"please enter a valid name";
					   System.out.println(msg);
		              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));

				}
				
				
				
				
				else if(selection == 6) {
				//	String  backToHomee = null;
					do {
						Scanner inputt = new Scanner(System.in);
						boolean exitt = false;
					//----------------------------------------------------	
						do {
							int selectionn = 4;
							do {
							System.out.println("----------------------------Welcome to School-------------------------------");
						
							System.out.println("Please Select an option to continue.....");
							System.out.println("Options");
							System.out.println("1.Add Inquiry ");
							System.out.println("2.Display Inquiryes");
							System.out.println("3.Update Inquiryes");
							System.out.println("4.Exit");
							
							System.out.println("Enter your selection...");
							 selectionn = inputt.nextInt();
							
							 inputt.nextLine();
							 if(selectionn == 4) {
								 exitt = true;
							 }
							 if(selectionn !=1 && selectionn !=2 && selectionn !=3 && selectionn !=4 ) {
								 System.out.println("Please enter a valid selection");
							 }
							}while(selectionn !=1 && selectionn !=2  && selectionn !=3 && selectionn !=4);
							
							 String  backToHomee = null;
							 if (selectionn == 1) {//Handles the adding process of new items to the list
									do {
									System.out.println("Inquiry Name");
									String namee = inputt.next();

									System.out.println("Inquiry Body");
									String bodyy = inputt.next();

									
									inputt.nextLine();
									InquiryService inquiryService = new InquiryServiceImpl();
									int resultt = inquiryService.addPInquirys(namee, bodyy);
									 String msgg = (resultt ==1) ? "Inquiry added!" :"please enter vaild Inquiry tropic";
									   System.out.println(msgg);
									System.out.println("Press 0 to navigate back to home or press any other key to continue....");
									
									backToHomee=inputt.nextLine();
									
									}while(!(backToHomee.equals("0")));
									
								} else if(selectionn == 2) {
									do {
										InquiryService inquiryService = new InquiryServiceImpl();
											List<Inquiry>inquirysList = inquiryService.listInquirys();
											System.out.println("............List of Inquiries...............");
											System.out.println("-----------------------------------------------------------------------------------------------");
											for(Inquiry inq: inquirysList) {
											System.out.println(inq.getInqId() + "  "+ inq.getName() +"  " + inq.getInqBody());
											}
											
												System.out.println("Press 0 to navigate back to home or press any other key to continue....");
												backToHomee=inputt.nextLine();
												
										}while(!(backToHomee.equals("0")));
							
									}else if (selectionn == 3) {//Handles the updating process of an item in the list
										do {
											System.out.println("Inquiry Name");
											String updatedInquiryName = inputt.nextLine();

											System.out.println("Inquiry Body");
											String updatedInquiryBody = inputt.nextLine();

											inputt.nextLine();
											
											InquiryService inquiryService = new InquiryServiceImpl();
										int result =inquiryService.updatePInquirys(updatedInquiryName,updatedInquiryBody);
										  String msgg = (result ==1) ? "updated the Inquiry!" :"please enter a name";
										   System.out.println(msgg);
							           System.out.println("Press 0 to navigate back to home or press any other key to continue....");
										
										backToHomee=inputt.nextLine();
										
										}while(!(backToHomee.equals("0")));
										
									}
							 
							 
							 
							 
							 
							 
							 
							 else if(selectionn == 4) {
									return;
								
								}
						}while(!exitt);
						
						
						 
						 
						 System.out.println("Press 0 to navigate back to home or press any other key to continue....2");
							backToHome=input.nextLine();
							//-------------------------------
							
					}while(!(backToHome.equals("0")));
		
				}else if(selection == 7) {
						return;
					}
				}while(!exit);
			}
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("============Parent concumer consumer stopped.============");
		context.ungetService(ParentServiceReference);
	}

}
