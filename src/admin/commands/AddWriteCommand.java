package admin.commands;

import dao.Dao;
import dao.MyDao;
import data.Page;
import logger.TrueLogger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddWriteCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Page Page = new Page();
        Dao dao = MyDao.getDao();
        try {
            Page.setId(request.getParameter("id"));
            Page.setParentid(request.getParameter("parentid"));
            Page.setTitle(request.getParameter("title"));
            Page.setTitle4menu(request.getParameter("title4menu"));
            Page.setUser(Integer.parseInt(request.getParameter("user")));
            Page.setDate(request.getParameter("date"));
            Page.setMaintext(request.getParameter("maintext"));
            dao.addPage(Page);
            response.sendRedirect("adminController");
        } catch (IOException e) {
            TrueLogger.getLogger().write("IOException � ������ execute ������ AddWriteCommand! -- " + e); // ������ � ���-����
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            TrueLogger.getLogger().write("NumberFormatException � ������ execute ������ AddWriteCommand! -- " + e2); // ������ � ���-����
            e2.printStackTrace();
        } catch (NullPointerException e1) {
            TrueLogger.getLogger().write("NullPointerException � ������ execute ������ AddWriteCommand! -- " + e1); // ������ � ���-����
            e1.printStackTrace();
        }
    }
}
