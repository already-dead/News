package admin.commands;

import logger.TrueLogger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            TrueLogger.getLogger().write("ServletException � ������ execute ������ AddCommand!" + e.getMessage()); // ������ � ���-����
            e.printStackTrace();
        } catch (IOException e1) {
            TrueLogger.getLogger().write("IOException � ������ execute ������ AddCommand! -- " + e1.getMessage()); // ������ � ���-����
            e1.printStackTrace();
        }
    }
}
