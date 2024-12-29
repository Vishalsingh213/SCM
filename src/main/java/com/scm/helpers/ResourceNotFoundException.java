package com.scm.helpers;

import java.rmi.RemoteException;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String arg)
    {
        super(arg);
    }
    public ResourceNotFoundException()
    {
        super("Resource Not Found");
    }
    
}
