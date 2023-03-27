package com.suavelomito.bootcamp.core.datos;

import com.suavelomito.bootcamp.core.entity.Admin;

public class DatosDummy {
    public static Admin getAdmin(){
        return new Admin(1,"Lala", "lol", "lala@mail.com");
    }
}
