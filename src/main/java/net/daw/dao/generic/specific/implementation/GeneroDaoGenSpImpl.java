/*
 * Copyright (C) July 2014 Rafael Aznar
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
package net.daw.dao.generic.specific.implementation;

import net.daw.dao.generic.implementation.TableDaoGenImpl;
import java.sql.Connection;
import net.daw.bean.generic.specific.implementation.GeneroBeanGenSpImpl;
import net.daw.helper.Aleatorio;
import net.daw.helper.ExceptionBooster;

public class GeneroDaoGenSpImpl extends TableDaoGenImpl<GeneroBeanGenSpImpl> {

    public GeneroDaoGenSpImpl(String strObject, Connection pooledConnection) throws Exception {
        super(strObject, pooledConnection);
    }

    public Integer getCount(String strTabla) throws Exception {
        int pages = 0;
        try {
            pages = Integer.parseInt(oMysql.getCount(strTabla));
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getCount ERROR: " + ex.getMessage()));
        }
        return pages;

    }

    public GeneroBeanGenSpImpl getRandomOne() throws Exception {
        GeneroBeanGenSpImpl oGenero = null;
        try {
            oGenero = new GeneroBeanGenSpImpl(Aleatorio.randInt(1, oMysql.getCount(strTabla, null)));
            oGenero = this.get(oGenero, 2);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getRandomOne ERROR: " + ex.getMessage()));
        }
        return oGenero;
    }

}
