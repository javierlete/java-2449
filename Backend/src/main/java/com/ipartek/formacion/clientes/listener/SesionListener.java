package com.ipartek.formacion.clientes.listener;

import com.ipartek.formacion.clientes.modelos.ListaAmigos;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         se.getSession().setAttribute("listaAmigos", new ListaAmigos());
    }	
}
