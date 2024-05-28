package la.model;

import javax.servlet.http.HttpServletRequest;

import la.dao.DAOException;

public class CategoryInsertBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {

		return "/addCategory.jsp";
	}

}
