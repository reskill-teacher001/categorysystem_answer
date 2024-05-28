package la.model;

import javax.servlet.http.HttpServletRequest;

import la.bean.Category;
import la.dao.CategoryDAO;
import la.dao.DAOException;

public class CategoryUpdateBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエスト・パラメータを取得
		int code = Integer.parseInt(request.getParameter("code"));
		
		//CategoryDAOのインスタンス生成
		CategoryDAO dao = new CategoryDAO();
		
		//指定したコードのカテゴリを取得
		Category category = dao.findByCode(code);
		
		if (category == null) {
			throw new DAOException("指定したコードのカテゴリがありません");
		}
		
		request.setAttribute("category", category);

		return "/updateCategory.jsp";
	}

}
