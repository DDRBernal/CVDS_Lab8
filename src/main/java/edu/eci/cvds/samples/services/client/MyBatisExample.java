/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException
     */
    public static void main(String args[]) throws SQLException, ParseException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();


        //Crear el mapper y usarlo:
        //ClienteMapper cm=sqlss.getMapper(ClienteMapper.class)
        //cm...

        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        System.out.println();
        System.out.println("Consulta Clientes:");
        ItemMapper im = sqlss.getMapper(ItemMapper.class);
        System.out.println(cm.consultarClientes()+"\n Consulta de un Cliente:");
        sqlss.commit();
        cm.agregarItemRentadoACliente(2,8 ,new SimpleDateFormat("yyyy/MM/dd").parse("2021/01/15"),new SimpleDateFormat("yyyy/MM/dd").parse("2020/03/11"));
        System.out.println(cm.consultarCliente(2));
        TipoItem tipoItem1 = new TipoItem(33,"alguna prueba");
        Item aItem = new Item(tipoItem1,
                4,"Un tipo de itemA",
                "alguna descripcion A",
                 new SimpleDateFormat("yyyy/MM/dd").parse("2021/01/15"),
                454, "renta11", "Suspenso");
        im.insertarItem(aItem);
        System.out.println("Consultar Items \n"+im.consultarItems()+"Consultar Item id 33"+im.consultarItem(33));
        System.out.println();
        sqlss.close();



    }


}
