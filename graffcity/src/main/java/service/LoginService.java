package service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Validador;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;

import facade.UsuarioFacade;


@Path("/login")
public class LoginService extends HttpServlet{
	@EJB 
	UsuarioFacade usuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(LoginService.class.getName());
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");// si hacemos get en el login te tira a index
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession respuesta = request.getSession(true);
        String usuario = request.getParameter("usuario"); //obtengo el nombre de usuario
        String password = request.getParameter("password"); // obtengo el nombre de password
        Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher m = p.matcher(usuario);
        Validador v = new Validador();
        
        //campos vacios
        if (usuario.isEmpty() || password.isEmpty()) {
            respuesta.setAttribute("error", "Hay campos vacios");
 
        } else {
            //No hay campos vacios, veo que el usuario sea válido
            if (m.find()) {
                respuesta.setAttribute("error", "El usuario no es correcto");
 
            } else {
                //Si el usuario es correcto, verifico que la contraseña tambien lo sea
                if (v.isUsernameOrPasswordValid(password)) {
                        try {
                        	
                            if (usuarioFacadeEJB.isAcountExists(usuario, password)) {
                                //Significa que la cuenta si existe
                                //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
                                respuesta.setAttribute("sessionNombre", usuario);
                                
                            } else {
                                respuesta.setAttribute("error", "Esta cuenta no existe");
                            }
 
                            
 
                        } catch (Exception e) {}
 
 
                    
 
                } else {
                    respuesta.setAttribute("error", "Contraseña no es válida");
 
                }
 
 
            }
        }
 
        response.sendRedirect("index.html");
 
    }

}
