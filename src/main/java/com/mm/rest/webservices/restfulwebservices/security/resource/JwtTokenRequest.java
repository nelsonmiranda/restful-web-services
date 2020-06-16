package com.mm.rest.webservices.restfulwebservices.security.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

//  {"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU5Mjg3NTEzNSwiaWF0IjoxNTkyMjcwMzM1fQ.MahxXTjIYmaXuFO05GAmBjNz0wj2CrGUQPFSbzKqr_zISDZRVglLrV6AV1InZjykI5zCaoxgFeSZs6I7gd758g"}
//  
  private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

