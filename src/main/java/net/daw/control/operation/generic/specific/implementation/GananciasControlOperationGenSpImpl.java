/*
 * Copyright (C) 2015 asus-pc
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
package net.daw.control.operation.generic.specific.implementation;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import net.daw.control.operation.generic.implementation.ControlOperationGenImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.service.generic.specific.implementation.AutorServiceGenSpImpl;
import net.daw.service.generic.specific.implementation.GananciasServiceGenSpImpl;

/**
 *
 * @author asus-pc
 */
public class GananciasControlOperationGenSpImpl extends ControlOperationGenImpl {

    private final GananciasServiceGenSpImpl oGananciasService = (GananciasServiceGenSpImpl) process;

    public GananciasControlOperationGenSpImpl(HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        super(request);
    }

    public String getall(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oGananciasService.getall();
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getall ERROR: " + ex.getMessage()));
        }
        return result;
    }

    public String getganancias(HttpServletRequest request) throws Exception {
        String result = null;
        Integer id = Integer.parseInt(request.getParameter("idautor"));
        try {
            result = oGananciasService.getganancias(id);
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getall ERROR: " + ex.getMessage()));
        }
        return result;
    }

    public String suma(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oGananciasService.suma(Integer.parseInt(request.getParameter("id_1")), Integer.parseInt(request.getParameter("id_2")));
            closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getall ERROR: " + ex.getMessage()));
        }
        return result;
    }

}
