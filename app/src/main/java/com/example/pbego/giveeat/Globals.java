package com.example.pbego.giveeat;

import android.app.Application;

/**
 * Created by pbego on 16/01/2018.
 */

public class Globals extends Application {
    private long idUt = 0;
    private long idAnn = 0;
    private long idProd = 0;
    private long idCat = 0;
    private long idConv = 0;
    private long idMess = 0;

    public long getIdUt(){return idUt;}
    public long getIdAnn(){return idAnn;}
    public long getIdProd(){return idProd;}
    public long getIdCat(){return idCat;}
    public long getIdConv(){return idConv;}
    public long getIdMess(){return idMess;}

    public void setIdUt(long num){idUt=num;}
    public void setIdAnn(long num){idAnn=num;}
    public void setIdProd(long num){idProd=num;}
    public void setIdCat(long num){idCat=num;}
    public void setIdConv(long num){idConv=num;}
    public void setIdMess(long num){idMess=num;}
}
