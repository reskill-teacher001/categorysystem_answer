package la.model;

import javax.servlet.http.HttpServletRequest;

import la.dao.CategoryDAO;
import la.dao.DAOException;

public class CategoryInsertExecuteBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエスト・パラメータを取得
		String name = request.getParameter("name");
		
		//CategoryDAOのインスタンス生成
		CategoryDAO dao = new CategoryDAO();
		
		//カテゴリを登録
		int rows = dao.insert(name);
		
		if (rows != 1) {
			throw new DAOException("登録に失敗しました");
		}
		
		return "/CategoryServlet?action=list";

		//return "/categories.jsp";
	}

}
