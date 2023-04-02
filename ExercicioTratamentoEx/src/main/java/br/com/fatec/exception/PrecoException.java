/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exception;

/**
 *
 * @author Paola
 */
public class PrecoException extends RuntimeException{
    
     public PrecoException() {
        super(); //chama o construtor da classe pai
    }

    public PrecoException(String message) {
        super(message); //chama o construtor da classe pai
    }
    
}
