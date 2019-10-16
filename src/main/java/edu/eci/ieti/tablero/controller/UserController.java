package edu.eci.ieti.tablero.controller;

import java.util.Date;

import javax.servlet.ServletException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public ResponseEntity<?> getUsersList() {
        return new ResponseEntity<>(userService.getUsersList(),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/user/{userid}", method=RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    @RequestMapping(value="/user/{userid}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @RequestMapping(value="/user/{userid}", method=RequestMethod.DELETE)
    public ResponseEntity<?> removeUser(@PathVariable String userId) {
        userService.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getUserName() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUserName();
        String password = login.getPassword();

        //TODO implement logic to verify user credentials
        User user = userService.getUserById(username);

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }
        //
        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {

        String accessToken;


        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }


        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }


    
    



}