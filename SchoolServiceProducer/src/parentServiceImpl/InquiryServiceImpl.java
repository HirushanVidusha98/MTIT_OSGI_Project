package parentServiceImpl;

import java.util.List;

//import managerStore.ManagerStore;
import parent.model.Inquiry;
import parent.model.Parent;
import parentService.InquiryService;
import parentStore.InquiryStore;
import parentStore.ParentStore;

public class InquiryServiceImpl implements InquiryService{
	@Override
	public synchronized int  addPInquirys(String name, String inqBody) {
		Inquiry newInquiry = new Inquiry(InquiryStore.inquirysList.size() + 1, name, inqBody);
		InquiryStore.inquirysList.add(newInquiry);

	return 1;
	}
	@Override
	public List<Inquiry> listInquirys(){
		return InquiryStore.inquirysList;
	}
	@Override
	public  int  updatePInquirys(String updatedInqName, String updatedInqBody) {
		Inquiry inquiryToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Inquiry tempInq : InquiryStore.inquirysList) {
			count++;
			if (tempInq.getName().equalsIgnoreCase(updatedInqName)) {

				inquiryToBeUpdated = tempInq;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			inquiryToBeUpdated.setName(updatedInqName);
			inquiryToBeUpdated.setInqBody(updatedInqBody);

			InquiryStore.inquirysList.set(count, inquiryToBeUpdated);
			return 1;

		} else {
			return -1;
		}
	}
}
