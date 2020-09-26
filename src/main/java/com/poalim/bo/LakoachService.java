package com.poalim.bo;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.poalim.bean.LakoachTnuaaVO;
import com.poalim.dao.LakoachDao;

public class LakoachService {

	public List<LakoachTnuaaVO> fetchLakoachAccounts() throws ClassNotFoundException {
		LakoachDao lakoachDao = new LakoachDao();
		List<LakoachTnuaaVO> lakoachTnuaaVOs = lakoachDao.fetchLakoachAccounts(null);
		return lakoachTnuaaVOs;
	}

	public List<LakoachTnuaaVO> fetchLakoachAccounts(String id) throws ClassNotFoundException {
		LakoachDao lakoachDao = new LakoachDao();
		Long idLong = null;
		if (StringUtils.isNumeric(id)) {
			idLong = new Long(id);
		}
		List<LakoachTnuaaVO> lakoachTnuaaVOs = lakoachDao.fetchLakoachAccounts(idLong);
		return lakoachTnuaaVOs;
	}

}
