package core.bis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;


public class RepositoryException extends Exception {
    
          // Parameterless Constructor
      public RepositoryException() {}

      // Constructor that accepts a message
      public RepositoryException(String message)
      {
         super(message);
      }

    public RepositoryException (Throwable cause) {
        super (cause);
    }

    public RepositoryException (String message, Throwable cause) {
        super (message, cause);
    }
    
}
