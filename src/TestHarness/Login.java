/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

import People.Account;

/**
 *
 * @author Group 2
 */
public class Login {

    public Account account;

    public Login() {

        account = new Account(0, "", "");

        String suppliedPassword = "Ham";
        String resetPassword = "Beans";

        System.out.println();
        System.out.println("Login");
        System.out.println("----------------");
        System.out.println("Authentication: " + account.authenticate(suppliedPassword));
        System.out.println("Reset Password: " + account.resetPassword(resetPassword));
        System.out.println();

    }

}
