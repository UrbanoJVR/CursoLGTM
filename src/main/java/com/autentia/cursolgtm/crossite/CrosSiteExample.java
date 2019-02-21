package com.autentia.cursolgtm.crossite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrosSiteExample {

    public void returnDataClient(HttpServletRequest request, HttpServletResponse response) {
        final String clientId = request.getHeader("clientID");
        //¿Cómo usar el dato manipulado para cross site?
    }
    //https://lgtm.com/projects/g/adityasharad/lgtm-workshop/alerts/?mode=list
}
