
package Servlets;

import entidades.Contatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Agenda;

@WebServlet(name = "AgendaServlet", urlPatterns = {"/AgendaServlet"})
public class AgendaServlet extends HttpServlet {
    
    private Agenda agenda;

    @Override
    public void init() throws ServletException {
        agenda = new Agenda();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contatos cont = new Contatos();
        String opcao = request.getParameter("opcao");
        
        if(opcao.equals("1"))
        {
            cont.setNome(request.getParameter("nome"));
            cont.setEmail(request.getParameter("e-mail"));
            cont.setTel(request.getParameter("telefone"));
            cont.setEndereco(request.getParameter("endereco"));
            agenda.inserir(cont);
            PrintWriter out = response.getWriter();
            out.println(agenda.listar());
        }
        if(opcao.equals("2"))
        {
            PrintWriter out = response.getWriter();
            cont.setNome(request.getParameter("nome"));
            
            if(agenda.remover(cont.getNome())){
                
                out.println("Contato removido!");
            }else{
                out.println("Contato não existe!");
            }
        }
        if(opcao.equals("3"))
        {
            PrintWriter out = response.getWriter();
            cont.setNome(request.getParameter("nome"));
            
            Contatos c1 = agenda.buscar(cont.getNome());
            if(c1 == null)
            {
                out.println("Contato não está na lista!");
            } else{
                out.println("Contato Encontrado: " + c1.getNome());
            }
        }
        if(opcao.equals("4"))
        {
            PrintWriter out = response.getWriter();
            out.print(agenda.listar());
        }
        
        
    }
    
    

    
}
