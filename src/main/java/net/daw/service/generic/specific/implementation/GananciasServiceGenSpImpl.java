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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.List;
import net.daw.bean.generic.specific.implementation.GananciasBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.GeneroBeanGenSpImpl;
import net.daw.dao.generic.specific.implementation.GananciasDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.GeneroDaoGenSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.service.generic.implementation.TableServiceGenImpl;

/**
 *
 * @author asus-pc
 */
public class GananciasServiceGenSpImpl extends TableServiceGenImpl {

    public GananciasServiceGenSpImpl(String strObject, Connection con) {
        super(strObject, con);
    }

    public String getall() throws Exception {
        String jason = null;
        try {
            oConnection.setAutoCommit(false);
            GananciasDaoGenSpImpl oGanDao = new GananciasDaoGenSpImpl("ganancias", oConnection);
            List<GananciasBeanGenSpImpl> listaGanancias = oGanDao.getPage(1000, 1, null, null);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String data = gson.toJson(listaGanancias);
            jason = "{\"list\":" + data + "}";
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return jason;
    }

    //coje las ganancias segun el id del autor (id que le pasamos)
    public String getganancias(Integer id) throws Exception {
        String jason = null;
        try {
            oConnection.setAutoCommit(false);
            GananciasBeanGenSpImpl oGananciasBean = new GananciasBeanGenSpImpl();
            GananciasDaoGenSpImpl oGanDao = new GananciasDaoGenSpImpl("ganancias", oConnection);
            List<GananciasBeanGenSpImpl> listaGanancias = oGanDao.getPage(1000, 1, null, null);

            for (int i = 0; i <= listaGanancias.size(); i++) {
                oGananciasBean = listaGanancias.get(i);
                Integer id_autor = oGananciasBean.getId_autor();
                if (id_autor == id) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    String data = gson.toJson(oGananciasBean);
                    return jason = "{\"list\":" + data + "}";
                }
            }

            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return jason;
    }

     public String suma(Integer id1, Integer id2) throws Exception {
        String jason = null;
        try {
            oConnection.setAutoCommit(false);
            GananciasBeanGenSpImpl oGananciasBean = new GananciasBeanGenSpImpl();
            GananciasBeanGenSpImpl oGananciasBean2 = new GananciasBeanGenSpImpl();
            GananciasDaoGenSpImpl oGanDao = new GananciasDaoGenSpImpl("ganancias", oConnection);
            Integer id_ganancia_uno = oGanDao.getId("id_autor", id1.toString());
            Integer id_ganancia_dos = oGanDao.getId("id_autor", id2.toString());
            
            oGananciasBean.setId(id_ganancia_uno);
            oGananciasBean2.setId(id_ganancia_dos);
            
            oGananciasBean = oGanDao.get(oGananciasBean, id_ganancia_uno);
            oGananciasBean2 = oGanDao.get(oGananciasBean2, id_ganancia_dos);
            
            Integer dinero1 = oGananciasBean.getDinero();
            Integer dinero2 = oGananciasBean2.getDinero();
            
            Integer suma = dinero1 + dinero2;
            
            jason = "{\"cantidad\":" + suma + "}";

            
            
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return jason;
    }

}
