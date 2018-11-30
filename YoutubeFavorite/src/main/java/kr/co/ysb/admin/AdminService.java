package kr.co.ysb.admin;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ysb.admin.dao.AdminMapper;
import kr.co.ysb.model.GallaryVO;
import kr.co.ysb.model.UserVO;
import kr.co.ysb.model.YoutubeVO;

@Service
public class AdminService {
	@Autowired
	private AdminMapper mapper;
	@Autowired
	private BCryptPasswordEncoder bpe;
	
	public void join(UserVO vo) {
		//비밀번호 암호화
		String encodePassword = bpe.encode(vo.getU_pw());
		vo.setU_pw(encodePassword);
		mapper.join(vo);
	}
	
	public void insertURL(YoutubeVO vo) {
		mapper.insertURL(vo);
	}

	public List<YoutubeVO> getList(){
		return mapper.getList();
	}
	
	public void insertGallary(GallaryVO vo) {
		String allpath = "src/main/resorces/img/";
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("date" + dateFormat.format(date));
		
		File resorcesDirectory = new File(allpath+dateFormat.format(date));
		System.out.println(resorcesDirectory);
	}
}
