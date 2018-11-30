package kr.co.ysb.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ysb.client.dao.ClientMapper;
import kr.co.ysb.model.YoutubeVO;

@Service
public class ClientService {
	@Autowired
	private ClientMapper mapper;
	
	public List<YoutubeVO> getList(){
		return mapper.getList();
	}

}
