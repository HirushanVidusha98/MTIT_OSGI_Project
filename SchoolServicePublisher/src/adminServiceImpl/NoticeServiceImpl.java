package adminServiceImpl;

import java.util.List;

import admin.model.Notice;
import adminService.NoticeService;
import adminStore.NoticeStore;

public class NoticeServiceImpl implements NoticeService{
	@Override
	public synchronized int addNotice(String noticeName, String noticeBody) {
		// TODO Auto-generated method stub
		Notice newNotice = new Notice(NoticeStore.noticesList.size() + 1, noticeName, noticeBody);
		NoticeStore.noticesList.add(newNotice);

	return 1;
	}

	@Override
	public int updateNotice(String UpdatedNoticeName, String UpdatedNoticeBody) {
		// TODO Auto-generated method stub
		
		Notice noticeToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Notice tempNotice : NoticeStore.noticesList) {
			count++;
			if (tempNotice.getNoticeName().equalsIgnoreCase(UpdatedNoticeName)) {

				noticeToBeUpdated = tempNotice;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			noticeToBeUpdated.setNoticeName(UpdatedNoticeName);
			noticeToBeUpdated.setNoticeBody(UpdatedNoticeBody);
			

			NoticeStore.noticesList.set(count, noticeToBeUpdated);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public synchronized int removeNotice(String noticeName) {
		// TODO Auto-generated method stub
		boolean invalid = true;
		int count = -1;
		for (Notice tempNotice :NoticeStore.noticesList) {
			count++;
			if (tempNotice.getNoticeName().equalsIgnoreCase(noticeName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			NoticeStore.noticesList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchNotice(String noticeName) {
		boolean valid = false;
		
		for (Notice tempTeacher : NoticeStore.noticesList) {
		
			if (tempTeacher.getNoticeName().equalsIgnoreCase(noticeName)) {

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
	public List<Notice> listNotices() {
		// TODO Auto-generated method stub
		return NoticeStore.noticesList;
	}
}
