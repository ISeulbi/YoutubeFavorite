package kr.co.ysb.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

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
		String ContextPath = this.getClass().getClassLoader().getResource("").getPath();
		try {
			//path 가져오기
			String fullPath = URLDecoder.decode(ContextPath, "UTF-8");
			String pathArray[] = fullPath.split("WEB-INF");
			
			//date 값 + 포멧
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			String targetpath = pathArray[0] + "resources/img/";
			String bigImagePath = targetpath + dateFormat.format(date);
			
			File path = new File(bigImagePath);
			if(!path.exists()) {
				path.mkdirs();
			}
			
			//확장자 가져오기
			int pos = vo.getImg().getOriginalFilename().lastIndexOf( "." );
			String ext = vo.getImg().getOriginalFilename().substring(pos + 1);
			//UUID 만들기
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString() + "." +ext;
			System.out.println(filename);
			//경로만들기
			File img = new File(bigImagePath, filename);
			//경로에 실제로 파일을 만듦
			FileCopyUtils.copy(vo.getImg().getBytes(), img);
			
			//썸네일 경로 생성
			String thumbImgPath = targetpath + "/thumb/" + dateFormat.format(date);
			path = new File(thumbImgPath);
			if(!path.exists()) {
				path.mkdirs();
			}
			
			//썸네일 만들기
			BufferedImage sourceImg = ImageIO.read(img);
			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
			File thumImg = new File(thumbImgPath +"/"+filename);
			System.out.println(thumImg);
			ImageIO.write(destImg, ext, thumImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
