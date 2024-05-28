package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Category;
import la.dao.CategoryDAO;
import la.dao.DAOException;

public class CategoryListPagingBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		int page;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
		
		//CategoryDAOのインスタンス生成
		CategoryDAO dao = new CategoryDAO();
		
		//Categoryの全レコード数を取得
		int record = dao.getCategoryRecords();
		
		//１ページの最大数
		int limit = 3;
		
		//ページの最大数を取得
		int max = record / limit;
		max = record % limit == 0 ? max : max + 1;
		
		//オフセット
		int offset = (page - 1) * limit;

		//全カテゴリー情報取得
		List<Category> list = dao.findAll(limit, offset);

		//リクエストスコープに全カテゴリ情報設定
		request.setAttribute("list", list);
		request.setAttribute("max", max);
		request.setAttribute("page", page);

		return "/paging_categories.jsp";
	}

}
