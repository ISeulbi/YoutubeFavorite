package kr.co.ysb.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ysb.model.GallaryVO;
import kr.co.ysb.model.UserVO;
import kr.co.ysb.model.YoutubeVO;

@Controller
@RequestMapping("admin")
public class AdminController{
	
	@Autowired
	private AdminService service;
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "admin/loginForm";
	}
	
	@RequestMapping("main")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("accessDenied")
	public String assessDenied() {
		return "admin/accessDenied";
	}
	
	@RequestMapping("join")
	public String join() {
		return "admin/joinForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(UserVO vo) {
		service.join(vo);
		return "redirect:loginForm";
	}
	
	@RequestMapping("modPw")
	public String modPwGet() {
		return "admin/modPw";
	}
	
	@RequestMapping(value="modPw", method=RequestMethod.POST)
	public String modPwPost(UserVO vo) {
		service.join(vo);
		return "redirect:main";
	}
	
	@RequestMapping("insertURL")
	public String insertURLGet() {
		return "admin/insertURL";
	}
	
	@RequestMapping(value="insertURL", method=RequestMethod.POST)
	public String insertURLPost(YoutubeVO vo) {
		//TODO
		service.insertURL(vo);
		return "redirect:main";
	}
	
	@RequestMapping("list")
	public String listGet(Model model) {
		model.addAttribute("list", service.getList());
		return "admin/list";
	}
	
	@RequestMapping("insertGallary")
	public String insertGallaryGet() {
		return "admin/insertGallary";
	}
	
	@RequestMapping(value="insertGallary", method=RequestMethod.POST)
	public String insertGallaryPost(GallaryVO vo, Model model) {
		service.insertGallary(vo);
		return "admin/insertGallary";
	}
	
	@RequestMapping("gallaryList")
	public String gallaryListGet() {
		return "admin/gallaryList";
	}
}
