package la.model;

import javax.servlet.http.HttpServletRequest;

import la.dao.CategoryDAO;
import la.dao.DAOException;

public class CategoryUpdateExecuteBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエスト・パラメータを取得
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		
		//CategoryDAOのインスタンス生成
		CategoryDAO dao = new CategoryDAO();
		
		//指定したコードのカテゴリを更新
		int rows = dao.update(code, name);
		
		if (rows != 1) {
			throw new DAOException("更新に失敗しました");
		}
		
		return "/CategoryServlet?action=list";
		//return "/categories.jsp";
	}

}
