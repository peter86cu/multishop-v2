/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.response;



public class ResponseAddEmpresa {

    private boolean status;
    private int code;
    private ErrorResult error;
    private ErrorResult404 error404;

    public ErrorResult404 getError404() {
        return error404;
    }

    public void setError404(ErrorResult404 error404) {
        this.error404 = error404;
    }
    
    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
    public ErrorResult getError() {
        return error;
    }

    public void setError(ErrorResult error) {
        this.error = error;
    }

}
