package la.model;

import javax.servlet.http.HttpServletRequest;

import la.bean.Category;
import la.dao.CategoryDAO;
import la.dao.DAOException;

public class CategoryDeleteExecuteBean implements IBean {

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
		
		//指定したコードのカテゴリを更新
		int rows = dao.delete(code);
		
		if (rows != 1) {
			throw new DAOException("削除に失敗しました");
		}
		
		return "/CategoryServlet?action=list";

		//return "/categories.jsp";
	}

}
