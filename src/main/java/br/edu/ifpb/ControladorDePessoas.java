package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ControladorDePessoas", urlPatterns = {"/pessoas"})
public class ControladorDePessoas extends HttpServlet {

    private ServiceDePessoa service = new ServiceDePessoa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDePessoas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Listagem de Pessoas " + request.getContextPath() + "</h2>");
            preencherTodasAsPessoas(out);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private void preencherTodasAsPessoas(PrintWriter out) {
        service
                .todasAsPessoas()
                .forEach(p -> out.println(p.getNome()+"</br>"));
    }
}
