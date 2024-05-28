package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Category;
import la.dao.CategoryDAO;
import la.dao.DAOException;

public class CategoryListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//CategoryDAOのインスタンス生成
		CategoryDAO dao = new CategoryDAO();

		//全カテゴリー情報取得
		List<Category> list = dao.findAll();

		//リクエストスコープに全カテゴリ情報設定
		request.setAttribute("list", list);

		return "/categories.jsp";
	}

}
