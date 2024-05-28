package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.model.CategoryDeleteExecuteBean;
import la.model.CategoryInsertBean;
import la.model.CategoryInsertExecuteBean;
import la.model.CategoryListPagingBean;
import la.model.CategoryUpdateBean;
import la.model.CategoryUpdateExecuteBean;
import la.model.IBean;

/**
 * Servlet implementation class ShopController
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//リクエスト取得
		String action = request.getParameter("action");

		IBean bean = null;
		String page = "/errInternal.jsp";

		try {
			if (action == null || action.equals("list")) { //一覧表示
				//bean = new CategoryListBean();
				bean = new CategoryListPagingBean();
			} else if (action.equals("regist")) { //登録用フォーム表示
				bean = new CategoryInsertBean();
			} else if (action.equals("regist_execute")) { //登録実行
				bean = new CategoryInsertExecuteBean();
			} else if (action.equals("update")) { //変更用フォーム表示
				bean = new CategoryUpdateBean();
			} else if (action.equals("update_execute")) { //変更実行
				bean = new CategoryUpdateExecuteBean();
			} else if (action.equals("delete_execute")) { //削除実行
				bean = new CategoryDeleteExecuteBean();
			}

			page = bean.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_message", e.getMessage());
		}

		//フォワード処理
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
