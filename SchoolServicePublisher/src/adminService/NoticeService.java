package adminService;

import java.util.List;

import admin.model.Notice;

public interface NoticeService {
	public int addNotice(String noticeName, String noticeBody);
	public int updateNotice(String noticeName, String noticeBody);
	public int removeNotice(String noticeName);
	public int searchNotice(String noticeName);
	public List<Notice> listNotices();
}