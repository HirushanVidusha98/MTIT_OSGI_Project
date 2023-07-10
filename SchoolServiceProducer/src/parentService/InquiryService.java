package parentService;

import java.util.List;

import parent.model.Inquiry;
import parent.model.Parent;

public interface InquiryService {
	public  int  addPInquirys(String name, String inqBody);
	public List<Inquiry> listInquirys();
	public  int  updatePInquirys(String name, String inqBody);
}
