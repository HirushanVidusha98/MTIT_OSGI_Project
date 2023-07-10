package admin.model;

public class Notice {

		private int noticeId;
		private String noticeName;
		private String noticeBody;
		
		public Notice(int noticeId, String noticeName, String noticeBody) {
			this.noticeId = noticeId;
			this.noticeName = noticeName;
			this.noticeBody = noticeBody;
		}

		public int getNoticeId() {
			return noticeId;
		}

		public void setNoticeId(int noticeId) {
			this.noticeId = noticeId;
		}

		public String getNoticeName() {
			return noticeName;
		}

		public void setNoticeName(String noticeName) {
			this.noticeName = noticeName;
		}

		public String getNoticeBody() {
			return noticeBody;
		}

		public void setNoticeBody(String noticeBody) {
			this.noticeBody = noticeBody;
		}
		

}
