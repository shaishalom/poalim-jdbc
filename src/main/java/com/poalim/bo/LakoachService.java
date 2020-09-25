package com.poalim.bo;

import java.util.List;

import com.poalim.bean.LakoachTnuaaVO;
import com.poalim.dao.LakoachDao;

public class LakoachService {

	public List<LakoachTnuaaVO> fetchLakoachAccounts() throws ClassNotFoundException {
		LakoachDao lakoachDao  = new LakoachDao();
		List<LakoachTnuaaVO> lakoachTnuaaVOs = lakoachDao.fetchLakoachAccounts();
		return lakoachTnuaaVOs;
	}
}
