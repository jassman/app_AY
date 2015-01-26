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
import java.util.ArrayList;
import java.util.Collections;
import net.daw.bean.generic.specific.implementation.AutorBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.CiudadBeanGenSpImpl;
import net.daw.dao.generic.specific.implementation.AutorDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.CiudadDaoGenSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.helper.FilterBeanHelper;
import net.daw.service.generic.implementation.TableServiceGenImpl;

/**
 *
 * @author asus-pc
 */
public class CiudadServiceGenSpImpl extends TableServiceGenImpl {

    public CiudadServiceGenSpImpl(String strObject, Connection con) {
        super(strObject, con);
    }

    public String copyautores(String id) throws Exception {
        int result = 0;
        try {
            oConnection.setAutoCommit(false);
            CiudadBeanGenSpImpl oCiudad = new CiudadBeanGenSpImpl();
            AutorBeanGenSpImpl oAutor = new AutorBeanGenSpImpl();
            CiudadDaoGenSpImpl oCiudadDao = new CiudadDaoGenSpImpl("ciudad", oConnection);
            AutorDaoGenSpImpl oAutorDao = new AutorDaoGenSpImpl("autor", oConnection);
            ArrayList<AutorBeanGenSpImpl> autorList = new ArrayList<>();

            ArrayList<FilterBeanHelper> alFilter = new ArrayList<>();
            FilterBeanHelper oFilterBean = new FilterBeanHelper();
            oFilterBean.setFilter("id");
            oFilterBean.setFilterOperator("equals");
            oFilterBean.setFilterValue(id);
            oFilterBean.setFilterOrigin("user");
            alFilter.add(oFilterBean);

            ArrayList<CiudadBeanGenSpImpl> id_filtrado = oCiudadDao.getPage(1000, 1, alFilter, null);
            for (int i = 0; i <= id_filtrado.size() - 1; i++) {
                oCiudad = id_filtrado.get(i);
                oAutor.setId(oCiudad.getId_autor());
                oAutor = oAutorDao.get(oAutor, oCiudad.getId_autor());
                autorList.add(oAutor);
            }

            for (int i = 0; i <= autorList.size() - 1; i++) {
                oAutor.setId(0);
                oAutor.setNombre(autorList.get(i).getNombre());
                oAutor.setApellido(autorList.get(i).getApellido());
                oAutorDao.set(oAutor);
            }
            result = autorList.size();
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return "se han insertado " + result + " registros de autor";
    }

    public String setCiudad(String nombre, String id) throws Exception {
        try {
            oConnection.setAutoCommit(false);
            CiudadBeanGenSpImpl oCiudad = new CiudadBeanGenSpImpl();
            CiudadDaoGenSpImpl oCiudadDao = new CiudadDaoGenSpImpl("ciudad", oConnection);
            oCiudad.setId(0);
            oCiudad.setNombre(nombre);
            oCiudad.setId_autor(Integer.parseInt(id));
            oCiudadDao.set(oCiudad);

            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return "se han insertado con exito la ciudad";
    }

    public String mezcla(String numero) throws Exception {
        String json = "";
        try {
            oConnection.setAutoCommit(false);
            CiudadBeanGenSpImpl oCiudad = new CiudadBeanGenSpImpl();
            CiudadDaoGenSpImpl oCiudadDao = new CiudadDaoGenSpImpl("ciudad", oConnection);
            
            ArrayList<CiudadBeanGenSpImpl> ciudadList = oCiudadDao.getPage(1000, 1, null, null);
            ArrayList<String> nombresList = new ArrayList<>();
            ArrayList<Integer> ids = new ArrayList<>();
            ArrayList<Integer> ids_autor = new ArrayList<>();
            
            for (int i=0; i<=ciudadList.size()-1; i++){
                oCiudad = ciudadList.get(i);
                nombresList.add(oCiudad.getNombre());
                ids.add(oCiudad.getId());
                ids_autor.add(oCiudad.getId_autor());
            }
            
            Collections.shuffle(nombresList);
            Collections.shuffle(ids);
            ArrayList<CiudadBeanGenSpImpl> ciudadMezcla = new ArrayList<>();
            
            for (int i=0; i<=ciudadList.size()-1; i++){
                oCiudad.setId(ids.get(i));
                oCiudad.setNombre(nombresList.get(i));
                oCiudad.setId_autor(ids_autor.get(i));
                ciudadMezcla.add(oCiudad);
                oCiudadDao.set(oCiudad);
            }
            
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String data = "";
            for (int i=0; i<=ciudadMezcla.size()-1; i++){
                String jasoneo = gson.toJson(ciudadMezcla.get(i));
                data += "," + jasoneo;
            }
            
            json = "{\"discos\":" + data + "}";
             

            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return json;
    }

}
