/*
 * Copyright (C) 2014 Rafael Aznar
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.daw.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.control.operation.generic.specific.implementation.AutorControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.DiscoControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.GeneroControlOperationGenSpImpl;
import net.daw.control.route.generic.specific.implementation.AutorControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.DiscoControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.GeneroControlRouteGenSpImpl;

public class exe extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }                        
            if (request.getParameter("ob") != null) {
                if (request.getParameter("op") != null) {
                    //ejercicio 1
                    //login
                    if (request.getParameter("ob").equals("usuario")) {
                        if (request.getParameter("op").equals("login")) {
                            getServletContext().getRequestDispatcher("/formulario.jsp").forward(request, response);
                        }
                    }
                    //login y logout
                    if (request.getParameter("ob").equals("usuario")) {
                        if (request.getParameter("op").equals("logindesdeformulario")) {
                            Integer numero1 = Integer.parseInt(request.getParameter("numero1"));
                            Integer numero2 = Integer.parseInt(request.getParameter("numero2"));
                            Integer login = Integer.parseInt(request.getParameter("login"));
                            Integer suma = numero1 + numero2;
                            Integer multi = numero1 * numero2;
                            if (login == suma) {
                                request.getSession().setAttribute("usuario", "ejercicio2");
                                out.println("te has logueado para el ejercicio 2");
                            }
                            if (login == multi) {
                                request.getSession().setAttribute("usuario", "ejercicio3");
                                out.println("te has logueado para el ejercicio 3");
                            }
                        }
                        if (request.getParameter("op").equals("logout")) {
                            request.getSession().invalidate();
                            out.println("ya no hay sesion");
                        }
                    }
                    //ejercicio 2
                    if (request.getParameter("ob").equals("genero")) {
                        if (request.getParameter("op").equals("getall")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("ejercicio2")) {
                                GeneroControlRouteGenSpImpl oGeneroRoute = new GeneroControlRouteGenSpImpl();
                                GeneroControlOperationGenSpImpl oGeneroControlOperation = new GeneroControlOperationGenSpImpl(request);
                                String jsonresult = oGeneroRoute.execute(request, oGeneroControlOperation);
                                out.print(jsonresult);
                            } else {
                                out.println("no se puede ejecutar el ejercicio 2");
                            }
                        }
                    }
                    //ejercicio 3
                    if (request.getParameter("ob").equals("genero")) {
                        if (request.getParameter("op").equals("getcount")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("ejercicio3")) {
                                GeneroControlRouteGenSpImpl oGeneroRoute = new GeneroControlRouteGenSpImpl();
                                GeneroControlOperationGenSpImpl oGeneroControlOperation = new GeneroControlOperationGenSpImpl(request);
                                String jsonresult = oGeneroRoute.execute(request, oGeneroControlOperation);
                                out.print(jsonresult);
                                //menos nota:
                                //ConnectionInterface DataConnectionSource = new BoneConnectionPoolImpl();
                                //Connection oConnection = DataConnectionSource.newConnection();
                                //GeneroDaoGenSpImpl oGenDao = new GeneroDaoGenSpImpl("genero", oConnection);
                                //out.print("{\"count\":" + oGenDao.getCount("genero") + "}");
                            } else {
                                out.println("no se puede ejecutar el ejercicio 3");
                            }

                        }
                    }
                    if (request.getParameter("ob").equals("autor")) {
                        //ejercicio 4
                        if (request.getParameter("op").equals("populate")) {
                            AutorControlRouteGenSpImpl oAutorRoute = new AutorControlRouteGenSpImpl();
                            AutorControlOperationGenSpImpl oAutorControlOperation = new AutorControlOperationGenSpImpl(request);
                            String jsonresult = oAutorRoute.execute(request, oAutorControlOperation);
                            out.print(jsonresult);

                        }
                        //ejercicio 7
                        if (request.getParameter("op").equals("removeall")) {
                            AutorControlRouteGenSpImpl oAutorRoute = new AutorControlRouteGenSpImpl();
                            AutorControlOperationGenSpImpl oAutorControlOperation = new AutorControlOperationGenSpImpl(request);
                            String jsonresult = oAutorRoute.execute(request, oAutorControlOperation);
                            out.print(jsonresult);

                        }
                    }
                    if (request.getParameter("ob").equals("disco")) {
                        //ejercicio 5
                        if (request.getParameter("op").equals("populate")) {
                            DiscoControlRouteGenSpImpl oDiscoRoute = new DiscoControlRouteGenSpImpl();
                            DiscoControlOperationGenSpImpl oDiscoControlOperation = new DiscoControlOperationGenSpImpl(request);
                            String jsonresult = oDiscoRoute.execute(request, oDiscoControlOperation);
                            out.print(jsonresult);

                        }
                        //ejercicio 6
                        if (request.getParameter("op").equals("getpage")) {
                            DiscoControlRouteGenSpImpl oDiscoRoute = new DiscoControlRouteGenSpImpl();
                            DiscoControlOperationGenSpImpl oDiscoControlOperation = new DiscoControlOperationGenSpImpl(request);
                            String jsonresult = oDiscoRoute.execute(request, oDiscoControlOperation);
                            out.print(jsonresult);
                        }
                        //ejercicio 8
                        if (request.getParameter("op").equals("changeforeign")) {
                            DiscoControlRouteGenSpImpl oDiscoRoute = new DiscoControlRouteGenSpImpl();
                            DiscoControlOperationGenSpImpl oDiscoControlOperation = new DiscoControlOperationGenSpImpl(request);
                            String jsonresult = oDiscoRoute.execute(request, oDiscoControlOperation);
                            out.print(jsonresult);
                        }
                    }
                }
            }
            //menu
            if (request.getParameter("ob") != null) {
                if (request.getParameter("ob").equals("menu")) {
                    getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
                }
            }
        } catch (Exception ex) {
            out.println(JsonControl.class.getName() + " " + ex.getMessage());
            ex.printStackTrace();
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
