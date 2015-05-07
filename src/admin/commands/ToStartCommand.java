package admin.commands;

import logger.TrueLogger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToStartCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("mylogin.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            TrueLogger.getLogger().write(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            TrueLogger.getLogger().write(e.getMessage());
        }

    }

}
