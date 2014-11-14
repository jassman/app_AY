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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.List;
import net.daw.bean.generic.specific.implementation.GeneroBeanGenSpImpl;
import net.daw.dao.generic.specific.implementation.GeneroDaoGenSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.service.generic.implementation.TableServiceGenImpl;

public class GeneroServiceGenSpImpl extends TableServiceGenImpl {

    public GeneroServiceGenSpImpl(String strObject, Connection con) {
        super(strObject, con);
    }

    public String getall() throws Exception {
        String jason = null;
        try {
            oConnection.setAutoCommit(false);
            GeneroDaoGenSpImpl oGenDao = new GeneroDaoGenSpImpl("genero", oConnection);
            List<GeneroBeanGenSpImpl> listaGeneros = oGenDao.getPage(1000, 1, null, null);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String data = gson.toJson(listaGeneros);
            jason = "{\"list\":" + data + "}";
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return jason;
    }

    public String getcount() throws Exception {
        String jason = null;
        try {
            oConnection.setAutoCommit(false);
            GeneroDaoGenSpImpl oGenDao = new GeneroDaoGenSpImpl("genero", oConnection);
            jason = "{\"count\":" + oGenDao.getCount("genero") + "}";
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return jason;
    }
}
