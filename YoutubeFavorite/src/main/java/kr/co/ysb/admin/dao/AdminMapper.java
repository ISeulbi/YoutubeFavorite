package kr.co.ysb.admin.dao;

import java.util.List;

//import kr.co.ysb.model.GallaryVO;
import kr.co.ysb.model.UserVO;
import kr.co.ysb.model.YoutubeVO;

public interface AdminMapper {
	public void join(UserVO p);
	
	public void insertURL(YoutubeVO p);
	
	public List<YoutubeVO> getList();
	
	//public void insertGallary(GallaryVO vo);
}
