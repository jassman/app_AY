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

package net.daw.service.generic.specific.implementation;

import java.sql.Connection;
import net.daw.dao.generic.specific.implementation.TituloDaoGenSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.service.generic.implementation.TableServiceGenImpl;

/**
 *
 * @author asus-pc
 */
public class TituloServiceGenSpImpl extends TableServiceGenImpl {

    public TituloServiceGenSpImpl(String strObject, Connection con) {
        super(strObject, con);
    }
    
    public String update(Integer id, String desc) throws Exception {
        int result = 0;
        try {
            oConnection.setAutoCommit(false);
            TituloDaoGenSpImpl oAutorDao = new TituloDaoGenSpImpl("titulo", oConnection);
            result = oAutorDao.update(id,desc);
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return "se han actualizado los " + result + " registros de autor";
    }
    
}
