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
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.generic.specific.implementation.ClienteBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.NombreBeanGenSpImpl;
import net.daw.connection.implementation.BoneConnectionPoolImpl;
import net.daw.connection.publicinterface.ConnectionInterface;
import net.daw.control.operation.generic.specific.implementation.AutorControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.CiudadControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.DiscoControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.GananciasControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.GeneroControlOperationGenSpImpl;
import net.daw.control.operation.generic.specific.implementation.TituloControlOperationGenSpImpl;
import net.daw.control.route.generic.specific.implementation.AutorControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.CiudadControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.DiscoControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.GananciasControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.GeneroControlRouteGenSpImpl;
import net.daw.control.route.generic.specific.implementation.TituloControlRouteGenSpImpl;
import net.daw.dao.generic.specific.implementation.NombreDaoGenSpImpl;

public class javier extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected ConnectionInterface DataConnectionSource = null;
    protected Connection connection = null;

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
                    if (request.getParameter("ob").equals("usuario")) {
                        if (request.getParameter("op").equals("entrar")) {
                            getServletContext().getRequestDispatcher("/formulario_entrar.jsp").forward(request, response);
                        }
                        if (request.getParameter("op").equals("entrarDB")) {
                            getServletContext().getRequestDispatcher("/formulario_entrar_DB.jsp").forward(request, response);
                        }
                        //login con palabra aleatoria
                        if (request.getParameter("op").equals("form_entrar")) {
                            String palabra = (String) request.getParameter("palabra");
                            String palabra_usuario = (String) request.getParameter("palabra_usuario");

                            if (palabra.equals(palabra_usuario)) {
                                request.getSession().setAttribute("usuario", "valido");
                                out.println("estas dentro");
                            } else {
                                out.println("fuera de aqui");
                            }
                        }
                        //logout
                        if (request.getParameter("op").equals("salir")) {
                            request.getSession().invalidate();
                            out.println("ya no hay sesion");
                        }
                    }

                    //login por DB
                    if (request.getParameter("ob").equals("autor")) {
                        if (request.getParameter("op").equals("form_entrar_DB")) {

                            AutorControlRouteGenSpImpl oAutorRoute = new AutorControlRouteGenSpImpl();
                            AutorControlOperationGenSpImpl oAutorControlOperation = new AutorControlOperationGenSpImpl(request);
                            String jsonresult = oAutorRoute.execute(request, oAutorControlOperation);

                            if (jsonresult.equalsIgnoreCase("ok")) {
                                request.getSession().setAttribute("usuario", "valido");
                                out.println("estas dentro");
                            } else {
                                out.println("mal");
                            }
                        }
                    }

                    //ejercicio 2
                    if (request.getParameter("ob").equals("ganancias")) {
                        if (request.getParameter("op").equals("getall")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("valido")) {
                                GananciasControlRouteGenSpImpl oGananciasRoute = new GananciasControlRouteGenSpImpl();
                                GananciasControlOperationGenSpImpl oGananciasControlOperation = new GananciasControlOperationGenSpImpl(request);
                                String jsonresult = oGananciasRoute.execute(request, oGananciasControlOperation);
                                out.print(jsonresult);
                            } else {
                                out.println("inicia sesion para continuar");
                            }
                        }

                        //ejercicio MOSTRAR GANANCIAS SEGUN ID DE CLAVE AJENA
                        if (request.getParameter("op").equals("getganancias")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("valido")) {
                                GananciasControlRouteGenSpImpl oGananciasRoute = new GananciasControlRouteGenSpImpl();
                                GananciasControlOperationGenSpImpl oGananciasControlOperation = new GananciasControlOperationGenSpImpl(request);
                                String jsonresult = oGananciasRoute.execute(request, oGananciasControlOperation);
                                out.print(jsonresult);
                            } else {
                                out.println("inicia sesion para continuar");
                            }
                        }

                        ///MOSTRAR LA SUMA DE DOS GANANCIAS PASADAS POR ID
                        if (request.getParameter("op").equals("suma")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("valido")) {
                                GananciasControlRouteGenSpImpl oGananciasRoute = new GananciasControlRouteGenSpImpl();
                                GananciasControlOperationGenSpImpl oGananciasControlOperation = new GananciasControlOperationGenSpImpl(request);
                                String jsonresult = oGananciasRoute.execute(request, oGananciasControlOperation);
                                out.print(jsonresult);
                            } else {
                                out.println("inicia sesion para continuar");
                            }
                        }

                        if (request.getParameter("op").equals("getpage")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("valido")) {
                                GananciasControlRouteGenSpImpl oGananciasRoute = new GananciasControlRouteGenSpImpl();
                                GananciasControlOperationGenSpImpl oGananciasControlOperation = new GananciasControlOperationGenSpImpl(request);
                                String jsonresult = oGananciasRoute.execute(request, oGananciasControlOperation);
                                out.print(jsonresult);
                            } else {
                                out.println("inicia sesion para continuar");
                            }
                        }

                    }
                    //ejercicio 3 MOSTRAR EL TOTAL DE REGISTROS
                    if (request.getParameter("ob").equals("genero")) {
                        if (request.getParameter("op").equals("getcount")) {
                            String valorsesion = (String) request.getSession().getAttribute("usuario");
                            if (valorsesion.equals("valido")) {
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
                        //ejercicio 4 COJER NOMBRE Y APELLIDOS E INSERTARLOS EN LA TABLA AUTOR
                        if (request.getParameter("op").equals("populate")) {
                            AutorControlRouteGenSpImpl oAutorRoute = new AutorControlRouteGenSpImpl();
                            AutorControlOperationGenSpImpl oAutorControlOperation = new AutorControlOperationGenSpImpl(request);
                            String jsonresult = oAutorRoute.execute(request, oAutorControlOperation);
                            out.print(jsonresult);

                        }
                        //ejercicio 7 BORRAR TODOS LOS REGISTROS
                        if (request.getParameter("op").equals("removeall")) {
                            AutorControlRouteGenSpImpl oAutorRoute = new AutorControlRouteGenSpImpl();
                            AutorControlOperationGenSpImpl oAutorControlOperation = new AutorControlOperationGenSpImpl(request);
                            String jsonresult = oAutorRoute.execute(request, oAutorControlOperation);
                            out.print(jsonresult);

                        }
                    }
                    if (request.getParameter("ob").equals("disco")) {
                        //ejercicio 5 EL POPULATE INSTERTANDO UN Nº DE DISCOS PASASDOS POR ID
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
                        //ejercicio 8 CAMBIA LA CLAVE AJENA DE UN DISCO
                        if (request.getParameter("op").equals("changeforeign")) {
                            DiscoControlRouteGenSpImpl oDiscoRoute = new DiscoControlRouteGenSpImpl();
                            DiscoControlOperationGenSpImpl oDiscoControlOperation = new DiscoControlOperationGenSpImpl(request);
                            String jsonresult = oDiscoRoute.execute(request, oDiscoControlOperation);
                            out.print(jsonresult);
                        }
                        //MUESTRA LOS DISCOS QUE PERTENECEN AL GENERO PASADO POR ID
                        if (request.getParameter("op").equals("porgenero")) {
                            DiscoControlRouteGenSpImpl oDiscoRoute = new DiscoControlRouteGenSpImpl();
                            DiscoControlOperationGenSpImpl oDiscoControlOperation = new DiscoControlOperationGenSpImpl(request);
                            String jsonresult = oDiscoRoute.execute(request, oDiscoControlOperation);
                            out.print(jsonresult);
                        }

                    }

                    if (request.getParameter("ob").equals("titulo")) {
                        //TE MUESTRA LOS REGISTROS CON RPP Y NUMERO DE PAGINA
                        if (request.getParameter("op").equals("getpage")) {
                            TituloControlRouteGenSpImpl oTituloRoute = new TituloControlRouteGenSpImpl();
                            TituloControlOperationGenSpImpl oTituloControlOperation = new TituloControlOperationGenSpImpl(request);
                            String jsonresult = oTituloRoute.execute(request, oTituloControlOperation);
                            out.print(jsonresult);

                        }
                        //ACTUALIZA UN REGISTRO CON ID=1 Y DESCRIPCION=LAIOS
                        if (request.getParameter("op").equals("update")) {
                            TituloControlRouteGenSpImpl oTituloRoute = new TituloControlRouteGenSpImpl();
                            TituloControlOperationGenSpImpl oTituloControlOperation = new TituloControlOperationGenSpImpl(request);
                            String jsonresult = oTituloRoute.execute(request, oTituloControlOperation);
                            out.print(jsonresult);
                        }
                    }

                    if (request.getParameter("ob").equals("ciudad")) {
                        if (request.getParameter("op").equals("copyautores")) {
                            CiudadControlRouteGenSpImpl oCiudadRoute = new CiudadControlRouteGenSpImpl();
                            CiudadControlOperationGenSpImpl oCiudadControlOperation = new CiudadControlOperationGenSpImpl(request);
                            String jsonresult = oCiudadRoute.execute(request, oCiudadControlOperation);
                            out.print(jsonresult);
                        }
                        if (request.getParameter("op").equals("insert")) {
                            CiudadControlRouteGenSpImpl oCiudadRoute = new CiudadControlRouteGenSpImpl();
                            CiudadControlOperationGenSpImpl oCiudadControlOperation = new CiudadControlOperationGenSpImpl(request);
                            String jsonresult = oCiudadRoute.execute(request, oCiudadControlOperation);
                            out.print(jsonresult);
                        }

                        if (request.getParameter("op").equals("remove")) {
                            CiudadControlRouteGenSpImpl oCiudadRoute = new CiudadControlRouteGenSpImpl();
                            CiudadControlOperationGenSpImpl oCiudadControlOperation = new CiudadControlOperationGenSpImpl(request);
                            String jsonresult = oCiudadRoute.execute(request, oCiudadControlOperation);
                            out.print(jsonresult);
                        }

                        if (request.getParameter("op").equals("get")) {
                            CiudadControlRouteGenSpImpl oCiudadRoute = new CiudadControlRouteGenSpImpl();
                            CiudadControlOperationGenSpImpl oCiudadControlOperation = new CiudadControlOperationGenSpImpl(request);
                            String jsonresult = oCiudadRoute.execute(request, oCiudadControlOperation);
                            out.print(jsonresult);
                        }
                        if (request.getParameter("op").equals("mezcla")) {
                            CiudadControlRouteGenSpImpl oCiudadRoute = new CiudadControlRouteGenSpImpl();
                            CiudadControlOperationGenSpImpl oCiudadControlOperation = new CiudadControlOperationGenSpImpl(request);
                            String jsonresult = oCiudadRoute.execute(request, oCiudadControlOperation);
                            out.print(jsonresult);
                        }
                    }

                }
            }
            //menu
            if (request.getParameter("ob") != null) {
                if (request.getParameter("ob").equals("menu_javier")) {
                    getServletContext().getRequestDispatcher("/menu_javier.jsp").forward(request, response);
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
