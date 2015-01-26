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
package net.daw.control.operation.generic.specific.implementation;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import net.daw.control.operation.generic.implementation.ControlOperationGenImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.helper.parameterCooker;
import net.daw.service.generic.specific.implementation.DiscoServiceGenSpImpl;

public class DiscoControlOperationGenSpImpl extends ControlOperationGenImpl {

    private final DiscoServiceGenSpImpl oDiscoService = (DiscoServiceGenSpImpl) process;

    public DiscoControlOperationGenSpImpl(HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        super(request);
    }

    public String populate(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oDiscoService.populate(parameterCooker.preparePopulateCantidadDeDiscos(request));
            super.closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":populate ERROR: " + ex.getMessage()));
        }
        return result;
    }
    public String changeforeign(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            result = oDiscoService.changeforeign(parameterCooker.prepareId_genero(request),parameterCooker.prepareId_genero_new(request));
            super.closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":changeforeign ERROR: " + ex.getMessage()));
        }
        return result;
    }
    
    public String porGenero(HttpServletRequest request) throws Exception {
        String result = null;
        try {
            int id_genero = Integer.parseInt(request.getParameter("id"));
            result = oDiscoService.porGenero(id_genero);
            super.closeDB();
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":changeforeign ERROR: " + ex.getMessage()));
        }
        return result;
    }
    
    
}
