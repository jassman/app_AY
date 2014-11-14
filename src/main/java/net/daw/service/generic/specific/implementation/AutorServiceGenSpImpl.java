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
package net.daw.service.generic.specific.implementation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.daw.bean.generic.specific.implementation.ApellidoBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.AutorBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.NombreBeanGenSpImpl;
import net.daw.dao.generic.specific.implementation.ApellidoDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.AutorDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.NombreDaoGenSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.service.generic.implementation.TableServiceGenImpl;

public class AutorServiceGenSpImpl extends TableServiceGenImpl {

    public AutorServiceGenSpImpl(String strObject, Connection con) {
        super(strObject, con);
    }

    public String populate() throws Exception {
        int contador = 0;
        try {
            oConnection.setAutoCommit(false);
            NombreDaoGenSpImpl oNombreDao = new NombreDaoGenSpImpl("nombre", oConnection);
            ApellidoDaoGenSpImpl oApellidoDao = new ApellidoDaoGenSpImpl("apellido", oConnection);

            ArrayList<NombreBeanGenSpImpl> listNombres = oNombreDao.getPage(1000, 1, null, null);
            ArrayList<ApellidoBeanGenSpImpl> listApellidos = oApellidoDao.getPage(1000, 1, null, null);

            Collections.shuffle(listNombres);
            Collections.shuffle(listApellidos);

            Iterator iterator = listNombres.iterator();
            Iterator iterator2 = listApellidos.iterator();

            while (iterator.hasNext() && iterator2.hasNext()) {
                NombreBeanGenSpImpl oNombre = (NombreBeanGenSpImpl) iterator.next();
                ApellidoBeanGenSpImpl oApellido = (ApellidoBeanGenSpImpl) iterator2.next();

                AutorBeanGenSpImpl oAutor = new AutorBeanGenSpImpl();
                oAutor.setNombre(oNombre.getNombre());
                oAutor.setApellido(oApellido.getApellido());

                AutorDaoGenSpImpl oAutorDao = new AutorDaoGenSpImpl("autor", oConnection);
                oAutorDao.set(oAutor);

                contador++;

            }
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return "los " + contador + " autores han sido creados con éxito";
    }

    public String removeall() throws Exception {
        int result = 0;
        try {
            oConnection.setAutoCommit(false);
            AutorDaoGenSpImpl oAutorDao = new AutorDaoGenSpImpl("autor", oConnection);
            result = oAutorDao.removeall();
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return "se han eliminado los " + result + " registros de autor";
    }
}
